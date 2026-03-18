package tag07.fpa.aufgabe2;

public class Fahrzeug {

    private final String marke;
    private final String fahrZeugToSting = getClass().getSimpleName().toUpperCase();

    public Fahrzeug(String marke) {
        this.marke = marke;
    }

    public String getMessage() {
        return "Ein " + fahrZeugToSting + " der Marke " + marke +
                " kann " + Thread.currentThread().getStackTrace()[2].getMethodName();
    }
}