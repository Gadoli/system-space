public class SystemeSolaire {
    private static final int MAX_PLANETES = 15;
    private Orbite[] orbites = new Orbite[MAX_PLANETES];
    private int ite = 0;
    private Etoile etoile;

    public SystemeSolaire(Etoile etoile) {
        this.etoile = etoile;
    }

    public void addPlanete(Planete planete) {
        orbites[planete.getRang() - 1] = new Orbite(planete);
    }

    public void step() {
        ite++;
        for (Orbite orbite: orbites)
            if (orbite != null)
                orbite.step();
    }

    public int getNbSteps() {
        return ite;
    }

    public String findMinDistance(int i, int j, int nbSteps, double alpha) {
        String out = String.format("Recherche de proximité entre %s et %s. État initial du système :\n\n%s" +
                "\n\nItérations intéressantes :\n\n",
                orbites[i].getPlanete(), orbites[j].getPlanete(), this);

        for (int k = 0; k < nbSteps; k++) {
            step();
            double angle = orbites[i].getDistanceAngulaire(orbites[j]);
            if (angle < alpha)
                out += String.format("Itération %d : angle de %.1f degrés\n", getNbSteps(), angle);
        }

        return out;
    }

    public String toString() {
        String str = String.format("Iteration %d  --  %s\n", getNbSteps(), etoile);

        for (Orbite orbite: orbites) {
            if (orbite != null)
            str += orbite + "\n";
        }

        return str;
    }
}
