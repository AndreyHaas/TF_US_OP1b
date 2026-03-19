package tag08.SOLID_beispiel;

/**
 * Schiff-Implementierung
 */
public class Schiff implements Transportmittel {
  private final String name;
  private TransportStatus status;
  private final double maxTonnage;

  public Schiff(String name, double maxTonnage) {
    this.name = name;
    this.maxTonnage = maxTonnage;
    this.status = TransportStatus.VERFUEGBAR;
  }

  @Override
  public void transportieren(String ware, int gewicht) {
    if (gewicht > maxTonnage * 1000) {
      throw new IllegalArgumentException("❌ Schiff " + name +
          ": Gewicht über Tonnage!");
    }

    setStatus(TransportStatus.IN_FAHRT);
    System.out.println("🚢 Schiff " + name +
        " transportiert " + gewicht + "kg " + ware + " über Wasser");
  }

  @Override
  public double berechneKosten(int entfernung) {
    // Schiff: 0.80€ pro km (günstiger, aber langsam)
    return entfernung * 0.80;
  }

  @Override
  public TransportStatus getStatus() {
    return status;
  }

  public double getMaxTonnage() {
    return maxTonnage;
  }

  @Override
  public void setStatus(TransportStatus status) {
    this.status = status;
    System.out.println("  📊 Schiff " + name + " Status → " + status.getAnzeigeName());
  }

  @Override
  public String getIdentifikation() {
    return "Schiff-" + name;
  }
}
