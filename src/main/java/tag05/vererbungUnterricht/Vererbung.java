package tag05.vererbungUnterricht;

public class Vererbung {

    public static void main(String[] args) {
        Tier tier = new Tier("Unbekanntes Tier");
        Hund hund = new Hund("Bello");
        System.out.println(hund.getName());
        Katze katze = new Katze("Minka", "weiß");
        System.out.println(katze.getName());
        System.out.println(katze.getFellFarbe());
        Dackel dackel = new Dackel("Waldi");
        System.out.println(dackel.getName());
        System.out.println(dackel.isJagdHund())        ;
        Hauskatze hauskatze = new Hauskatze("Lilly", "weiß", new Besitzer("Müller", true));
        System.out.println(hauskatze.getName());
        System.out.println(hauskatze.getFellFarbe());

        NorwegischeWaldkatze norwegischeWaldkatze = new NorwegischeWaldkatze("Nora", "schwarz-braun");
        System.out.println(norwegischeWaldkatze.getName());
        System.out.println(norwegischeWaldkatze.getFellFarbe());






    }
}
