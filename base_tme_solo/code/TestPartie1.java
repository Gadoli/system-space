/**
 * Created by thomas on 11/11/16.
 */
public class TestPartie1 {
    public static void main(String[] args) {
        Etoile sol = new Etoile("Soleil", 5777, 1);
        Planete me = new PlaneteTellurique("Mercure");
        Planete ve = new PlaneteTellurique("Venus");
        Planete te = new PlaneteTellurique("Terre");
        Planete ma = new PlaneteTellurique("Mars");
        Planete ju = new PlaneteGazeuse("Jupiter");
        Planete sa = new PlaneteGazeuse("Saturne");
        Planete ur = new PlaneteGazeuse("Uranus");
        Planete ne = new PlaneteGazeuse("Neptune");

        System.out.println(me);
        System.out.println(ve);
        System.out.println(te);
        System.out.println(ma);
        System.out.println(ju);
        System.out.println(sa);
        System.out.println(ur);
        System.out.println(ne);
        System.out.println(sol);
    }
}
