package tag03.assoziation;

import java.util.ArrayList;
import java.util.List;

public class Auto {

  /*
      Wir speichern alle Autos in einer statischen Liste, damit wir sie bequem iterieren und ausgeben können.
   */
  protected static final List<Auto> AUTO_LISTE = new ArrayList<>();

  private final int id;
  private final String marke;

  /*
      Autos können einen Besitzer haben. Damit stehen Person und Auto in Verbindung zueinander.
      Kenn wir das Auto (d.h. wir haben eine Referenz auf das Objekt), können wir zum Auto den Besitzer abfragen.
  */
  private Person besitzer; // in 'besitzer' wird die Referenz (also Speicheradresse) der Person gespeichert.

  /*
      Jedes Auto hat eine Liste mit Personen, die das auto fahren dürfen.
      Damit stehen Person und Auto in Verbindung zueinander.
  */
  private final ArrayList<Person> fahrerListe = new ArrayList<>();

  public int getId() {
    return id;
  }

  public String getMarke() {
    return marke;
  }

  public Person getBesitzer() {
    return besitzer;
  }

  public void setBesitzer(Person besitzer) {
    this.besitzer = besitzer;
  }

  public List<Person> getFahrerListe() {
    return fahrerListe;
  }

  public List<Auto> getAutoListe() {
    return AUTO_LISTE;
  }

  /*
      Konstruktor 1 Auto-Klasse
      Assoziation: Autos haben Besitzer. Aber es kann auch Autos ohne Besitzer geben.
      Möchte ich ein Objekt ohne Besitzer erzeugen, rufe ich diesen Konstruktor auf.
  */
  public Auto(int id, String marke) {
    this.id = id;
    this.marke = marke;

    AUTO_LISTE.add(this);
  }

  /*
      Konstruktor 2 Auto-Klasse
      Assoziation: Autos haben Besitzer. Aber es kann auch Autos ohne Besitzer geben.
      Möchte ich ein Objekt mit Besitzer erzeugen, rufe ich diesen Konstruktor auf.
   */
  public Auto(int id, String marke, Person besitzer) {
    this(id,
        marke); /* Konstruktor-Verkettung. Damit vermeiden wir doppelten Code, denn die Zuweisung an die Attribute geschieht jetzt nur einmal.*/
    this.besitzer = besitzer;
  }

  public void addFahrer(Person fahrer) {
    if (!fahrerListe.contains(fahrer)) {
      fahrerListe.add(fahrer);
    }
  }

  @Override
  public String toString() {
    String besitzerName = besitzer != null ? besitzer.getNachname() : "keiner";
    return String.format("Auto{id=%d, marke='%s', besitzer=%s, fahrer=%d}",
        id, marke, besitzerName, fahrerListe.size());
  }
}