package tag01.hausaufgaben;

public enum IHK {
  SEHR_GUT(92),
  GUT(81),
  BEFRIEDIGEND(67),
  AUSREICHEND(50),
  MANGELHAFT(30),
  UNGENUEGEND(0);

  private int punkte;

  IHK(int punkte) {
    this.punkte = punkte;
  }

  public int getPunkte() {
    return punkte;
  }
}
