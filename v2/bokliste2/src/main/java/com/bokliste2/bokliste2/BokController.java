package com.bokliste2.bokliste2;

import com.bokliste2.bokliste2.model.Bok;
import com.bokliste2.bokliste2.model.Forfatter;
import com.bokliste2.bokliste2.repository.BokRepo;
import com.bokliste2.bokliste2.repository.ForfatterRepo;
import com.bokliste2.bokliste2.service.BokService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Comparator;
import java.util.List;

@Controller
public class BokController {

    private final BokService bokService;
    private final BokRepo bokRepo;
    private final ForfatterRepo forfatterRepo;

    public BokController(BokService bokService, BokRepo bokRepo, ForfatterRepo forfatterRepo) {
        this.bokService = bokService;
        this.bokRepo = bokRepo;
        this.forfatterRepo = forfatterRepo;
    }

    // --- Lister bøker sortert etter år ---
    @GetMapping("/allebokersortertpaar")
    public String alleBoker(Model model) {
        List<Bok> sortert = bokService.findAll().stream()
                .sorted(Comparator.comparingInt(Bok::getYearOfRelease))
                .toList();
        model.addAttribute("bokList", sortert);
        return "alleBoker";
    }

    // --- Lister bøker sortert etter tittel ---
    @GetMapping("/allebokersortertpatittel")
    public String bokerPatittel(Model model) {
        List<Bok> tittel = bokService.findAll().stream()
                .sorted(Comparator.comparing(Bok::getTitle))
                .toList();
        model.addAttribute("bokList", tittel);
        return "alleBoker";
    }

    // --- Lister bøker sortert etter (alfabetisk første) forfatter ---
    @GetMapping("/allebokersortertpaforfatter")
    public String alleBokerFatter(Model model) {
        List<Bok> fatter = bokService.findAll().stream()
                .sorted(Comparator.comparing(
                        bok -> bok.getAuthors().stream()
                                .map(Forfatter::getAuthorLName)
                                .sorted()           // gjør rekkefølgen stabil
                                .findFirst()
                                .orElse("")
                ))
                .toList();
        model.addAttribute("bokList", fatter);
        return "alleBoker";
    }

    // --- Viser registreringsskjema for forfatter ---
    @GetMapping("/registrerforfatter")
    public String registrerForfatter(Model model) {
        model.addAttribute("bokList", bokService.findAll());
        return "registrerForfatter"; // JSP-skjema
    }

    // --- Tar imot skjema, lagrer og redirecter til bekreftelse (PRG) ---
    @PostMapping("/registrerforfatter")
    public String registrerforfatter(@RequestParam String fname,
                                     @RequestParam String lname,
                                     @RequestParam(value = "bokIds", required = false) List<Integer> bokIds,
                                     RedirectAttributes redirectAttributes) {

        // 1) lag ny forfatter
        Forfatter f = new Forfatter();
        f.setAuthorFName(fname);
        f.setAuthorLName(lname);

        // 2) koble valgte bøker (trygt om ingen er valgt)
        List<Bok> valgte = (bokIds == null || bokIds.isEmpty())
                ? List.of()
                : bokRepo.findAllById(bokIds);

        // EIERSIDEN er Bok.authors – oppdater begge veier:
        for (Bok b : valgte) {
            b.getAuthors().add(f);  // owning side
            f.getBooks().add(b);    // inverse side
        }

        // 3) lagre (med CascadeType.PERSIST/MERGE på Bok.authors holder dette)
        forfatterRepo.save(f);
        // hvis du IKKE har cascade på Bok.authors: bokRepo.saveAll(valgte);

        // 4) flash-attributter til bekreftelsessiden
        redirectAttributes.addFlashAttribute("fnamevisning", fname);
        redirectAttributes.addFlashAttribute("lnamevisning", lname);
        redirectAttributes.addFlashAttribute(
                "boktitler",
                valgte.stream().map(Bok::getTitle).toList()
        );

        return "redirect:/forfatterbekreftelse";
    }

    // --- Bekreftelsesside (GET etter redirect) ---
    @GetMapping("/forfatterbekreftelse")
    public String forfatterBekreftelse() {
        return "forfatterbekreftelse";
    }
}