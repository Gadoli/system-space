import java.awt.*;

public class ExempleSysSolaire {
    /*
     * Classe permettant de stocker les valeurs réelles de notre système solaire
     */
    public Etoile soleil=new Etoile("Soleil",1.98892e30,6.96e5,new Vecteur(0,0,0),new Vecteur(0,0,0));

    public Planete mercure=new Planete("Mercure",3.3022e23,2439.7,new Vecteur(4.60012e7,0,0),new Vecteur(0,47.87,0));
    public Planete venus =new Planete("Vénus",4.8676e24,6051.8,new Vecteur(1.07477e8,0,0),new Vecteur(0,35.02,0));
    public Planete terre=new Planete("Terre",5.97237e24,6371,new Vecteur(1.47095e8,0,0),new Vecteur(0,29.78,0));
    public Planete mars=new Planete("Mars",6.4185e23,3389.5,new Vecteur(2.0662e8,0,0),new Vecteur(0,24.13,0));
    public Planete jupiter=new Planete("Jupiter",1.8986e27,69911,new Vecteur(7.405736e8,0,0),new Vecteur(0,13.07,0));
    public Planete saturne=new Planete("Saturne",5.6846e26,60268,new Vecteur(1.353572956e9,0,0),new Vecteur(0,9.69,0));
    public Planete uranus=new Planete("Uranus",8.6810e25,25559,new Vecteur(2.748938461e9,0,0),new Vecteur(0,6.81,0));
    public Planete neptune=new Planete("Neptune",1.0243e26,24764,new Vecteur(4.452940833e9,0,0),new Vecteur(0,5.43,0));

    public Sateille lune=new Sateille("Lune",7.3477e22,1737.1,new Vecteur(3.63104e5,0,0),new Vecteur(0,1.022,0),null);

    public SystemeTerrestre stMercure =new SystemeTerrestre(mercure);
    public SystemeTerrestre stVenus =new SystemeTerrestre(venus);
    public SystemeTerrestre stTerre =new SystemeTerrestre(terre);
    public SystemeTerrestre stMars =new SystemeTerrestre(mars);
    public SystemeTerrestre stJupiter =new SystemeTerrestre(jupiter);
    public SystemeTerrestre stSaturne =new SystemeTerrestre(saturne);
    public SystemeTerrestre stUranus =new SystemeTerrestre(uranus);
    public SystemeTerrestre stNeptune =new SystemeTerrestre(neptune);

    public final Planete planetes[]={mercure,venus,terre,mars,jupiter,saturne,uranus,neptune};
        public final SystemeTerrestre tabST[]={stMercure,stVenus,stTerre,stMars,stJupiter,stSaturne,stUranus,stNeptune};

    public SysPlanUniqueEtoile systemeSolaire=new SysPlanUniqueEtoile("Systeme_Solaire",soleil,tabST,null);

    public ExempleSysSolaire(){
        stTerre.ajouteSatellite(lune);
        soleil.setCouleur(Color.RED);
        mercure.setCouleur(new Color(76,100,136));
        venus.setCouleur(new Color(200,139,59));
        terre.setCouleur(new Color(135,206,235));
        mars.setCouleur(new Color(199,143,108));
        jupiter.setCouleur(new Color(172,144,123));
        saturne.setCouleur(new Color(250,195,130));
        uranus.setCouleur(new Color(200,226,223));
        neptune.setCouleur(new Color(84,138,182));

        lune.setCouleur(new Color(255,215,118));
    }
}
