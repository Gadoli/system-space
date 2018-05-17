import java.util.ArrayList;

public abstract class SystemePlanetaire extends Systeme{
    /*attribut*/
    protected ArrayList<SystemeTerrestre> sysTers;

    /*constructeur*/
    public SystemePlanetaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative,ArrayList<SystemeTerrestre> sysTers,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative,superSys);
        if(sysTers==null){
            this.sysTers=new ArrayList<SystemeTerrestre>();
        }
        else{
            this.sysTers = sysTers;
            for(int i=0;i<this.sysTers.size();i++){
                this.sysTers.get(i).setSuperSys(this);
            }
        }
    }

    public SystemePlanetaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative,SystemeTerrestre []tabSysTer,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative,superSys);
        sysTers=new ArrayList<SystemeTerrestre>();
        if(tabSysTer==null||tabSysTer.length==0){
            this.sysTers=new ArrayList<SystemeTerrestre>();
        }
        else{
            for(int i=0;i<tabSysTer.length;i++){
                tabSysTer[i].setSuperSys(this);
                sysTers.add(tabSysTer[i]);
            }
        }
    }

    public SystemePlanetaire(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,positionRelative,vitesseRelative,null);
        sysTers=new ArrayList<SystemeTerrestre>();
    }

    /*getter*/
    public ArrayList<SystemeTerrestre> getSysTers() { return sysTers;}

    /*methode*/
    public abstract void ajouteSysTer( SystemeTerrestre st);
}
