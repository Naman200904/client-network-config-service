package com.example.clientnetworkconfigservice.service;

import com.example.clientnetworkconfigservice.dto.ClientNetworkResponse;
import com.example.clientnetworkconfigservice.dto.CreateClientNetworkRequest;
import com.example.clientnetworkconfigservice.model.ClientNetworkProfile;
import com.example.clientnetworkconfigservice.repository.ClientNetworkRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

/**
 * Service layer that encapsulates business logic for:
 *  - validating and processing incoming client network configuration data
 *  - transforming request DTOs into domain models
 *  - persisting and retrieving data via repository abstraction
 */
@Service
public class ClientNetworkService {

    /**
     * Repository abstraction used for storing and retrieving network profiles.
     * In this project phase, the implementation is in-memory, but this can later be
     * replaced with DynamoDB implementation without changing controller/service contracts.
     */
    private final ClientNetworkRepository repository;

    /**
     * Constructs the service with a repository dependency.
     *
     * @param repository repository layer used for persistence operations
     */
    public ClientNetworkService(ClientNetworkRepository repository) {
        this.repository = repository;
    }

    /**
     * Creates a new record OR updates the existing record for a given clientId.
     *
     * Processing performed:
     *  - Basic normalization (e.g., trimming strings)
     *  - Assigning metadata (requestId, timestamps)
     *  - Storing the resulting profile using repository
     *
     * @param request incoming request containing client network requirements
     * @return response DTO containing stored profile
     */
    public ClientNetworkResponse createOrUpdate(CreateClientNetworkRequest request) {
        // Generate a requestId to track this write operation (useful for troubleshooting/auditing)
        String requestId = UUID.randomUUID().toString();

        // Capture current system time as write timestamp
        Instant now = Instant.now();

        // Build domain model from request payload
        ClientNetworkProfile profile = ClientNetworkProfile.builder()
                .clientId(trim(request.getClientId()))
                .environment(trim(request.getEnvironment()))
                .protocol(trim(request.getProtocol()))
                .cidrBlock(trim(request.getCidrBlock()))
                .port(request.getPort())
                .encryptionEnabled(request.isEncryptionEnabled())
                .notes(trim(request.getNotes()))
                .requestId(requestId)
                .lastUpdatedAt(now)
                .build();

        // Persist the profile (in-memory for now)
        repository.save(profile);

        // Convert saved domain object into response DTO
        return toResponse(profile);
    }

    /**
     * Retrieves a stored profile by clientId.
     *
     * @param clientId unique identifier for the client
     * @return response DTO representing stored profile
     * @throws IllegalArgumentException if the profile is not found
     */
    public ClientNetworkResponse getByClientId(String clientId) {
        ClientNetworkProfile profile = repository.findByClientId(clientId)
                .orElseThrow(() -> new IllegalArgumentException("No network profile found for clientId: " + clientId));

        return toResponse(profile);
    }

    /**
     * Utility method to safely trim strings and avoid NullPointerExceptions.
     *
     * @param value raw string input
     * @return trimmed string, or null if input is null
     */
    private String trim(String value) {
        return value == null ? null : value.trim();
    }

    /**
     * Maps domain model into a response DTO.
     *
     * @param profile domain entity representing stored client network config
     * @return API response DTO
     */
    private ClientNetworkResponse toResponse(ClientNetworkProfile profile) {
        return ClientNetworkResponse.builder()
                .clientId(profile.getClientId())
                .environment(profile.getEnvironment())
                .protocol(profile.getProtocol())
                .cidrBlock(profile.getCidrBlock())
                .port(profile.getPort())
                .encryptionEnabled(profile.isEncryptionEnabled())
                .notes(profile.getNotes())
                .requestId(profile.getRequestId())
                .lastUpdatedAt(profile.getLastUpdatedAt())
                .build();
    }
}
