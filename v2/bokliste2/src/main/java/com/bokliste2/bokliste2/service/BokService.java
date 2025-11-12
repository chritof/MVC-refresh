package com.bokliste2.bokliste2.service;

import com.bokliste2.bokliste2.model.Bok;
import com.bokliste2.bokliste2.repository.BokRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BokService {
    @Autowired
    private BokRepo bokRepo;


    public List<Bok> findAll() {
        return bokRepo.findAll();
    }
}
