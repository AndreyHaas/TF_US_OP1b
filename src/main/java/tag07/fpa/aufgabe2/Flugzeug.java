package tag07.fpa.aufgabe2;

public class Flugzeug extends Fahrzeug implements IFlugfaehig {
    public Flugzeug(String marke) {
        super(marke);
    }

    @Override
    public void fliegen() {
        System.out.println(getFahrZeugToSting() + " der Marke " + getMarke() + " kann fliegen!");
    }
}