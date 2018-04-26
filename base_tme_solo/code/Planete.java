public abstract class Planete {
    private int rang;
    private String nom;
    private static int cpt = 1;

    public Planete(String nom) {
        this.rang = cpt++;
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public int getRang() {
        return rang;
    }

    public abstract boolean hasAnneaux();

    public String toString() {
        return String.format("%s[anneaux=%b, rang=%d]", nom, hasAnneaux(), rang);
    }
}
