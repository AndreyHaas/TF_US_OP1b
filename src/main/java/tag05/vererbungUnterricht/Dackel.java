package tag05.vererbungUnterricht;

public class Dackel extends Hund{
    private boolean isJagdHund = true;
    public Dackel(String name){
        super(name);
    }
    public boolean isJagdHund(){
        return isJagdHund;
    }
    @Override
    public String gibLaut(){
        return "Der Dackel bellt besonders laut.";
    }
}
