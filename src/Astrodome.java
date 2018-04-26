public abstract class Astrodome {
    private static int nbAstrodome=0;
    private int id;
    private String nom;
    private double masse;
    private double rayonReel;
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;

    public Astrodome(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        nbAstrodome++;
        this.id=nbAstrodome;
        this.nom=nom;
        this.masse=masse;
        this.rayonReel=rayonReel;
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
    }



}
