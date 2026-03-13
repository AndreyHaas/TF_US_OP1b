package tag05.aufgabe0;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class aggregateGruppe {
    private final List<Abenteurer> abenteurerInDerGruppe;

    public aggregateGruppe() {
        abenteurerInDerGruppe = new ArrayList<>();
    }

    public List<Abenteurer> getAbenteurerGruppe() {
        return abenteurerInDerGruppe;
    }

    public void setAbenteurer(Abenteurer abenteurer) {
        abenteurerInDerGruppe.add(abenteurer);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", aggregateGruppe.class.getSimpleName() + "[", "]")
                .add("abenteurerInDerGruppe=" + abenteurerInDerGruppe)
                .toString();
    }
}