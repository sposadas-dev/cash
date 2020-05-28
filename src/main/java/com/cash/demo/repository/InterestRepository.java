package com.cash.demo.repository;

import com.cash.demo.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Integer> {

    Interest findByFee(Integer fee);

}
