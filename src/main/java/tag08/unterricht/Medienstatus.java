package tag08.unterricht;

public enum Medienstatus {
    VERFUEGBAR("Verfügbar"),
    AUSGELIEHEN("Ausgeliehen"),
    RESERVIERT("Reserviert"),
    BESCHAEDIGT("Beschädigt");

    private String anzeigeText;
    Medienstatus(String anzeigeText){
        this.anzeigeText = anzeigeText;
    }
    public String getAnzeigeText(){
        return  anzeigeText;
    }
}
