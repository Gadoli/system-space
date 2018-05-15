public class SysPlanUniqueEtoile extends SystemePlanetaire {
    private Etoile etoile;

    public SysPlanUniqueEtoile(String nom,Vecteur positionRelative,Vecteur vitesseRelative,Etoile etoile,SystemeGalaxy superSys){
        super(nom,positionRelative,vitesseRelative,superSys);
        this.etoile=etoile;
    }

    public Etoile getEtoile() {
        return etoile;
    }

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
