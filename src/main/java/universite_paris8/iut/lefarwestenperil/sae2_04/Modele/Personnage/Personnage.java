package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;
//La classe Personnage est une classe abstraite représentant les personnages du jeux mis a part le Gardien.
//Elle gère les points de vie, d'attaque et de défense, ainsi que la position et l'inventaire d'armes.
//Elle permet également de gérer les attaques et la réception de dégâts.

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Arme;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.GestionArme;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.SeDeplace;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.util.List;

/*public abstract class Personnage extends SeDeplacer {
    //protected int tailleTuile = 32;

    private int pointVie;
    private int pointAttaque;
    private int pointDefense;
    private int pointVieMax;


    //private int vitesseDeplacement;

    private Environnement env;
    private Terrain terrain;

    private List<Arme> armes;
    private Arme armeActuelle;
    protected Arme arme;
    private int indexArmeActuelle;

    //private IntegerProperty x, y;
    //protected int direction;


    private boolean brule;
    private static int compteurBrulure;


    public Personnage(int x, int y,int vitesse,int pointVie, int pointAttaque, int pointDefense,Terrain terrain) {
        super(x, y, vitesse);
        this.pointVie = pointVie;
        this.pointVieMax = pointVie;
        this.pointAttaque = pointAttaque;
        this.pointDefense = pointDefense;
        this.armes = new ArrayList<>();
        this.armeActuelle = null;

        //this.x = new SimpleIntegerProperty(x);
        //this.y = new SimpleIntegerProperty(y);
        this.terrain = terrain;
        //this.vitesseDeplacement=4;
        //this.indexArmeActuelle = 0;
        this.brule = false;
        this.compteurBrulure = 0;

    }


    public boolean isBrule(){
        return this.brule;
    }



    public void brulure(){
        if(compteurBrulure % 10 == 0){
            this.setPointVie(getPointVie()-1);
            if (compteurBrulure==30){
                compteurBrulure = 0;
                brule= false;
            }
        }
        compteurBrulure++;
    }

    public void ajouterArme(Arme arme) {
        this.armes.add(arme);
        if (this.armes.size() == 1) {
            this.armeActuelle = arme;
        }
    }
    public Arme getArme(){return armeActuelle;}




    public int getPointVieMax() {
        return pointVieMax;
    }

    public void setPointVieMax(int pointVieMax){
        this.pointVieMax = pointVieMax;
    }

    /*public void changerArmeSuivante() {
        if (!armes.isEmpty()) {
            indexArmeActuelle = (indexArmeActuelle + 1) % armes.size();
            armeActuelle = armes.get(indexArmeActuelle);
        }
        System.out.println("Armes: " + armes);
        System.out.println("Arme actuelle après changement suivant: " + armeActuelle);
    }*/

    /*public void changerArmePrecedente() {
        if (!armes.isEmpty()) {
            indexArmeActuelle = (indexArmeActuelle - 1 + armes.size()) % armes.size();
            armeActuelle = armes.get(indexArmeActuelle);
        }
        System.out.println("Armes: " + armes);
        System.out.println("Arme actuelle après changement précédent: " + armeActuelle);
    }
   private void changerArmeActuel(int n) {
       if (!armes.isEmpty()) {
           indexArmeActuelle = (indexArmeActuelle + n + armes.size()) % armes.size();
           armeActuelle = armes.get(indexArmeActuelle);
       }
   }
    private void afficherInformations(String direction) {
        System.out.println("Armes: " + armes);
        System.out.println("Arme actuelle après changement " + direction + ": " + armeActuelle);
    }
    public void changerArmeSuivante() {
        changerArmeActuel(1);
        afficherInformations("suivant");
    }

    public void changerArmePrecedente() {
        changerArmeActuel(-1);
        afficherInformations("précédent");
    }

    public int getTailleTuile() {
        return terrain.getTailleTuile();
    }

    public int getDirection() {
        return direction;
    }

    public void attaque(List<Ennemi> cibles) {
        if (arme != null) {
            if (getArme() instanceof Bombe) {
                Bombe bombe = (Bombe) getArme();
                System.out.println("bombe");
                if (bombe.estEnCours()) {
                    System.out.println("Une bombe est déjà en cours. Veuillez attendre l'explosion.");
                    return;
                }
            }
            arme.attaquer(this, cibles);
        } else {
            System.out.println("Aucune arme pour l'attaque directionnelle.");
        }
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    public boolean estVivant() {
        return this.pointVie > 0;
    }

    public IntegerProperty vieProperty(){
        return new SimpleIntegerProperty(pointVie);
    }



    public int getPointVie() {
        return pointVie;
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public int getPointDefense() {
        return pointDefense;
    }

    public Environnement getEnv() {
        return env;
    }



    public void recevoirDegats(int pointsDegats) {
        int degatReel = pointsDegats - this.pointDefense;
        System.out.println("degat reel :" + degatReel);
        if (degatReel > 0) {
            if (this.pointVie >= degatReel)
                this.pointVie -= degatReel;
            else {
                this.pointVie = 0;
            }
        }
        System.out.println(pointVie);
    }

    public Arme getArmeActuelle() {
        if(this.armes.size() == 1) {
            this.armeActuelle = this.armes.get(armes.size()-1);
        }
        if (this.armes.size()>=2) {
            armeActuelle = this.armes.get(armes.size()-1);
        }
        return armeActuelle;
    }
    public List<Arme> getArmes() {
        return this.armes;
    }

    public void ramasserArme(Arme arme) {
        this.armes.add(arme);
        System.out.println(armes);
    }



    public void setArmeActuelle(Arme armeActuelle) {
        this.arme = armeActuelle;
    }


    @Override
    public String toString() {
        return "Personnage{" +
                "pointVie=" + pointVie +
                ", pointAttaque=" + pointAttaque +
                ", pointDefense=" + pointDefense +
                ", armes=" + armes +
                '}';
    }

    public void setBrule() {
        this.brule = true;
    }

    @Override
    public int getVitesse() {
        return super.getVitesse();
    }

    public Terrain getTerrain() {
        return terrain;
    }
}*/


public abstract class Personnage extends SeDeplace {
    private int pointVie;
    private int pointAttaque;
    private int pointDefense;
    private int pointVieMax;

    private Environnement env;
    private Terrain terrain;

    protected Arme arme;

    private GestionEtat gestionEtat;
    private GestionCombat gestionCombat;
    private GestionArme gestionArme;


    public Personnage(int x, int y, int vitesse, int pointVie, int pointAttaque, int pointDefense, Terrain terrain) {
        super(x, y, vitesse);
        this.pointVie = pointVie;
        this.pointVieMax = pointVie;
        this.pointAttaque = pointAttaque;
        this.pointDefense = pointDefense;
        this.terrain = terrain;
        this.gestionCombat=new GestionCombat(this);
        this.gestionEtat=new GestionEtat();
        this.gestionArme=new GestionArme();

    }

   /* public boolean isBrule() {
        return this.brule;
    }*/

   /* public void brulure() {
        if (compteurBrulure % 10 == 0) {
            this.setPointVie(getPointVie() - 1);
            if (compteurBrulure == 30) {
                compteurBrulure = 0;
                brule = false;
            }
        }
        compteurBrulure++;
    }*/
   public void brulure() {
       gestionEtat.brulure(this);
   }

    public int getPointVieMax() {
        return pointVieMax;
    }

    public void setPointVieMax(int pointVieMax) {
        this.pointVieMax = pointVieMax;
    }

    public int getTailleTuile() {
        return terrain.getTailleTuile();
    }

   /* public void attaque(List<Ennemi> cibles) {
        if (arme != null) {
            arme.attaquer(this, cibles);
        } else {
            System.out.println("Aucune arme pour l'attaque.");
        }
    }*/
   public void attaque(List<Ennemi> cibles) {
       gestionCombat.attaque(cibles);
   }


    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }

    public boolean estVivant() {
        return this.pointVie > 0;
    }

    public IntegerProperty vieProperty() {
        return new SimpleIntegerProperty(pointVie);
    }

    public int getPointVie() {
        return pointVie;
    }

    public int getPointAttaque() {
        return pointAttaque;
    }

    public int getPointDefense() {
        return pointDefense;
    }

    public Environnement getEnv() {
        return env;
    }

    /*public void recevoirDegats(int pointsDegats) {
        int degatReel = pointsDegats - this.pointDefense;
        if (degatReel > 0) {
            if (this.pointVie >= degatReel)
                this.pointVie -= degatReel;
            else {
                this.pointVie = 0;
            }
        }
    }*/
    public void recevoirDegats(int pointsDegats) {
        gestionCombat.recevoirDegats(pointsDegats);
    }

    /*public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }*/

    public Terrain getTerrain() {
        return terrain;
    }

    /*public void setBrule() {
        this.brule = true;
    }*/
    public void setBrule() {
        gestionEtat.setBrule();
    }

    @Override
    public String toString() {
        return "Personnage{" +
                "pointVie=" + pointVie +
                ", pointAttaque=" + pointAttaque +
                ", pointDefense=" + pointDefense +
                ", arme=" + arme +
                '}';
    }

    public GestionArme getGestionArme() {
        return gestionArme;
    }
   public GestionCombat getGestionCombat() {
        return gestionCombat;
   }
   public GestionEtat getGestionEtat() {
        return gestionEtat;
   }
}