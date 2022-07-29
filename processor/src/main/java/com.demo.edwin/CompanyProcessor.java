package com.demo.edwin;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

@Slf4j
@Component
public class CompanyProcessor {

    Set<String> domains = new HashSet<>();

    @Bean
    public Function<GenericMessage<String>, String> validateUniqueDomain() {
        return (message) -> {
            log.info("JsonObject received {}", message);
            try {
                JSONObject jsonObject = new JSONObject(message.getPayload());
                String lowerCaseValue = jsonObject.getString("domain").toLowerCase();
                if (!domains.add(lowerCaseValue)) {
                    throw new AmqpRejectAndDontRequeueException("Duplicated domain " + message);
                }
                log.info("Sending unique domain {}", lowerCaseValue);
                return lowerCaseValue;
            } catch (Exception e) {
                throw new AmqpRejectAndDontRequeueException("Exception: " + e.getMessage());
            }
        };
    }

}
