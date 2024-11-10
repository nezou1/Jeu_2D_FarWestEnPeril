package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Projectiles.Projectile;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Gardien;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;

import java.util.*;

/**
 * La classe Environnement représente le contexte global du jeu, incluant les ennemis, leur barre de vie et le terrain.
 */
public class Environnement {
//    private final ObservableList<Ennemi> ennemis = FXCollections.observableArrayList();
    private static GestionEnnemi gestionEnnemi;
    private static GestionProjectile gestionProjectile;
    private final ObservableList<BarreDeVie> barreDeVies = FXCollections.observableArrayList();
    private final ObservableList<Gardien> gardiens = FXCollections.observableArrayList();
    private static Link link;

    private static Terrain terrain;
    private int tours;


    public Environnement(Terrain terrain, Link link) {
//        gestionEnnemi = new GestionEnnemi(this);
        gestionProjectile = new GestionProjectile();
        Environnement.terrain = terrain;
        Environnement.link = link;
        this.tours = 0;
    }

    public static Terrain getTerrain(){
        return terrain;
    }

    public int getHauteur(){
        return terrain.getHauteur();
    }
    public int getLargeur(){
        return terrain.getLargeur();
    }

//    public static ObservableList<Ennemi> getEnnemis() {
//        return gestionEnnemi.getEnnemis();
//    }
    public static void ajouterEnnemisAleatoirement(int nbEnnemi){
        gestionEnnemi.ajouterEnnemisAleatoirement(nbEnnemi);
    }

    public static ObservableList<Projectile> getProjectiles(){
        return gestionProjectile.getProjectiles();
    }
    public static void ajouterProjectile(Projectile projectile){
        gestionProjectile.ajouterProjectile(projectile);
    }

    public ObservableList<Gardien> getGardiens() {
        return gardiens;
    }
    public void ajouterGardien(Gardien gardien) {
        gardiens.add(gardien);
    }
//    public List<Ennemi> getEnnemisDansRayon(int x, int y, int rayon) {
//        return gestionEnnemi.getEnnemisDansRayon(x,y,rayon);
//    }

    public ObservableList<BarreDeVie> getBarreDeVies() {
        return barreDeVies;
    }
    public void ajouterBarreDeVie(BarreDeVie b) {
        barreDeVies.add(b);
    }

    public int getTours() {
        return tours;
    }

    public static Link getLink() {
        return link;
    }



    public void unTour() {
//        gestionEnnemi.deplacerEnnemis(link);
        gestionEnnemi.miseAjour();
        gestionProjectile.mettreAJourProjectiles();

        if (link.isBrule()) {
            link.brulure();
        }
        this.tours++;
    }

    public static boolean estMarchable(int x, int y) {
        return terrain.estMarchable(x,y);
    }


    public void ajouterQuestionGardien(){
        List<String> choix = new ArrayList<>();
        choix.add("Oui");
        choix.add("Non");
        ajouterGardien(new Gardien(2944, 544, "Lexpression «Creuse où tu te tiens » signifie-t-elle qu'on peut trouver des opportunités ou des solutions autour de soi sans chercher ailleurs ?", choix, "Oui", "Bien joué ! Récupère ton marteau qui te permet de casser des cactus pour sauver ton papa qui est coincé dedans(en changeant d'arme).", 0, this));
        ajouterGardien(new Gardien(2144, 832, "L'expression indienne « Comme les rats quittent un navire qui coule » est-elle utilisée pour décrire les gens qui abandonnent une situation difficile ou désespérée ?", choix, "Oui", "Bonne réponse! Tu as 1 cœur de vie en plus !", 1, this));
        ajouterGardien(new Gardien(1600, 1000, "Est-ce que l'expression indienne « Un chameau ne passe pas par le chas d'une aiguille » signifie qu'il est possible pour une personne arrogante de se montrer humble ?", choix, "Non", "Bonne réponse! Tu as 1 cœur de vie en plus !",1, this));
    }

    public Gardien verifierRencontreLinkGardien() {
        for (Gardien gardien : gardiens) {
            if (link.getX()/32 == gardien.getX()/32 && link.getY()/32 == gardien.getY()/32) {
                return gardien;
            }
        }
        return null;
    }

    public void ajouterBrulure() {
        link.setBrule();
    }


    public boolean verifierVictoire() {
            int x = link.getX()/32;
            int y = link.getY()/32;
            return getTerrain().getTab()[y][x] == 12 ;
        }
}

