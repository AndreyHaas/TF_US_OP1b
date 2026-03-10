package tag01.materialen.fpa;

/*
    Aufgabe 0 (Basics)

    Schreiben Sie ein Programm, indem ein Benutzer über ein Menü zwischen drei Möglichkeiten auswählen kann.
    Die auswählbaren Möglichkeiten werden über ein Enum erfasst. Es sollen "JA", "NEIN" und "VIELLEICHT" auswählbar sein.

    In einem Switch-Case wird die Eingabe auf Übereinstimmung mit den Enum-Konstanten geprüft und der Benutzer erhält passend zu seiner Auswahl eine Ausgabe.
    Trifft der Benutzer eine ungültige Wahl, soll eine Fehlermeldung ausgegeben werden.

    Hinweis: Die Auswahlmöglichkeiten können per Schleife mithilfe der Methode values() des Enums ausgegeben werden. Mit valueOf() kann aus einem String eine Enum-Konstante gemacht werden.
 */

import java.util.Scanner;

enum Auswahl {
  JA, NEIN, VIELLEICHT
}

public class Lösung_0 {

  static Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Macht Ihnen Java Spaß?");

    Auswahl[] auswahlWerte = Auswahl.values();

    for (int i = 0; i < auswahlWerte.length; i++) {
      System.out.print(auswahlWerte[i]);
      if (i < auswahlWerte.length - 1) {
        System.out.print("/");
      }
    }
    System.out.print(": ");

    String auswahlString = scanner.nextLine();

    try {
      Auswahl auswahl = Auswahl.valueOf(
          auswahlString.toUpperCase()); // toUpperCase macht aus der Eingabe Großbuchstaben.
      switch (auswahl) {
        case JA:
          System.out.println("Super! Dann können wir so weitermachen!");
          break;
        case NEIN:
          System.out.println("Kann ich verstehen. C# ist eh viel besser.");
          break;
        case VIELLEICHT:
          System.out.println("Das wird bestimmt noch!");
      }
    } catch (IllegalArgumentException ex) {
      System.out.println("Keine gültige Auswahl!");
    }
  }
}