public class Orbite {
    private Planete planete;
    private boolean[] position;

    public Orbite(Planete planete) {
        this.planete = planete;
        position = new boolean[planete.getRang() * 7];
        position[(int) (Math.random() * position.length)] = true;
    }

    public double getVitesse() {
        return 2.8d / Math.sqrt(planete.getRang());
    }

    private int getPositionInd() {
        for (int i = 0; i < position.length; i++) {
            if (position[i])
                return i;
        }
        return 0;
    }

    public void step() {
        int step = (int) Math.round(getVitesse());
        int pos = getPositionInd();
        position[pos] = false;
        pos = Math.floorMod(pos + step, position.length);
        position[pos] = true;
    }

    public Planete getPlanete() {
        return planete;
    }

    public double getPositionAngulaire() {
        return 360.0d * getPositionInd() / position.length;
    }

    public double getDistanceAngulaire(Orbite o) {

        double diff = Math.abs(getPositionAngulaire() - o.getPositionAngulaire());
        if (diff > 180)
            diff = 360 - diff;
        return diff;
    }


    @Override
    public String toString() {
        String out = "";
        for (boolean aPosition : position) {
            if (!aPosition)
                out += ".";
            else if (planete.hasAnneaux())
                out += "O";
            else
                out += "o";
        }

        out += String.format(" (planete: %s v=%.2f)", planete.toString(), getVitesse());
        return out;
    }
}
