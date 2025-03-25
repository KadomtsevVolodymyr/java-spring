package com.flux.flux_carsharing.configuration;

import java.util.Base64;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * WebClientConfig
 */
@Configuration
public class WebClientConfig {

  @Bean
  public WebClient webClient() {
    return WebClient.builder()
    .baseUrl("http://localhost:8080")
    .defaultHeader("Content-Type", "application/json")
    .defaultHeader(HttpHeaders.AUTHORIZATION, "Basic " + Base64.getEncoder().encodeToString("bobross:1234".getBytes()))
    .build();
  }

}
