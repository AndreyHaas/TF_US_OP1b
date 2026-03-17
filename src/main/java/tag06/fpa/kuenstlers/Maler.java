package tag06.fpa.kuenstlers;

public class Maler extends Kuenstler {

  public Maler(String name) {
    super(name);
  }

  @Override
  public void kunstErstellen() {
    System.out.println("Ich male ein Bild");
  }
}