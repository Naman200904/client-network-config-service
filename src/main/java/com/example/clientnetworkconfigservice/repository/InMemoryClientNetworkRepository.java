package com.example.clientnetworkconfigservice.repository;

import com.example.clientnetworkconfigservice.model.ClientNetworkProfile;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * In-memory repository implementation for ClientNetworkRepository.
 *
 * This implementation uses a thread-safe ConcurrentHashMap to store profiles.
 * It is suitable for local development, demos, and unit tests.
 *
 * NOTE: In production, this layer can be replaced by DynamoDB-based implementation.
 */
@Repository
public class InMemoryClientNetworkRepository implements ClientNetworkRepository {

    /**
     * Thread-safe map keyed by clientId.
     * Value stores the latest client network profile configuration for that client.
     */
    private final Map<String, ClientNetworkProfile> store = new ConcurrentHashMap<>();

    /**
     * Saves or updates the provided profile in the in-memory store.
     *
     * @param profile domain entity to persist
     */
    @Override
    public void save(ClientNetworkProfile profile) {
        store.put(profile.getClientId(), profile);
    }

    /**
     * Fetches a profile by clientId if it exists.
     *
     * @param clientId unique client identifier
     * @return Optional containing profile if present
     */
    @Override
    public Optional<ClientNetworkProfile> findByClientId(String clientId) {
        return Optional.ofNullable(store.get(clientId));
    }
}
