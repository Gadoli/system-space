import java.awt.*;
import java.util.ArrayList;

public class SystemeGalaxy extends Systeme {
    /*attribut*/
    private ArrayList<SystemePlanetaire> systemePlanetaires;
    private Etoile coeur;

    /*constructeur*/
    public SystemeGalaxy(String nom,Vecteur positionRelative,Vecteur vitesseRelative,double masse){
        super(nom,positionRelative,vitesseRelative,null);
        systemePlanetaires=new ArrayList<SystemePlanetaire>();
        this.coeur=new Etoile("CoeurGalaxy",masse,10,new Vecteur(0,0,0),new Vecteur(0,0,0),null);
        this.coeur.setCouleur(Color.BLACK);
    }

    /*getter*/
    public ArrayList<SystemePlanetaire> getSystemePlanetaires() { return systemePlanetaires; }
    public Etoile getCoeur() { return coeur; }

    /*methode*/
    public void ajouteSysPlan(SystemePlanetaire sp){
        sp.setSuperSys(this);
        systemePlanetaires.add(sp);
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
