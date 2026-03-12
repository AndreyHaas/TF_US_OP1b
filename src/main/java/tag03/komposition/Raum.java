package tag03.komposition;

public class Raum {
    private final int raumNummer;

    public int getRaumNummer() {
        return raumNummer;
    }

    public Raum(int raumNummer) {
        this.raumNummer = raumNummer;
    }

    protected void finalize() {
        System.out.println("Der Raum mit der Nummer " + raumNummer + " wurde gelöscht!");
    }
}
