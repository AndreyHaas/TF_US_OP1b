package tag03.assoziation;

import java.util.ArrayList;

public class Person {
    // Wir speichern alle Personen in einer statischen Liste, damit wir sie bequem iterieren und ausgeben können.
    public static final List<Person> personListe = new ArrayList<>();

    private final int id;
    private String nachname;

    // Liste aller Autos, die diese Person fahren darf. Damit stehen die Autos in Verbindung mit der Person.
    private final List<Auto> darfFahren = new ArrayList<>();

    // Liste aller Haustiere dieser Person. Damit stehen Haustiere in Verbindung mit der Person und wenn wir die Person kennen (d.h. wir haben das Objekt der Person), dann können wir dessen Haustiere abfragen.
    private final List<Haustier> haustierListe = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public List<Auto> getDarfFahren() {
        return darfFahren;
    }

    public List<Haustier> getHaustierListe() {
        return haustierListe;
    }

    // Konstruktor Person-Klasse:
    public Person(int id, String nachname) {
        this.id = id;
        this.nachname = nachname;

        personListe.add(this);
    }
}
