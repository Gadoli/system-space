import java.awt.*;
import java.util.ArrayList;

public abstract class Astre implements Course{
    private static int nbAstre=0;
    private int id;
    public static ArrayList<Astre> listAstre=new ArrayList<Astre>();
    private String nom;
    private double masse;//kg
    private double rayonReel;//km
    private Vecteur positionRelative;//km
    private Vecteur vitesseRelative;// km/s
    protected Systeme aSysteme;
    private Color couleur;

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
        listAstre.add(this);
    }

    public Astre(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        this(nom,masse,rayonReel,positionRelative,vitesseRelative,null);
    }

    /*getter*/
    public double getMasse() { return masse; }
    public Vecteur getVitesseRelative() { return vitesseRelative; }
    public Vecteur getPositionRelative() { return positionRelative; }
    public String getNom() {return nom;}
    public double getRayonReel() { return rayonReel; }
    public Color getCouleur() { return couleur; }
    public Systeme getaSysteme() { return aSysteme;}
    public int getId() { return id; }

    /*setter*/
    public void setMasse(double masse) { this.masse = masse; }
    public void setVitesseRelative(Vecteur vitesseRelative) { this.vitesseRelative = vitesseRelative; }
    public void setPositionRelative(Vecteur positionRelative) { this.positionRelative = positionRelative; }
    public void setaSysteme(Systeme aSysteme) {this.aSysteme = aSysteme;}
    public void setRayonReel(double rayonReel) { this.rayonReel = rayonReel; }
    public void setCouleur(Color couleur) { this.couleur = couleur; }

    /*outil*/
    public static double attractionGravifique(double masse1,double masse2,double distance){
        if(distance<=1e-20){
            return 0;
        }
        return Systeme.G*masse1/distance/distance/1e6*masse2;
    }

    public static double accelarationGravifique(double masse,double distance){
        if(distance<=1e-20){
            return 0;
        }
        return Systeme.G*masse/distance/distance*1e-6;
    }

    public abstract Vecteur calculeForce_p1();

    public abstract Vecteur calculeAccelaration_p1();

    @Override
    public void marche(Vecteur vitesse, double temps) {
        this.setPositionRelative(this.getPositionRelative().add(vitesse.mulScalaire(temps)));
    }

    @Override
    public void marche() {
        this.marche(this.getVitesseRelative(),Systeme.periode_simulate);
    }

    public void astreMAJ(){
        //Vecteur force=calculeForce_p1();
        Vecteur acce=calculeAccelaration_p1();
        marche();
        System.out.println("Position de "+this.nom+" = "+getPositionRelative().toString()+"; sa vitesse= "+getVitesseRelative().toString()+" son attraction= "+acce.toString());
        //setVitesseRelative(getVitesseRelative().add(force.mulScalaire(Systeme.periodeMAJ/getMasse())));//v->v+f/m*t
        setVitesseRelative(getVitesseRelative().add(acce.mulScalaire(Systeme.periodeMAJ)));//v->v+a*t
    }
}
