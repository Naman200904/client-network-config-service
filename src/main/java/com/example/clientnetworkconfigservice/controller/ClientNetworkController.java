package com.example.clientnetworkconfigservice.controller;

import com.example.clientnetworkconfigservice.dto.ClientNetworkResponse;
import com.example.clientnetworkconfigservice.dto.CreateClientNetworkRequest;
import com.example.clientnetworkconfigservice.service.ClientNetworkService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller responsible for exposing APIs related to
 * Client Network Configuration management.
 *
 * Endpoints:
 *  - POST: Create/Store a client's network protocol requirements
 *  - GET : Fetch stored requirements for a given clientId
 */
@RestController
@RequestMapping("/api/client-network")
public class ClientNetworkController {

    /**
     * Service dependency containing the core business logic for
     * validating input, building domain models, and persisting data.
     */
    private final ClientNetworkService service;

    /**
     * Constructor injection for service dependency.
     *
     * @param service service layer component that handles request processing
     */
    public ClientNetworkController(ClientNetworkService service) {
        this.service = service;
    }

    /**
     * Creates a new client network configuration record.
     *
     * @param request request body containing client network protocol/config parameters
     * @return ResponseEntity containing the created/updated profile details
     */
    @PostMapping
    public ResponseEntity<ClientNetworkResponse> create(@RequestBody CreateClientNetworkRequest request) {
        ClientNetworkResponse response = service.createOrUpdate(request);
        return ResponseEntity.ok(response);
    }

    /**
     * Fetches a stored client network configuration record by clientId.
     *
     * @param clientId unique identifier for the client
     * @return ResponseEntity containing the stored profile details (or not found)
     */
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientNetworkResponse> getByClientId(@PathVariable String clientId) {
        ClientNetworkResponse response = service.getByClientId(clientId);
        return ResponseEntity.ok(response);
    }
}
