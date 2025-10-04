package com.boksokOgSortering.boksokOgSortering;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoklisteController {

@GetMapping("/noenboker")
public String noenBoke(Model model, @RequestParam(defaultValue = "") String forfatter, @RequestParam("filter") String[] filter, @RequestParam(defaultValue = "onTitle") String sort) {

        Map<String, Comparator<Bok>> comp = new HashMap<>();
        comp.put("onTitle", Comparator.comparing(Bok::getTittel));
        comp.put("onYear", Comparator.comparing(Bok::getUtgivelsesaar));

        List<String> valgtFilter = List.of(filter);

        List<Bok> noenB = Boker.alleBoker.stream()
                .filter(b -> b.getForfatter().contains(forfatter))
                .filter(b -> valgtFilter.contains(b.getGenre()))
                .sorted(comp.get(sort))
                .toList();
        model.addAttribute("boker", noenB);


        return "boklisteView";
}


    @GetMapping("/alleboker")
    public String alleBoker(Model model) {
        model.addAttribute("boker", Boker.alleBoker);
        return "boklisteView";
    }

}
