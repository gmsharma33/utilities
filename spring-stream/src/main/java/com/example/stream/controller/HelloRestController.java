package com.example.stream.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
@RequestMapping("/hello")
@Slf4j
public class HelloRestController {

    @RequestMapping("")
    public String hello() {
        log.info("Started..!");
        return "Hello world..!";
    }

    @GetMapping(value = "/stream", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<String> getStream() {
        return Flux.interval(Duration.ofSeconds(2)).map(item -> "count " + item + "\n");
    }

}
