package tag05.vererbungUnterricht;

public class Hauskatze extends Katze{
    private final Besitzer besitzer;
    public Hauskatze(String name, int alter, String fellFarbe, Besitzer besitzer){
        super(name, alter, fellFarbe);
        this.besitzer = besitzer;
    }
    @Override
    public String gibLaut(){
        return "Hauskatze macht Miau im Treppenhaus";
    }

}
