package com.bokliste2.bokliste2.service;


import com.bokliste2.bokliste2.repository.ForfatterRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ForfatterService {

    @Autowired
    private ForfatterRepo forfatterRepo;
}
