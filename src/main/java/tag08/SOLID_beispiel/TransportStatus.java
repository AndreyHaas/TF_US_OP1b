package tag08.SOLID_beispiel;

/**
 * Status eines Transportmittels (Enum)
 */
public enum TransportStatus {
  VERFUEGBAR("Verfügbar"),
  IN_FAHRT("Unterwegs"),
  WARTUNG("In Wartung"),
  AUSGEFALLEN("Defekt");

  private final String anzeigeName;

  TransportStatus(String anzeigeName) {
    this.anzeigeName = anzeigeName;
  }

  public String getAnzeigeName() {
    return anzeigeName;
  }

  public boolean istVerfuegbar() {
    return this == VERFUEGBAR;
  }
}
