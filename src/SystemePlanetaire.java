import java.util.ArrayList;

public abstract class SystemePlanetaire extends Systeme{
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;
    private ArrayList<Planete> Planetes;

    public SystemePlanetaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom);
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
        Planetes = new ArrayList<Planete>();
    }
    
    public void ajouteSysTer( SystemeTerrestre st){
        Planetes.add(st);
    }

}
