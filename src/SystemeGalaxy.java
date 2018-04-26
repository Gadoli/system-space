import java.util.ArrayList;

public class SystemeGalaxy extends Systeme {
    private ArrayList<SystemePlanetaire> systemePlanetaires;

    public SystemeGalaxy(String nom){
        super(nom);
        systemePlanetaires=new ArrayList<SystemePlanetaire>();
    }
}
