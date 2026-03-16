# TF_US_OP1b

## 📌 1. Enum (Aufzählungstyp)
### 🔹 Was ist ein Enum?
#### Ein Enum ist ein spezieller Datentyp für feste Konstantenmengen.

#### 🔹 Einfaches Enum
```java
public enum Status {
    OFFEN, IN_BEARBEITUNG, ERLEDIGT
}

// Verwendung
Status s = Status.OFFEN;
```
#### 🔹 Enum mit Attributen
```java
public enum Note {
    SEHR_GUT(92), GUT(81), BEFRIEDIGEND(67);

    private final int minPunkte;
    
    Note(int minPunkte) {  // Konstruktor
        this.minPunkte = minPunkte;
    }
    
    public int getMinPunkte() { return minPunkte; }
}

// Verwendung
int punkte = Note.GUT.getMinPunkte();  // 81
```
#### 🔹 Enum mit Methoden
```java
public enum Tag {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG;

    public boolean istWochenende() {
        return this == SAMSTAG || this == SONNTAG;
    }
}
```
#### 🔹 Wichtige Enum-Methoden
```java
Methode	        Beschreibung	                Beispiel
values()	    Alle Konstanten als Array	    Tag[] tage = Tag.values();
valueOf(String)	String → Enum	                Tag t = Tag.valueOf("MONTAG");
name()	        Name als String	                "MONTAG".equals(Tag.MONTAG.name())
ordinal()	    Position (0-basiert)	        Tag.MONTAG.ordinal() // 0
```
## 🧬 2. Vererbung (Inheritance)
#### 🔹 Grundprinzip
```java
// Elternklasse (Superklasse)
public class Fahrzeug {
    protected String marke;

    public void fahren() {
        System.out.println("Fahrzeug fährt");
    }
}

// Kindklasse (Subklasse)
    public class Auto extends Fahrzeug {
    private int tueren;

    public void hupen() {
        System.out.println("Hup!");
    }
}
```
#### 🔹 Schlüsselwörter
```java
Keyword	        Bedeutung	            Beispiel
extends	        Vererbung               class Auto extends Fahrzeug
super	        Elternklasse aufrufen   super.marke, super()
@Override	    Methode überschreiben   kennzeichnet Überschreibung
```
🔹 Vererbungshierarchie
```java
Object (Mutter aller Klassen)
└── Fahrzeug
    ├── Auto
    └── Motorrad
```
#### 🔹 Methoden überschreiben
```java
@Override
public void fahren() {
    System.out.println("Auto fährt mit 4 Rädern");
}
```
#### 🔒 3. Zugriffsmodifikatoren
```java
Modifikator	    Klasse  Paket	Kindklasse	Welt
private	        ✅	    ❌	    ❌	        ❌
default (kein)	✅   	✅	    ❌	        ❌
protected	    ✅	    ✅	    ✅	        ❌
public	        ✅	    ✅	    ✅	        ✅
Merke: protected ist perfekt für Vererbung!
```
#### 🚫 4. Vererbung verhindern
##### final bei Klassen
```java
public final class EndKlasse {
    // Kann nicht vererbt werden!
}
```
##### final bei Methoden
```java
public class Fahrzeug {
    public final void starten() {
        // Kann nicht überschrieben werden!
    }
}
```
#### 🎭 5. Abstrakte Klassen & Methoden
```java
public abstract class Tier {
    protected String name;

    public abstract void lautGeben();  // Muss überschrieben werden
    
    public void schlafen() {           // Normale Methode
        System.out.println("Zzz...");
    }
}

public class Hund extends Tier {
    @Override
    public void lautGeben() {
        System.out.println("Wuff!");
    }
}
```
#### 📊 6. Vererbung vs. Interface
```java
Aspekt	    extends (Klasse)	implements (Interface)
Beziehung	"ist ein"	        "kann"
Mehrfach	❌ Nein	            ✅ Ja (mehrere Interfaces)
Attribute	✅ Ja	            ❌ Nur Konstanten
Methoden	Konkret + abstrakt	Abstrakt (vor Java 8)
```
```java
public class Fledermaus extends Tier implements Fliegen, EchoOrtung {
    // Geht beides!
}
```
#### 💡 7. Wichtige Merksätze
```java
Konzept	    Merksatz
Enum	    "Feste Werte – typsicher und lesbar"
extends	    "Kind erbt von Eltern"
super	    "Anruf bei den Eltern"
@Override	"Ich mach's anders als mein Vater"
protected	"Nur in der Familie sichtbar"
final	    "Hier endet die Vererbung"
abstract	"Nur Bauplan, keine Objekte"
```
✅ Zusammenfassung
```java
Konzept	        Code	                    Zweck
Einfaches       Enum	                    enum Farbe { ROT, GRÜN }	Konstanten
Enum mit Werten	SEHR_GUT(92)	            Werte zu Konstanten
Vererbung	    class Kind extends Eltern	Code-Wiederverwendung
Überschreiben	@Override void methode()	Anpassung
Abstrakt	    abstract class	            Bauplan
final Klasse	final class	                Keine Kinder
```
### 🎯 Merke: Enums sind Aufzählungen, Vererbung ist für "ist ein"-Beziehungen. Beides macht Code sicherer und klarer!