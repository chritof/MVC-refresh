package com.semesterRegistrering.semesterRegistrering;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class EmnelisteController {

    @Autowired
    private EmneRepository emneRepository;

    /**
     * Viser siden med valgemner.
     * Her henter vi emner (f.eks. høst-valgfag) og sender til JSP.
     */
    @GetMapping("/valgemner")
    public String visValgemner(Model model) {
        // Hent emner fra databasen (her velger vi høst-valgfag)
        List<Emne> emner = emneRepository.findBySemesterAndType("h", "v");

        model.addAttribute("emner", emner);
        return "emneliste";  // JSP-filen din heter emneliste.jsp
    }

    /**
     * Behandler innsending av skjema fra JSP-siden.
     * Validerer input, oppdaterer antall interesserte i databasen og viser kvittering.
     */
    @PostMapping("/valgemner")
    public String registrerValg(
            @RequestParam(name = "emnekoder", required = false) List<String> emnevalg,
            RedirectAttributes ra) {

        // Valider input
        if (!erGyldigEmnevalg(emnevalg)) {
            ra.addFlashAttribute("error", "Du må velge mellom 1 og 3 gyldige emner.");
            return "redirect:/valgemner";
        }

        // Oppdater "antall" i databasen for alle valgte emner
        for (String kode : emnevalg) {
            emneRepository.findById(kode).ifPresent(emne -> {
                emne.registrerInteresse(); // Øker antall++
                emneRepository.save(emne);
            });
        }

        ra.addFlashAttribute("success", "Valgene dine er registrert!");
        return "redirect:/valgemner";
    }

    /**
     * Validerer at emnevalget er gyldig:
     * - Listen må inneholde 1–3 emner
     * - Alle må finnes i databasen
     * - Alle må være høst-valgfag
     */
    private boolean erGyldigEmnevalg(List<String> emnevalg) {
        if (emnevalg == null || emnevalg.isEmpty() || emnevalg.size() > 3) {
            return false;
        }

        // Hent alle gyldige høstvalgfag fra databasen
        List<String> gyldigeEmnekoder = emneRepository.findBySemesterAndType("h", "v")
                .stream()
                .map(Emne::getKode)
                .collect(Collectors.toList());

        // Sjekk om alle valgte koder finnes i listen over gyldige
        return gyldigeEmnekoder.containsAll(emnevalg);
    }
}