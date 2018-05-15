public class Sateille extends Astre {

    public Sateille(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative,SystemeTerrestre aSyster){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative,aSyster);
    }

    @Override
    public Vecteur calculeForce_p1() {
        SystemeTerrestre st=(SystemeTerrestre)aSysteme;
        double force=Astre.attractionGravifique(this.getMasse(),st.getPlanete().getMasse(),this.getPositionRelative().norme());
        return Vecteur.decomposeForce(force,this.getPositionRelative());
    }
}
