package tag05.vererbungUnterricht;

public class Katze extends Tier {

  protected String fellFarbe;

  public Katze(String name, int alter, String fellFarbe) {
    super(name, alter);
    this.fellFarbe = fellFarbe;
  }

  public String schnurren() {
    return "Die Katze schnurrt";
  }

  @Override
  public String gibLaut() {
    return "Die Katze miaut!";
  }

  public String getFellFarbe() {
    return fellFarbe;
  }

}
