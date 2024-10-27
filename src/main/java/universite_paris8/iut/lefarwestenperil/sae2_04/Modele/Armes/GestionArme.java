package universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Armes;

import java.util.ArrayList;

public class GestionArme {

    private ArrayList<Arme> armes;
    private int indexArmeActuelle;
    private Arme arme;
    public GestionArme() {
        armes = new ArrayList<>();
        indexArmeActuelle = 0;
    }

    public void ajouterArme(Arme arme) {
        this.armes.add(arme);
        if (this.armes.size() == 1) {
            this.arme = arme;
        }
    }

    private void changerArmeActuel(int n) {
        if (!armes.isEmpty()) {
            indexArmeActuelle = (indexArmeActuelle + n + armes.size()) % armes.size();
            arme = armes.get(indexArmeActuelle);
        }
    }
    private void afficherInformations(String direction) {
        System.out.println("Armes: " + armes);
        System.out.println("Arme actuelle après changement " + direction + ": " + arme);
    }
    public void changerArmeSuivante() {
        changerArmeActuel(1);
        afficherInformations("suivant");
    }

    public void changerArmePrecedente() {
        changerArmeActuel(-1);
        afficherInformations("précédent");
    }

    public Arme getArme() {
        return arme;
    }

    public void setArme(Arme arme) {
        this.arme = arme;
    }
}
