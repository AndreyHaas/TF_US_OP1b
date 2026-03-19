package tag08.aufgabe1;

public interface Druckbar {
    String STANDARD_FORMAT = "A4";
    void drucken();
    static void testDruck(){
        System.out.println("Testdruck");
    }
    default boolean pruefeFormat(String format){
       // return format.equalsIgnoreCase(format);
       return STANDARD_FORMAT.equalsIgnoreCase(format);
    }
}
