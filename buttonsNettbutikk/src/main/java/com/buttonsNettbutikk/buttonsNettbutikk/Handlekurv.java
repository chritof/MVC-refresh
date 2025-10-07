package com.buttonsNettbutikk.buttonsNettbutikk;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Handlekurv {

    // Liste over alle ordrelinjer (varer + antall)
    private List<Ordelinje> ordrelinjer = new ArrayList<>();

    /**
     * Legger til et gitt antall av en vare i handlekurven.
     * Hvis varen finnes fra før, øker antallet. Hvis ikke, legges den til som ny.
     */
    public void leggTilEtAntallAvEnVare(Vare vare, int antall) {
        if (vare == null || antall <= 0) {
            return; // ugyldig input
        }

        for (Ordelinje ol : ordrelinjer) {
            if (ol.getVare().getId() == vare.getId()) {
                ol.setAntall(ol.getAntall() + antall);
                return;
            }
        }

        // Opprett ny ordrelinje
        Ordelinje nyOrdre = new Ordelinje();
        nyOrdre.setVare(vare);
        nyOrdre.setAntall(antall);
        ordrelinjer.add(nyOrdre);
    }

    /**
     * Fjerner en ordrelinje (vare) helt fra handlekurven basert på vare-ID.
     */
    public void fjernOrdrelinje(int vareid) {
        Iterator<Ordelinje> iterator = ordrelinjer.iterator();
        while (iterator.hasNext()) {
            Ordelinje ol = iterator.next();
            if (ol.getVare().getId() == vareid) {
                iterator.remove();
                return;
            }
        }
    }

    /**
     * Sjekker om handlekurven er tom.
     */
    public boolean isTom() {
        return ordrelinjer.isEmpty();
    }

    /**
     * Returnerer alle ordrelinjene (brukes i JSP med JSTL for å vise innholdet).
     */
    public Collection<Ordelinje> getOrdrelinjer() {
        return ordrelinjer;
    }

    /**
     * Regner ut totalbeløpet for alle varer i handlekurven.
     */
    public int getTotal() {
        int total = 0;
        for (Ordelinje ol : ordrelinjer) {
            total += ol.getBelop();
        }
        return total;
    }
}