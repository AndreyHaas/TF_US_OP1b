### 1. Was ist eine Assoziation?
##### Eine Assoziation ist eine Beziehung zwischen zwei eigenständigen Klassen. Beispiel: Ein Auto hat einen Besitzer (Person).

### 2. Was ist eine Aggregation?
##### Eine Aggregation ist eine spezielle "Teil-Ganzes"-Beziehung, bei der die Teile auch ohne das Ganze existieren können. Beispiel: Ein Einkauf besteht aus einer Person und einem Produkt – beide existieren auch ohne den Einkauf.

### 3. Worin unterscheiden sich beide?
##### Assoziation: Allgemeine "kennt"-Beziehung, Teile unabhängig

##### Aggregation: Spezielle "besteht aus"-Beziehung, Teile können auch ohne Ganzes existieren

##### Komposition (nicht hier): Teile sterben mit dem Ganzen

### 4. Welche Beziehung besteht zwischen Auto und Person?
##### Mehrfache Assoziation:
##### Ein Auto hat einen Besitzer (0..1)
##### Ein Auto hat mehrere Fahrer (0..*)
##### Eine Person darf mehrere Autos fahren (0..*)

### 5. Welche Beziehung besteht zwischen Einkauf und Person/Produkt?
##### Aggregation: Der Einkauf besteht aus einer Person und einem Produkt, aber beide können auch unabhängig existieren.

### 6. Welche Rolle spielt Haustier?
##### Haustier ist ein eigenständiges Objekt, das einer Person zugeordnet werden kann. Es ist eine Aggregation (Person "hat" Haustiere).

### 7. Warum enthält Person mehrere Listen?
##### Weil eine Person zu verschiedenen Klassen Beziehungen haben kann:

##### darfFahren → zu Autos

##### haustiere → zu Haustieren

### 8. Warum einzelne Referenzen vs. Listen?
##### Einzelne Referenz: Bei 0..1 Beziehungen (z.B. Auto.besitzer)

##### Liste: bei 0..* Beziehungen (z.B. Auto.fahrerListe)

### 9. Welche Aufgabe haben Konstruktoren?
##### Objekte initialisieren

##### Pflichtattribute setzen

##### Objekte in statische Listen eintragen

### 10. Warum Getter/Setter?
##### Kapselung (private Attribute)

##### Kontrollierter Zugriff von außen

### 11. Vorteile statischer Listen?
##### Zentrale Verwaltung aller Objekte einer Klasse

##### Einfaches Iterieren für Tests/Ausgaben

### 12. Warum LocalDateTime? 
##### Genauer Zeitstempel (Datum + Uhrzeit)

##### Unveränderlich (immutable)

##### Viele nützliche Methoden für Datumsberechnungen