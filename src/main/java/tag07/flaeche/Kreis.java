package tag07.flaeche;

public class Kreis implements HatFlaeche {

  private double radius;

  public double getRadius() {
    return radius;
  }

  public void setRadius(double radius) {
    this.radius = radius;
  }

  public Kreis(double radius) {
    this.radius = radius;
  }

  @Override
  public double berechneFlaeche() {
    return (Math.PI * (Math.pow(radius, 2)));
  }
}
