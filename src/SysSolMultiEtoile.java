import java.util.ArrayList;

public class SysSolMultiEtoile extends SystemeSolaire {
    private ArrayList<Etoile> etoiles;

    public SysSolMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,positionRelative,vitesseRelative);
        this.etoiles=new ArrayList<Etoile>();
    }
}
