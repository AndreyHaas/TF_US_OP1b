package tag06;

public class Abstrakt {

  public static void main(String[] args) {
    Leistenkrokodil leistenkrokodil = new Leistenkrokodil("Harry");
    System.out.println(leistenkrokodil.beschreibe());
    System.out.println(leistenkrokodil.gibArtInfo());
    System.out.println("            ");
    System.out.println(leistenkrokodil.getName());
    System.out.println("            ");
    Nilkrokodil nilkrokodil = new Nilkrokodil("Garry");
    System.out.println(nilkrokodil.beschreibe());
    System.out.println(nilkrokodil.gibArtInfo());
    System.out.println("            ");
    System.out.println(nilkrokodil.getName());
  }
}