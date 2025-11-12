package com.bokliste2.bokliste2;


import com.bokliste2.bokliste2.model.Bok;
import com.bokliste2.bokliste2.model.Forfatter;
import com.bokliste2.bokliste2.service.BokService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.StreamSupport.stream;


@Controller
public class BokController {

    @Autowired
    private BokService bokService;

    //metode for å sortere bøkene på utgivelsesår:
    @GetMapping("/allebokersortertpaar")
    public String alleBoker(Model model) {
        List<Bok> bokList = bokService.findAll();
        List<Bok> sortert = bokService.findAll().stream()
                .sorted(Comparator.comparingInt(Bok::getYearOfRelease))
                .collect(Collectors.toList());
        model.addAttribute("bokList", sortert);
        return "alleBoker";
    }

    //metode for å sortere bøkene på tittel:
    @GetMapping("/allebokersortertpatittel")
    public String bokerPatittel(Model model) {
    List<Bok> tittel = bokService.findAll().stream()
            .sorted(Comparator.comparing(Bok::getTitle))
            .collect(Collectors.toList());
        model.addAttribute("bokList", tittel);
        return "alleBoker";
    }

    @GetMapping("/allebokersortertpaforfatter")
    public String alleBokerFatter(Model model) {
        List<Bok> fatter = bokService.findAll().stream()
                .sorted(Comparator.comparing(
                        bok -> bok.getAuthors().stream()
                                .findFirst()
                                .map(Forfatter::getAuthorLName)
                                .orElse("")
                ))
                .collect(Collectors.toList());
        model.addAttribute("bokList", fatter);
        return "alleBoker";
    }


}