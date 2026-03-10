package tag01.hausaufgaben;

import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;
import org.jetbrains.annotations.NotNull;

public class Loesung_1 {

  public static void main(String[] args) {

    String bereich = StringUtils.EMPTY;

    for (IHK note : IHK.values()) {
      bereich = getBereich(note);
      int punkte = note.getPunkte();
      System.out.printf("%-12s ab %3d Punkte %s%n", note, punkte, bereich);
    }

    System.out.println("\n" + "─".repeat(40));
    Scanner scanner = new Scanner(System.in);
    int punktzahl = einlesenPunktzahl(scanner);

    IHK note = bestimmeNote(punktzahl);

    ergebnisZeigen(punktzahl, note, bereich);
  }

  private static void ergebnisZeigen(int punktzahl, IHK note, String bereich) {
    System.out.println("\n" + "*".repeat(40));
    System.out.println("ERGEBNIS");
    System.out.println("Punktzahl: " + punktzahl);
    System.out.println("IHK-Note:  " + note + " (" + bereich + ")");
    System.out.println("*".repeat(40));
  }

  public static int einlesenPunktzahl(@NotNull Scanner scanner) {
    int punktzahl;

    while (true) {
      System.out.println("Punktzahl eingeben (0-100): ");
      String eingabe = scanner.nextLine();

      try (scanner) {
        punktzahl = Integer.parseInt(eingabe);

        if (punktzahl >= 0 && punktzahl <= 100) {
          return punktzahl;
        } else {
          System.out.println("Punktzahl muss zwischen 0 und 100 liegen!");
        }
      } catch (NumberFormatException e) {
        System.out.println(e.getMessage() + "Bitte eine gültige Zahl eingeben!");
      }
    }
  }

  public static IHK bestimmeNote(int punktzahl) {
    for (IHK note : IHK.values()) {
      if (punktzahl >= note.getPunkte()) {
        return note;
      }
    }

    return IHK.UNGENUEGEND;
  }

  public static @NotNull String getBereich(@NotNull IHK note) {
    return switch (note) {
      case SEHR_GUT -> "(92-100 Punkte)";
      case GUT -> "(81-91 Punkte)";
      case BEFRIEDIGEND -> "(67-80 Punkte)";
      case AUSREICHEND -> "(50-66 Punkte)";
      case MANGELHAFT -> "(30-49 Punkte)";
      case UNGENUEGEND -> "(0-29 Punkte)";
    };
  }
}
