package com.lolitaflamme.coffeefindermysqlmvc.repository;

import com.lolitaflamme.coffeefindermysqlmvc.domain.Coffee;
import org.springframework.data.repository.CrudRepository;

public interface CoffeeRepository extends CrudRepository<Coffee, Long> {
}
