package com.validereFodselsaar.validereFodselsaar;

public class InputValidator {

    /*
     * "Et gyldig fødselsår er 4 siffer og er mellom 1900 og året vi er i nå"
     */
    static boolean erGyldigAarstall(String s) {

        // Steg 1: Ikke godta null
        if (s == null) {
            return false;
        }

        // Steg 2: Ikke godta om det ikke kan parses til et heltall
        int aar;
        try {
            aar = Integer.parseInt(s);  // prøv å gjøre om til tall
        } catch (NumberFormatException e) {
            return false; // returner false hvis det ikke er tall
        }

        // Steg 3: Sjekke om det er et gyldig år (1900 <= år <= nåværende år)
        int innevaerendeAar = java.time.Year.now().getValue();

        if (s.length() == 4 && aar >= 1900 && aar <= innevaerendeAar) {
            return true;  // gyldig
        } else {
            return false; // ugyldig
        }
    }
}

