package com.demo;

import org.springframework.data.repository.CrudRepository;

public interface DemoTableRepository extends CrudRepository<DemoTable, String> {
}
