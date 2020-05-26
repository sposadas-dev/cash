package com.cash.demo.repository;

import com.cash.demo.entity.Interest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends CrudRepository<Interest, Integer> {

    public Interest findByFee(Integer fee);

}
