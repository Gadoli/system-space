import java.util.ArrayList;

public class Planete extends Astre {

    public Planete(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative, SystemePlanetaire aSysPlan){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative,aSysPlan);
    }

    @Override
    public double getMasse() {
        return super.getMasse();
    }

    @Override
    public Vecteur getPositionRelative() {
        return super.getPositionRelative();
    }

    @Override
    public Vecteur calculeForce_p1() {
        Vecteur dis=getPositionRelative();
        Etoile e;
        double f;
        if(aSysteme instanceof SysPlanUniqueEtoile){
            SysPlanUniqueEtoile sue=(SysPlanUniqueEtoile) aSysteme;
            e=sue.getEtoile();
        }
        else {
            SysPlanMultiEtoile spe=(SysPlanMultiEtoile)aSysteme;
            e=spe.getEtoileVirtuel();
        }
        f=Astre.attractionGravifique(this.getMasse(),e.getMasse(),dis.norme());
        return Vecteur.decomposeForce(f,dis);
    }

    @Override
    public void marche(Vecteur vitesse, double temps) {

    }
}
