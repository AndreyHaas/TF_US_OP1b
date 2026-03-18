package tag07.fpa.aufgabe1;

public class Musiker implements ISaenger, IGitarrenspieler {

    private String forName;
    private String nachName;

    public Musiker(String forName, String nachName) {
        this.forName = forName;
        this.nachName = nachName;
    }

    public String getForName() {
        return forName;
    }

    public void setForName(String forName) {
        this.forName = forName;
    }

    public String getNachName() {
        return nachName;
    }

    public void setNachName(String nachName) {
        this.nachName = nachName;
    }

    @Override
    public void gitarreSpielen() {
        System.out.println(getClass().getSimpleName() + " kan Gitarre spielen!");
    }

    @Override
    public void singen() {
        System.out.println(getClass().getSimpleName() + " kan singen!");
    }
}
