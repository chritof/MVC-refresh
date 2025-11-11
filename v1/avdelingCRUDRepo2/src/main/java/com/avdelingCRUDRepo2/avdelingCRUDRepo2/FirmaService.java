package com.avdelingCRUDRepo2.avdelingCRUDRepo2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FirmaService {

    @Autowired private AvdelingRepo avdelingRepo;

    public List<Avdeling> finnAlleAvdelinger() {
        return avdelingRepo.findAll();
    }


}

