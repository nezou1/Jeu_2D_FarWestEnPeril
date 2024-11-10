package universite_paris8.iut.lefarwestenperil.sae2_04.Modele;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Terrain {

    private int[][] tab;

    public Terrain() {
        chargerTerrain();
    }

    private void chargerTerrain() {
        List<int[]> lignes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/universite_paris8/iut/lefarwestenperil/sae2_04/terrain.txt"))) {
            String ligne;
            ligne = reader.readLine();
            while (ligne != null) {
                String[] valeurs = ligne.split(",");
                int[] ligneTab = new int[valeurs.length];
                for (int i = 0; i < valeurs.length; i++) {
                    ligneTab[i] = Integer.parseInt(valeurs[i].trim());
                }
                lignes.add(ligneTab);
                ligne = reader.readLine();
            }
            tab = lignes.toArray(new int[0][]);

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(tab.length + "  " + tab[0].length);
    }

    public int[][] getTab() {
        return this.tab;
    }

    public int getHauteur() {
        return tab.length;
    }

    public int getLargeur() {
        return tab[0].length;
    }

    public boolean estMarchable(int y, int x) {

        if (x >= 0 && x < getLargeur() && y >= 0 && y < getHauteur()) {
            return tab[y][x] == 0 || tab[y][x] == 12;
        }
        return false;
    }
    /**
     * Vérifie si les coordonnées (x, y) sont valides dans le tableau.
     * @param x la coordonnée x à vérifier
     * @param y la coordonnée y à vérifier
     * @return true si les coordonnées sont valides, sinon false
     */
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < tab[0].length && y >= 0 && y < tab.length;
    }

}
