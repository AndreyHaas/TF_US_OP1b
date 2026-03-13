package tag05.aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class KuchenSteuerApp {
    public static void main(String[] args) {
        System.out.println("=== Kuchen-Programm gestartet ===\n");

        // 1. Kuchen mit 0 Stücken (wird nicht zur Liste hinzugefügt)
        System.out.println("1. Versuch: Kuchen mit 0 Stücken:");
        Kuchen kuchen0 = new Kuchen(new ArrayList<>());

        // 2. Kuchen mit 3 Stücken
        System.out.println("\n2. Kuchen mit 3 Stücken wird erstellt:");
        List<Integer> gewichte1 = new ArrayList<>();
        gewichte1.add(150);
        gewichte1.add(200);
        gewichte1.add(175);
        Kuchen kuchen1 = new Kuchen(gewichte1);

        // 3. Kuchen mit 4 Stücken
        System.out.println("\n3. Kuchen mit 4 Stücken wird erstellt:");
        List<Integer> gewichte2 = new ArrayList<>();
        gewichte2.add(120);
        gewichte2.add(130);
        gewichte2.add(140);
        gewichte2.add(150);
        Kuchen kuchen2 = new Kuchen(gewichte2);

        // 4. Kuchen mit 5 Stücken
        System.out.println("\n4. Kuchen mit 5 Stücken wird erstellt:");
        List<Integer> gewichte3 = new ArrayList<>();
        gewichte3.add(100);
        gewichte3.add(110);
        gewichte3.add(120);
        gewichte3.add(130);
        gewichte3.add(140);
        Kuchen kuchen3 = new Kuchen(gewichte3);

        // Alle Kuchen anzeigen
        System.out.println("\n\n=== Alle Kuchen und ihre Stücke ===");
        Kuchen.zeigeAlleKuchen();
    }
}
