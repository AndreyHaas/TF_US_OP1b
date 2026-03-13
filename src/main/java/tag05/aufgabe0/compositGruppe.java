package tag05.aufgabe0;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

class compositGruppe {
    private List<Abenteurer> abenteurerInDerGruppe = new ArrayList<>();

    public void createAbenteurer(String name) {
        Abenteurer abenteurer = new Abenteurer(name);
        abenteurerInDerGruppe.add(abenteurer);
    }

    public void clearAbenteurerGruppe() {
        abenteurerInDerGruppe.clear();
    }

    public List<Abenteurer> getAbenteurerGruppe() {
        return abenteurerInDerGruppe;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", compositGruppe.class.getSimpleName() + "[", "]")
                .add("abenteurerInDerGruppe=" + abenteurerInDerGruppe)
                .toString();
    }
}
