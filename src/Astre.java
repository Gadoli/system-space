public abstract class Astre{
    private static int nbAstre=0;
    private int id;
    private String nom;
    private double masse;
    private double rayonReel;
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;

    public Astre(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        nbAstre++;
        this.id=nbAstre;
        this.nom=nom;
        this.masse=masse;
        this.rayonReel=rayonReel;
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
    }



}
