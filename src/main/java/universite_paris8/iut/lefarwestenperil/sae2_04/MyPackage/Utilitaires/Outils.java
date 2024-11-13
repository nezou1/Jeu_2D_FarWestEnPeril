package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires;

public class Outils {

    /** retoune la {@code distance} entre un point de {@code départ} ({@code x} et {@code y}) et un point d'{@code arrivée} ({@code cibleX} et {@code cibleY})
     * {@return  double}
     */
    public static double distanceEntre(int x, int y, double cibleX, double cibleY){
        return Math.sqrt(Math.pow(cibleX - x, 2) + Math.pow(cibleY - y, 2));
    }
}
