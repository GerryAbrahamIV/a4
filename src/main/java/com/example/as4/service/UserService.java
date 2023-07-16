package com.example.as4.service;

import com.example.as4.config.Config;
import com.example.as4.dto.LoginModel;
import com.example.as4.models.oauth.Role;
import com.example.as4.models.oauth.User;
import com.example.as4.repository.oauth.RoleRepository;
import com.example.as4.repository.oauth.UserRepository;
import com.example.as4.response.RegisterModel;
import com.example.as4.response.Response;
import com.example.as4.service.oauth.Oauth2UserDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpStatusCodeException;

import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService{
    Config config = new Config();
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private Oauth2UserDetailsService userDetailsService;
    @Autowired
    public Response templateResponse;
    @Value("${BASEURL}")
    private String baseUrl;
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public Map registerManual(RegisterModel objModel) {
        Map map = new HashMap();
        try {
            String[] roleNames = {"ROLE_USER", "ROLE_READ",
                    "ROLE_WRITE"}; // admin
            User user = new User();
            user.setUsername(objModel.getUsername().toLowerCase());
            user.setFullname(objModel.getFullname());
            user.setEnabled(false);
// matikan user
            String password =
                    encoder.encode(objModel.getPassword().replaceAll("\\s+", ""));
            List<Role> r = roleRepository.findByNameIn(roleNames);
            user.setRoles(r);
            user.setPassword(password);
            User obj = userRepository.save(user);
            return templateResponse.templateSukses(obj);
        } catch (Exception e) {
            logger.error("Eror registerManual=", e);
            return templateResponse.templateEror("eror:"+e);
        }
    }
    public Map getDetailProfile(Principal principal) {
        User idUser = getUserIdToken(principal, userDetailsService);
        try {
            User obj = userRepository.save(idUser);
            return templateResponse.sukses(obj);
        } catch (Exception e){
            return templateResponse.error(e,"500");
        }
    }

    private User getUserIdToken(Principal principal, Oauth2UserDetailsService userDetailsService) {
        UserDetails user = null;
        String username = principal.getName();
        if (!StringUtils.isEmpty(username)) {
            user = userDetailsService.loadUserByUsername(username);
        }

        if (null == user) {
            throw new UsernameNotFoundException("User not found");
        }
        User idUser = userRepository.findOneByUsername(user.getUsername());
        if (null == idUser) {
            throw new UsernameNotFoundException("User name not found");
        }
        return idUser;
    }

    public Map login(LoginModel loginModel) {
        /**
         * business logic for login here
         * **/
        try {
            Map<String, Object> map = new HashMap<>();
            User checkUser =
                    userRepository.findOneByUsername(loginModel.getUsername());
            if ((checkUser != null) &&
                    (encoder.matches(loginModel.getPassword(), checkUser.getPassword()))) {
                if (!checkUser.isEnabled()) {
                    map.put("is_enabled", checkUser.isEnabled());
                    return templateResponse.templateEror(map);
                }
            }
            if (checkUser == null) {
                return templateResponse.notFound("user not found");
            }
            if (!(encoder.matches(loginModel.getPassword(),
                    checkUser.getPassword()))) {
                return templateResponse.templateEror("wrong password");
            }
            String url = baseUrl + "/oauth/token?username=" +
                    loginModel.getUsername() +
                    "&password=" + loginModel.getPassword() +
                    "&grant_type=password" +
                    "&client_id=my-client-web" +
                    "&client_secret=password";
            ResponseEntity<Map> response = restTemplateBuilder.build()
                    .exchange(url, HttpMethod.POST, null,
                            new ParameterizedTypeReference<Map>() {});
            if (response.getStatusCode() == HttpStatus.OK) {
                User user = userRepository.findOneByUsername(loginModel.getUsername());
                List<String> roles = new ArrayList<>();
                for (Role role : user.getRoles()) {
                    roles.add(role.getName());
                }
                //save token
//              checkUser.setAccessToken(response.getBody().get("access_token").toString());
//              checkUser.setRefreshToken(response.getBody().get("refresh_token").toString());
// userRepository.save(checkUser);
                map.put("access_token",
                        response.getBody().get("access_token"));
                map.put("token_type",
                        response.getBody().get("token_type"));
                map.put("refresh_token",
                        response.getBody().get("refresh_token"));
                map.put("expires_in",
                        response.getBody().get("expires_in"));
                map.put("scope", response.getBody().get("scope"));
                map.put("jti", response.getBody().get("jti"));
                return map;
            } else {
                return templateResponse.notFound("user not found");
            }
        } catch (HttpStatusCodeException e) {
            e.printStackTrace();
            if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
                return templateResponse.templateEror("invalid login");
            }
            return templateResponse.templateEror(e);
        } catch (Exception e) {
            e.printStackTrace();
            return templateResponse.templateEror(e);
        }
    }
}
