package sesionCookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sesionCookie.model.Frukt;
import sesionCookie.model.FruktListe;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FruktController {



    @GetMapping("/frukt")
    public String frukt(Model model, HttpSession session, HttpServletResponse response, @CookieValue(name = "antallFrukt", required = false) String antallFrukt) {

        model.addAttribute("fruktListe", FruktListe.getFrukt());

        List<Frukt> sessionFrukt = (List<Frukt>) session.getAttribute("sessionFrukt");
        if (sessionFrukt == null) {
            sessionFrukt = new ArrayList<>();
            session.setAttribute("sessionFrukt", sessionFrukt);
        }
        model.addAttribute("sessionFrukt", sessionFrukt);

        if (antallFrukt == null) {
            antallFrukt = String.valueOf(sessionFrukt.size());
        }

        //vil lage en måte hvor vi lagrer antall elementer i brukeren sik fruktliste
        //i en cookie og viser denne på jsp siden:

        model.addAttribute("antallFrukt", antallFrukt);


        model.addAttribute("sessionAntall", antallFrukt); // kommer fra cookie


        return "frukt";
    }

    @PostMapping("/frukt-leggtil")
    public String fruktLeggtil(Model model, @RequestParam int id, HttpSession session, HttpServletResponse response) {

        List<Frukt> sessionFrukt = (List<Frukt>) session.getAttribute("sessionFrukt");
        if (sessionFrukt == null) {
            sessionFrukt = new ArrayList<>();
            session.setAttribute("sessionFrukt", sessionFrukt);
        }

        Frukt finnFrukt = FruktListe.getFrukt().stream().
                filter(x -> x.getId() == id).findFirst().orElse(null);
        sessionFrukt.add(finnFrukt);


        //trenger ikke denne siden etter etter bruker aktiverer denne metoden sender
        //denne metoden videre til getmapping hvor vi der lar jsp-en får tilgang til
        //sessionfrukt!
        //model.addAttribute("sessionFrukt", sessionFrukt);


        // Oppdater cookie med antall frukt i session
        Cookie c = new Cookie("antallFrukt",
                String.valueOf(sessionFrukt.size()));
        c.setMaxAge(15);   // varer i 15 sek (bare demo)
        c.setPath("/");    // tilgjengelig for hele appen
        response.addCookie(c);

        return "redirect:/frukt";
    }

}
