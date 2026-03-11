package tag03.komposition;

public class Komposition {
    public static void main(String[] args) {
        Gebäude gebäude = new Gebäude("Schule", 1);
        gebäude.addRaum(2);
        gebäude.addRaum(3);
        gebäude.addRaum(4);

        //Raum r = new Raum(5);
        //gebäude.raumListe.add(r);

        System.out.println("Raumnummern des Gebäudes:");
        System.out.println(gebäude.getRäume());

        gebäude = null;

        System.gc();

        System.out.println("Hier sollte das Gebäude und alle Räume gelöscht sein... hoffentlich.");
    }
}
