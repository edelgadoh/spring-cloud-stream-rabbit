package com.demo.edwin;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
public class CompanyController {

    @Value("${spring.cloud.stream.bindings.processorChannel.destination}")
    private String bindingName;

    @Autowired
    private StreamBridge streamBridge;

    @GetMapping("/company-domain/{domain}")
    public ResponseEntity<String> companyDomain(@PathVariable String domain) {
        log.info("Sending domain {} to topic {}", domain, bindingName);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("domain", domain);
        jsonObject.put("createdAt", LocalDateTime.now());

        streamBridge.send(bindingName, MessageBuilder.withPayload(jsonObject.toString()).build());
        return ResponseEntity.ok("OK");
    }

}
