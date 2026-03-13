package tag05.vererbungUnterricht;

public class NorwegischeWaldkatze extends Katze{
    private boolean hatLangesFell;
    public NorwegischeWaldkatze(String name, String fellFarbe){
        super(name, fellFarbe);
        this.hatLangesFell = true;
    }

    @Override
    public String schnurren() {
        return "Die Waldkatze schnurrt auf Norwegisch, Schnørr, Schnørr!";
    }
}
