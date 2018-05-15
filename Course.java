public interface Course {
    void marche(Vecteur vitesse,double temps);
    void marche();

    /**
     * l'ordre de mis-a-jour:
     * le plus haut systeme(systeme galaxy) mis-a-jour la position et la vitesse de son coeur(rien changer en fait, toujours 0),
     * Puis, changer celles de ses sous-systemes (systemes planetere) et calculer le force pour chaque sous-systeme
     * D'apres le force, mis-a-jour la position et la vitesse du coeur pour chaque sous-systeme
     * Et on descend en niveau de ses sous-systemes, et les considere comme les plus hauts systemes, repeter le traitement.
     *
     * Et au debut, on la vitesse initiale pour certain astre ou systeme, mais on commence par calculer son astraction,
     * apres, on multiple la vitesse initiale et la periode de mis-a-jour, on obtient une distance sous forme vecteur,
     * on calcule le somme de la position actuelle et cette distence, on obtient la nouvelle position.
     * puis, on multiple la force et la periode de mis-a-jour, on obtient le changement de vitesse,
     * a la fin, on calcule le somme de la vitesse actuelle et le changement de vitesse,
     * c'est la nouvelle vitesse.
     */
}
