package tag07.flaeche;

public class Rechteck implements HatFlaeche {

  private double laenge;
  private double breite;

  public double getLaenge() {
    return laenge;
  }

  public void setLaenge(double laenge) {
    this.laenge = laenge;
  }

  public double getBreite() {
    return breite;
  }

  public void setBreite(double breite) {
    this.breite = breite;
  }

  public Rechteck(double laenge, double breite) {
    this.laenge = laenge;
    this.breite = breite;
  }

  @Override
  public double berechneFlaeche() {
    return laenge * breite;
  }
}
