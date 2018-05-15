import java.util.ArrayList;

public class SystemeGalaxy extends Systeme {
    private ArrayList<SystemePlanetaire> systemePlanetaires;
    private Etoile coeur;

    public SystemeGalaxy(String nom,Vecteur positionRelative,Vecteur vitesseRelative,double masse){
        super(nom,positionRelative,vitesseRelative,null);
        systemePlanetaires=new ArrayList<SystemePlanetaire>();
        this.coeur=new Etoile("CoeurGalaxy",masse,10,new Vecteur(0,0,0),new Vecteur(0,0,0),null);
    }
    
    public void ajouteSysPlan(SystemePlanetaire sp){
        systemePlanetaires.add(sp);
    }

    public ArrayList<SystemePlanetaire> getSystemePlanetaires() {
        return systemePlanetaires;
    }

    public Etoile getCoeur() {
        return coeur;
    }

    @Override
    public void marche(Vecteur vitesse, double temps) {
        return;
    }

    @Override
    public void marche() {
        return;
    }

    @Override
    public void systemeMAJ() {
        for(int i=0;i<systemePlanetaires.size();i++){
            systemePlanetaires.get(i).systemeMAJ();
        }
    }
}
