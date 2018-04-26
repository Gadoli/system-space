public class SysSolUniqueEtoile extends SystemePlanetaire {
    private Etoile etoile;

    public SysSolUniqueEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,Etoile etoile){
        super(nom,positionRelative,vitesseRelative);
        this.etoile=etoile;
    }
}
