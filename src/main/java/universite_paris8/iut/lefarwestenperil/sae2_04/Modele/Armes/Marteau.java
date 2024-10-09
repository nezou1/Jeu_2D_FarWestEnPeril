package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Ennemi;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Environnement;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Link;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Personnage.Personnage;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.util.List;

public class Marteau extends Arme {
    private Environnement env;
    public Marteau(int pointAttaque, int rayon, Environnement env) {
        super(pointAttaque, rayon);
        this.env = env;
    }
/*
    @Override
    public void attaquer(Personnage att, List<Ennemi> cibles) {
        Link link = env.getLink();
        casserCactus(env.getLink().getTerrain(), link);
    }


    public void casserCactus(Terrain terrain, Link link) {
        int x = (link.getX()+11) / 32;
        int y = (link.getY()+13) / 32;

        switch (link.getDirection()) {
            case 0:
                x++;
                break;
            case 1:
                y++;
                break;
            case 2:
                x--;
                break;
            case 3:
                y--;
                break;
        }

        if (terrain.getTab()[y][x] == 3) {
            terrain.getTab()[y][x] = 0;
        }
    }

 */

    @Override
    public void attaquer(Personnage att) {
        System.out.println("ça doit faire un truc askip");
    }

    public String toString() {
        return "Marteau : " + super.toString();
    }
}
