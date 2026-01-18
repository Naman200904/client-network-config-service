package com.example.clientnetworkconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Client Network Config Service.
 *
 * This Spring Boot application hosts REST APIs that allow clients to
 * create and retrieve networking protocol/configuration requirements.
 * In the current phase, data persistence is backed by an in-memory repository.
 */
@SpringBootApplication
public class ClientNetworkConfigServiceApplication {

    /**
     * Bootstraps the Spring Boot application context and starts the embedded server.
     *
     * @param args command-line arguments passed during application startup
     */
    public static void main(String[] args) {
        SpringApplication.run(ClientNetworkConfigServiceApplication.class, args);
    }
}
