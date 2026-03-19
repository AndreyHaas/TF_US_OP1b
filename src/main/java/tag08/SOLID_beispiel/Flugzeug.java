package tag08.SOLID_beispiel;

/**
 * Flugzeug-Implementierung
 */
public class Flugzeug implements Transportmittel {
  private final String flugnummer;
  private TransportStatus status;
  private int maxPassagier;

  public Flugzeug(String flugnummer, int maxPassagier) {
    this.flugnummer = flugnummer;
    this.maxPassagier = maxPassagier;
    this.status = TransportStatus.VERFUEGBAR;
  }

  @Override
  public void transportieren(String ware, int gewicht) {
    setStatus(TransportStatus.IN_FAHRT);
    System.out.println("✈️ Flugzeug " + flugnummer +
        " transportiert " + gewicht + "kg " + ware + " durch die Luft");
  }

  @Override
  public double berechneKosten(int entfernung) {
    // Flugzeug: 3.50€ pro km (schnell, aber teuer)
    return entfernung * 3.50;
  }

  @Override
  public TransportStatus getStatus() {
    return status;
  }

  @Override
  public void setStatus(TransportStatus status) {
    this.status = status;
    System.out.println("  📊 Flug " + flugnummer + " Status → " + status.getAnzeigeName());
  }

  @Override
  public String getIdentifikation() {
    return "Flug-" + flugnummer;
  }
}