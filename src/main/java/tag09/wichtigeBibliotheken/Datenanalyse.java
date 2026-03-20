package tag09.wichtigeBibliotheken;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Datenanalyse {

    public static void kategorienAusgaben(ProduktVerwaltung produktVerwaltung) {
        Set<String> kategorien = new HashSet<>();

        for (Produkt produkt : produktVerwaltung.getProdukte()) {
            kategorien.add(produkt.getKategorie());
        }
        System.out.println("Kategorien: ");

        for (String kategorie : kategorien) {
            System.out.println(kategorie);
        }

    }

    public static void produkteNachNameZuordnen(ProduktVerwaltung produktVerwaltung) {
        Map<String, Produkt> produktMap = new HashMap<>();

        for (Produkt produkt : produktVerwaltung.getProdukte()) {
            produktMap.put(produkt.getName(), produkt);
        }
        System.out.println("Produkte in der Map:");

        for (String name : produktMap.keySet()) {
            System.out.println(name + "->" + produktMap.get(name).beschreibe());
        }
    }
}