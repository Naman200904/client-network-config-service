package com.example.clientnetworkconfigservice.model;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

/**
 * Domain model representing a client's networking protocol requirements
 * and configuration details.
 *
 * This is the central entity stored by the repository layer. In a DynamoDB-backed
 * version, this model can be annotated with DynamoDB mapper annotations.
 */
@Getter
@Builder
public class ClientNetworkProfile {

    /** Unique identifier for a client (primary lookup key). */
    private String clientId;

    /** Environment where config applies (e.g., dev / test / prod). */
    private String environment;

    /** Network protocol requested by client (e.g., HTTP, HTTPS, TCP, UDP). */
    private String protocol;

    /** CIDR block / network range allowed for client access (e.g., 10.0.0.0/24). */
    private String cidrBlock;

    /** Port used for inbound/outbound communication (e.g., 443 for HTTPS). */
    private int port;

    /** Indicates whether traffic must be encrypted (TLS/SSL enabled). */
    private boolean encryptionEnabled;

    /** Optional additional notes or special requirements from client. */
    private String notes;

    /** Unique request identifier for the latest write/update operation. */
    private String requestId;

    /** Timestamp indicating when the profile was last updated. */
    private Instant lastUpdatedAt;
}
