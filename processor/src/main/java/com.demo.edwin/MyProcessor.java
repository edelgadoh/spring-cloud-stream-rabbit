package com.demo.edwin;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Slf4j
@Component
public class MyProcessor {

    Set<String> domains = new HashSet<>();

    @Bean
    public Function<String, String> validateUniqueDomain() {
        return (domain) -> {
            log.info("Domain received {}", domain);
            String lowerCaseValue = domain.toLowerCase();
            if (!domains.add(lowerCaseValue)) {
                throw new AmqpRejectAndDontRequeueException("Duplicated domain "+ domain);
            }
            log.info("Sending domain {}", lowerCaseValue);
            return lowerCaseValue;
        };
    }

}
