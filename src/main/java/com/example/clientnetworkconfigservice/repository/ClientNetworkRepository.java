package com.example.clientnetworkconfigservice.repository;

import com.example.clientnetworkconfigservice.model.ClientNetworkProfile;

import java.util.Optional;

/**
 * Repository abstraction for Client Network Profile persistence.
 *
 * This interface allows the service layer to remain independent of the storage mechanism.
 * Current implementation: In-memory map.
 * Future implementation: DynamoDB (or any other database) without modifying service/controller.
 */
public interface ClientNetworkRepository {

    /**
     * Saves a client network profile.
     * If a profile with the same clientId already exists, it should be replaced/updated.
     *
     * @param profile domain entity to store
     */
    void save(ClientNetworkProfile profile);

    /**
     * Retrieves a client network profile for the provided clientId.
     *
     * @param clientId unique identifier of the client
     * @return Optional containing profile if present, else empty
     */
    Optional<ClientNetworkProfile> findByClientId(String clientId);
}
