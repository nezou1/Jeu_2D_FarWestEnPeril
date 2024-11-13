package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats;

import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage.EtreVivant;

public abstract class Etat {

    private boolean active;
    private int duree;

    public Etat(int duree) {
        this.duree = duree;
        this.active = true;
    }

    public boolean isActive() {
        return active;
    }
    public void deactivate() {
        this.active = false;
    }

    public int getDuree() {
        return duree;
    }
    public boolean isFinish(){
        return duree == 0;
    }
    public void decreaseDuree() {
        int val = duree > 0 ? 1 : 0;
        this.duree-=val;
    }

    public abstract void apply(EtreVivant etreVivant);
}
