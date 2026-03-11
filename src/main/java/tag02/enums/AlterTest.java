package tag02.enums;

public class AlterTest {

    public static void main(String[] args)
    {
    // 1. Eine Enum-Konstante verwenden
    Alter a1 = Alter.VOLLJÄHRIG;

    // 2. Gespeicherten Wert mit getAlterZahl() ausgeben
    System.out.println("Konstante: " + a1);
    System.out.println("Wert: " + a1.getAlterZahl());

    System.out.println();

    // 3. Methode getAlter(int zahl) testen
    Alter a2 = Alter.getAlter(18);
    System.out.println("Ergebnis von getAlter(18): " + a2);

    Alter a3 = Alter.getAlter(60);
    System.out.println("Ergebnis von getAlter(60): " + a3);

    Alter a4 = Alter.getAlter(10);
    System.out.println("Ergebnis von getAlter(10): " + a4);

    System.out.println();

    // 4. Methode getAlterByName(String name) testen
    int wert1 = Alter.getAlterByName("SENIOR");
    System.out.println("Ergebnis von getAlterByName(\"SENIOR\"): " + wert1);

    int wert2 = Alter.getAlterByName("volljährig");
    System.out.println("Ergebnis von getAlterByName(\"volljährig\"): " + wert2);

    int wert3 = Alter.getAlterByName("kind");
    System.out.println("Ergebnis von getAlterByName(\"kind\"): " + wert3);

    }
}
