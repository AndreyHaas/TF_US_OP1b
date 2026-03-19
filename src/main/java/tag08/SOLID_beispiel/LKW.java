package tag08.SOLID_beispiel;

/**
 * LKW-Implementierung
 * Single Responsibility: Nur LKW-spezifische Logik
 */
public class LKW implements Transportmittel {
  private final String kennzeichen;
  private TransportStatus status;
  private double lastKapazitaet;
  private String aktuellerFahrer;

  // Assoziation: LKW HAT einen Fahrer (optional)
  private Fahrer zugeordneterFahrer;

  public LKW(String kennzeichen, double lastKapazitaet) {
    this.kennzeichen = kennzeichen;
    this.lastKapazitaet = lastKapazitaet;
    this.status = TransportStatus.VERFUEGBAR;
  }

  @Override
  public void transportieren(String ware, int gewicht) {
    if (gewicht > lastKapazitaet) {
      throw new IllegalArgumentException("❌ LKW " + kennzeichen +
          ": Gewicht (" + gewicht + "kg) über Kapazität (" + lastKapazitaet + "kg)");
    }

    setStatus(TransportStatus.IN_FAHRT);
    String fahrerInfo = (zugeordneterFahrer != null) ?
        " (Fahrer: " + zugeordneterFahrer.getName() + ")" : "";

    System.out.println("🚛 LKW " + kennzeichen + fahrerInfo +
        " transportiert " + gewicht + "kg " + ware);
  }

  @Override
  public double berechneKosten(int entfernung) {
    // LKW: 1.50€ pro km + 0.20€ pro kg (angenommen 1000kg)
    return entfernung * 1.50 + (entfernung * 0.20);
  }

  @Override
  public TransportStatus getStatus() {
    return status;
  }

  @Override
  public void setStatus(TransportStatus status) {
    this.status = status;
    System.out.println("📊 LKW " + kennzeichen + " Status → " + status.getAnzeigeName());
  }

  @Override
  public String getIdentifikation() {
    return "LKW-" + kennzeichen;
  }

  // Assoziation: Fahrer zuweisen
  public void setFahrer(Fahrer fahrer) {
    this.zugeordneterFahrer = fahrer;
  }
}