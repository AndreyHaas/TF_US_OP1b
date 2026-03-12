package tag03.komposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Gebeude {
    private final String name;
    // Möchte ich eine Komposition umsetzen, muss ich darauf achten, dass die Teile nicht außerhalb des Ganzen existieren.
    // Hier dürfen die Räume nur innerhalb der Klasse Gebäude verfügbar sein, damit sie gelöscht werden, wenn das Gebäude gelöscht wird.
    final List<Raum> raumListe = new ArrayList<>();


    public String getName() {
        return name;
    }

    public Gebeude(String name, int raumNummer) {
        this.name = name;
        addRaum(raumNummer);
    }

    // Finalizer zur Demonstration. Der Finalizer sollte in richtigen Programmen nicht verwendet werden!
    // Ist in Versionen nach Java 8 als "Deprecated" markiert und nicht mehr verwendbar.
    protected void finalize() {
        System.out.println("Das Gebäude mit dem Namen " + name + " wurde gelöscht!");
    }

    public String getRaume() {
        StringBuilder sb = new StringBuilder("[");
        Iterator<Raum> iterator = raumListe.iterator();

        while (iterator.hasNext()) {
            sb.append(iterator.next().getRaumNummer());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");

        return sb.toString();
    }

    public void addRaum(int raumNummer) {
        raumListe.add(new Raum(raumNummer));
        // Raum-Objekt erzeugen und der Liste hinzufügen. Das Objekt existiert damit nur innerhalb der Liste.
    }
}
