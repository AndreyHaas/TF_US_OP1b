package tag06.fpa.kreatur;

public class Ritter extends Kreatur {

  protected Ritter(String name) {
    super(name);
  }

  @Override
  public void angreifen() {
    System.out.println(getClass().getSimpleName() + "nutzt sein Schwert!");
  }
}