package com.cash.demo.controller;

import com.cash.demo.entity.Interest;
import com.cash.demo.service.InterestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Api(value = "Interests Management System")
@RestController
public class InterestController {

    private final static Logger logger = LoggerFactory.getLogger(InterestController.class);

    @Autowired
    private InterestService interestService;

    @ApiOperation(value = "Gets all interests")
    @GetMapping("/interests")
    public List<Interest> getAllInterests() {
        return interestService.findAllInterests();
    }

    @GetMapping("/interests/{fee}")
    public Interest getInterestByFee(@PathVariable Integer fee) {
        return interestService.findInterest(fee);
    }

    @PostMapping("/interests")
    public Interest addInterests(@Valid @RequestBody Interest interest) {
        return interestService.addInterest(interest);
    }

    @PutMapping("/interests/{fee}")
    public Interest updateInterest(@PathVariable Integer fee, @Valid @RequestBody Interest interest) {
        return interestService.updateInterest(fee, interest);
    }

    @PatchMapping("/interests/{fee}")
    public Interest patchInterest(@PathVariable Integer fee, @Valid @RequestBody Interest interest) {
        return interestService.patchInterest(fee, interest);
    }

    @DeleteMapping("/interests/{fee}")
    void deleteInterest(@PathVariable Integer fee) {
        interestService.deleteInterest(fee);
    }

}
