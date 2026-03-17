package tag06.fpa.kuenstlers;

public class Saenger extends Kuenstler {

  public Saenger(String name) {
    super(name);
  }

  @Override
  public void kunstErstellen() {
    System.out.println("Ich singe einen Song");
  }
}