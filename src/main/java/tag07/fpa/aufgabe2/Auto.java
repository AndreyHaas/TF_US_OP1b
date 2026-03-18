package tag07.fpa.aufgabe2;

public class Auto extends Fahrzeug implements IFahrbar {
    public Auto(String marke) {
        super(marke);
    }

    @Override
    public void fahren() {
        System.out.println(getFahrZeugToSting() + " der Marke " + getMarke() + " kann fahren!");
    }
}
