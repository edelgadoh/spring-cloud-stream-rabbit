package com.demo.edwin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
public class CompanyConsumer {

    @Bean
    public Consumer<String> companyDomainReceived(){
        return (message) -> {
            log.info("New company domain received {}", message);
        };
    }
}
