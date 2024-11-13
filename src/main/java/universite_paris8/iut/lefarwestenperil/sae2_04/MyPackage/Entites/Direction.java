package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites;

/**
 * <p>
 *     Enumerateur Direction:
 * </p>
 * <p>
 * Cette énumérateur s'occupe de la gestion des directions
 * </p>
 * Il y a 8 directions:
 * <ul>
 *     <li>{@code HAUT}</li>
 *     <li>{@code BAS}</li>
 *     <li>{@code GAUCHE}</li>
 *     <li>{@code DROIT}</li>
 *     <li>{@code HAUT_GAUCHE}</li>
 *     <li>{@code HAUT_DROIT}</li>
 *     <li>{@code BAS_GAUCHE}</li>
 *     <li>{@code BAS_DROIT}</li>
 * </ul>
 */
public enum Direction {
    NULL(0,0),
    HAUT(0,-1), BAS(0,1), GAUCHE(-1,0), DROIT(1,0),

    HAUT_GAUCHE(-1,-1), HAUT_DROIT(1,-1), BAS_GAUCHE(-1,1), BAS_DROIT(1,1);

    private final int dx;
    private final int dy;

    Direction(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public int getDx() {
        return dx;
    }
    public int getDy() {
        return dy;
    }

}
