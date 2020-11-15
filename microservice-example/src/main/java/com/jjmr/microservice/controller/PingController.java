package com.jjmr.microservice.controller;

import net.logstash.logback.argument.StructuredArguments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.slf4j.Marker;
import org.slf4j.helpers.BasicMarkerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/v1/ping")
public class PingController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PingController.class);

    @GetMapping("/")
    public ResponseEntity<String> getPing() {
        MDC.put("mdc_field", UUID.randomUUID().toString());
        LOGGER.info("Log simple");
        Marker marker = new BasicMarkerFactory().getMarker("test_marker");
        marker.add(new BasicMarkerFactory().getMarker("test_marker2"));
        marker.add(new BasicMarkerFactory().getMarker("test_marker3"));
        LOGGER.info(marker, "Log con markers");
        LOGGER.info("Log con un argumento", StructuredArguments.value("arg1", "arg1value"));
        Map<Object, Object> map = new HashMap<Object, Object>();
        map.put("arg1", "arg1 with map");
        map.put("arg2", "arg2 with map");
        map.put("arg3", "arg3 with map");
        LOGGER.info("Log con múltiples argumentos", StructuredArguments.entries(map));
        return new ResponseEntity<>("Service is available", HttpStatus.OK);
    }

    @GetMapping("/exception")
    public String exception() {
        String response = "";
        try {
            throw new Exception("Exception has occured....");
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error(e.getMessage());

            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            LOGGER.error("Exception - " + stackTrace);
            response = stackTrace;
        }

        return response;
    }
}
