package tag05.vererbungUnterricht;

public class Hund extends Tier {

  private final String fellFarbe;

  public Hund(String name, int alter, String fellFarbe) {
    super(name, alter);
    this.fellFarbe = fellFarbe;
  }

  public String getFellFarbe() {
    return fellFarbe;
  }

  @Override
  public String gibLaut() {
    return "Der Hund bellt!";
  }
}