package com.demo;

import com.demo.domain.DemoTable;
import com.demo.domain.DemoTableRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Autowired
    private DemoTableRepository demoTableRepository;

    @PostConstruct
    private void postConstruct() {
        DemoTable demoTable = new DemoTable(UUID.randomUUID(), "Nikki Nicholas", "abc@gas", "12-123456-1");
        System.out.println(demoTable);
        demoTableRepository.save(demoTable);
    }
}
