public class SysSolUniqueEtoile extends SystemeSolaire {
    private Etoile etoile;

    public SysSolUniqueEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,Etoile etoile){
        super(nom,positionRelative,vitesseRelative);
        this.etoile=etoile;
    }
}
