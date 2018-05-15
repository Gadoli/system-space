import static java.lang.Math.sqrt;

public class Vecteur {
    private double x;
    private double y;
    private double z;

    public Vecteur(double x,double y,double z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    public static double distanceEntre(Vecteur p1, Vecteur p2){
        return sqrt((p1.x+p2.x)*(p1.x+p2.x)+(p1.y+p2.y)*(p1.y+p2.y)+(p1.z+p2.z)*(p1.z+p2.z));
    }//  7/05/2018

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

    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }

    public void setX(double x) {
        this.x = x;
    }
    public void setY(double y) {
        this.y = y;
    }
    public void setZ(double z) {
        this.z = z;
    }

    public static Vecteur decomposeForce(double force, Vecteur direction){
        double t12=direction.getY()/direction.getX();
        double t13=direction.getZ()*direction.getX();
        double x=force/sqrt(1+t12*t12+t13*t13);
        double y=t13*x;
        double z=t13*x;
        return new Vecteur(x,y,z);
    }
    /**
     * t11=|a|/|a|, t12=|b|/|a|, t3=|c|/|a|
     * (t11^2 + t12^2 + t13^2)*|a|^2=|a+b+c|^2  =>  |a|=|a+b+c|/sqrt(t11^2 + t12^2 + t13^2)
     */

    public Vecteur clone(){
        return new Vecteur(x,y,z);
    }
}
