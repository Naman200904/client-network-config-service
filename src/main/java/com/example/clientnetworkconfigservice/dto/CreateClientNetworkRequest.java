package com.example.clientnetworkconfigservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateClientNetworkRequest {

    @NotBlank
    private String clientId;

    @NotBlank
    private String clientName;

    @NotBlank
    private String environment; // DEV/UAT/PROD

    @NotBlank
    private String cidrBlock; // e.g. 10.0.0.0/16

    @NotBlank
    private String routingProtocol; // STATIC/OSPF/BGP

    @NotEmpty
    private List<Integer> vlans;

    @NotNull
    private Boolean vpnRequired;

    private String notes;

    // Getters and setters (IntelliJ: Generate -> Getters and Setters)
    public String getClientId() { return clientId; }
    public void setClientId(String clientId) { this.clientId = clientId; }

    public String getClientName() { return clientName; }
    public void setClientName(String clientName) { this.clientName = clientName; }

    public String getEnvironment() { return environment; }
    public void setEnvironment(String environment) { this.environment = environment; }

    public String getCidrBlock() { return cidrBlock; }
    public void setCidrBlock(String cidrBlock) { this.cidrBlock = cidrBlock; }

    public String getRoutingProtocol() { return routingProtocol; }
    public void setRoutingProtocol(String routingProtocol) { this.routingProtocol = routingProtocol; }

    public List<Integer> getVlans() { return vlans; }
    public void setVlans(List<Integer> vlans) { this.vlans = vlans; }

    public Boolean getVpnRequired() { return vpnRequired; }
    public void setVpnRequired(Boolean vpnRequired) { this.vpnRequired = vpnRequired; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
