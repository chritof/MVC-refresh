package sesionCookie.model;

import java.util.List;

public class FruktListe {

    static List<Frukt> frukt = List.of(
            new Frukt(1, "Banan", 7),
            new Frukt(2, "Eple", 20),
            new Frukt(3, "Pære", 18),
            new Frukt(4, "Appelsin", 12),
            new Frukt(5, "Druer", 30),
            new Frukt(6, "Mango", 25),
            new Frukt(7, "Vannmelon", 45)
    );

    public static List<Frukt> getFrukt() {
        return frukt;
    }
}
