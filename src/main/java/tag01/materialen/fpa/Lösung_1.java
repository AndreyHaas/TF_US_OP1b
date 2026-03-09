package aufgaben;

/*
    Schreiben Sie bitte ein Java Programm, in dem ...
	- das Enum Ihk eingeführt wird (für die Noten SehrGut = 92, Gut = 81, Befriedigend = 67, Ausreichend = 50, Mangelhaft = 30, Ungenügend = 0)
	- vom User in einer Schleife eine Punktzahl abgefragt wird
        (die Schleife wird - ohne Fehlermeldung - wiederholt, falls Eingabe nicht zwischen 0 und 100, oder ein anderer Fehler geschah)
    - nach der Schleife wird der Name des entsprechenden Enum-Wertes ausgegeben
        (also SehrGut bei Eingaben zwischen 100 und 92
                  Gut bei Eingaben von 81 bis 91
                  ... )

    2 Hinweise:
    - Versuchen Sie bitte den letzten Punkt mit einer foreach-Schleife zu lösen
    - Das ganze geschieht natürlich aus Trainingsgründen ... Problem: SehrGut statt "Sehr Gut"
      Man würde hier also normalerweise eher ein string-Array in Betracht ziehen
 */

import java.util.Scanner;

public class Lösung_1
{
    public enum IHK
    {
        SEHR_GUT(92), GUT(81), BEFRIEDIGEND(67), AUSREICHEND(50), MANGELHAFT(30), UNGENÜGEND(0);

        private final int punkte;

        IHK(int punkte)
        {
            this.punkte = punkte;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int punktzahl = 0;

        do
        {
            System.out.println("Bitte Punktzahl eingeben: ");
            try
            {
                String tmp = sc.nextLine();
                punktzahl = Integer.parseInt(tmp);
            }
            catch (Exception e)
            {
                System.out.println("Bitte eine Zahl eingeben!!");
                punktzahl = -1;
            }
        } while (punktzahl < 0 || punktzahl > 100);

        for (IHK ihk : IHK.values())
        {
            if (punktzahl >= ihk.punkte)
            {
                System.out.println(ihk);
                break;
            }
        }
    }
}







