package tag07.fpa.aufgabe2;

public class Main {
    static void main() {
        Auto audi = new Auto("Audi");
        audi.fahren();

        Boot submarine = new Boot("Submarine");
        submarine.schwimmen();

        Flugzeug airbus = new Flugzeug("Airbus");
        airbus.fliegen();

        Bagger reno = new Bagger("Reno");
        reno.fahren();
    }
}
