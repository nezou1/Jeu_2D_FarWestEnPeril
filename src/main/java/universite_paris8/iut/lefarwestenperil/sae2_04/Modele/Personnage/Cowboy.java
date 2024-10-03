package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes.Lasso;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

public class Cowboy extends Ennemi {

    public Cowboy(Terrain terrain, Environnement env) {
        super(200, 200, 3, 3,3, terrain, 1, 100,false, 40, env, 20, 19, 25);
        Lasso lasso = new Lasso(env);
        super.ramasserArme(lasso);
        setArmeActuelle(lasso);
    }
}