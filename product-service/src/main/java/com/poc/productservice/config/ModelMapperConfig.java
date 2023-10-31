package com.poc.productservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Model mapper config.
 */
@Configuration
public class ModelMapperConfig {

  @Bean
  public ModelMapper modelMapper() {
    return new ModelMapper();
  }

}