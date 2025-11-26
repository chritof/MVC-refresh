package raskGjennomgang.raskGjennomgang;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
}
