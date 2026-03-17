package tag06.fpa.kreatur;

public abstract class Kreatur {

  private final String name;

  protected Kreatur(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public abstract void angreifen();
}