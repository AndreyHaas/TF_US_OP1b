package tag03.komposition;

public class Raum {
    private int raumNummer;

    public Raum(int raumNummer) {
        this.raumNummer = raumNummer;
        System.out.println("  Raum " + raumNummer + " wurde erstellt");
    }

    public int getRaumNummer() {
        return raumNummer;
    }

    @Override
    protected void finalize() {
        System.out.println("  Raum " + raumNummer + " wird gelöscht (finalize)");
    }
}
