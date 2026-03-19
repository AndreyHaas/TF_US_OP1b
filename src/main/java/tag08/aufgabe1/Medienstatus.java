package tag08.aufgabe1;

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
