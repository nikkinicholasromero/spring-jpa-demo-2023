package com.demo;

import com.demo.domain.DemoTable;
import com.demo.domain.DemoTableRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private DemoTableRepository demoTableRepository;

    @PostConstruct
    private void postConstruct() {
        DemoTable demoTable = new DemoTable(UUID.randomUUID());
        demoTableRepository.save(demoTable);
    }
}
