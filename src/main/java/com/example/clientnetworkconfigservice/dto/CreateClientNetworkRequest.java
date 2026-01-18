package com.example.clientnetworkconfigservice.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Request DTO used for creating/updating a client network configuration.
 *
 * This class represents the JSON payload expected by the POST API.
 * Validation annotations can be added later once dependency resolution is fixed.
 */
@Getter
@Setter
public class CreateClientNetworkRequest {

    /** Client identifier for whom network config is being stored. */
    private String clientId;

    /** Target environment for the configuration (dev/test/prod). */
    private String environment;

    /** Requested network protocol (HTTP/HTTPS/TCP/UDP). */
    private String protocol;

    /** Allowed CIDR block for access control. */
    private String cidrBlock;

    /** Port required for communication. */
    private int port;

    /** Whether encryption (TLS/SSL) is required for the connection. */
    private boolean encryptionEnabled;

    /** Optional notes or special client requirements. */
    private String notes;
}
