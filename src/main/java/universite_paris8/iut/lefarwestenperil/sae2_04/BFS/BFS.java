package universite_paris8.iut.lefarwestenperil.sae2_04.BFS;

import java.awt.Point;
import java.util.*;

public class BFS {

    private static int[][] moves = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}}; // Définition des mouvements possibles (haut, bas, gauche, droite)

    //Recherche le chemin le plus court entre deux points dans une grille en utilisant l'algorithme BFS.
    public static List<Point> bfs(int[][] terrain, Point depart, Point arrivee) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(depart);

        // HashMap pour stocker les parents de chaque tuile
        Map<Point, Point> parents = new HashMap<>();
        parents.put(depart, null);

        boolean found = false;

        while (!queue.isEmpty() && !found) {
            Point tuileCourante = queue.poll();

            int x = tuileCourante.x;
            int y = tuileCourante.y;

            for (int[] move : moves) {
                int newX = x + move[0];
                int newY = y + move[1];
                // Vérifier si le déplacement est valide et si la tuile n'a pas déjà été visitée
                if (isValidMove(terrain, newX, newY) && !parents.containsKey(new Point(newX, newY))) {
                    Point newTuile = new Point(newX, newY);
                    queue.add(newTuile);
                    parents.put(newTuile, tuileCourante);
                    // Vérifier si la tuile actuelle est l'arrivée
                    if (newTuile.equals(arrivee)) {
                        found = true;
                        break;
                    }
                }
            }
        }
        // Reconstituer le chemin à partir des parents
        List<Point> chemin = new ArrayList<>();
        Point tuile = arrivee;
        while (tuile != null) {
            chemin.add(0, tuile);
            tuile = parents.get(tuile);
        }

        // Remove the last tile if the path length is greater than 1
        if (chemin.size() > 1) {
            chemin.remove(chemin.size() - 1);
        }

        return chemin;
    }

    private static boolean isValidMove(int[][] terrain, int x, int y) {
        int ligne = terrain.length;
        int colonne = terrain[0].length;
        return x >= 0 && x < ligne && y >= 0 && y < colonne && (terrain[x][y] == 0);
    }
}