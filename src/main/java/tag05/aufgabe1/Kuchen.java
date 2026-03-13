package tag05.aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class Kuchen {
    private static List<Kuchen> kuchenListe = new ArrayList<>();
    public List<Kuchenstueck> kuchenStuecks = new ArrayList<>();
    private int gesamtGewicht() {
        int gewicht = 0;
        for (Kuchenstueck stueck : kuchenStuecks) {
            gewicht += stueck.getGewicht();
        }
        return gewicht;
    }

    public static void zeigeAlleKuchen() {
        if (kuchenListe.isEmpty()) {
            System.out.println("Es sind keine Kuchen vorhanden.");
            return;
        }

        for (int i = 0; i < kuchenListe.size(); i++) {
            Kuchen kuchen = kuchenListe.get(i);
            System.out.println("\n--- Kuchen " + (i + 1) + " ---");

            List<Kuchenstueck> stuecke = kuchen.kuchenStuecks;
            if (stuecke.isEmpty()) {
                System.out.println("Dieser Kuchen hat keine Stücke.");
            } else {
                for (int j = 0; j < stuecke.size(); j++) {
                    System.out.println("Stück " + (j + 1) + ": " +
                            stuecke.get(j).getGewicht() + "gramm");
                }
                System.out.println("Gesamtgewicht: " + kuchen.gesamtGewicht() + "gramm");
            }
        }
    }

    public Kuchen(List<Integer> gewichte) {
        if (gewichte == null || gewichte.isEmpty()) {
            System.out.println("Fehler: Kuchen muss mindestens ein Stück haben. " +
                    "Kuchen wird nicht zur Liste hinzugefügt.");
            return;
        }

        kuchenListe.add(this);

        for (int gewicht : gewichte) {
            Kuchenstueck kuchenstueck = new Kuchenstueck(gewicht);
            kuchenStuecks.add(kuchenstueck);
        }
    }
}