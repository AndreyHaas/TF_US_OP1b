package tag07.fpa.aufgabe2;

public class Fahrzeug {

    private String fahrZeugToSting = getClass().getSimpleName().toUpperCase();

    private final String marke;

    public Fahrzeug(String marke) {
        this.marke = marke;
    }

    public String getMarke() {
        return marke;
    }

    public String getFahrZeugToSting() {
        return fahrZeugToSting;
    }
}