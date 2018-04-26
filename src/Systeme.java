public abstract class Systeme {
    private String nom;
    private double periodeMAJ;//    22/4/2018  //periode de mis-a-jour en second

    public Systeme(String nom){
        this.nom=nom;
        this.periodeMAJ=0.01;// 22/4/2018   //valeur par defaut
    }
}

/*
* Le systeme Galaxy est considere comme le plus grand universe où l'on joue la simulation.
* Le systeme Galaxy peut comprendre des systemes Solaires, par exemple s1 et s2,
* mais pour etre efficace et reduire le temps inutile en realite, les planetes dans differants systeme, par exemple, p1 dans s1 et p2 dans s2,
* on ne calcule pas l'influence entre les deux, car c'est tres petit dans presque tous les cas.
* Par contre, on calcule chaque fois apres le mouvement de tous les planetes, si, par exemple, p1 est plus proche a la coeur de s1 ou celui de s2,
* On toujours respecte le regle ou le planete est procede par le systeme le plus proche.    //  23/04/2018
* */
