public class PlaneteTellurique extends Planete {

    public PlaneteTellurique(String nom) {
        super(nom);
    }

    @Override
    public boolean hasAnneaux() {
        return false;
    }
}
