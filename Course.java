public interface Course {
    void marche(Vecteur vitesse,double temps);
    void marche();

    /**
     * l'ordre de mis-a-jour:
     * le plus haut systeme(systeme galaxy) voit la position et la vitesse de son coeur se mettre à jour(rien ne change en fait, les valeurs sont toujours 0),
     * Puis, celles de ses sous-systemes (systemes planetaires) et la force pour chaque sous-systeme eset calculé
     * D'apres le force, la position et la vitesse du coeur pour chaque sous-systeme sont mis à jour
     * Et on descend au niveau de ses sous-systemes, et considere les sous-systemes precedents comme les plus hauts systemes, réitérer le traitement.
     *
     * Au debut, on a la vitesse initiale pour certains astres ou systemes, mais on commence par calculer son astraction,
     * apres, on multiple la vitesse initiale et la periode de mis-a-jour, on obtient une distance sous la forme d'un vecteur,
     * on calcule la somme de la position actuelle et cette distence, on obtient ainsi la nouvelle position.
     * puis, on multiple la force et la periode de mis-a-jour, on obtient le changement de vitesse,
     * a la fin, on calcule la somme de la vitesse actuelle et le changement de vitesse,
     * on a donc la nouvelle vitesse par le precedent calcul.
     */
}
