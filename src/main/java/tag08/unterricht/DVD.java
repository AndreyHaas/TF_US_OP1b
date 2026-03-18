package tag08.unterricht;

public class DVD extends Medium{
    private int laufzeit;
    private long dvdId;
    private String genre;
    private String ausgeliehenVon;

    public int getLaufzeit() {
        return laufzeit;
    }

    public long getDvdId() {
        return dvdId;
    }

    public String getGenre() {
        return genre;
    }

    public String getAusgeliehenVon() {
        return ausgeliehenVon;
    }

    public DVD(String titel, Medienstatus status){
        super(titel, status);
    }
    public DVD(String titel, Medienstatus status, int laufzeit, long dvdId, String genre,String ausgeliehenVon){
        super(titel, status);
        this.laufzeit = laufzeit;
        this.dvdId = dvdId;
        this.genre = genre;
        this.ausgeliehenVon = ausgeliehenVon;
    }

    @Override
    public String gibMedienInfo(){
        return getClass().getSimpleName() + beschreibe();
    }
}
