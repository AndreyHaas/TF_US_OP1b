package tag07.fpa.aufgabe2;

public class Bagger extends Fahrzeug implements IFahrbar{
    public Bagger(String marke) {
        super(marke);
    }

    @Override
    public void fahren() {
        System.out.println(getFahrZeugToSting() + " der Marke " + getMarke() + " kann fahren!");
    }
}
