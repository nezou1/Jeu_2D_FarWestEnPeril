package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.StrategieAttaque;

import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage.EtreVivant;

import java.util.ArrayList;

public class Arsenal implements StrategieAttaque {

    private StrategieAttaque armeActuelle;
    private final ArrayList<StrategieAttaque> armes;

    public Arsenal() {
        armes = new ArrayList<>();
    }

    public ArrayList<StrategieAttaque> getArmes() {
        return armes;
    }
    public StrategieAttaque getArmeActuelle() {
        return armeActuelle;
    }
    public void setArmeActuelle(StrategieAttaque arme) {
        for (StrategieAttaque ar : armes){
            if (ar.getClass().equals(arme.getClass())){
                armeActuelle = ar;
                break;
            }
        }
    }

    public void ajouterArme(StrategieAttaque arme) {
        armes.add(arme);
        if (armeActuelle == null)
            armeActuelle = arme;
    }

    public void armeSuivante(){
        changerArmeActuel(1);
        afficherInformations("suivante");
    }
    public void armePrecedente() {
        changerArmeActuel(-1);
        afficherInformations("précédente");
    }

    private int indexArmeActuelle(){
        return armes.indexOf(armeActuelle);
    }

    private void changerArmeActuel(int n) {
        if (!armes.isEmpty()) {
            int newIndex = (indexArmeActuelle() + n + armes.size()) % armes.size();
            armeActuelle = armes.get(newIndex);
        }
    }

    private void afficherInformations(String direction) {
        System.out.println("Armes: " + armes);
        System.out.println("Arme actuelle après changement " + direction + ": " + armeActuelle);
    }

    @Override
    public void attaquer(EtreVivant proprietaite) {
        armeActuelle.attaquer(proprietaite);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Arsenal : ");
        for (StrategieAttaque arme : armes) {
            if (arme != armeActuelle)
                str.append(arme.toString()).append("\n");
        }
        str.append("ArmeActuelle : ").append(armeActuelle.toString()).append("\n");
        return str.toString();
    }
}
