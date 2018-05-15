import java.util.ArrayList;

public class SysPlanMultiEtoile extends SystemePlanetaire {
    private ArrayList<Etoile> etoiles;
    private Etoile etoileVirtuel;

    public SysPlanMultiEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative,superSys);
        this.etoiles=new ArrayList<Etoile>();
        this.etoileVirtuel=new Etoile(nom+"_centreVirtuel",0,0,positionRelative,vitesseRelative,this);
    }
    
    public void ajouteEtoile(Etoile e){
        etoiles.add(e);
    }

    @Override
    public void ajouteSysTer(SystemeTerrestre st) {
        if(etoiles.size()==0){
            System.out.println("Erreur! Il faut ajouter au moins un etoile dans ce systeme avant ajouter de systeme terrestre.\n");
            return;
        }
        else{
            sysTers.add(st);
        }
    }

    public ArrayList<Etoile> getEtoiles() {
        return etoiles;
    }
    public Etoile getEtoileVirtuel() {
        return etoileVirtuel;
    }

    public void barycentreMAJ(){//mis a jour la position de barycentre du systeme planetaire par apport au systeme galaxy
        if(etoiles.get(0)==null){
            return;
        }
        double t;
        Vecteur coeur=etoiles.get(0).getPositionRelative().clone();
        double masse=etoiles.get(0).getMasse();
        Vecteur temps;
        for(int i=1;i<etoiles.size();i++){
            t=etoiles.get(i).getMasse()/(etoiles.get(i+1).getMasse()+masse);
            temps=etoiles.get(i).getPositionRelative().sub(coeur);
            temps=temps.mulScalaire(t);
            coeur=coeur.add(temps);
            masse+=etoiles.get(i).getMasse();
        }

        //mis a jour la position de barycentre
        temps=etoileVirtuel.getPositionRelative();
        etoileVirtuel.setVitesseRelative(coeur.sub(temps).mulScalaire(1/Systeme.periodeMAJ));
        etoileVirtuel.setPositionRelative(coeur);
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
