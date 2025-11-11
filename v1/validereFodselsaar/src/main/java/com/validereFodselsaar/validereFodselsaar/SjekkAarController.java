package com.validereFodselsaar.validereFodselsaar;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class SjekkAarController {

    @GetMapping("/skjema")
    public String aarstallSkjema() {
        return "skjema";
    }

    @GetMapping("/sjekkAar")
    public String sjekkFodselsaar(Model model, String fodselsaar) {

        //"Guard" - Vi sjekker og håndterer feilsituasjoner først
        boolean gyldig = InputValidator.erGyldigAarstall(fodselsaar);

        // ...

        //Kommer vi hit, er alt i orden
        model.addAttribute("gyldig", gyldig);
        return "tilbakemelding";
    }

}

