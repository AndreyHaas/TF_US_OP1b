## SOLID – Die 5 Prinzipien sauberer Softwarearchitektur

---

### Was ist SOLID?

**SOLID** ist ein Akronym für fünf grundlegende Design-Prinzipien in der objektorientierten Programmierung.

**Ziel:** Wartbaren, flexiblen und verständlichen Code zu schaffen.

**Entwickelt von:** Robert C. Martin (Uncle Bob)

---

## 📌 S – Single Responsibility Principle (SRP)

**"Eine Klasse sollte nur einen einzigen Grund haben, sich zu ändern."**

| ⚡ Bedeutung | ❌ Vermeiden | ✅ Besser |
|-------------|-------------|----------|
| Jede Klasse hat genau **eine** Aufgabe | Eine Klasse, die alles kann (God Object) | Aufteilung in spezialisierte Klassen |

**Beispiel:**
```java
// ❌ Schlecht
class User {
    void speichernInDB() { ... }
    void sendeEmail() { ... }
    void berechneSteuern() { ... }
}

// ✅ Gut
class User { ... }
class UserRepository { void speichernInDB(User u) { ... } }
class EmailService { void sendeEmail(User u) { ... } }
class Steuerrechner { void berechneSteuern(User u) { ... } }
```

---

## 📌 O – Open/Closed Principle (OCP)

**"Klassen sollten offen für Erweiterung sein, aber geschlossen für Modifikation."**

| ⚡ Bedeutung | ❌ Vermeiden | ✅ Besser |
|-------------|-------------|----------|
| Neues Verhalten hinzufügen, ohne bestehenden Code zu ändern | If-else-Ketten für jeden neuen Fall | Polymorphie und Interfaces |

**Beispiel:**
```java
// ❌ Schlecht
class Rechner {
    double berechnen(String typ, double a, double b) {
        if (typ.equals("+")) return a + b;
        if (typ.equals("-")) return a - b;
        // Neuer Operator = neue if-Bedingung = bestehenden Code ändern!
    }
}

// ✅ Gut
interface Operation { double execute(double a, double b); }
class Addition implements Operation { 
    public double execute(double a, double b) { return a + b; } 
}
class Rechner {
    double berechnen(Operation op, double a, double b) {
        return op.execute(a, b);  // Neuer Operator = neue Klasse = kein bestehender Code wird geändert!
    }
}
```

---

## 📌 L – Liskov Substitution Principle (LSP)

**"Objekte einer abgeleiteten Klasse müssen überall dort einsetzbar sein, wo Objekte der Basisklasse verwendet werden."**

| ⚡ Bedeutung | ❌ Vermeiden | ✅ Besser |
|-------------|-------------|----------|
| Kindklassen dürfen das Verhalten der Elternklasse nicht einschränken oder brechen | Methoden überschreiben, die nichts tun oder Exceptions werfen | Korrekte Vererbungshierarchie |

**Beispiel:**
```java
// ❌ Schlecht
class Vogel { void fliegen() { ... } }
class Pinguin extends Vogel { 
    void fliegen() { throw new RuntimeException("Kann nicht fliegen!"); }
}

// ✅ Gut
interface Vogel { ... }
interface FlugfähigerVogel extends Vogel { void fliegen(); }
class Pinguin implements Vogel { ... }  // Kein fliegen()
class Adler implements FlugfähigerVogel { public void fliegen() { ... } }
```

---

## 📌 I – Interface Segregation Principle (ISP)

**"Viele spezifische Interfaces sind besser als ein großes, allgemeines Interface."**

| ⚡ Bedeutung | ❌ Vermeiden | ✅ Besser |
|-------------|-------------|----------|
| Keine Klasse sollte zu Methoden gezwungen werden, die sie nicht braucht | Fat Interfaces mit vielen Methoden | Kleine, fokussierte Interfaces |

**Beispiel:**
```java
// ❌ Schlecht
interface Arbeiter {
    void arbeiten();
    void essen();
    void schlafen();
}
class Roboter implements Arbeiter {
    public void arbeiten() { ... }
    public void essen() { throw new Exception(); }  // Roboter isst nicht!
    public void schlafen() { throw new Exception(); } // Roboter schläft nicht!
}

// ✅ Gut
interface Arbeit { void arbeiten(); }
interface Essen { void essen(); }
interface Schlafen { void schlafen(); }
class Roboter implements Arbeit {
    public void arbeiten() { ... }  // Nur das, was wirklich gebraucht wird
}
```

---

## 📌 D – Dependency Inversion Principle (DIP)

**"Abstraktionen sollten nicht von Details abhängen. Details sollten von Abstraktionen abhängen."**

| ⚡ Bedeutung | ❌ Vermeiden | ✅ Besser |
|-------------|-------------|----------|
| High-Level-Module hängen nicht direkt von Low-Level-Modulen ab | Direkte Abhängigkeiten auf konkrete Klassen | Abhängigkeiten über Interfaces/Abstraktionen |

**Beispiel:**
```java
// ❌ Schlecht
class Lampe {
    void anschalten() { ... }
}
class Schalter {
    private Lampe lampe;  // Direkte Abhängigkeit!
    void umlegen() { lampe.anschalten(); }
}

// ✅ Gut
interface Schaltbar { void anschalten(); }
class Lampe implements Schaltbar {
    public void anschalten() { ... }
}
class Schalter {
    private Schaltbar geraet;  // Abhängigkeit von Abstraktion!
    void umlegen() { geraet.anschalten(); }
}
```

---

## Zusammenfassung

| Prinzip | Merksatz |
|---------|----------|
| **S**ingle Responsibility | Eine Klasse = eine Aufgabe |
| **O**pen/Closed | Erweiterbar, aber nicht veränderbar |
| **L**iskov Substitution | Kinder müssen Eltern ersetzen können |
| **I**nterface Segregation | Lieber viele kleine Interfaces |
| **D**ependency Inversion | Abhängigkeiten nur von Abstraktionen |

---

## Warum SOLID?

✅ **Wartbarer Code** – Änderungen in einem Bereich brechen nicht andere Bereiche

✅ **Testbarer Code** – Kleine, fokussierte Klassen sind leicht zu testen

✅ **Flexibler Code** – Neue Features können einfach hinzugefügt werden

✅ **Verständlicher Code** – Jede Klasse hat eine klare Verantwortung

✅ **Teamfähig** – Mehrere Entwickler können parallel arbeiten, ohne sich ständig in die Quere zu kommen