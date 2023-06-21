package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
@SpringBootApplication
public class Application {
    private final DemoTableRepository demoTableRepository;

    public Application(DemoTableRepository demoTableRepository) {
        this.demoTableRepository = demoTableRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @GetMapping
    public void index() {
        DemoTable demoTable = new DemoTable(UUID.randomUUID());
        demoTableRepository.save(demoTable);
    }
}
