public class ExempleSysSolaire {
    public Etoile soleil=new Etoile("Soleil",1.98892e30,6.96e5,new Vecteur(1,1,1),new Vecteur(217,217,217));

    public Planete mercure=new Planete("Mercure",3.3022e23,2439.7,new Vecteur(1,1,1),new Vecteur(0,0,0));
    public Planete venus =new Planete("Vénus",4.8676e24,6051.8,new Vecteur(1,1,1),new Vecteur(0,0,0));
    public Planete terre=new Planete("Terre",5.97237e24,6371,new Vecteur(0,0,0),new Vecteur(0,0,0));
    public Planete mars=new Planete("Mars",6.4185e23,3389.5,new Vecteur(0,0,0),new Vecteur(0,0,0));
    public Planete jupiter=new Planete("Jupiter",1.8986e27,69911,new Vecteur(0,0,0),new Vecteur(0,0,0));
    public Planete saturne=new Planete("Saturne",5.6846e26,60268,new Vecteur(0,0,0),new Vecteur(0,0,0));
    public Planete uranus=new Planete("Uranus",8.6810e25,25559,new Vecteur(0,0,0),new Vecteur(0,0,0));
    public Planete neptune=new Planete("Neptune",1.0243e26,24764,new Vecteur(0,0,0),new Vecteur(0,0,0));

    

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
}
