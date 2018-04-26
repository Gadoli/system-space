public class Etoile {
    private String nom;
    private int temperature, masse;

    public Etoile(String nom, int temperature, int masse) {
        this.nom = nom;
        this.temperature = temperature;
        this.masse = masse;
    }

    public String getNom() {
        return nom;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getMasse() {
        return masse;
    }

    public String toString() {
        return String.format("%s[T=%dK M=%dMS]", nom, temperature, masse);
    }
}
