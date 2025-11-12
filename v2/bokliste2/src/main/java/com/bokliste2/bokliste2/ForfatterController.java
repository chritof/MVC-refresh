package com.bokliste2.bokliste2;


import com.bokliste2.bokliste2.model.Bok;
import com.bokliste2.bokliste2.model.Forfatter;
import com.bokliste2.bokliste2.repository.BokRepo;
import com.bokliste2.bokliste2.repository.ForfatterRepo;
import com.bokliste2.bokliste2.service.BokService;
import com.bokliste2.bokliste2.service.ForfatterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ForfatterController {

    @Autowired
    private ForfatterService forfatterService;
    @Autowired
    private ForfatterRepo forfatterRepo;
    @Autowired
    private BokService bokService;
    @Autowired
    private BokRepo bokRepo;

    @GetMapping("/forfattere")
    public String forfattere(Model model) {
        List<Forfatter> forfattere = forfatterRepo.findAll();
        model.addAttribute("forfattere", forfattere);
        return "forfattere";
    }

    @PostMapping("/forfatter")
    public String lagebok(@RequestParam String title, @RequestParam int year, Model model) {
        Bok bok = new Bok();
        bok.setTitle(title);
        bok.setYearOfRelease(year);
        bokRepo.save(bok);
        return "bokbekreftelse";
    }

    @GetMapping("/registrerbok")
    public String registrerbok(Model model) {

        List<String> forfattere = forfatterRepo.findAll().stream()
                .map(Forfatter::getAuthorLName)
                .collect(Collectors.toList());
        model.addAttribute("forfatternavn", forfattere);
        return "registrerBok";
    }

}
