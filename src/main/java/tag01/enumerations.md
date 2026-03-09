# Enum in Java - Das vollständige Handbuch 📚
### Inhaltsverzeichnis
#### [Was ist ein Enum?](#1-was-ist-ein-enum)
#### [Warum Enum? (Konstanten vs. Enum)](#2-warum-enum-konstanten-vs-enum)
#### [Einfache Enums](#3-einfache-enums)
#### [Enums mit Attributen](#4-enums-mit-attributen)
#### [Enums mit Methoden](#5-enums-mit-methoden)
#### [Wichtige Enum-Methoden](#6-wichtige-enum-methoden)
#### [Enums in switch-Anweisungen](#7-enums-in-switch-Anweisungen)
#### [Enums mit eigenen Konstruktoren](#8-enums-mit-eigenen-konstruktoren)
#### [Best Practices](#9-best-practices)


## 1. Was ist ein Enum?
   Enum (kurz für Enumeration = Aufzählung) ist ein spezieller Datentyp in Java, der eine festgelegte Menge von Konstanten definiert.

```java
public enum Tag {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG
}
```
👉 Ein Enum ist wie eine Liste von festen Werten, aus denen man wählen kann.

## 2. Warum Enum? (Konstanten vs. Enum)
   🔴 Der alte Weg: Konstanten
```java
public class Tag {
    public static final int MONTAG = 1;
    public static final int DIENSTAG = 2;
    public static final int MITTWOCH = 3;
    // ... und so weiter
}
```
```
// Verwendung:
int heute = Tag.MONTAG;  // OK
int morgen = 99;         // ❌ Auch erlaubt! Keine Typsicherheit!
```
Probleme mit Konstanten:
```
❌ Keine Typsicherheit (jeder int-Wert ist erlaubt)
❌ Keine Kontrolle über gültige Werte
❌ Keine zusätzlichen Methoden möglich
```
✅ Der Enum-Weg
```java
public enum Tag {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG
}
// Verwendung:
Tag heute = Tag.MONTAG;     // ✅ OK
Tag morgen = Tag.DIENSTAG;  // ✅ OK
// Tag falsch = 99;          // ❌ Compiler-Fehler! Typsicher!
Vorteile von Enums:

✅ Typsicherheit – nur vordefinierte Werte erlaubt
✅ Lesbarkeit – klare Bedeutung der Werte
✅ Methoden – können eigene Methoden haben
✅ switch-freundlich – perfekt für switch-Anweisungen
```
## 3. Einfache Enums
### 3.1 Definition
```java
public enum Ampel {
   ROT, GELB, GRÜN
}
```
### 3.2 Verwendung
```java
public class Main {
   public static void main(String[] args) {
   // Deklaration und Zuweisung
   Ampel aktuelleAmpel = Ampel.ROT;
        // Vergleich
        if (aktuelleAmpel == Ampel.ROT) {
            System.out.println("Anhalten!");
        }
        
        // Ausgabe
        System.out.println(aktuelleAmpel);  // ROT
   }
}
```
## 4. Enums mit Attributen
#### Enums können Attribute haben – wie normale Klassen!

```java
public enum Planet {
    MARS(3390),    // Radius in km
    ERDE(6371),
    JUPITER(69911);

    private int radiusKm;  // Attribut
    
    // Konstruktor
    Planet(int radiusKm) {
        this.radiusKm = radiusKm;
    }
    
    // Getter-Methode
    public int getRadiusKm() {
        return radiusKm;
    }
}

// Verwendung:
Planet p = Planet.ERDE;
System.out.println(p.getRadiusKm());  // 6371
```

## 5. Enums mit Methoden
### Enums können eigene Methoden haben – sogar abstrakte Methoden!

### 5.1 Normale Methoden
```java
public enum Wochentag {
    MONTAG, DIENSTAG, MITTWOCH, DONNERSTAG, FREITAG, SAMSTAG, SONNTAG;

    // Eigene Methode
    public boolean istWochenende() {
        return this == SAMSTAG || this == SONNTAG;
    }
}

// Verwendung:
Wochentag tag = Wochentag.SAMSTAG;
System.out.println(tag.istWochenende());  // true
```
### 5.2 Abstrakte Methoden (jeder Enum-Wert anders)
```java
public enum Operation {
PLUS {
    @Override
        public double berechnen(double x, double y) {
        return x + y;
    }
},
MINUS {
    @Override
        public double berechnen(double x, double y) {
        return x - y;
    }
},
MAL {
    @Override
        public double berechnen(double x, double y) {
        return x * y;
    }
};

    public abstract double berechnen(double x, double y);
}

// Verwendung:
double ergebnis = Operation.PLUS.berechnen(5, 3);  // 8.0
```
## 6. Wichtige Enum-Methoden
### Jeder Enum hat automatisch folgende Methoden:

#### 6.1 values() – alle Enum-Werte als Array
```java
Tag[] alleTage = Tag.values();
for (Tag t : alleTage) {
System.out.println(t);
}
// Ausgabe: MONTAG DIENSTAG MITTWOCH ...
```
#### 6.2 valueOf(String) – Enum aus String
```java
Tag tag = Tag.valueOf("MONTAG");  // Gibt Tag.MONTAG zurück
// Tag.valueOf("MONTAG");          // ❌ Exception, wenn nicht vorhanden
```
#### 6.3 ordinal() – Position im Enum (0-basiert)
```java
Tag t = Tag.MITTWOCH;
System.out.println(t.ordinal());  // 2 (weil 0=MONTAG, 1=DIENSTAG, 2=MITTWOCH)
```
#### 6.4 name() – Name als String
```java
Tag t = Tag.MONTAG;
System.out.println(t.name());  // "MONTAG"
```
## 7. Enums in switch-Anweisungen
Enums sind perfekt für switch!
```java
public enum Ampel {
ROT, GELB, GRÜN
}

public void handleAmpel(Ampel ampel) {
switch (ampel) {
    case ROT:
        System.out.println("Anhalten!");
        break;
    case GELB:
        System.out.println("Achtung, gleich wird's rot!");
        break;
    case GRÜN:
        System.out.println("Fahren!");
        break;
    }
}

// Verwendung:
handleAmpel(Ampel.ROT);  // Ausgabe: Anhalten!
```
## 8. Enums mit eigenen Konstruktoren
### Enums können komplexe Daten speichern:

```java
public enum Pizza {
    MARGHERITA("Tomate, Mozzarella", 8.50),
    SALAMI("Tomate, Mozzarella, Salami", 9.90),
    HAWAII("Tomate, Mozzarella, Schinken, Ananas", 10.50);

    private String zutaten;
    private double preis;
    
    // Konstruktor
    Pizza(String zutaten, double preis) {
        this.zutaten = zutaten;
        this.preis = preis;
    }
    
    public String getZutaten() {
        return zutaten;
    }
    
    public double getPreis() {
        return preis;
    }
}

// Verwendung:
Pizza meinePizza = Pizza.SALAMI;
System.out.println(meinePizza.getZutaten());  // Tomate, Mozzarella, Salami
System.out.println(meinePizza.getPreis());    // 9.90
```

## 9. Best Practices

### ✅ DO's
```java
// 1. Enums für feste Wertebereiche nutzen
public enum Status {
   OFFEN, IN_BEARBEITUNG, ABGESCHLOSSEN
}

// 2. Aussagekräftige Namen verwenden
public enum Farbe {
    ROT, GRÜN, BLAU  // ✅ Klar und verständlich
}

// 3. Enums mit Attributen für zusätzliche Infos
public enum Monat {
    JANUAR(31), FEBRUAR(28), MAERZ(31);  // ✅ Mit Tagen
}
```
### ❌ DON'Ts
```java
// 1. Enums nicht für dynamische Werte nutzen
public enum Benutzer {  // ❌ Benutzer kommen und gehen!
    ANNA, BEN, CLAUDIA
}

// 2. Keine zu vielen Werte
public enum Buchstaben {  // ❌ Viel zu viele!
    A, B, C, D, E, F, ... // 26 Stück!
}

// 3. ordinal() nicht für Logik verwenden
if (tag.ordinal() > 3) {  // ❌ Unklar! Was bedeutet >3?
    // ...
}

if (tag == Tag.DONNERSTAG) {  // ✅ Klar!
    // ...
}
```

### 📊 Zusammenfassung
```java
Aspekt	                Beschreibung	                    Beispiel
Einfacher Enum	        Nur Konstanten	                    enum Farbe { ROT, GRÜN }
Enum mit Attributen	Werte haben Daten	            enum Planet { ERDE(6371) }
Enum mit Methoden	Eigene Funktionalität	            enum Tag { ... public boolean istWochenende() }
Enum in switch	        Perfekt für Fallunterscheidungen    switch(tag) { case MONTAG: ... }
values()	        Alle Enum-Werte	                    Tag[] alle = Tag.values()
valueOf()	        String zu Enum	                    Tag t = Tag.valueOf("MONTAG")
```
### 🧠 Merksätze
#### "Enum ist wie eine VIP-Liste – nur geladene Gäste sind erlaubt!"
#### "Enums sind Konstanten auf Steroiden – sie können noch viel mehr!"
#### "Unter der Haube ist jeder Enum-Wert eine eigene Instanz der Enum-Klasse."

### 🎯 Typische Anwendungsfälle
```
✅ Ampelzustände (ROT, GELB, GRÜN)
✅ Wochentage (MONTAG, DIENSTAG, ...)
✅ Monate (JANUAR, FEBRUAR, ...)
✅ Bestellstatus (OFFEN, BEZAHLT, VERSANDT)
✅ Rollen in einem System (ADMIN, USER, GAST)
✅ HTTP-Statuscodes (OK, NOT_FOUND, ERROR)
```
## Enums sind eines der nützlichsten Features in Java – sie machen Code sicherer, lesbarer und wartbarer! 🚀