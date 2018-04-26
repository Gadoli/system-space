public abstract class SystemePlanetaire extends Systeme{
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;

    public SystemePlanetaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom);
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
    }

}
