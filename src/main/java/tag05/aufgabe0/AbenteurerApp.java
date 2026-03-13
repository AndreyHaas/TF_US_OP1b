package tag05.aufgabe0;

public class AbenteurerApp {
    static void main() {

        Abenteurer jan = new Abenteurer("Jan");
        Abenteurer sarah = new Abenteurer("Sarah");
        Abenteurer seb = new Abenteurer("Seb");

        aggregateGruppe abenteurerGruppe = new aggregateGruppe();
        abenteurerGruppe.setAbenteurer(jan);
        abenteurerGruppe.setAbenteurer(sarah);
        abenteurerGruppe.setAbenteurer(seb);

        System.out.println("*".repeat(25));
        System.out.println("Abenteurer in der Gruppe:");
        System.out.println("*".repeat(25)+ "\n");

        for (Abenteurer abenteurer : abenteurerGruppe.getAbenteurerGruppe()) {
            System.out.println("- " + abenteurer.getName());
        }
    }
}
