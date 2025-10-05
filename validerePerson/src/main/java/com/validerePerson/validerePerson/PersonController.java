package com.validerePerson.validerePerson;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@Controller
public class PersonController {

    @GetMapping("/personskjema")
    public String personskjema() {
        return "personskjema";
    }

    @GetMapping("/sjekkPerson")
    public String sjekkPerson(Model model,
                              @Valid @ModelAttribute("person") Person person,
                              BindingResult bindingResult) {

        // Hvis det finnes valideringsfeil
        if (bindingResult.hasErrors()) {
            List<String> feilmeldinger = bindingResult.getAllErrors().stream()
                    .map(e -> e.getDefaultMessage()).toList();

            model.addAttribute("feilmeldinger", feilmeldinger);
            return "personskjema";
        }

        model.addAttribute("person", person);
        return "personkvittering";
    }





    /**
     *
     *  @GetMapping("/sjekkPerson")
     *     public String sjekkPerson(Model model, @ModelAttribute("person") Person person) {
     *
     *         return "personkvittering";
     *     }
     *
     *
     * disse gjør det samme!!
     *
     *
     *  @GetMapping("/sjekkPerson")
     *     public String sjekkPerson(@RequestParam String navn,
     *                               @RequestParam String mobil,
     *                               @RequestParam int hoydecm,
     *                               @RequestParam String fdato,
     *                               Model model) {
     *         Person p = new Person();
     *         p.setNavn(navn);
     *         p.setMobil(mobil);
     *         p.setHoydecm(hoydecm);
     *         p.setFdato(LocalDate.parse(fdato));
     *         model.addAttribute("person", p);
     *         return "personkvittering";
     *         }
     *
    */

}
