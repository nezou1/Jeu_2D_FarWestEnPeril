package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Feu;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public class Dragon extends Ennemi {

    public Dragon(Terrain terrain, Environnement env) {
        super(200, 200, 10, 5, 5, terrain, 2, 150, true, 50, env, 30, 21, 18);
        Feu feu = new Feu(env);
        super.ramasserArme(feu);
        setArmeActuelle(feu);
    }
}
