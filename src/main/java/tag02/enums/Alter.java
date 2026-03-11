package tag02.enums;

public enum Alter {

    NEUGEBOREN(0),
    VOLLJÄHRIG(18),
    SENIOR(60);
    private final int alterZahl;
    private Alter(int alterZahl)
    {
        this.alterZahl = alterZahl;
    }
    public int getAlterZahl()
    {
        return  alterZahl;
    }
    public static Alter getAlter(int zahl) {
        for (Alter a : Alter.values())
        {
            if(a.alterZahl == zahl)
            {
                return a;
            }
        }
        return  null;
    }

    public static int getAlterByName(String name)
    {
        for (Alter a : Alter.values())
        {
            if(a.name().equalsIgnoreCase(name))
            {
                return a.alterZahl;
            }
        }
        return 0;

    }




}
