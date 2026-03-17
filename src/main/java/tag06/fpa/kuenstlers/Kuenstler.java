package tag06.fpa.kuenstlers;

public abstract class Kuenstler {

  private String name;

  protected Kuenstler(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract void kunstErstellen();
}