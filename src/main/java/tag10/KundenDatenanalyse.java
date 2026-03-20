package tag10;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class KundenDatenanalyse {

    public static void kategorienAusgeben(KundenVerwaltung kundenVerwaltung) {
        Set<String> kategorien = new HashSet<>();

        for (Kunde kunde : kundenVerwaltung.getKunden()) {
            kategorien.add(kunde.getKategorie());
        }

        System.out.println("Kategorien:");
        for (String kategorie : kategorien) {
            System.out.println(kategorie);
        }
    }

    public static void kundenNachNameZuordnen(KundenVerwaltung kundenVerwaltung) {
        Map<String, Kunde> kundenMap = new HashMap<>();

        for (Kunde kunde : kundenVerwaltung.getKunden()) {
            kundenMap.put(kunde.getName(), kunde);
        }

        System.out.println("Kunden in der Map:");
        for (String name : kundenMap.keySet()) {
            System.out.println(name + " -> " + kundenMap.get(name).beschreibe());
        }
    }
}