import java.util.ArrayList;

public class SystemeTerrestre extends Systeme{
    /*attribut*/
    private Planete planete;
    private ArrayList<Sateille> satelittes;

    /*constructeur*/
    public SystemeTerrestre(String nom,Planete planete,SystemePlanetaire superSys){
        super(nom,planete.getPositionRelative(),planete.getVitesseRelative(),superSys);
        this.planete=planete;
        planete.setaSysteme(this);
        satelittes = new ArrayList<Sateille>();
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
        satelittes.add(s);
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
        for(int i=0;i<satelittes.size();i++){//tous les sateilles marchent
            satelittes.get(i).astreMAJ();
        }
    }
}
