public class TestPartie3 {
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

        SystemeSolaire sys = new SystemeSolaire(sol);
        sys.addPlanete(me);
        sys.addPlanete(ve);
        sys.addPlanete(te);
        sys.addPlanete(ma);
        sys.addPlanete(ju);
        sys.addPlanete(sa);
        sys.addPlanete(ur);
        sys.addPlanete(ne);

        for (int i = 0; i < 50; i++) {
            System.out.println(sys);
            sys.step();
            try { Thread.sleep(250); } catch(Exception e){}
        }
    }
}
