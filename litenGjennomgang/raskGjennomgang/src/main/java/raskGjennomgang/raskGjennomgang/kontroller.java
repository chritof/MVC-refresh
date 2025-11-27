package raskGjennomgang.raskGjennomgang;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import raskGjennomgang.raskGjennomgang.model.Forfatter;

@Controller
public class kontroller {


    @GetMapping("/sum")
    public String sum(Model model, @RequestParam int a, @RequestParam int b) {
        int sum = a + b;
        model.addAttribute("sum", sum);
        return "sum";
    }

    @GetMapping("/form")
    public String form() {
        return "form";
    }

    @PostMapping("/greet")
    public String greet(Model model, @RequestParam String name) {
        model.addAttribute("greet", name);
        return "greet";
    }

    //--------------Oppgave2----------------//


    @GetMapping("/forfatter")
    public String forfatter(Model model) {
        model.addAttribute("forfatter", new Forfatter());
        return "forfatterForm";
    }

    @PostMapping("/forfatter")
    public String forfatter(
            @Valid @ModelAttribute("forfatter") Forfatter forfatter,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "forfatterForm";
        }

        redirectAttributes.addFlashAttribute("forfatter", forfatter);
        System.out.println("POST /forfatter KJØRER");
        return "redirect:/forfatterResultat";
    }

    //må ha denne hvis jeg bruker redirect. hvis man refresher siden man satte redirect på så kjøres denne metoden.
    @GetMapping("/forfatterResultat")
    public String resultat() {
        System.out.println("GET /forfatterResultat KJØRER");
        return "forfatterResultat";
    }

    
}
