package tag08.SOLID_beispiel;

import java.util.ArrayList;
import java.util.List;

/**
 * Fahrer-Klasse
 * Assoziation: Fahrer KANN LKW fahren
 */
public class Fahrer {
  private final String name;
  private final String fuehrerscheinKlasse;

  // Assoziation: Fahrer KANN mehrere LKWs fahren
  private List<LKW> qualifizierteLKWs = new ArrayList<>();

  public Fahrer(String name, String fuehrerscheinKlasse) {
    this.name = name;
    this.fuehrerscheinKlasse = fuehrerscheinKlasse;
  }

  public void addQualifiziertenLKW(LKW lkw) {
    qualifizierteLKWs.add(lkw);
  }

  public boolean kannFahren(LKW lkw) {
    return qualifizierteLKWs.contains(lkw);
  }

  public void fahre(LKW lkw, String ziel) {
    if (!kannFahren(lkw)) {
      System.out.println("❌ " + name + " darf LKW " +
          lkw.getIdentifikation() + " nicht fahren!");
      return;
    }
    System.out.println("👨‍✈️ " + name + " fährt " +
        lkw.getIdentifikation() + " nach " + ziel);
  }

  public String getName() {
    return name;
  }
}