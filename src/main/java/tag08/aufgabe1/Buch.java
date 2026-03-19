package tag08.aufgabe1;

public class Buch extends Medium{
    private String autor;
    private int seitenAnzahl;
    private String isbn;

    private String ausgeliehenVon;

    public String getAutor() {
        return autor;
    }

    public int getSeitenAnzahl() {
        return seitenAnzahl;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getAusgeliehenVon() {
        return ausgeliehenVon;
    }

    public Buch(String titel, Medienstatus status){
        super(titel,status);
    }
    public Buch(String titel, Medienstatus status, String autor, int seitenAnzahl, String isbn, String ausgeliehenVon){
        this(titel, status);
        this.autor = autor;
        this.seitenAnzahl = seitenAnzahl;
        this.isbn = isbn;
        this.ausgeliehenVon = ausgeliehenVon;
    }

    @Override
    public String gibMedienInfo(){
        return getClass().getSimpleName() + beschreibe();
    }

}
