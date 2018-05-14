public class Planete extends Astre {

    public Planete(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative);
    }
    
    public String toString(){
        return "o";
    }
}
