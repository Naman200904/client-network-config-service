package com.example.clientnetworkconfigservice.dto;

import java.util.List;

public class ClientNetworkResponse {
    private String clientId;
    private String clientName;
    private String environment;
    private String cidrBlock;
    private String routingProtocol;
    private List<Integer> vlans;
    private Boolean vpnRequired;
    private String notes;
    private String createdAt;

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

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
