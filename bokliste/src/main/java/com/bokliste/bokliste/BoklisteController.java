package com.bokliste.bokliste;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bokliste.bokliste.Boker;

import static com.bokliste.bokliste.Boker.alleboker;

@Controller
public class BoklisteController {

    @GetMapping("/alleboker")
    public String alleBoker(Model model) {
        model.addAttribute("bokliste", Boker.alleboker);
        return "boklisteView";
    }
}