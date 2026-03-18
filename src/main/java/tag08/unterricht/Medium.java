package tag08.unterricht;

public abstract class Medium {

    private String titel;
    private Medienstatus status;

    public Medium(String titel, Medienstatus status){
        this.titel = titel;
        this.status = status;
    }
    public String getTitel(){
        return titel;
    }
    public Medienstatus getStatus(){
        return status;
    }

    public void setStatus(Medienstatus status){
        this.status = status;
    }
    public String beschreibe(){
        return "Titel: " +titel+ " Status: " + status.getAnzeigeText();
    }
    public abstract String gibMedienInfo();


}
