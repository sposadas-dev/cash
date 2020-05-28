package com.cash.demo.service.impl;

import com.cash.demo.entity.Interest;
import com.cash.demo.repository.InterestRepository;
import com.cash.demo.service.InterestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
public class InterestServiceImpl implements InterestService {

    private final static Logger logger = LoggerFactory.getLogger(InterestServiceImpl.class);

    @Autowired
    private InterestRepository interestRepository;

    @Override
    public List<Interest> findAllInterests() {
        return interestRepository.findAll();
    }

    @Override
    public Interest findInterest(Integer fee) {
        return interestRepository.findByFee(fee);
    }

    @Override
    public Interest addInterest(Interest interest) {
        return interestRepository.save(interest);
    }

    @Override
    public Interest updateInterest(Integer fee, Interest interest) {
        if (interestRepository.existsById(fee)) {
            interest.setFee(fee);
        }
        return interestRepository.save(interest);
    }

    @Override
    public Interest patchInterest(Integer fee, Interest interest) {
        Interest interestBefore = interestRepository.findByFee(fee);
        if (interestBefore == null) {
            throw new EntityNotFoundException("The interest from {" + fee + "} fees not exists");
        }
        interest.setFee(fee);
        return interestRepository.save(interest);
    }

    @Override
    public void deleteInterest(Integer fee) {
        if (interestRepository.existsById(fee)) {
            interestRepository.deleteById(fee);
        }
    }

}
