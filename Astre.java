public abstract class Astre implements Attraction,Course{
    private static int nbAstre=0;
    private int id;
    private String nom;
    private double masse;
    private double rayonReel;
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;
    protected Systeme aSysteme;

    /*constructeur*/
    public Astre(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative,Systeme aSysteme){
        nbAstre++;
        this.id=nbAstre;
        this.nom=nom;
        this.masse=masse;
        this.rayonReel=rayonReel;
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
        this.aSysteme=aSysteme;
    }

    /*getter*/
    public double getMasse() { return masse; }
    public Vecteur getVitesseRelative() { return vitesseRelative; }
    public Vecteur getPositionRelative() { return positionRelative; }
    public double getRayonReel() { return rayonReel; }

    /*setter*/
    public void setMasse(double masse) { this.masse = masse; }
    public void setVitesseRelative(Vecteur vitesseRelative) { this.vitesseRelative = vitesseRelative; }
    public void setPositionRelative(Vecteur positionRelative) { this.positionRelative = positionRelative; }

    /*outil*/
    public static double attractionGravifique(double masse1,double masse2,double distance){
        return Attraction.G*masse1*masse2/distance/distance;
    }

    @Override
    public abstract Vecteur calculeForce_p1();

    @Override
    public void marche(Vecteur vitesse, double temps) {
        this.setPositionRelative(this.getPositionRelative().add(vitesse.mulScalaire(temps)));
    }

    @Override
    public void marche() {
        this.marche(this.getVitesseRelative(),Systeme.periodeMAJ);
    }

    public void astreMAJ(){
        Vecteur force=calculeForce_p1();
        marche();
        setVitesseRelative(getVitesseRelative().add(force.mulScalaire(Systeme.periodeMAJ/getMasse())));//v->v+f/m*t
    }

}
