package tag08.SOLID_beispiel;

/**
 * Interface für alle Transportmittel
 * - Definiert den VERTRAG (was jedes Transportmittel können muss)
 * - Abstraktion vom Typ "KANN transportieren"
 */
public interface Transportmittel {

  void transportieren(String ware, int gewicht);

  double berechneKosten(int entfernung);

  TransportStatus getStatus();

  void setStatus(TransportStatus status);

  String getIdentifikation();

  // Default-Methode (ab Java 8)
  default boolean istEinsatzbereit() {
    return getStatus() == TransportStatus.VERFUEGBAR;
  }
}