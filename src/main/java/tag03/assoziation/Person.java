package tag03.assoziation;

import java.util.ArrayList;
import java.util.List;

public class Person {

  // Wir speichern alle Personen in einer statischen Liste, damit wir sie bequem iterieren und ausgeben können.
  protected static final List<Person> PERSONEN_LISTE = new ArrayList<>();

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
  public List<Person> getPersonenListe() {
    return PERSONEN_LISTE;
  }

  public List<Haustier> getHaustierListe() {
    return haustierListe;
  }

  public Person(int id, String nachname) {
    this.id = id;
    this.nachname = nachname;
    // Automatisch in statische Liste eintragen
    PERSONEN_LISTE.add(this);
  }

  public void addDarfFahren(Auto auto) {
    if (!darfFahren.contains(auto)) {
      darfFahren.add(auto);
    }
  }

  public void deleteDarfFahren(Auto auto) {
    darfFahren.remove(auto);
  }

  public void addHaustier(Haustier haustier) {
    if (!haustierListe.contains(haustier)) {
      haustierListe.add(haustier);
    }
  }

  @Override
  public String toString() {
    return String.format("Person{id=%d, nachname='%s', darfFahren=%d, haustiere=%d}",
        id, nachname, darfFahren.size(), haustierListe.size());
  }
}