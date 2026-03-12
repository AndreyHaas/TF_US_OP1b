📋 Inhaltsverzeichnis
### Ziel der Aufgabe

### Fachlicher Hintergrund

### Vorgegebene Klassenstruktur

## Aufgabe 1: Klasse Raum[#]

Aufgabe 2: Klasse Gebäude

Aufgabe 3: Konstruktor Gebäude

Aufgabe 4: Methode addRaum()

Aufgabe 5: Methode getRäume()

Aufgabe 6: finalize()-Methoden

Aufgabe 7: Testklasse Komposition

Aufgabe 8: Analyse der auskommentierten Zeilen

Lernziele

Reflexions- und Kontrollfragen

🎯 Ziel der Aufgabe
In dieser Aufgabe analysieren und entwickeln Sie ein Java-Programm, das eine Komposition zwischen den Klassen Gebäude und Raum modelliert.

Lernziele:

Wie eine Komposition in Java umgesetzt wird

Wie Teilobjekte innerhalb eines Gesamtobjekts erzeugt werden

Warum Teilobjekte bei einer Komposition nicht unabhängig existieren

Einsatz von Listen, Konstruktoren und Methoden für Objektstrukturen

💡 Fokus: Eine Komposition ist eine besonders enge Teil-Ganzes-Beziehung. Die Teilobjekte gehören fest zum Gesamtobjekt und sollen nicht unabhängig existieren.

📖 Fachlicher Hintergrund
In der objektorientierten Programmierung gibt es verschiedene Beziehungsarten:

Beziehungstyp	Beschreibung	Beispiel
Assoziation	Lose "kennt"-Beziehung	Person kennt Auto
Aggregation	Teil-Ganzes (Teile eigenständig)	Einkauf mit Person/Produkt
Komposition	Enge Teil-Ganzes (Teile nicht eigenständig)	Gebäude mit Räumen
Typische Kompositionsbeispiele:

Ein Gebäude besteht aus Räumen

Ein Haus besteht aus Zimmern

Ein Dokument besteht aus Seiten

Ein Auto besteht aus fest eingebauten Teilen

Wichtig bei Komposition:

Teilobjekte werden innerhalb des Gesamtobjekts erzeugt

Teilobjekte werden in einer internen Liste gespeichert

Teilobjekte sollen nicht unabhängig existieren

⚠️ Hinweis: finalize() wird hier nur zu Demonstrationszwecken eingesetzt. In modernem Java ist es veraltet!

📁 Vorgegebene Klassenstruktur
text
Package: komposition.template
├── 📄 Gebäude.java      (Gesamtobjekt)
├── 📄 Raum.java         (Teilobjekt)
└── 📄 Komposition.java  (Testklasse mit main)
🧩 Aufgabe 1: Klasse Raum
📄 Raum.java (Teilobjekt)
```java
package komposition.template;

/**
* Teilobjekt der Komposition.
* Ein Raum existiert nur im Kontext eines Gebäudes.
*/
public class Raum {

  private final int raumNummer;  // Unveränderliche Raumnummer

  /**
    * Konstruktor - erzeugt einen Raum mit gegebener Nummer
    * @param raumNummer Die Nummer dieses Raums
      */
      public Raum(int raumNummer) {
        this.raumNummer = raumNummer;
      }

  /**
    * Getter für die Raumnummer
    * @return die Raumnummer
    */
      public int getRaumNummer() {
        return raumNummer;
      }

  /**
    * finalize() NUR zu Demonstrationszwecken!
    * Zeigt an, wann ein Raum vom Garbage Collector erfasst wird.
    */
      @Override
      protected void finalize() {
          System.out.println("🔴 Raum " + raumNummer + " wird gelöscht (finalize)");
      }
    }
    
✅ Anforderungen erfüllt:
Attribut private int raumNummer
```
Konstruktor mit Parameter

Getter-Methode getRaumNummer()

finalize()-Methode für Demo

🏢 Aufgabe 2: Klasse Gebäude
📄 Gebäude.java (Gesamtobjekt) - Teil 1
```java
package komposition.template;

import java.util.ArrayList;
import java.util.Iterator;

/**
* Gesamtobjekt der Komposition.
* Ein Gebäude enthält Räume, die ohne das Gebäude nicht existieren können.
  */
  public class Gebäude {

  private final String name;                          // Name des Gebäudes
  private final ArrayList<Raum> raumListe;            // Komposition: Räume gehören fest zum Gebäude

  /**
    * Konstruktor - erzeugt ein Gebäude mit Namen und erstem Raum
    * @param name Name des Gebäudes
    * @param ersteRaumNummer Nummer des ersten Raums
      */
      public Gebäude(String name, int ersteRaumNummer) {
      this.name = name;
      this.raumListe = new ArrayList<>();

      // Direkt beim Erzeugen: ersten Raum anlegen!
      addRaum(ersteRaumNummer);
      System.out.println("🏢 Gebäude '" + name + "' erzeugt mit erstem Raum " + ersteRaumNummer);
      }

  /**
    * Getter für den Gebäudenamen
    * @return Name des Gebäudes
      */
      public String getName() {
      return name;
      }

  // Weitere Methoden folgen...
  }
  ✅ Bisher erfüllt:
  Attribut private final ArrayList<Raum> raumListe

Attribut private String name

Getter getName()

final für die Listenreferenz
```
🏗️ Aufgabe 3: Konstruktor Gebäude
✅ Bereits im obigen Code implementiert:

```java
public Gebäude(String name, int ersteRaumNummer) {
this.name = name;
this.raumListe = new ArrayList<>();
addRaum(ersteRaumNummer);  // ← Ersten Raum direkt anlegen!
}
➕ Aufgabe 4: Methode addRaum()
📄 Gebäude.java - Teil 2
java
/**
* Komposition pur: Raum wird INNERHALB des Gebäudes erzeugt!
* Kein externes Raum-Objekt wird übergeben.
*
* @param raumNummer Nummer des neuen Raums
*/
public void addRaum(int raumNummer) {
// 🔑 Entscheidend: Erzeugung im Gesamtobjekt!
Raum neuerRaum = new Raum(raumNummer);
raumListe.add(neuerRaum);
System.out.println("  ➕ Raum " + raumNummer + " wurde dem Gebäude hinzugefügt");
}
✅ Besonderheit:
Raum wird innerhalb der Methode erzeugt (new Raum(...))

Kein Zugriff von außen auf den Konstruktor von Raum für die Komposition
```
📋 Aufgabe 5: Methode getRäume()
📄 Gebäude.java - Teil 3
```java
/**
* Gibt alle Raumnummern als String zurück, z.B. [101, 102, 103]
*
* @return formatierter String mit allen Raumnummern
*/
public String getRäume() {
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
✅ Verwendete Techniken:
StringBuilder für effiziente String-Konkatenation

Iterator<Raum> zum kontrollierten Durchlaufen

getRaumNummer() aus der Klasse Raum
```
💀 Aufgabe 6: finalize()-Methoden
📄 Gebäude.java - Teil 4
```java
/**
* finalize() NUR zu Demonstrationszwecken!
* Zeigt an, wann das Gebäude vom Garbage Collector erfasst wird.
*/
@Override
protected void finalize() {
System.out.println("🔴🔴 GEBÄUDE '" + name + "' wird gelöscht (finalize)");
// Räume werden automatisch mitgelöscht, da sie nur hier referenziert werden!
}
📄 Raum.java (bereits gezeigt)
java
@Override
protected void finalize() {
System.out.println("🔴 Raum " + raumNummer + " wird gelöscht (finalize)");
}
⚠️ Wichtig: finalize() ist veraltet und dient hier NUR der Demonstration, dass Objekte gelöscht werden!
```
🧪 Aufgabe 7: Testklasse Komposition
📄 Komposition.java
```java
package komposition.template;

/**
* Testklasse für die Komposition zwischen Gebäude und Raum.
* Demonstriert die Erzeugung, Verwaltung und Löschung von Objekten.
  */
  public class Komposition {

  public static void main(String[] args) {
  System.out.println("=== KOMPOSITION: GEBÄUDE & RÄUME ===\n");

       // 1. Gebäude mit erstem Raum erzeugen
       Gebäude schule = new Gebäude("Goethe-Gymnasium", 101);
       
       // 2. Weitere Räume hinzufügen (alle INNERHALB des Gebäudes erzeugt!)
       schule.addRaum(102);
       schule.addRaum(103);
       schule.addRaum(104);
       schule.addRaum(105);
       
       // 3. Alle Räume ausgeben
       System.out.println("\n📋 Räume im Gebäude " + schule.getName() + ": " + schule.getRäume());
       
       // ⚠️ Diese Zeilen sind auskommentiert - Analyse in Aufgabe 8!
       // Raum r = new Raum(5);                // ❌ Widerspricht Komposition!
       // schule.raumListe.add(r);              // ❌ Umgeht die Kontrolle!
       
       System.out.println("\n=== GARBAGE COLLECTOR AUFRUF ===\n");
       
       // 4. Referenz auf Gebäude löschen
       schule = null;
       
       // 5. Garbage Collector anregen (keine Garantie, aber für Demo)
       System.gc();
       
       // 6. Warten, damit finalize() sich melden kann
       try {
           Thread.sleep(1000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       
       System.out.println("\n=== PROGRAMMENDE ===");
  }
  }
  ```
  🔍 Aufgabe 8: Analyse der auskommentierten Zeilen
  Die auskommentierten Zeilen:
  ```java
  // Raum r = new Raum(5);                // ❌ Widerspricht Komposition!
  // schule.raumListe.add(r);              // ❌ Umgeht die Kontrolle!

  ❌ Warum ist das falsch?
  Aspekt	            Erklärung
  Existenz	            Ein Raum wird außerhalb des Gebäudes erzeugt – er könnte theoretisch ohne Gebäude existieren
  Kontrolle	            Das Gebäude hat keine Kontrolle über die Erzeugung
  Kapselung	            Direkter Zugriff auf raumListe umgeht die Kapselung
  Komposition	        Die enge Bindung wird aufgehoben – der Raum könnte auch einem anderen Gebäude zugeordnet werden
  ```
  ✅ Warum ist addRaum() besser?
  ```java
  schule.addRaum(105);  // ✅ Raum wird INNERHALB erzeugt!
  Vorteil	Beschreibung
  Kapselung	Gebäude kontrolliert vollständig seine Räume
  Existenz	Räume entstehen NUR durch das Gebäude
  Konsistenz	Keine "herrenlosen" Räume
  Realitätsnähe	In der Realität gibt es auch keine Räume ohne Gebäude
```
🎯 Lernziele
Nach Abschluss dieser Aufgabe können Sie:
```java
✅ erklären, was eine Komposition in Java ist
✅ den Unterschied zwischen Gesamtobjekt und Teilobjekt beschreiben
✅ Teilobjekte innerhalb eines Gesamtobjekts erzeugen und verwalten
✅ ArrayList, Iterator und StringBuilder im Zusammenhang mit Objektlisten einsetzen
✅ erläutern, warum Räume nicht unabhängig vom Gebäude existieren sollen
✅ die Rolle von finalize() als reine Demonstrationshilfe einordnen

❓ Reflexions- und Kontrollfragen
📌 Kontrollfragen zur Komposition
Was ist eine Komposition in Java?
→ Eine enge Teil-Ganzes-Beziehung, bei der Teilobjekte ohne das Gesamtobjekt nicht existieren können.

Worin unterscheidet sich eine Komposition von einer Aggregation?
→ Aggregation: Teile können eigenständig existieren (z.B. Einkauf mit Person/Produkt)
Komposition: Teile sind existenzabhängig (Räume ohne Gebäude? 🤔)

Warum ist Gebäude/Raum ein typisches Kompositionsbeispiel?
→ Räume sind ohne Gebäude nicht sinnvoll – perfekte Existenzabhängigkeit!

📌 Kontrollfragen zur Klassenstruktur
Aufgabe der raumListe?
→ Speichert alle Räume dieses Gebäudes (final = Liste kann nicht ausgetauscht werden)

Aufgabe des Attributs name?
→ Identifiziert das Gebäude (z.B. "Goethe-Gymnasium")

Warum ArrayList<Raum>?
→ Flexible Anzahl, Reihenfolge bleibt erhalten, einfach erweiterbar

📌 Kontrollfragen zur Programmlogik
Aufgabe von addRaum(int raumNummer)?
→ Erzeugt einen NEUEN Raum und fügt ihn der Liste hinzu

Warum wird in addRaum() ein neues Raum-Objekt erzeugt?
→ Kennzeichen der Komposition: Räume entstehen NUR durch das Gebäude!

Aufgabe von getRäume()?
→ Sammelt alle Raumnummern in einem String für die Ausgabe

Warum Iterator<Raum>?
→ Kontrolliertes Durchlaufen, einfache Prüfung auf letztes Element

📌 Kontrollfragen zu finalize()
Warum finalize() nur zu Demonstrationszwecken?
→ Zeigen, DASS Objekte gelöscht werden – in echtem Code veraltet!

Warum ist die Ausgabe nach System.gc() nicht sicher?
→ Garbage Collector läuft nicht deterministisch – nur ein Vorschlag an die JVM

Warum sollte finalize() nicht mehr verwendet werden?
→ Unzuverlässig, Performance-Probleme, seit Java 9 deprecated

📌 Kontrollfragen zur Modellierung
Warum widerspricht ein extern erzeugter Raum der Komposition?
```
```java
Raum r = new Raum(5);  // ❌ Raum existiert AUßERHALB!
→ Könnte theoretisch ohne Gebäude existieren – falsches Modell!

Warum Teilobjekte nur innerhalb des Gesamtobjekts erzeugen?
→ Stellt Existenzabhängigkeit sicher, verhindert "herrenlose" Objekte
```
```java
Vorteile dieser Modellierung?

✅ Kapselung
✅ Konsistenz
✅ Wartbarkeit
✅ Realitätsnähe
📊 Erwartete Ausgabe
```
```java

=== KOMPOSITION: GEBÄUDE & RÄUME ===

🏢 Gebäude 'Goethe-Gymnasium' erzeugt mit erstem Raum 101
➕ Raum 101 wurde dem Gebäude hinzugefügt
➕ Raum 102 wurde dem Gebäude hinzugefügt
➕ Raum 103 wurde dem Gebäude hinzugefügt
➕ Raum 104 wurde dem Gebäude hinzugefügt
➕ Raum 105 wurde dem Gebäude hinzugefügt

📋 Räume im Gebäude Goethe-Gymnasium: [101, 102, 103, 104, 105]

=== GARBAGE COLLECTOR AUFRUF ===

🔴🔴 GEBÄUDE 'Goethe-Gymnasium' wird gelöscht (finalize)
🔴 Raum 101 wird gelöscht (finalize)
🔴 Raum 102 wird gelöscht (finalize)
🔴 Raum 103 wird gelöscht (finalize)
🔴 Raum 104 wird gelöscht (finalize)
🔴 Raum 105 wird gelöscht (finalize)

=== PROGRAMMENDE ===
```
```java
💡 Merksatz
"Räume gibt es nur, weil es ein Gebäude gibt – genau das ist Komposition!" 🏢

Kompositionsmerkmal	Umsetzung im Code
Erzeugung	new Raum(...) INNERHALB des Gebäudes
Speicherung	private final ArrayList<Raum>
Zugriff	Nur über Methoden des Gebäudes
Löschung	Mit dem Gebäude verschwinden alle Räume
