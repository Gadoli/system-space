import java.util.ArrayList;

public class SysPlanMultiEtoile extends SystemePlanetaire {
    /*attributs*/
    private ArrayList<Etoile> etoiles;
    private Etoile etoileVirtuel;

    /*constructeurs*/
    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,ArrayList<SystemeTerrestre> sysTers,SystemeGalaxy superSys,ArrayList<Etoile>etoiles){
        super(nom,positionRelative,vitesseRelative,sysTers,superSys);
        this.etoiles=etoiles;
        this.etoileVirtuel=new Etoile(nom+"_centreVirtuel",0,0,positionRelative,vitesseRelative,this);
    }

    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,ArrayList<SystemeTerrestre> sysTers,SystemeGalaxy superSys){
        this(nom,positionRelative,vitesseRelative,sysTers,superSys,null);
        this.etoiles=new ArrayList<Etoile>();
    }

    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,SystemeTerrestre []tabSysTer,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative,tabSysTer,superSys);
        this.etoiles=new ArrayList<Etoile>();
        this.etoileVirtuel=new Etoile(nom+"_centreVirtuel",0,0,positionRelative,vitesseRelative,this);
    }

    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative);
        super.superSys=superSys;
        this.etoiles=new ArrayList<Etoile>();
        this.etoileVirtuel=new Etoile(nom+"_centreVirtuel",0,0,positionRelative,vitesseRelative,this);
    }

    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        this(nom,positionRelative,vitesseRelative,null);
    }

    /*getters*/
    public ArrayList<Etoile> getEtoiles() { return etoiles; }
    public Etoile getEtoileVirtuel() { return etoileVirtuel; }

    /*methodes*/
    public void ajouteEtoile(Etoile e){
        etoiles.add(e);
        e.setaSysteme(this);
    }

    @Override
    public void ajouteSysTer(SystemeTerrestre st) {
        if(etoiles.size()==0){
            System.out.println("Erreur! Il faut ajouter au moins une etoile dans ce systeme avant d'ajouter un systeme terrestre.\n");
            return;
        }
        else{
            st.setSuperSys(this);
            sysTers.add(st);
            barycentreMAJ();
        }
    }

    public void barycentreMAJ(){//mis a jour de la position du barycentre du systeme planetaire par apport au systeme galaxy
        if(etoiles.get(0)==null){
            return;
        }
        double t;
        double masse=etoiles.get(0).getMasse();
        Vecteur p1=etoiles.get(0).getPositionRelative();
        Vecteur temps;
        for(int i=1;i<etoiles.size();i++){
            t=etoiles.get(i).getMasse()/(masse+etoiles.get(i).getMasse());
            p1=p1.mulScalaire(1-t);
            temps=etoiles.get(i).getPositionRelative().mulScalaire(t);
            p1=p1.add(temps);
            masse+=etoiles.get(i).getMasse();
        }

        //mis a jour la position du barycentre

        etoileVirtuel.setPositionRelative(p1);
        etoileVirtuel.setMasse(masse);

        /*
        //mis a jour des positions relatives des systemes terrestre
        temps=coeur.sub(temps);
        for(int i=0;i<sysTers.size();i++){
            sysTers.get(i).setPositionRelative(sysTers.get(i).getPositionRelative().add(temps));
        }
        */
    }

    @Override
    public void marche(Vecteur vitesse, double temps) {
        return;
    }

    @Override
    public void marche() {
        for(int i=0;i<etoiles.size();i++){
            etoiles.get(i).astreMAJ();
        }
        barycentreMAJ();
        setPositionRelative(etoileVirtuel.getPositionRelative());
        setVitesseRelative(etoileVirtuel.getVitesseRelative());
    }

    @Override
    public void systemeMAJ() {
        marche();//les etoiles et le systeme marchent
        for(int i=0;i<sysTers.size();i++){
            sysTers.get(i).systemeMAJ();
        }
    }
}
