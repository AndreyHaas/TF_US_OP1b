package tag05.vererbungUnterricht;

public class Vererbung {

    public static void main(String[] args) {
        Tier tier = new Tier("Unbekanntes Tier", 1);
        Hund hund = new Hund("Bello", 2, "Weiß");
        System.out.println(hund.getName());
        Katze katze = new Katze("Minka", 3, "fdf");
        System.out.println(katze.getName());
        System.out.println(katze.getFellFarbe());
        Dackel dackel = new Dackel("Waldi",2, "schwarz");
        System.out.println(dackel.getName());
        System.out.println(dackel.isJagdHund())        ;
        Hauskatze hauskatze = new Hauskatze("Lilly", 2,"weiß", new Besitzer("Müller", true));
        System.out.println(hauskatze.getName());
        System.out.println(hauskatze.getFellFarbe());

        NorwegischeWaldkatze norwegischeWaldkatze = new NorwegischeWaldkatze("Nora", 2,"schwarz-braun");
        System.out.println(norwegischeWaldkatze.getName());
        System.out.println(norwegischeWaldkatze.getFellFarbe());






    }
}
