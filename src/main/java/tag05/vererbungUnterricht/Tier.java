package tag05.vererbungUnterricht;

import java.util.ArrayList;
import java.util.List;

public class Tier {

  private final String name;
  private final int alter;

  public static final List<Tier> tierListe = new ArrayList<>();

  public String getName() {
    return name;
  }

  public int getAlter() {
    return alter;
  }

  public List<Tier> getTierListe() {
    return tierListe;
  }

  public Tier(String name, int alter) {
    this.name = name;
    this.alter = alter;
    tierListe.add(this);
  }

  public String gibLaut() {
    return "Ein Tier macht Laut";
  }

  public void ausgabe(){
    System.out.println("das ist Tier");
  }
}