public class SysPlanUniqueEtoile extends SystemePlanetaire {
    private Etoile etoile;

    public SysPlanUniqueEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,Etoile etoile){
        super(nom,positionRelative,vitesseRelative);
        this.etoile=etoile;
    }
}
