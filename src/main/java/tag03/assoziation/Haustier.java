package tag03.assoziation;

public class Haustier {
    private final int id;
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Haustier(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
