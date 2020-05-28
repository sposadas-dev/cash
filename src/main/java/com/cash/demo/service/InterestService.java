package com.cash.demo.service;

import com.cash.demo.entity.Interest;

import java.util.List;

public interface InterestService {

    List<Interest> findAllInterests();

    Interest findInterest(Integer fee);

    Interest addInterest(Interest interest);

    Interest updateInterest(Integer fee, Interest interest);

    Interest patchInterest(Integer fee, Interest interest);

    void deleteInterest(Integer fee);
}
