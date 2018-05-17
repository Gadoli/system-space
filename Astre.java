public abstract class Astre implements Attraction,Course{
    private static int nbAstre=0;
    private int id;
    private String nom;
    private double masse;//kg
    private double rayonReel;//km
    private Vecteur positionRelative;//AU
    private Vecteur vitesseRelative;// km/s
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

    public Astre(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        nbAstre++;
        this.id=nbAstre;
        this.nom=nom;
        this.masse=masse;
        this.rayonReel=rayonReel;
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
    }

    /*getter*/
    public double getMasse() { return masse; }
    public Vecteur getVitesseRelative() { return vitesseRelative; }
    public Vecteur getPositionRelative() { return positionRelative; }
    public String getNom() {return nom;}

    /*setter*/
    public void setMasse(double masse) { this.masse = masse; }
    public void setVitesseRelative(Vecteur vitesseRelative) { this.vitesseRelative = vitesseRelative; }
    public void setPositionRelative(Vecteur positionRelative) { this.positionRelative = positionRelative; }
    public void setaSysteme(Systeme aSysteme) {this.aSysteme = aSysteme;}

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
