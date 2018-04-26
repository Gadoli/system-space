public abstract class Systeme {
    private String nom;
    private double periodeMAJ;//    22/4/2018  //periode de mis-a-jour en second

    public Systeme(String nom){
        this.nom=nom;
        this.periodeMAJ=0.01;// 22/4/2018   //valeur par defaut
    }
}

/*
* Le système Galaxy est considéré comme le plus grand univers où l'on joue la simulation.
* Le système Galaxy peut comprendre des systèmes planétaires, par exemple s1 et s2,
* mais pour être efficace et réduire le temps inutile dans la réalite, les planètes dans différents système, par exemple, p1 dans s1 et p2 dans s2,
* on ne calcule pas l'influence entre les deux, car c'est très petit dans pratiquiment tous les cas.
* Par contre, on calcule à chaque fois après le mouvement de toutes les planètes, si, par exemple, p1 est plus proche du coeur de s1 ou celui de s2,
* On respecte toujours la règle où la planète est précèdé par le système le plus proche.    //  23/04/2018
* */
