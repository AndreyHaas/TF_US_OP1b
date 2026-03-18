package tag08.unterricht;

public class Ausleihe {
    private Person person;
    private Medium medium;

    public Ausleihe(Person person, Medium medium){
        this.person = person;
        this.medium = medium;
        person.fuegeAusleiheHinzu(this);
    }

    public Person getPerson() {
        return person;
    }

    public Medium getMedium() {
        return medium;
    }

}
