package com.personRegskjema.personRegskjema;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistreringController {

    // Viser skjemaet (kun hvis du heller vil at Spring skal levere det istedenfor static/)
    @GetMapping("/regskjema")
    public String visSkjema() {
        return "redirect:/regskjema.html";
    }

    // Tar imot POST fra skjemaet
    @PostMapping("/registrer")
    public String registrer(
            @RequestParam String navn,
            @RequestParam int alder,
            Model model) {

        // Legg inn data i modellen
        model.addAttribute("navn", navn);
        model.addAttribute("alder", alder);

        // Gå til kvittering.jsp
        return "kvittering";
    }
}

