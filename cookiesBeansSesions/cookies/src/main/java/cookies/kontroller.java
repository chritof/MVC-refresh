package cookies;


import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class kontroller {



    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH:mm:ss");

    @GetMapping("/home")
    public String home(
            @CookieValue(name="sisteBesok", required=false) String sisteBesok,
            Model model, HttpServletResponse response) {

        if(sisteBesok == null) {
            model.addAttribute("melding", "Hei. Velkommen første gang til oss.");
        } else {
            model.addAttribute("melding", "Hei. Ser du var sist inne " + sisteBesok);
        }

        Cookie c = new Cookie("sisteBesok", LocalDateTime.now().format(formatter));
        c.setMaxAge(10);
        response.addCookie(c);

        return "home";
    }

    //---------------sesion------------//
    //lagre tekst i HttpSession: (alternativ 1):
    @PostMapping("/save-text")
    public String saveText(@RequestParam String tekst, HttpSession session) {
        session.setAttribute("lagretTekst", tekst);
        return "redirect:/skriv";
    }

    @GetMapping("/skriv")
    public String skriv(HttpSession session, Model model) {
        String tekst = (String) session.getAttribute("lagretTekst");
        model.addAttribute("tekst", tekst);
        return "skriv";
    }

    //-------------------------------------------------------------------------
    //lagre i cookie: (alternativ 2):
    @PostMapping("/save-text2")
    public String saveText(@RequestParam String tekst,
                           HttpServletResponse response) {

        Cookie c = new Cookie("lagretTekst", tekst);
        c.setMaxAge(60 * 60 * 24 * 30); // 30 dager
        c.setPath("/");
        response.addCookie(c);

        return "redirect:/skriv2";
    }

    @GetMapping("/skriv2")
    public String skriv(@CookieValue(name="lagretTekst",
                                required=false) String tekst,
                        Model model) {
        model.addAttribute("tekst", tekst);
        return "skriv2";
    }

}
