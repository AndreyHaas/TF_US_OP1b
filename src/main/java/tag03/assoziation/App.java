package tag03.assoziation;

public class App {

  public static void main(String[] args) {

    Person mueller = new Person(1, "Müller");
    Person schmidt = new Person(2, "Schmidt");
    Person weber = new Person(3, "Weber");

    Auto vwg = new Auto(101, "VW Golf");
    Auto bmwX3 = new Auto(102, "BMW X3");
    Auto audiA4 = new Auto(103, "Audi A4");

    Produkt laptop = new Produkt(1001, 899.99, "Laptop");
    Produkt maus = new Produkt(1002, 29.99, "Maus");
    Produkt tastatur = new Produkt(1003, 59.99, "Tastatur");

    Haustier bello = new Haustier(201, "Bello");
    Haustier minka = new Haustier(202, "Minka");
    Haustier tweety = new Haustier(203, "Tweety");

    vwg.setBesitzer(mueller);
    bmwX3.setBesitzer(mueller);
    audiA4.setBesitzer(schmidt);

    vwg.addFahrer(mueller);
    vwg.addFahrer(schmidt);
    bmwX3.addFahrer(mueller);
    bmwX3.addFahrer(weber);
    audiA4.addFahrer(schmidt);

    mueller.addDarfFahren(vwg);
    mueller.addDarfFahren(bmwX3);
    schmidt.addDarfFahren(vwg);
    schmidt.addDarfFahren(audiA4);
    weber.addDarfFahren(bmwX3);

    mueller.addHaustier(bello);
    mueller.addHaustier(minka);
    schmidt.addHaustier(tweety);

    Einkauf einkauf1 = new Einkauf(10001, mueller, laptop);
    Einkauf einkauf2 = new Einkauf(10002, schmidt, maus);
    Einkauf einkauf3 = new Einkauf(10003, mueller, tastatur);

    System.out.println("=== AUSGABE ALLER OBJEKTE ===\n");

    System.out.println("--- Personen ---");
    for (Person person : Person.PERSONEN_LISTE) {
      System.out.println(person);
    }

    System.out.println("\n--- Autos ---");
    for (Auto auto : Auto.AUTO_LISTE) {
      System.out.println(auto);
    }

    System.out.println("\n--- Produkte ---");
    for (Produkt produkt : Produkt.PRODUKT_LISTE) {
      System.out.println(produkt);
    }

    System.out.println("\n--- Haustiere ---");
    for (Haustier haustier : Haustier.HAUSTIER_LISTE) {
      System.out.println(haustier);
    }

    System.out.println("\n--- Einkäufe ---");
    for (Einkauf einkauf : Einkauf.EINKAUFS_LISTE) {
      System.out.println(einkauf);
    }

    System.out.println("\n=== DETAILAUSGABEN ===\n");

    System.out.println("--- Details zu " + mueller.getNachname() + " ---");
    System.out.println("Haustiere: " + mueller.getHaustierListe().size());
    for (Haustier haustier : mueller.getHaustierListe()) {
      System.out.println("  * " + haustier);
    }
    System.out.println("Darf fahren: " + mueller.getDarfFahren().size() + " Autos");
    for (Auto auto : mueller.getDarfFahren()) {
      System.out.println("  * " + auto);
    }

    System.out.println("\n--- Details zu " + vwg.getMarke() + " ---");
    System.out.println("Besitzer: " + (vwg.getBesitzer() != null ?
        vwg.getBesitzer().getNachname() : "keiner"));
    System.out.println("Fahrer: " + vwg.getFahrerListe().size());
    for (Person person : vwg.getFahrerListe()) {
      System.out.println("  * " + person.getNachname());
    }
  }
}