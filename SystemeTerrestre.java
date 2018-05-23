import java.util.ArrayList;

public class SystemeTerrestre extends Systeme{
    /*attribut*/
    private Planete planete;
    private ArrayList<Sateille> sateilles;

    /*constructeur*/
    public SystemeTerrestre(String nom,Planete planete,ArrayList<Sateille> sateilles,SystemePlanetaire superSys){
        super(nom,planete.getPositionRelative(),planete.getVitesseRelative(),superSys);
        this.planete=planete;
        planete.setaSysteme(this);
        if(sateilles != null){
            this.sateilles=sateilles;
        }
        else{
            this.sateilles=new ArrayList<Sateille>();
        }
    }

    public SystemeTerrestre(String nom,Planete planete,SystemePlanetaire superSys){
        super(nom,planete.getPositionRelative(),planete.getVitesseRelative(),superSys);
        this.planete=planete;
        planete.setaSysteme(this);
        sateilles = new ArrayList<Sateille>();
    }
    public SystemeTerrestre(String nom,Planete planete){
        this(nom,planete,null);
    }

    public SystemeTerrestre(Planete planete){
        this("SysTer_"+planete.getNom(),planete,null);
    }

    /*getter*/
    public Planete getPlanete() {return planete;}

    /*methode*/
    public void ajouteSatellite(Sateille s){
        s.setaSysteme(this);
        sateilles.add(s);
    }

    @Override
    public void marche(Vecteur vitesse, double temps) {
        return;
    }

    @Override
    public void marche() {
        planete.astreMAJ();
        setPositionRelative(planete.getPositionRelative());
        setVitesseRelative(planete.getVitesseRelative());
    }

    @Override
    public void systemeMAJ() {
        marche();//planete et le systeme marchent
        for(int i=0;i<sateilles.size();i++){//tous les satelittes marchent
            sateilles.get(i).astreMAJ();
        }
    }
}
