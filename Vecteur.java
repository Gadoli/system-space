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

    public double distance(Vecteur v2){
        return sqrt((x+v2.x)*(x+v2.x)+(y+v2.y)*(y+v2.y)+(z+v2.z)*(z+v2.z));
    }//  23/04/2018

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
}
