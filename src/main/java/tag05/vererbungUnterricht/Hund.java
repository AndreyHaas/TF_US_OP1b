package tag05.vererbungUnterricht;

public class Hund extends Tier{
    public Hund(String name) {
        super(name);
    }
    @Override
    public String gibLaut(){
        return "Der Hund bellt!";
    }

}
