public class Sateille extends Astre {

    public Sateille(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative);
    }
    
    public String getNom(){
        return this.nom;
    }
    
    public String toString(){
        return "°";
    }
}
