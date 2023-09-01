package com.reply.model.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Clock;
import java.time.ZoneId;

@Configuration
public class ApplicationConfig {

    @Bean("clock")
    public Clock clock(){
        return Clock.system(ZoneId.systemDefault());
    }
}
