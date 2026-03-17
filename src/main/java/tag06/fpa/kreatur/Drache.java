package tag06.fpa.kreatur;

public class Drache extends Kreatur {

  public Drache(String name) {
    super(name);
  }

  @Override
  public void angreifen() {
    System.out.println(getClass().getSimpleName() + " spuckt Feuer");
  }
}