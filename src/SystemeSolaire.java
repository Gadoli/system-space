public abstract class SystemeSolaire extends Systeme{
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;

    public SystemeSolaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom);
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
    }

}
