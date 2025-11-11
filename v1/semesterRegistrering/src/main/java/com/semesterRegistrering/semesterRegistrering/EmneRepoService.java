package com.semesterRegistrering.semesterRegistrering;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class EmneRepoService {

    @Autowired
    private EmneRepository emneRepository;

    public List<Emne> finnValgemnerForSemester(String semester) { // "v" eller "h"
        return emneRepository.findBySemester(semester);
    };

    public void registrerInteresseFor(List<String> emnekoder){
        for (String kode : emnekoder) {
            emneRepository.findById(kode).ifPresent(emne -> {
                emne.registrerInteresse();
                emneRepository.save(emne);
            });
        }
    }
}
