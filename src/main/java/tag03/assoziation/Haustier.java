package tag03.assoziation;

import java.util.ArrayList;
import java.util.List;

public class Haustier {

  protected static final List<Haustier> HAUSTIER_LISTE = new ArrayList<>();
  private final int id;
  private String name;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public List<Haustier> getHaustierListe() {
    return HAUSTIER_LISTE;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setHaustierListe(Haustier haustier) {
    if (!HAUSTIER_LISTE.contains(haustier)) {
      HAUSTIER_LISTE.add(haustier);
    }
  }

  public Haustier(int id, String name) {
    this.id = id;
    this.name = name;
    HAUSTIER_LISTE.add(this);
  }

  @Override
  public String toString() {
    return String.format("Haustier{id=%d, name='%s'}", id, name);
  }
}