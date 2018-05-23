import javax.swing.*;
import java.awt.*;
import java.lang.Thread;

public class UniversTest {
    public static void main(String []args){
        int taille_x,taille_y;
        taille_x=1980;
        taille_y=1080;
        PaintAstre pa=new PaintAstre(taille_x,taille_y);

        Frame fenetre=new JFrame();
        fenetre.setTitle("FenetreUnivers");
        fenetre.setSize(taille_x,taille_y);
        fenetre.setLocationRelativeTo(null);
        fenetre.setBackground(Color.black);
        ((JFrame) fenetre).setContentPane(pa);
        ((JFrame) fenetre).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fenetre.setVisible(true);

        SystemeGalaxy sg=new SystemeGalaxy("Galaxy",new Vecteur(0,0,0),new Vecteur(0,0,0),0);//masse=1.98892e100

        /**test pour systeme galaxy avec deux systemes solaires à unique étoiles*/
        ExempleSysSolaire ex1=new ExempleSysSolaire();
        Vecteur p1=new Vecteur(1e32,1e32,1e32);
        Vecteur v1=new Vecteur(0,-3.6183243268468564E24,0);
        ex1.soleil.setPositionRelative(p1);
        ex1.soleil.setVitesseRelative(v1);
        ex1.systemeSolaire.setPositionRelative(p1);
        ex1.systemeSolaire.setVitesseRelative(v1);
        for(int i=1;i<Astre.listAstre.size();i++){
            Astre a=Astre.listAstre.get(i);
            a.setPositionRelative(a.getPositionRelative().mulScalaire(-1));
            a.setVitesseRelative(a.getVitesseRelative().mulScalaire(-1));
            a.getaSysteme().setPositionRelative(a.getPositionRelative().mulScalaire(-1));
            a.getaSysteme().setVitesseRelative(a.getVitesseRelative().mulScalaire(-1));
        }

        ExempleSysSolaire ex2=new ExempleSysSolaire();
        ex2.soleil.setPositionRelative(p1);
        ex2.soleil.setVitesseRelative(v1);
        ex2.systemeSolaire.setPositionRelative(p1);
        ex2.systemeSolaire.setVitesseRelative(v1);

        sg.ajouteSysPlan(ex1.systemeSolaire);
        sg.ajouteSysPlan(ex2.systemeSolaire);


        /** test pour le systeme solaire à unique étoile*/
        /*
        ExempleSysSolaire ex3=new ExempleSysSolaire();
        sg.ajouteSysPlan(ex3.systemeSolaire);
        */

        /**test pour systeme solaire AVEC DEUX soleils, système multi étoile donc*/
        /*
        ExempleSysSolaire ex4=new ExempleSysSolaire();
        SysPlanMultiEtoile spme=new SysPlanMultiEtoile("Multi_test",new Vecteur(0,0,0),new Vecteur(0,0,0),sg);
        spme.ajouteEtoile(ex4.soleil);
        for(int i=0;i<ex4.tabST.length;i++){
            spme.ajouteSysTer(ex4.tabST[i]);
        }
        Etoile deuxieme=new Etoile("deuxime",ex4.soleil.getMasse(),ex4.soleil.getRayonReel(),new Vecteur(-1e32,-1e32,-1e32),new Vecteur(0,0,0));
        deuxieme.setCouleur(Color.RED);
        spme.ajouteEtoile(deuxieme);
        sg.ajouteSysPlan(spme);
        */

        try{
            while (1+1==2){
                Thread.sleep(Systeme.periodeMAJ);
                sg.systemeMAJ();
                ((JFrame) fenetre).setContentPane(pa);
                /**pour afficher la trace utiliser la ligne ci-dessus**/
                //pa.repaint();
            }
        }catch (InterruptedException e){
            return;
        }
    }
}
