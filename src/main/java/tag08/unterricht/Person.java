package tag08.unterricht;

import java.util.List;

public class Person {

    private final String name;
    private final long id;

    private final List<Ausleihe> ausleihen;

    public List<Ausleihe> getAusleihen() {
        return ausleihen;
    }
    public void fuegeAusleiheHinzu(Ausleihe ausleihe){
        ausleihen.add(ausleihe);
    }

    public Person(String name, long id, List<Ausleihe> ausleihen){
        this.name = name;
        this.id = id;
        this.ausleihen = ausleihen;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }


}
