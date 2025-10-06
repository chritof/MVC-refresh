package com.sesjonerInnlogging.sesjonerInnlogging.controller;

import java.util.List;
import java.util.Map;

import com.sesjonerInnlogging.sesjonerInnlogging.model.Cart;
import com.sesjonerInnlogging.sesjonerInnlogging.model.CartItem;
import com.sesjonerInnlogging.sesjonerInnlogging.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/webshop")
public class WebshopController {

    /*
     * GET /webshop er forespørselen for å vise webshop-siden.
     */
    @GetMapping
    public String visWebshoppen(HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", "Du må være innlogget ...");
            return "redirect:login";
        }
        return "webshopView";
    }

    /*
     * POST /webshop er forespørselen for å handle en/flere varer.
     */
    @PostMapping
    public String leggVarerIHandlekurv(
            @RequestParam(name="vare", required=false) List<String> varer,
            HttpSession session,
            RedirectAttributes ra) {

        // Sjekk om brukeren er innlogget
        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", "Du må være innlogget ...");
            return "redirect:login";
        }

        // Hent eller opprett handlekurv
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        // Definer en "katalog" med tilgjengelige varer
        Map<String, CartItem> katalog = Map.of(
                "bukse",  new CartItem("Bukse", 699),
                "genser", new CartItem("Genser", 499),
                "jakke",  new CartItem("Jakke", 999)
        );

        // Legg til varer som brukeren har valgt
        if (varer != null) {
            for (String valgtVare : varer) {
                CartItem item = katalog.get(valgtVare);
                if (item != null) {
                    cart.addItem(new CartItem(item.getName(), item.getPrice()));
                }
            }
        }

        // Etter at varer er lagt i handlekurv, redirect til webshop
        return "redirect:webshop";
    }
}
