package tag05.vererbungUnterricht;

public class Tier {
    private final String name;
    public String getName() {
        return name;
    }
    public Tier (String name){
        this.name = name;
    }

    public String gibLaut(){
        return "Ein Tier macht Laut";
    }



}
