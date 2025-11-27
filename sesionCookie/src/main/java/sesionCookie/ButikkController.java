package sesionCookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sesionCookie.model.Vare;
import sesionCookie.model.VareListe;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ButikkController {

    //denne koden gjør så langt 2 ting:
    //      1. den lager en sesion for å lagre handlekurven til brukeren.
    //      2. den lager en cookie ut i fra det teksten som bruker skriver i tekstfeltet.


    @GetMapping("/home")
    public String home(Model model, HttpSession session, @CookieValue(name = "tekst", required = false) String tekst) {
        model.addAttribute("vareliste", VareListe.getVareListe());

        List<Vare> handlekurv = (List<Vare>) session.getAttribute("handlekurv");
        if (handlekurv == null) {
            handlekurv = new ArrayList<>();
            session.setAttribute("handlekurv", handlekurv);
        }

        model.addAttribute("handlekurv", handlekurv);

        model.addAttribute("cookieTekst", tekst);

        return "home";
    }

    @PostMapping("/legg-til")
    public String leggTilVare(@RequestParam("id") int id, HttpSession session) {

        // Hent eller opprett handlekurv
        List<Vare> handlekurv = (List<Vare>) session.getAttribute("handlekurv");
        if (handlekurv == null) {
            handlekurv = new ArrayList<>();
            session.setAttribute("handlekurv", handlekurv);
        }

        // Finn vare med riktig id i VareListe
        Vare vare = VareListe.getVareListe().stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);

        if (vare != null) {
            handlekurv.add(vare);
        }

        return "redirect:/home";
    }

    @PostMapping("lag-cookie")
    public String lagCookie(@RequestParam("tekst") String tekst, HttpServletResponse response) {
        Cookie cookie = new Cookie("tekst", tekst);
        cookie.setMaxAge(30);
        response.addCookie(cookie);
        cookie.setPath("/");
        return "redirect:/home";
    }







}
