package com.avdelingCRUDRepo2.avdelingCRUDRepo2;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class myController {

    @Autowired
    private AnsattRepo ansattRepo;

    @Autowired
    private AvdelingRepo avdelingRepo;
    @Autowired
    private FirmaService aService;


    @GetMapping(value = "/avdelinger")
    @ResponseBody
    public List<Avdeling> avdelinger() {
        return aService.finnAlleAvdelinger();
    }

    @GetMapping(value = "/avdelingpaid")
    @ResponseBody
    public String avdeling(@RequestParam int id) {
        Optional<Avdeling> avd = avdelingRepo.findById(id);
        if (avd.isPresent()) {
            return avd.get().toString();
        } else {
            return "No department found with id: " + id;
        }
    }

    @GetMapping("/ansatte")
    @ResponseBody
    public List<Ansatt> ansatt() {
        return ansattRepo.findAll();
    }

    @GetMapping("/ansattpaid")
    @ResponseBody
    public String ansattpaid(@RequestParam int id) {
        Optional<Ansatt> ansatt = ansattRepo.findById(id);
        if (ansatt.isPresent()) {
            return ansatt.get().toString();
        }else{
            return "No department found with id: " + id;
        }
    }
}
