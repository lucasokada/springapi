package com.springapi.core;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //configuraçao de beans
public class ModelMapperConfig {

    @Bean //instancia um bean do tipo modelmapper
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
