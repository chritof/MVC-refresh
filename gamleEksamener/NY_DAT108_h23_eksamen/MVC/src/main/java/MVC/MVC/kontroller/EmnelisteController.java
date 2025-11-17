package MVC.MVC.kontroller;

import MVC.MVC.model.emne;
import MVC.MVC.repo.EmneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmnelisteController {

    @Autowired
    private EmneRepository emneRepository;

    // GET: viser selve emnelisten (samsvarer med JSP-en "emneliste.jsp")
    @GetMapping("/velgemner")
    public String emneliste(Model model) {
        model.addAttribute("emneliste", emneRepository.findAll());
        return "emneliste";
    }

    // POST: behandler innsending av skjema
    @PostMapping("/registrer")
    public String velgEmner(
            @RequestParam(value = "valgteEmner", required = false) List<String> emnevalg,
            RedirectAttributes redirectAttributes) {

        boolean vellykket = erGyldigEmnevalg(emnevalg);

        if (vellykket) {
            // Gyldig input → oppdater databasen og lag kvitteringsmelding
            for (String kode : emnevalg) {
                emne e = emneRepository.findById(kode).orElse(null);
                if (e != null) {
                    e.setAntall(e.getAntall() + 1);
                    emneRepository.save(e);
                }
            }
            redirectAttributes.addFlashAttribute("melding", "Riktig, emnene er registrert");
            redirectAttributes.addFlashAttribute("farge", "green");
        } else {
            // Ugyldig input → ingen endring i databasen, bare feilmelding
            redirectAttributes.addFlashAttribute("melding", "Feil i brukerinput");
            redirectAttributes.addFlashAttribute("farge", "red");
        }

        // PRG-mønster: redirect tilbake til GET /velgemner
        return "redirect:/velgemner";
    }

    /**
     * Validerer at emnevalg:
     *  - ikke er null
     *  - har 1–3 emnekoder
     *  - alle kodene finnes som registrerte høst-valgfag i databasen
     */
    private boolean erGyldigEmnevalg(List<String> emnevalg) {

        if (emnevalg == null || emnevalg.isEmpty() || emnevalg.size() > 3) {
            return false;
        }

        List<emne> alleEmner = emneRepository.findAll();
        List<String> gyldigeKoder = new ArrayList<>();

        for (emne e : alleEmner) {
            // Høstvalgfag: semester = 'h', type = 'v'
            // Høstvalgfag: semester = 'h', type = 'v'
            if ("h".equalsIgnoreCase(String.valueOf(e.getSemester())) &&
                    "v".equalsIgnoreCase(String.valueOf(e.getType()))) {

                gyldigeKoder.add(e.getKode());
            }
        }

        return gyldigeKoder.containsAll(emnevalg);
    }
}