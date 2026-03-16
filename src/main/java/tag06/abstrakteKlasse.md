# 📚 **Abstrakte Klassen in Java – Umfassender Guide für Projekte**

## 📋 **Inhaltsverzeichnis**
1. [Was ist eine abstrakte Klasse?](#-was-ist-eine-abstrakte-klasse)
2. [Eigenschaften abstrakter Klassen](#-eigenschaften-abstrakter-klassen)
3. [Abstrakte vs. konkrete Klassen](#-abstrakte-vs-konkrete-klassen)
4. [Abstrakte Methoden](#-abstrakte-methoden)
5. [Praxisbeispiel: Tierhierarchie](#-praxisbeispiel-tierhierarchie)
6. [Abstrakte Klassen vs. Interfaces](#-abstrakte-klassen-vs-interfaces)
7. [Typische Anwendungsfälle](#-typische-anwendungsfälle)
8. [Best Practices](#-best-practices)
9. [Häufige Fehler](#-häufige-fehler)
10. [Checkliste für Projekte](#-checkliste-für-projekte)

---

## 🧩 **Was ist eine abstrakte Klasse?**

Eine **abstrakte Klasse** ist eine Klasse, die **nicht instanziiert** werden kann. Sie dient als **Bauplan** oder **Vorlage** für andere Klassen.

```java
public abstract class Fahrzeug {
    protected String marke;
    protected int baujahr;
    
    public void starten() {
        System.out.println("Fahrzeug startet...");
    }
    
    public abstract void bewegen();  // Abstrakte Methode
}
```

### 🔑 **Schlüsselmerkmal:**
> **"Eine abstrakte Klasse sagt WAS getan werden muss, aber nicht immer WIE."**

---

## ✨ **Eigenschaften abstrakter Klassen**

| Eigenschaft | Beschreibung | Beispiel |
|-------------|--------------|----------|
| **Keine Instanziierung** | `new` direkt auf abstrakter Klasse nicht erlaubt | `new Fahrzeug()` ❌ |
| **Kann abstrakte Methoden haben** | Methoden ohne Körper | `public abstract void bewegen();` |
| **Kann konkrete Methoden haben** | Normale Methoden mit Implementierung | `public void starten() { ... }` |
| **Kann Attribute haben** | Wie normale Klassen | `protected String marke;` |
| **Kann Konstruktoren haben** | Für Unterklassen | `public Fahrzeug(String marke)` |
| **Kann alles wie normale Klasse** | Bis auf Instanziierung | – |

---

## ⚖️ **Abstrakte vs. konkrete Klassen**

| Aspekt | Abstrakte Klasse | Konkrete Klasse |
|--------|------------------|-----------------|
| **Instantiiert werden?** | ❌ Nein | ✅ Ja |
| **Abstrakte Methoden?** | ✅ Ja (optional) | ❌ Nein |
| **Vererbung** | Als Basis gedacht | Kann Basis sein |
| **Zweck** | Bauplan / Vorlage | Gebrauchsfertiges Objekt |
| **Schlüsselwort** | `abstract` | keines |

---

## 🎯 **Abstrakte Methoden**

Eine **abstrakte Methode** ist eine Methode **ohne Körper**. Sie zwingt Unterklassen zur Implementierung.

```java
public abstract class Form {
    public abstract double flaecheBerechnen();  // Nur Signatur!
    public abstract double umfangBerechnen();   // Kein Körper!
}

public class Kreis extends Form {
    private double radius;
    
    @Override
    public double flaecheBerechnen() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public double umfangBerechnen() {
        return 2 * Math.PI * radius;
    }
}
```

### ⚠️ **Wichtig:**
> **"Jede konkrete Unterklasse MUSS alle abstrakten Methoden implementieren!"**

---

## 🏗️ **Praxisbeispiel: Tierhierarchie**

```java
// Abstrakte Basisklasse
public abstract class Tier {
    protected String name;
    protected int alter;
    
    public Tier(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
    
    // Konkrete Methode (für alle gleich)
    public void schlafen() {
        System.out.println(name + " schläft zzz...");
    }
    
    // Abstrakte Methoden (jedes Tier macht es anders)
    public abstract void fressen();
    public abstract void geraeuschMachen();
    
    // Getter
    public String getName() { return name; }
}

// Konkrete Unterklasse 1
public class Hund extends Tier {
    public Hund(String name, int alter) {
        super(name, alter);
    }
    
    @Override
    public void fressen() {
        System.out.println(name + " frisst Fleisch");
    }
    
    @Override
    public void geraeuschMachen() {
        System.out.println(name + " bellt: Wuff! Wuff!");
    }
    
    // Hund-spezifische Methode
    public void apportieren() {
        System.out.println(name + " apportiert den Ball");
    }
}

// Konkrete Unterklasse 2
public class Katze extends Tier {
    public Katze(String name, int alter) {
        super(name, alter);
    }
    
    @Override
    public void fressen() {
        System.out.println(name + " frisst Fisch");
    }
    
    @Override
    public void geraeuschMachen() {
        System.out.println(name + " miaut: Miau!");
    }
}
```

### 🎮 **Verwendung im Projekt:**

```java
public class Tierheim {
    private List<Tier> tiere = new ArrayList<>();
    
    public void tierAufnehmen(Tier tier) {
        tiere.add(tier);
    }
    
    public void alleTiereFuettern() {
        for (Tier tier : tiere) {
            tier.fressen();  // ✅ Polymorphie!
        }
    }
    
    public void alleTiereZumGeraeuschBringen() {
        for (Tier tier : tiere) {
            tier.geraeuschMachen();  // ✅ Jedes Tier macht SEIN Geräusch
        }
    }
}

// Hauptprogramm
public class Main {
    public static void main(String[] args) {
        Tierheim tierheim = new Tierheim();
        
        tierheim.tierAufnehmen(new Hund("Bello", 3));
        tierheim.tierAufnehmen(new Katze("Minka", 2));
        tierheim.tierAufnehmen(new Hund("Rex", 5));
        
        tierheim.alleTiereFuettern();
        tierheim.alleTiereZumGeraeuschBringen();
    }
}
```

---

## 🔄 **Abstrakte Klassen vs. Interfaces**

| Aspekt | Abstrakte Klasse | Interface (ab Java 8) |
|--------|------------------|----------------------|
| **Schlüsselwort** | `abstract class` | `interface` |
| **Vererbung** | `extends` (nur eine) | `implements` (mehrere) |
| **Attribute** | ✅ Alle möglich | ❌ Nur `public static final` |
| **Konstruktoren** | ✅ Ja | ❌ Nein |
| **Abstrakte Methoden** | ✅ Ja | ✅ Ja |
| **Konkrete Methoden** | ✅ Ja | ✅ `default` / `static` |
| **Zugriffsmodifikatoren** | Alle | `public` (default) |

### 💡 **Wann was nehmen?**

| Situation | Abstrakte Klasse | Interface |
|-----------|------------------|-----------|
| **Gemeinsame Attribute** | ✅ Ja | ❌ Nein |
| **Mehrfachvererbung nötig** | ❌ Nein | ✅ Ja |
| **"Ist ein"-Beziehung** | ✅ Ja | ❌ Nein |
| **"Kann"-Beziehung** | ❌ Nein | ✅ Ja |
| **Basisimplementierung** | ✅ Ja | ❌ (nur default) |

---

## 🎨 **Typische Anwendungsfälle**

### 1. **Hierarchische Strukturen**
```java
public abstract class Mitarbeiter {
    protected String name;
    protected double gehalt;
    
    public abstract double berechneBonus();
}
```

### 2. **Vorlagen (Template Method Pattern)**
```java
public abstract class DatenProcessor {
    // Template-Methode
    public final void verarbeiteDaten() {
        datenLaden();
        datenValidieren();
        datenSpeichern();
    }
    
    protected abstract void datenLaden();
    protected abstract void datenValidieren();
    protected abstract void datenSpeichern();
}
```

### 3. **Framework-Klassen**
```java
public abstract class HttpServlet {
    public void service(HttpRequest request, HttpResponse response) {
        if ("GET".equals(request.getMethod())) {
            doGet(request, response);
        } else if ("POST".equals(request.getMethod())) {
            doPost(request, response);
        }
    }
    
    protected abstract void doGet(HttpRequest request, HttpResponse response);
    protected abstract void doPost(HttpRequest request, HttpResponse response);
}
```

---

## ✅ **Best Practices**

### DO's ✅
```java
// 1. Abstrakte Klasse sinnvoll benennen
public abstract class Fahrzeug { ... }

// 2. protected für Attribute, die Unterklassen brauchen
protected String marke;

// 3. abstrakte Methoden für variablen Teil
public abstract void bewegen();

// 4. konkrete Methoden für gemeinsamen Code
public void starten() { ... }

// 5. final bei Template-Methoden
public final void fahreStrecke() { ... }
```

### DON'Ts ❌
```java
// 1. Zu viele abstrakte Methoden
public abstract class Alles {
    public abstract void a();
    public abstract void b();
    // ... 20 weitere abstrakte Methoden
}

// 2. Öffentliche Attribute
public String name;  // ❌ Besser protected

// 3. Leere abstrakte Klasse ohne Sinn
public abstract class Leer { }  // ❌ Wofür?

// 4. Abstrakte Klasse als "Datencontainer"
public abstract class Daten {
    public String a;
    public String b;
    // Keine Methoden! ❌ Dann besser normale Klasse
}
```

---

## ⚠️ **Häufige Fehler**

### ❌ Fehler 1: Abstrakte Klasse instanziieren
```java
Fahrzeug f = new Fahrzeug();  // ❌ Compiler-Fehler!
```

### ❌ Fehler 2: Abstrakte Methode nicht implementieren
```java
public class Auto extends Fahrzeug {
    // ❌ Keine Implementierung von bewegen()!
}
```

### ❌ Fehler 3: `abstract` bei Methode vergessen
```java
public abstract class Fahrzeug {
    public void bewegen();  // ❌ 'abstract' fehlt!
}
```

### ❌ Fehler 4: Zu viel in abstrakte Klasse packen
```java
public abstract class SuperKlasse {
    // 20 Methoden, 15 Attribute – zu viel!
}
```

---

## 📋 **Checkliste für Projekte**

### Bei Entwurf einer abstrakten Klasse:
- [ ] Ist die Klasse abstrakt genug (keine konkreten Objekte)?
- [ ] Welche Methoden müssen **alle** Unterklassen haben? → abstrakt
- [ ] Welche Methoden sind für **alle gleich**? → konkret
- [ ] Welche Attribute sind in Unterklassen nötig? → `protected`
- [ ] Gibt es eine sinnvolle **Ist-ein**-Beziehung?
- [ ] Brauche ich vielleicht doch ein Interface?

### Bei Verwendung einer abstrakten Klasse:
- [ ] Alle abstrakten Methoden implementiert?
- [ ] `@Override` verwendet?
- [ ] `super()` im Konstruktor aufgerufen?
- [ ] Sinnvolle, spezifische Implementierung?

---

## 🎯 **Zusammenfassung**

| Konzept | Merksatz |
|---------|----------|
| **Abstrakte Klasse** | "Kann keine Objekte, nur Baupläne" |
| **Abstrakte Methode** | "Was, aber nicht wie" |
| **Konkrete Methode** | "So machen es alle gleich" |
| **Unterklasse** | "Muss abstrakte Methoden implementieren" |
| **Polymorphie** | "Gleicher Aufruf – unterschiedliches Verhalten" |

> **💡 Merke: Abstrakte Klassen sind wie Kochrezepte – sie sagen, was gebraucht wird, aber jeder Koch kann es anders zubereiten!** 👨‍🍳

---

## 📚 **Weiterführende Themen**
- [ ] Interfaces vs. abstrakte Klassen
- [ ] Template Method Pattern
- [ ] Factory Pattern mit abstrakten Klassen
- [ ] Mehrfachvererbung (über Interfaces)
- [ ] Abstrakte Klassen in Frameworks (z.B. Spring)