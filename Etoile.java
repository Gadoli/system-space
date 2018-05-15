import java.util.ArrayList;

public class Etoile extends Astre {

    public Etoile(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative,SystemePlanetaire aSysPlan){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative,aSysPlan);
    }

    @Override
    public double getMasse() {
        return super.getMasse();
    }

    @Override
    public void setMasse(double masse) {
        super.setMasse(masse);
    }

    @Override
    public void setPositionRelative(Vecteur positionRelative) {
        super.setPositionRelative(positionRelative);
    }

    @Override
    public void setVitesseRelative(Vecteur vitesseRelative) {
        super.setVitesseRelative(vitesseRelative);
    }

    @Override
    public Vecteur calculeForce_p1() {
        SystemeGalaxy sg=(SystemeGalaxy) aSysteme.superSys;
        ArrayList<SystemePlanetaire> spList=sg.getSystemePlanetaires();
        Vecteur forceTotal;
        double force;

        force=Astre.attractionGravifique(this.getMasse(),sg.getCoeur().getMasse(),this.aSysteme.positionRelative.norme());
        forceTotal=Vecteur.decomposeForce(force,this.getPositionRelative());

        if(aSysteme instanceof SysPlanUniqueEtoile){
            return forceTotal;
        }
        if(aSysteme instanceof SysPlanMultiEtoile){
            double m3=((SysPlanMultiEtoile) aSysteme).getEtoileVirtuel().getMasse();
            double m1=this.getMasse();
            double r=m1/(m3-m1);
            Vecteur v3=((SysPlanMultiEtoile) aSysteme).getEtoileVirtuel().getPositionRelative();
            Vecteur v1=this.getPositionRelative();
            Vecteur v4=(v3.sub(v1)).mulScalaire(1+r);
            double fm2m1=Astre.attractionGravifique(m1,m3-m1,v4.norme());
            forceTotal=forceTotal.add(Vecteur.decomposeForce(fm2m1,v4));
            return forceTotal;
        }
        else{
            System.out.println("Erreur! Le type de systeme planetaire est inconnu!");
            return null;
        }
    }
}
