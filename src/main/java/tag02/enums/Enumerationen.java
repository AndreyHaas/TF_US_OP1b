package tag02.enums;

import java.util.ArrayList;
import java.util.List;

public class Enumerationen {

    public static void main(String[] args)
    {
        // 1
        for(Ampelfarbe ampelfarbe : Ampelfarbe.values())
        {

            info(ampelfarbe);
        }
        // 2
        for(Ampelfarbe ampelfarbe : Ampelfarbe.values())
        {

            System.out.println(ampelfarbe.name());
        }
        // 3
        for(Fehlercode fehlercode : Fehlercode.values())
        {
            System.out.println("Die Konstante ist " + fehlercode.name() + " und der Code ist " + fehlercode.getCode());
        }
        //4
        Fehlercode fehlercode = Fehlercode.valueOf(456);
        System.out.println(fehlercode);
        if( Fehlercode.valueOf(5) == null)
        {
            System.out.println("Kein Fehlercode vorhanden");
        }
        //5
        System.out.println(Monat.getMonateInQuartal(2));
        //6
        Monat monat = Monat.valueOf(2);
        System.out.println(monat);
        /*
         // 1. Konstanten des Enums Ampelfarbe verwenden und info(...) aufrufen
        Ampelfarbe farbe = Ampelfarbe.ROT;
        info(farbe);
        info(Ampelfarbe.GELB);
        info(Ampelfarbe.GRUEN);

        System.out.println();

        // 2. Über alle Werte von Ampelfarbe iterieren und Namen ausgeben
        for (Ampelfarbe a : Ampelfarbe.values()) {
            System.out.println(a.name());
        }

        System.out.println();

        // 3. Konstante des Enums Fehlercode verwenden und Name + Code ausgeben
        Fehlercode fehler = Fehlercode.ILLEGAL_ARGUMENT;
        System.out.println("Die Konstante " + fehler.name() + " hat den Wert " + fehler.getCode());

        System.out.println(Arrays.toString(Fehlercode.values()));

        // 4. Fehlercode.valueOf(int code) testen
        Fehlercode fehler2 = Fehlercode.valueOf(456);
        if (fehler2 != null) {
            System.out.println("Die Konstante " + fehler2.name() + " hat den Wert " + fehler2.getCode());
        } else {
            System.out.println("Kein passender Fehlercode gefunden.");
        }

        System.out.println();

        // 5. Monat.getMonateInQuartal(int quartal) testen
        System.out.println("Monate im 3. Quartal:");
        System.out.println(Monat.getMonateInQuartal(3));

        System.out.println();

        // 6. Monat.valueOf(int zahl) testen
        Monat monat = Monat.valueOf(10);
        if (monat != null) {
            System.out.println("Zahl: " + monat.getZahl()
                    + ", Name: " + monat.name()
                    + ", Quartal: " + monat.getQuartal());
        } else {
            System.out.println("Kein passender Monat gefunden.");
        }

         */



    }


    enum Ampelfarbe
    {
        ROT, GELB, GRÜN;
    }

    static void info(Ampelfarbe farbe) {
        switch (farbe)
        {
            case ROT:
                System.out.println(farbe.ordinal() + ", Anhalten");
                break;
            case GELB:
                System.out.println(farbe.ordinal() +", Achtung");
                break;
            case GRÜN:
                System.out.println(farbe.ordinal() +", Weiterfahren");
                break;
        }
    }

    enum Fehlercode {
        ILLEGAL_ARGUMENT(123), OUT_OF_BOUNDS(456), NULL_REFERENCE(789), NUMBER_FORMAT(147);

        private final int code;

        private Fehlercode(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }

        public static Fehlercode valueOf(int code)
        {
            for(Fehlercode fehlercode : Fehlercode.values())
            {
                if(fehlercode.getCode() == code)
                {
                    return fehlercode;
                }
            }
            return null;
        }

    }

    enum Monat {
        JANUAR(1, 1),
        FEBRUAR(2, 1),
        MÄRZ(3, 1),
        APRIL(4, 2),
        MAI(5, 2),
        JUNI(6, 2),
        JULI(7, 3),
        AUGUST(8, 3),
        SEPTEMBER(9, 3),
        OKTOBER(10, 4),
        NOVEMBER(11, 4),
        DEZEMBER(12, 4);

        private final int zahl;
        private final int quartal;

        private Monat(int zahl, int quartal)
        //Modifier 'private' is redundant for enum constructors
        {
            this.zahl = zahl;
            this.quartal = quartal;
        }

        public int getZahl() {
            return zahl;
        }

        public int getQuartal() {
            return quartal;
        }

        public static List<Monat> getMonateInQuartal(int quartal)
        {
            List<Monat> monateInQuartal = new ArrayList<>();
            for(Monat monat: Monat.values())
            {
                if(monat.getQuartal() == quartal)
                {
                    monateInQuartal.add(monat);
                }
            }
            return monateInQuartal;
        }
        public static Monat valueOf(int zahl)
        {
            for(Monat monat: Monat.values()) {
                if (monat.getZahl() == zahl)
                {
                    return monat;
                }
            }
            return null;
        }

        static void info()
        {

        }

    }




}
