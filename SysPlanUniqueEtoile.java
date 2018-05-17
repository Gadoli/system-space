import java.util.ArrayList;

public class SysPlanUniqueEtoile extends SystemePlanetaire {
    /*attribut*/
    private Etoile etoile;

    /*constructeur*/
    public SysPlanUniqueEtoile(String nom, Etoile etoile, ArrayList<SystemeTerrestre>sysTers, SystemeGalaxy superSys){
        super(nom,etoile.getPositionRelative(),etoile.getVitesseRelative(),sysTers,superSys);
        this.etoile=etoile;
        etoile.setaSysteme(this);
    }

    public SysPlanUniqueEtoile(String nom, Etoile etoile, SystemeTerrestre []tabSysTer, SystemeGalaxy superSys){
        super(nom,etoile.getPositionRelative(),etoile.getVitesseRelative(),tabSysTer,superSys);
        this.etoile=etoile;
        etoile.setaSysteme(this);
    }

    public SysPlanUniqueEtoile(String nom, Etoile etoile, SystemeGalaxy superSys){
        super(nom,etoile.getPositionRelative(),etoile.getVitesseRelative());
        super.superSys=superSys;
        this.etoile=etoile;
        etoile.setaSysteme(this);
    }

    public SysPlanUniqueEtoile(String nom,Etoile etoile){
        this(nom,etoile,null);
    }

    public SysPlanUniqueEtoile(Etoile etoile){
        this("SysPU_"+etoile.getNom(),etoile);
    }

    /*getter*/
    public Etoile getEtoile() {return etoile;}

    /*methode*/
    @Override
    public void ajouteSysTer(SystemeTerrestre st) {
        if(etoile==null){
            System.out.println("Erreur! Il faut ajouter une etoile dans ce systeme avant d'ajouter un systeme terrestre.\n");
            return;
        }
        else{
            sysTers.add(st);
        }
    }

    @Override
    public void marche(Vecteur vitesse, double temps) {
        return;
    }

    @Override
    public void marche() {
        etoile.astreMAJ();
        setPositionRelative(etoile.getPositionRelative());
        setVitesseRelative(etoile.getVitesseRelative());
    }

    @Override
    public void systemeMAJ() {
        marche();//etoile et le systeme marchent
        for(int i=0;i<sysTers.size();i++){
            sysTers.get(i).systemeMAJ();
        }
    }
}
