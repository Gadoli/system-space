public class Etoile extends Astre {

    public Etoile(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative);
    }
    
    public String toString(){
        return "+"
    }
    
    public String getNom(){
        return this.nom;
    }
}
