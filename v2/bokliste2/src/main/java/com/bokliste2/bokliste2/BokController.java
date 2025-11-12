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

import java.util.ArrayList;
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

    @GetMapping("/allebokersortertpaar")
    public String alleBoker(Model model) {
        List<Bok> sortert = bokService.findAll().stream()
                .sorted(Comparator.comparingInt(Bok::getYearOfRelease))
                .toList();
        model.addAttribute("bokList", sortert);
        return "alleBoker";
    }

    @GetMapping("/allebokersortertpatittel")
    public String bokerPatittel(Model model) {
        List<Bok> tittel = bokService.findAll().stream()
                .sorted(Comparator.comparing(Bok::getTitle))
                .toList();
        model.addAttribute("bokList", tittel);
        return "alleBoker";
    }

    @GetMapping("/allebokersortertpaforfatter")
    public String alleBokerFatter(Model model) {
        List<Bok> fatter = bokService.findAll().stream()
                .sorted(Comparator.comparing(
                        bok -> bok.getAuthors().stream()
                                .map(Forfatter::getAuthorLName)
                                .sorted()
                                .findFirst()
                                .orElse("")
                ))
                .toList();
        model.addAttribute("bokList", fatter);
        return "alleBoker";
    }

    @GetMapping("/registrerforfatter")
    public String registrerForfatter(Model model) {
        model.addAttribute("bokList", bokService.findAll());
        return "registrerForfatter";
    }

    @PostMapping("/registrerforfatter")
    public String registrerforfatter(@RequestParam String fname,
                                     @RequestParam String lname,
                                     @RequestParam(required = false) List<Integer> bokIds,
                                     RedirectAttributes redirectAttributes) {

        Forfatter forfatter = new Forfatter();
        forfatter.setAuthorFName(fname);
        forfatter.setAuthorLName(lname);

        List<Bok> valgte = (bokIds == null || bokIds.isEmpty())
                ? List.of()
                : bokRepo.findAllById(bokIds);


        for (Bok b : valgte) {
            b.getAuthors().add(forfatter);
            forfatter.getBooks().add(b);
        }

        forfatterRepo.save(forfatter);

        redirectAttributes.addFlashAttribute("fnamevisning", fname);
        redirectAttributes.addFlashAttribute("lnamevisning", lname);
        redirectAttributes.addFlashAttribute("boktitler",
                valgte.stream().map(Bok::getTitle).toList()
        );
        //utne redirect her, så ville nettsiden lagt inn en helt lik forfatter med samme verdier
        //hver gang du refresher sidne. la oss si at du refresher sidne 12 ganager, da vil systemer
        //lage 12 like objekter i databasen (med forskjellig id).
        return "redirect:/forfatterbekreftelse";
    }

    @GetMapping("/forfatterbekreftelse")
    public String forfatterBekreftelse() {
        return "forfatterbekreftelse";
    }
}