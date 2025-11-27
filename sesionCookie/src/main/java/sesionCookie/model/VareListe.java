package sesionCookie.model;

import java.util.List;

public class VareListe {

    static List<Vare> vare = List.of(
            new Vare(1, "bil", "rask bil", 2_000_000),
            new Vare(2, "hus", "stort hus", 1_900_000),
            new Vare(3, "båt", "liten fiskebåt", 150_000),
            new Vare(4, "pc", "gaming pc", 22_000),
            new Vare(5, "telefon", "ny iPhone", 12_000),
            new Vare(6, "sykkel", "terrengsykkel", 7_500),
            new Vare(7, "tv", "75\" OLED TV", 18_000),
            new Vare(8, "koffert", "stor reisekoffert", 1_200)
    );

    public static List<Vare> getVareListe() {
        return vare;
    }
}
