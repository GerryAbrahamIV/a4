package com.example.as4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(securedEnabled = true) //secure definition
public class Oauth2ResourceServerConfiguration extends
        ResourceServerConfigurerAdapter {
    /**
     * Manage resource server.
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer
                                  resources) throws Exception {
        super.configure(resources);
    }
// private static final String SECURED_PATTERN = "/api/**";
    /**
     * Manage endpoints.
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and()
                .csrf()
                .disable()
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/","/showFile/**","/v1/showFile/**","/v1/upload",
                        "/user-register/**","/swagger-ui/**","/swagger-ui.html","/v3/apidocs/**","/user-login/**",
                        "/forget-password/**",
                        "/oauth/authorize**", "/login**","/user/login**", "/error**")
                .permitAll()
/*                .antMatchers("/v1/role-test-global/listbarang").hasAnyAuthority("ROLE_READ")
                .antMatchers("/v1/role-test-global/postbarang").hasAnyAuthority("ROLE_WRITE")
                .antMatchers("/v1/role-test-global/post-baranguser").hasAnyAuthority("ROLE_USER")
                .antMatchers("/v1/role-test-global/post-barangadmin").hasAnyAuthority("ROLE_ADMIN")*/
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}
