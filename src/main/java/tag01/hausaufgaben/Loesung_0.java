package tag01.hausaufgaben;

import java.util.Scanner;
import java.util.StringJoiner;

public class Loesung_0 {

  public static void main(String[] args) {
    System.out.println("Macht Ihnen Java Spaß?");
    zeigeMenue();
    Scanner scanner = new Scanner(System.in);
    String userEingabe = scanner.nextLine().toUpperCase();
    auswahlUebersetzen(userEingabe);
  }

  private static void auswahlUebersetzen(String userEingabe) {
    try {
      Auswahl auswahl = Auswahl.valueOf(userEingabe);
      switch (auswahl) {
        case JA -> System.out.println("Super! Dann können wir so weitermachen!");
        case NEIN -> System.out.println("Kann ich verstehen. C# ist eh viel besser.");
        case VIELLEICHT -> System.out.println("Das wird bestimmt noch!");
        default -> System.out.println("Keine gültige Auswahl!");
      }
    } catch (IllegalArgumentException exception) {
      System.out.println("Exception: " + exception.getMessage());
    }
  }

  static void zeigeMenue() {
    Auswahl[] konstanten = Auswahl.values();
    StringJoiner stringJoiner = new StringJoiner(" / ");

    for (Auswahl auswahl : konstanten) {
      stringJoiner.add(auswahl.name());
    }

    System.out.println("Wähle aus: " + stringJoiner);
  }
}