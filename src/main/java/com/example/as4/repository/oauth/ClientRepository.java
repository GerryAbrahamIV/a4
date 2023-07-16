package com.example.as4.repository.oauth;

import com.example.as4.models.oauth.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends
        PagingAndSortingRepository<Client, Long> {
    Client findOneByClientId(String clientId);

}

