package com.buttonsNettbutikk.buttonsNettbutikk;


import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ButikkController {

    @Autowired
    VareRepository vareRepository;

    @GetMapping("/butikk")
    public String butikk(Model model, HttpSession session) {
        if (session.getAttribute("handlekurv") == null) {
            session.setAttribute("handlekurv", new Handlekurv());
        }
        List<Vare> varer = vareRepository.findAll();
        model.addAttribute("varer", varer);
        return "butikk";
    }

    @PostMapping("/handle")
    public String visButikk(@RequestParam int vareid, @RequestParam int antall,
                            HttpSession session) {

        Vare vare = vareRepository.findById(vareid).orElse(null);
        if (vare != null) {
            Handlekurv handlekurv = (Handlekurv) session.getAttribute("handlekurv");
            handlekurv.leggTilEtAntallAvEnVare(vare, antall);
        }
        return "redirect:/butikk";
    }

    @PostMapping("/fjerne")
    public String fjerne(HttpSession session, @RequestParam int vareid) {
        Handlekurv handlekurv = (Handlekurv) session.getAttribute("handlekurv");
        handlekurv.fjernOrdrelinje(vareid);
        return "redirect:/butikk";
    }

}
