package com.example.clientnetworkconfigservice.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

/**
 * Response DTO returned by both GET and POST APIs.
 *
 * Contains the stored client network configuration along with metadata
 * such as requestId and lastUpdatedAt for traceability.
 */
@Getter
@Builder
public class ClientNetworkResponse {

    /** Unique identifier of the client. */
    private String clientId;

    /** Environment where this configuration applies. */
    private String environment;

    /** Requested protocol (HTTP/HTTPS/TCP/UDP). */
    private String protocol;

    /** Allowed CIDR block/range. */
    private String cidrBlock;

    /** Port used for the configured service. */
    private int port;

    /** Indicates if encryption is required/enabled. */
    private boolean encryptionEnabled;

    /** Optional notes or extra requirements. */
    private String notes;

    /** Unique id generated during write operation for traceability. */
    private String requestId;

    /** Timestamp of the most recent update/write. */
    private Instant lastUpdatedAt;
}
