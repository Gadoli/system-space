public abstract class Systeme implements Course{
    /*attributs*/
    private String nom;
    public static final long periodeMAJ=100;//  periode de mis-a-jour en milliseconde
    public static final long periode_simulate=86400;//  en seconde, simule un jour par une periode de mis-a-jour
    public static final double G=6.67408e-11;
    protected Vecteur positionRelative;
    protected Vecteur vitesseRelative;
    protected Systeme superSys;

    /*constructeur*/
    public Systeme(String nom,Vecteur positionRelative,Vecteur vitesseRelative,Systeme superSys){
        this.nom=nom;
        this.positionRelative=positionRelative;
        this.vitesseRelative=vitesseRelative;
        this.superSys=superSys;
    }
    public Systeme(String nom,Vecteur positionRelative,Vecteur vitesseRelative){
        this(nom,positionRelative,vitesseRelative,null);
    }

    /*getter*/
    public Vecteur getPositionRelative() {return positionRelative;}
    public Vecteur getVitesseRelative() {return vitesseRelative;}
    public Systeme getSuperSys() { return superSys; }

    /*setter*/
    public void setPositionRelative(Vecteur positionRelative) {this.positionRelative = positionRelative;}
    public void setVitesseRelative(Vecteur vitesseRelative) {this.vitesseRelative = vitesseRelative;}
    public void setSuperSys(Systeme superSys) { this.superSys = superSys; }

    /*methode*/
    public abstract void systemeMAJ();//la methode finale pour mettre a jour pour le systeme

    //public abtract void marcheSystem(); // 26/04/2018 // non ajouté car non traité dans les classes filles pour l'instant
}

/**
 * Le système Galaxy est considéré comme le plus grand univers où l'on joue la simulation.
 * Le système Galaxy peut comprendre des systèmes planétaires, par exemple s1 et s2,
 * mais pour être efficace et réduire le temps inutile dans la réalite, les planètes dans différents système, par exemple, p1 dans s1 et p2 dans s2,
 * on ne calcul pas l'influence entre les deux, car c'est très petit dans pratiquiment tous les cas.
 *
 *
 * Dans le systeme terrestre, la vitesse relative et la position relative de satelitte sont par rapport a ce systeme, c-a-d, sa planete;
 *  et celles des planetes (dans ce systeme) sont par rapport a son super systeme, c-a-d, systeme planetaire.
 *  La position relative de ce systeme est donc celle référencé à la planete.
 *
 * Meme theorie pour Planete et Etoile.
 *
 * Dans le systeme planete, comme ci-dessus, la vitesse relative et la position relative de Planete sont par rapport a ce systeme, c-a-d, son etoile;
 *  et celles d'(es) Etoile(s) (dans ce systeme) sont par rapport a son super systeme, c-a-d, systeme galaxy.
 *  La position relative de ce systeme est donc celle référencé à l' etoile/etoile virtuel.
 *
 * Dans le systeme galaxy, comme ci-dessus, la vitesse relative et la position relative de Etoile sont par rapport a ce systeme, c-a-d, son coeur;
 *  La position relative de ce systeme est toujours nulle.
 * */
