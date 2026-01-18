package com.example.clientnetworkconfigservice.repository;

import com.example.clientnetworkconfigservice.model.ClientNetworkProfile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryClientNetworkRepository implements ClientNetworkRepository {

    private final Map<String, ClientNetworkProfile> store = new ConcurrentHashMap<>();

    @Override
    public void save(ClientNetworkProfile profile) {
        store.put(profile.getClientId(), profile);
    }

    @Override
    public Optional<ClientNetworkProfile> findById(String clientId) {
        return Optional.ofNullable(store.get(clientId));
    }
}
