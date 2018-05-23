public class Sateille extends Astre {

    /*
     * Pour éviter les changements dans les différentes classes on a laissé Sateille au lieu de Satelitte
     */

    public Sateille(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative,SystemeTerrestre aSyster){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative,aSyster);
    }

    @Override
    public Vecteur calculeForce_p1() {
        SystemeTerrestre st=(SystemeTerrestre)aSysteme;
        double force=Astre.attractionGravifique(this.getMasse(),st.getPlanete().getMasse(),this.getPositionRelative().norme());
        return Vecteur.decomposeForce(force,this.getPositionRelative());
    }

    @Override
    public Vecteur calculeAccelaration_p1() {
        SystemeTerrestre st=(SystemeTerrestre)aSysteme;
        double force=-Astre.accelarationGravifique(st.getPlanete().getMasse(),this.getPositionRelative().norme());
        return Vecteur.decomposeForce(force,this.getPositionRelative());
    }
}
