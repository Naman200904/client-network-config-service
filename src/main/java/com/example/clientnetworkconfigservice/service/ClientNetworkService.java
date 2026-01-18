package com.example.clientnetworkconfigservice.service;

import com.example.clientnetworkconfigservice.dto.ClientNetworkResponse;
import com.example.clientnetworkconfigservice.dto.CreateClientNetworkRequest;
import com.example.clientnetworkconfigservice.model.ClientNetworkProfile;
import com.example.clientnetworkconfigservice.repository.ClientNetworkRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientNetworkService {

    private final ClientNetworkRepository repo;

    public ClientNetworkService(ClientNetworkRepository repo) {
        this.repo = repo;
    }

    public ClientNetworkResponse create(CreateClientNetworkRequest req) {
        // Basic processing/normalization
        ClientNetworkProfile profile = new ClientNetworkProfile();
        profile.setClientId(req.getClientId().trim());
        profile.setClientName(req.getClientName().trim());
        profile.setEnvironment(req.getEnvironment().trim().toUpperCase());
        profile.setCidrBlock(req.getCidrBlock().trim());
        profile.setRoutingProtocol(req.getRoutingProtocol().trim().toUpperCase());
        profile.setVlans(req.getVlans());
        profile.setVpnRequired(req.getVpnRequired());
        profile.setNotes(req.getNotes());
        profile.setCreatedAtNow();

        repo.save(profile);
        return toResponse(profile);
    }

    public ClientNetworkResponse getById(String clientId) {
        return repo.findById(clientId)
                .map(this::toResponse)
                .orElse(null);
    }

    private ClientNetworkResponse toResponse(ClientNetworkProfile p) {
        ClientNetworkResponse r = new ClientNetworkResponse();
        r.setClientId(p.getClientId());
        r.setClientName(p.getClientName());
        r.setEnvironment(p.getEnvironment());
        r.setCidrBlock(p.getCidrBlock());
        r.setRoutingProtocol(p.getRoutingProtocol());
        r.setVlans(p.getVlans());
        r.setVpnRequired(p.getVpnRequired());
        r.setNotes(p.getNotes());
        r.setCreatedAt(p.getCreatedAt());
        return r;
    }
}
