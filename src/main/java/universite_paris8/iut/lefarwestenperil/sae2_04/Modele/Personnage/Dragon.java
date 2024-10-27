package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.GestionArme;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Feu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;
//La classe Dragon est un type d'ennemi qui hérite de Ennemi.
//Elle initialise ses caractéristiques via son constructeur et lui attribue une arme de feu.

public class Dragon extends Ennemi {

    public Dragon(Terrain terrain, Environnement env) {
        super(200, 200, 10, 5, 5, terrain, 5, 150, true, 50, env, 30, 21, 18);
        Feu feu = new Feu(env);
        getGestionArme().setArme(feu);
    }
}
