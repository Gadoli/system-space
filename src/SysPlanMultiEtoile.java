import java.util.ArrayList;

public class SysPlanMultiEtoile extends SystemePlanetaire {
    private ArrayList<Etoile> etoiles;

    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,positionRelative,vitesseRelative);
        this.etoiles=new ArrayList<Etoile>();
    }
}
