package com.cash.demo.repository;

import com.cash.demo.entity.Fee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeeRepository extends CrudRepository<Fee, Integer> {
}
