import static java.lang.Math.sqrt;

public class Vecteur {
    /*attribut*/
    private double x;
    private double y;
    private double z;

    /*cosntructeur*/
    public Vecteur(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    /*getter*/
    public double getX() { return x; }
    public double getY() { return y; }
    public double getZ() { return z; }

    /*setter*/
    public void setX(double x) { this.x = x;}
    public void setY(double y) { this.y = y;}
    public void setZ(double z) { this.z = z;}

    public static double distanceEntre(Vecteur p1, Vecteur p2){
        return sqrt((p1.x+p2.x)*(p1.x+p2.x)+(p1.y+p2.y)*(p1.y+p2.y)+(p1.z+p2.z)*(p1.z+p2.z));
    }
    /*methode*/
    public double norme(){
        return sqrt(x*x + y*y + z*z);
    }

    public Vecteur add(Vecteur v2){
        return new Vecteur(x+v2.x,y+v2.y,z+v2.z);
    }

    public Vecteur sub(Vecteur v2){
        return new Vecteur(x-v2.x,y-v2.y,z-v2.z);
    }

    public Vecteur mulScalaire(double t){
        return new Vecteur(t*x,t*y,t*z);
    }

    public double distanceX(Vecteur v2){
        return x-v2.x;
    }//  23/04/2018
    public double distanceY(Vecteur v2){
        return y-v2.y;
    }//  23/04/2018
    public double distanceZ(Vecteur v2){
        return z-v2.z;
    }//  23/04/2018

    public static Vecteur decomposeForce(double force, Vecteur direction){

        double s=sqrt(direction.getX()*direction.getX()+direction.getY()*direction.getY()+direction.getZ()*direction.getZ());
        if(s<=1e-30){
            return new Vecteur(0,0,0);
        }
        else return new Vecteur(direction.getX()/s*force,direction.getY()/s*force,direction.getZ()/s*force);
    }

    @Override
    public String toString() {
        return "("+x+", "+y+", "+z+")";
    }


    public Vecteur clone(){
        return new Vecteur(x,y,z);
    }
}
