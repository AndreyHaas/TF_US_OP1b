package tag05.vererbungUnterricht;

public class NorwegischeWaldkatze extends Katze{
    private boolean hatLangesFell;
    public NorwegischeWaldkatze(String name, int alter, String fellFarbe){
        super(name, alter, fellFarbe);
        this.hatLangesFell = true;
    }

    @Override
    public String schnurren() {
        return "Die Waldkatze schnurrt auf Norwegisch, Schnørr, Schnørr!";
    }
}
