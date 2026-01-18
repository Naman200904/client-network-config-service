package com.example.clientnetworkconfigservice.service;

import com.example.clientnetworkconfigservice.dto.CreateClientNetworkRequest;
import com.example.clientnetworkconfigservice.repository.ClientNetworkRepository;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientNetworkServiceTest {

    @Test
    void create_shouldNormalizeAndSave() {
        ClientNetworkRepository repo = mock(ClientNetworkRepository.class);
        when(repo.findById(anyString())).thenReturn(Optional.empty());

        ClientNetworkService service = new ClientNetworkService(repo);

        CreateClientNetworkRequest req = new CreateClientNetworkRequest();
        req.setClientId("  c-001 ");
        req.setClientName("  Acme Corp ");
        req.setEnvironment("prod");
        req.setCidrBlock("10.0.0.0/16");
        req.setRoutingProtocol("ospf");
        req.setVlans(List.of(10, 20));
        req.setVpnRequired(true);
        req.setNotes("Primary");

        var res = service.create(req);

        assertEquals("c-001", res.getClientId());
        assertEquals("PROD", res.getEnvironment());
        assertEquals("OSPF", res.getRoutingProtocol());
        assertNotNull(res.getCreatedAt());

        verify(repo, times(1)).save(any());
    }
}
