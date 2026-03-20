# Wie HashSet funktioniert

## Grundprinzip

`HashSet` ist eine Implementierung des `Set`-Interfaces in Java, die auf einer **HashMap** basiert. Sie speichert Elemente in einer **Hashtabelle** und garantiert **keine Duplikate**.

---

## Interne Struktur

```java
public class HashSet<E> {
    private transient HashMap<E, Object> map;
    private static final Object PRESENT = new Object();
    
    public HashSet() {
        map = new HashMap<>();
    }
    
    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }
}
```

**Wichtig:** Ein `HashSet` verwendet intern eine `HashMap`, wobei die Elemente als **Schlüssel** gespeichert werden und ein Dummy-Objekt (`PRESENT`) als Wert dient.

---

## Wie wird ein Element gespeichert?

### 1. **hashCode() wird aufgerufen**
```java
int hash = element.hashCode();
```
- Berechnet den Hashwert des Objekts
- Bestimmt, in welchem **Bucket** das Element landet

### 2. **Bucket-Berechnung**
```java
int index = hash & (array.length - 1);
```
- Der Hashwert wird auf die Array-Größe reduziert
- So wird der Index im internen Array bestimmt

### 3. **Speicherung im Bucket**
- Wenn der Bucket leer ist → Element wird gespeichert
- Wenn der Bucket bereits Elemente enthält → **Kollision**

### 4. **Kollisionsbehandlung**
Bei Kollision werden Elemente in einer **verketteten Liste** (oder ab Java 8 in einem **Baum** ab einer bestimmten Größe) im selben Bucket gespeichert.

### 5. **Duplikatsprüfung**
```java
if (map.containsKey(element)) {
    return false;  // Element existiert bereits
}
```
- Vor dem Einfügen wird geprüft, ob ein Element mit gleichem `hashCode()` und `equals()` bereits existiert
- Nur wenn keins existiert, wird eingefügt

---

## Beispielablauf

```java
HashSet<String> set = new HashSet<>();
set.add("Apfel");
```

1. `"Apfel".hashCode()` → berechnet Hash (z.B. 1234567)
2. Index berechnen: `1234567 & (16-1)` → z.B. Index 7
3. Bucket 7 prüfen → leer → speichern

```java
set.add("Apfel");  // Zweiter Versuch
```
1. Gleicher Hash → gleicher Index
2. Bucket prüfen: Element mit `equals("Apfel")` gefunden
3. **Kein Einfügen**, Rückgabe `false`

---

## Wichtige Methoden

| Methode | Beschreibung |
|---------|--------------|
| `hashCode()` | Bestimmt den Bucket |
| `equals()` | Prüft auf tatsächliche Gleichheit bei Kollision |
| `add(E e)` | Fügt Element ein (keine Duplikate) |
| `contains(Object o)` | Prüft, ob Element vorhanden |
| `remove(Object o)` | Entfernt Element |
| `size()` | Gibt Anzahl der Elemente zurück |

---

## Beispiel mit eigener Klasse

```java
public class Person {
    private String name;
    private int alter;
    
    public Person(String name, int alter) {
        this.name = name;
        this.alter = alter;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, alter);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Person)) return false;
        Person other = (Person) obj;
        return Objects.equals(name, other.name) && alter == other.alter;
    }
}

// Verwendung
HashSet<Person> personen = new HashSet<>();
personen.add(new Person("Anna", 25));
personen.add(new Person("Anna", 25));  // Wird nicht hinzugefügt
System.out.println(personen.size());    // 1
```

---

## Performance

| Operation | Average Case | Worst Case |
|-----------|--------------|------------|
| `add()` | O(1) | O(n) |
| `contains()` | O(1) | O(n) |
| `remove()` | O(1) | O(n) |

- **Average O(1)** – wenn Hash-Funktion gut verteilt
- **Worst Case O(n)** – wenn alle Elemente im gleichen Bucket landen (schlechte `hashCode()`-Implementierung)

---

## Zusammenfassung

| Eigenschaft | Beschreibung |
|-------------|--------------|
| **Basiert auf** | HashMap |
| **Keine Duplikate** | Prüft über `hashCode()` und `equals()` |
| **Ungeordnet** | Keine garantierte Reihenfolge |
| **Erlaubt `null`** | Ein `null`-Element ist erlaubt |
| **Nicht synchronisiert** | Nicht threadsicher (für Multithreading `Collections.synchronizedSet()`) |

---

## Wichtige Regel

> **Wenn du `hashCode()` überschreibst, musst du auch `equals()` überschreiben!**

Die Vertragsbedingung lautet:  
Wenn zwei Objekte nach `equals()` gleich sind, müssen sie **denselben `hashCode()`** liefern.