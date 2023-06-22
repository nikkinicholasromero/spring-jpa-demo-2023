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
        DemoTable demoTable1 = new DemoTable.Builder(UUID.randomUUID(), "Nikki Nicholas", "Romero", "nikkinicholas.romero@gmail.com", "12-123456-1")
                .build();
        System.out.println(demoTable1);
        demoTableRepository.save(demoTable1);

        DemoTable demoTable2 = new DemoTable.Builder(UUID.randomUUID(), "Leslie Anne", "Romero", "sayin.leslieanne@gmail.com", "11-222222-3")
                .middleName("Sayin")
                .build();
        System.out.println(demoTable2);
        demoTableRepository.save(demoTable2);
    }
}
