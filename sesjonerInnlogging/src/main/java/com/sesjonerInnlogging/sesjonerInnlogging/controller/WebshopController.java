package com.sesjonerInnlogging.sesjonerInnlogging.controller;

import java.util.List;

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
            HttpSession session, RedirectAttributes ra) {

        if (!LoginUtil.erBrukerInnlogget(session)) {
            ra.addFlashAttribute("redirectMessage", "Du må være innlogget ...");
            return "redirect:login";
        }

        Cart cart = (Cart) session.getAttribute("cart");
        if (varer != null && varer.contains("bukse")) {
            cart.addItem(new CartItem("Bukse", 699));
        }
        //...

        return "redirect:webshop";
    }
}
