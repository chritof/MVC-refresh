package sesionCookie;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String loginPost(@RequestParam String navn, @RequestParam String password, HttpSession session) {
        session.setAttribute("navn", navn);
        session.setAttribute("password", password);
        return "redirect:/home1";
    }

    @GetMapping("/home1")
    public String home1() {
        return "home1";
    }
}
