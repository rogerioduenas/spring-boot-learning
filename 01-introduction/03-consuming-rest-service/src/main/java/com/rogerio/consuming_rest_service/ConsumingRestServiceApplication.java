package com.rogerio.consuming_rest_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class ConsumingRestServiceApplication {

  private static final Logger logger = LoggerFactory.getLogger(ConsumingRestServiceApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ConsumingRestServiceApplication.class, args);
  }

  @Bean
  @Profile("!test")
  public ApplicationRunner run(RestClient.Builder builder) {
    RestClient restClient = builder.baseUrl("http://localhost:8081").build();
    return args -> {
      Quote quote = restClient
          .get().uri("/api/random")
          .retrieve()
          .body(Quote.class);
      logger.info(quote.toString());
    };
  }

}
