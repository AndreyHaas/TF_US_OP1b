package tag07.fpa.aufgabe2;

public class Boot extends Fahrzeug implements ISchwimmfaehig {
    public Boot(String marke) {
        super(marke);
    }

    @Override
    public void schwimmen() {
        System.out.println(getFahrZeugToSting() + " der Marke " + getMarke() + " kann schwimmen!");
    }
}
