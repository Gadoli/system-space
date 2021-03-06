import java.util.ArrayList;

public class SystemeSatelitteNaturel extends Systeme{
    private Planete planete;
    private ArrayList<Sateille> satelittes;
    private Vecteur positionRelative;
    private Vecteur vitesseRelative;

    public SystemeSatelitteNaturel(String nom,Planete planete,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom);
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
        satelittes = new ArrayList<Satelitte>;
    }
    
    public void ajouteSatellite(Satellite s){
        satelittes.add(s);
    }
    
    public String toString(){
        s="";
        for (int i=0; i<satelittes.length; i++){
            s+=satellites.toString();
        }
        return planete.toString()+s;
    }
    
    
    
}
