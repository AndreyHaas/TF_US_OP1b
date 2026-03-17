package tag06;

public abstract class Krokodil {

  private String name;

  public Krokodil(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract String gibArtInfo();

  public String beschreibe() {
    return "Krokodilname " + name;
  }
}