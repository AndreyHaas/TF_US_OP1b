package tag05.vererbungUnterricht;

public class Hauskatze extends Katze{
    private final Besitzer besitzer;
    public Hauskatze(String name, String fellFarbe, Besitzer besitzer){
        super(name, fellFarbe);
        this.besitzer = besitzer;
    }
    @Override
    public String gibLaut(){
        return "Hauskatze macht Miau im Treppenhaus";
    }

}
