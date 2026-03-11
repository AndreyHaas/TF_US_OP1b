package tag03.komposition;

import java.util.ArrayList;
import java.util.Iterator;

public class Gebäude {
    // Möchte ich eine Komposition umsetzen, muss ich darauf achten, dass die Teile nicht außerhalb des Ganzen existieren.
    // Hier dürfen die Räume nur innerhalb der Klasse Gebäude verfügbar sein, damit sie gelöscht werden, wenn das Gebäude gelöscht wird.
    final List<Raum> raumListe = new ArrayList<>();

    private String name;

    public String getName() {
        return name;
    }

    public Gebäude(String name, int raumNummer) {
        this.name = name;
        addRaum(raumNummer);
    }

    // Finalizer zur Demonstration. Der Finalizer sollte in richtigen Programmen nicht verwendet werden!
    // Ist in Versionen nach Java 8 als "Deprecated" markiert und nicht mehr verwendbar.
    protected void finalize() {
        System.out.println("Das Gebäude mit dem Namen " + name + " wurde gelöscht!");
    }

    public String getRäume() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Iterator<Raum> it = raumListe.iterator(); it.hasNext(); ) {
            Raum r = it.next();
            sb.append(r.getRaumNummer());
            if (it.hasNext())
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public void addRaum(int raumNummer) {
        raumListe.add(new Raum(raumNummer));
        // Raum-Objekt erzeugen und der Liste hinzufügen. Das Objekt existiert damit nur innerhalb der Liste.
    }
}
