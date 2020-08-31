package com.protosstechnology.train.bootexamine.controlller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j

public class LogController {
    @Value("${application.server.path")
    private String serverPath;

    @GetMapping("/logger")
    public ResponseEntity<String> index() {

        log.trace("A TRACE Message");
        log.debug("A DEBUG Message");
        log.debug("An INFO Message");
        log.warn("A WARN Message");
        log.error("An ERROR Message");
        log.warn("serverPath={}",serverPath);

        return ResponseEntity.ok().body("Check out the Logs to see the output...");

    }
}