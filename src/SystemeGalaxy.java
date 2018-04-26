import java.util.ArrayList;

public class SystemeGalaxy extends Systeme {
    private ArrayList<SystemeSolaire> systemeSolaires;

    public SystemeGalaxy(String nom){
        super(nom);
        systemeSolaires=new ArrayList<SystemeSolaire>();
    }
}
