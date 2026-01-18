package com.example.clientnetworkconfigservice.controller;

import com.example.clientnetworkconfigservice.dto.ClientNetworkResponse;
import com.example.clientnetworkconfigservice.dto.CreateClientNetworkRequest;
import com.example.clientnetworkconfigservice.service.ClientNetworkService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clients")
public class ClientNetworkController {

    private final ClientNetworkService service;

    public ClientNetworkController(ClientNetworkService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ClientNetworkResponse> create(@Valid @RequestBody CreateClientNetworkRequest req) {
        return ResponseEntity.ok(service.create(req));
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientNetworkResponse> get(@PathVariable String clientId) {
        ClientNetworkResponse res = service.getById(clientId);
        return (res == null) ? ResponseEntity.notFound().build() : ResponseEntity.ok(res);
    }
}
