import java.util.ArrayList;

public class Planete extends Astre {
    /*constructeurs*/
    public Planete(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative, SystemePlanetaire aSysPlan){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative,aSysPlan);
    }

    public Planete(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative);
    }

    /*methodes*/
    @Override
    public Vecteur calculeForce_p1() {
        Vecteur dis=getPositionRelative();
        Etoile e;
        double f;
        if(aSysteme.superSys instanceof SysPlanUniqueEtoile){
            SysPlanUniqueEtoile sue=(SysPlanUniqueEtoile) aSysteme.superSys;
            e=sue.getEtoile();
        }
        else {
            SysPlanMultiEtoile spe=(SysPlanMultiEtoile)aSysteme.superSys;
            e=spe.getEtoileVirtuel();
        }
        f=Astre.attractionGravifique(this.getMasse(),e.getMasse(),dis.norme());
        return Vecteur.decomposeForce(f,dis);
    }

    @Override
    public Vecteur calculeAccelaration_p1() {
        Vecteur dis=getPositionRelative();
        Etoile e;
        double f;
        if(aSysteme.superSys instanceof SysPlanUniqueEtoile){
            SysPlanUniqueEtoile sue=(SysPlanUniqueEtoile) aSysteme.superSys;
            e=sue.getEtoile();
        }
        else {
            SysPlanMultiEtoile spe=(SysPlanMultiEtoile)aSysteme.superSys;
            e=spe.getEtoileVirtuel();
        }
        f=-Astre.accelarationGravifique(e.getMasse(),dis.norme());
        return Vecteur.decomposeForce(f,dis);
    }
}
