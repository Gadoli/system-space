import java.util.ArrayList;

public abstract class SystemePlanetaire extends Systeme{
    protected ArrayList<SystemeTerrestre> sysTers;

    public SystemePlanetaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative,superSys);
        sysTers = new ArrayList<SystemeTerrestre>();
    }
    
    public abstract void ajouteSysTer( SystemeTerrestre st);

    public ArrayList<SystemeTerrestre> getSysTers() {
        return sysTers;
    }
}
