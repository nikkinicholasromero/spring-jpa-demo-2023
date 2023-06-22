package com.demo.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DemoTableRepository extends CrudRepository<DemoTable, UUID> {
}
