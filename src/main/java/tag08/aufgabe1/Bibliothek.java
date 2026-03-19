package tag08.aufgabe1;

import java.util.ArrayList;
import java.util.List;

public class Bibliothek {
    List<Medium> medien;
    public Bibliothek(){
        medien = new ArrayList<>();
    }
    public void mediumHinzufuegen(Medium medium) {
        medien.add(medium);
    }
    public void alleMedienAusgeben(){
        for(Medium medium:medien){
            System.out.println(medium.gibMedienInfo());

            switch (medium.getStatus())
            {
                case VERFUEGBAR:
                case RESERVIERT:
                case AUSGELIEHEN:
                case BESCHAEDIGT:
                    medium.beschreibe();
                    break;

            }
        }


    }

}
