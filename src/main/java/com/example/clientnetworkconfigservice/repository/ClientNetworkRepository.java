package com.example.clientnetworkconfigservice.repository;

import com.example.clientnetworkconfigservice.model.ClientNetworkProfile;

import java.util.Optional;

public interface ClientNetworkRepository {
    void save(ClientNetworkProfile profile);
    Optional<ClientNetworkProfile> findById(String clientId);
}
