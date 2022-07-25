package com.demo.edwin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Slf4j
@Component
public class MyProcessor {

    @Bean
    public Function<String, String> convertToUppercase() {
        return (value) -> {
            log.info("Received {}", value);
            String upperCaseValue = value.toUpperCase();
            log.info("Sending {}", upperCaseValue);
            return upperCaseValue;
        };
    }

}
