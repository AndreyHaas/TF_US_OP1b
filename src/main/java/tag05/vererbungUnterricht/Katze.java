package tag05.vererbungUnterricht;

public class Katze extends Tier {
    protected String fellFarbe;

    public Katze(String name, String fellFarbe){
        super(name);
        this.fellFarbe = fellFarbe;
    }
    public String schnurren() {
        return "Die Katze schnurrt";
    }
    @Override
    public String gibLaut(){
        return "Die Katze miaut!";
    }
    public String getFellFarbe(){
        return fellFarbe;
    }

}
