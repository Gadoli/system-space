import java.util.ArrayList;

public class Etoile extends Astre {
    /*constructeurs*/
    public Etoile(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative,SystemePlanetaire aSysPlan){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative,aSysPlan);
    }

    public Etoile(String nom,double masse,double rayonReel,Vecteur positionRelative,Vecteur vitesseRelative){
        super(nom,masse,rayonReel,positionRelative,vitesseRelative);
    }

    /*methodes*/
    @Override
    public Vecteur calculeForce_p1() {
        SystemeGalaxy sg=(SystemeGalaxy) aSysteme.superSys;
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

    @Override
    public Vecteur calculeAccelaration_p1() {
        SystemeGalaxy sg=(SystemeGalaxy) aSysteme.superSys;
        Vecteur forceTotal;
        double force;

        force=-Astre.accelarationGravifique(sg.getCoeur().getMasse(),this.aSysteme.positionRelative.norme());
        forceTotal=Vecteur.decomposeForce(force,this.getPositionRelative());

        if(aSysteme instanceof SysPlanUniqueEtoile){
            return forceTotal;
        }
        if(aSysteme instanceof SysPlanMultiEtoile){
            double m3=((SysPlanMultiEtoile) aSysteme).getEtoileVirtuel().getMasse();
            double m1=this.getMasse();

            if(m3-m1<1e-20) return new Vecteur(0,0,0);
            double r=m1/(m3-m1);
            Vecteur v3=((SysPlanMultiEtoile) aSysteme).getEtoileVirtuel().getPositionRelative();
            Vecteur v1=this.getPositionRelative();
            Vecteur v4=(v3.sub(v1)).mulScalaire(1+r);
            double fm2m1=-Astre.accelarationGravifique(m3-m1,v4.norme());
            forceTotal=forceTotal.add(Vecteur.decomposeForce(fm2m1,v4));
            return forceTotal;
        }
        else{
            System.out.println("Erreur! Le type du systeme planetaire est inconnu!");
            return null;
        }
    }
}
