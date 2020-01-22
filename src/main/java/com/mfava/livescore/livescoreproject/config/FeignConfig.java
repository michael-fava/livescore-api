package com.mfava.livescore.livescoreproject.config;

import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author michaelfava
 */
@Configuration
public class FeignConfig {

    @Bean
    public Decoder feignDecoder() {
        return new JacksonDecoder();
    }
}
