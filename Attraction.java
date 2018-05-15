public interface Attraction {
    public static double G=6.67408e-11;

    public Vecteur calculeForce_p1();//precision basique: on ne considere que l'influence par le coeur du super-systeme
}

/**
 * Systeme Galaxy
 * |--  le coeur de galaxy              +++
 * |--  les Systemes Planetaires
 *      |-- le/les etoile(s)            ++
 *      |-- les Systemes Terrestres
 *          |-- le planate              +
 *          |-- le/les sateille(s)
 */

