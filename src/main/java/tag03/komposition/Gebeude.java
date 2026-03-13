package tag03.komposition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Gebeude {
    final ArrayList<Raum> raumListe = new ArrayList<>();
    private String name;

    public String getName() {
        return name;
    }

    // Konstruktor mit Name und erster Raumnummer
    public Gebeude(String name, int raumNummer) {
        this.name = name;
        System.out.println("Gebäude \"" + name + "\" wird erstellt");
        addRaum(raumNummer); // Ersten Raum direkt hinzufügen
    }

    // Methode zum Hinzufügen eines neuen Raums
    public void addRaum(int raumNummer) {
        Raum neuerRaum = new Raum(raumNummer);
        raumListe.add(neuerRaum);
    }

    // Methode zur Ausgabe aller Räume
    public String getRaume() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");

        Iterator<Raum> iterator = raumListe.iterator();
        while (iterator.hasNext()) {
            Raum r = iterator.next();
            sb.append(r.getRaumNummer());
            if (iterator.hasNext()) {
                sb.append(", ");
            }
        }

        sb.append(" ]");
        return sb.toString();
    }

    @Override
    protected void finalize() {
        System.out.println(this.getClass().getName() + " " + getName() + "\" wird gelöscht (finalize)");
    }
}
