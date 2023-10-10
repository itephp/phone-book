package com.brandly360.phonebook;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

  @Bean
  public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
    return factory -> factory.setRegisterDefaultServlet(true);
  }

  @Bean
  public ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
