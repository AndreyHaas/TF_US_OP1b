package tag08.unterricht;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        //Aufgabe 4: Analyse von Polymorphie
        Medium m1;
        Medium m2;
        m1 = new Buch("Java Lernen", Medienstatus.VERFUEGBAR);
        m2 = new DVD("OOP verstehen", Medienstatus.RESERVIERT);

        List<Medium> medien = new ArrayList<>();
        medien.add(m1);
        medien.add(m2);
    }
}
