package tag09.wichtigeBibliotheken;

import java.util.StringJoiner;

public class Kunde {
    private final long id;
    private final String name;
    private final String kategorie;

    public Kunde(long id, String name, String kategorie) {
        this.id = id;
        this.name = name;
        this.kategorie = kategorie;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getKategorie() {
        return kategorie;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Kunde.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("kategorie='" + kategorie + "'")
                .toString();
    }
}
