/**
 * Created by thomas on 11/11/16.
 */
public class TestPartie2 {
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

        Orbite oTe = new Orbite(te);
        Orbite oJu = new Orbite(ju);

        for (int i = 0; i < 20; i++) {
            System.out.println(oTe);
            oTe.step();
        }

        for (int i = 0; i < 20; i++) {
            System.out.println(oJu);
            oJu.step();
        }
    }
}
