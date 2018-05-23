import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PaintAstre extends JPanel {
    public static double echelle_rayon_etoile=0.0001;
    public static double echelle_rayon_planete=0.001;
    public static double echelle_dis_etoile=1e-30;
    public static double echelle_dis_planete=1e-6;//5e-7
    public static double echelle_dis_sateille=1e-4;
    public static double rayon_min=10;

    private ArrayList<Astre> listAstre=Astre.listAstre;
    private int longueur;
    private int largeur;

    public PaintAstre(int longueur,int largeur){
        this.longueur=longueur;
        this.largeur=largeur;
    }

    public void paint(Graphics g){
        int centre_x=(int)(longueur/2);
        int centre_y=(int)(largeur/2);
        int rayon,x,y;
        x=y=0;
        double er;

        for(int i=0;i<listAstre.size();i++){
            g.setColor(listAstre.get(i).getCouleur());

            if(listAstre.get(i) instanceof Etoile){
                er=echelle_rayon_etoile;

                x=(int)(listAstre.get(i).getPositionRelative().getX()*echelle_dis_etoile);
                y=(int)(listAstre.get(i).getPositionRelative().getY()*echelle_dis_etoile);
                if(listAstre.get(i).getId()==1){
                    g.setColor(Color.WHITE);
                    g.drawArc(x,y,11,11,0,360);
                }
            }
            else{
                er=echelle_rayon_planete;

                if(listAstre.get(i) instanceof Planete){
                    Planete p=(Planete) listAstre.get(i);
                    x=(int)(p.getPositionRelative().getX()*echelle_dis_planete+p.getaSysteme().getSuperSys().getPositionRelative().getX()*echelle_dis_etoile);
                    y=(int)(p.getPositionRelative().getY()*echelle_dis_planete+p.getaSysteme().getSuperSys().getPositionRelative().getY()*echelle_dis_etoile);
                }
                else if(listAstre.get(i) instanceof Sateille){
                    Sateille s=(Sateille)listAstre.get(i);
                    x=(int)(s.getPositionRelative().getX()*echelle_dis_sateille+s.getaSysteme().getSuperSys().getPositionRelative().getX()*echelle_dis_planete
                            +s.getaSysteme().getSuperSys().getSuperSys().getPositionRelative().getX()*echelle_dis_etoile);
                    y=(int)(s.getPositionRelative().getY()*echelle_dis_sateille+s.getaSysteme().getSuperSys().getPositionRelative().getY()*echelle_dis_planete
                            +s.getaSysteme().getSuperSys().getSuperSys().getPositionRelative().getY()*echelle_dis_etoile);
                    x=100000;//eviter d'afficher sateillites
                    y=x;
                }
            }

            rayon=(int)(listAstre.get(i).getRayonReel()*er);
            if(rayon<rayon_min){
                rayon=(int)(rayon_min);
            }

            x=centre_x+x-rayon;
            y=centre_y+y-rayon;

            if(x<=longueur&&x>=0&&y<=largeur&&y>=0){
                g.fillOval(x,y,rayon*2,rayon*2);
            }
        }
    }
}
