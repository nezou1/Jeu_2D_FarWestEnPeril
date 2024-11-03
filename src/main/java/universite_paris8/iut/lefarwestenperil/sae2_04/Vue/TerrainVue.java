package universite_paris8.iut.lefarwestenperil.sae2_04.Vue;

import javafx.scene.layout.TilePane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import universite_paris8.iut.lefarwestenperil.sae2_04.Main;
import universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Terrain;

import java.net.URL;

public class TerrainVue {

    private TilePane tuile;
    private Terrain terrain;

    public TerrainVue(Terrain terrain, TilePane tuile) {
        this.terrain = terrain;
        this.tuile = tuile;
    }

    public void creerCarte() {
        tuile.getChildren().clear();

        URL urlImageSol = Main.class.getResource("sable.png");
        Image imageSol = new Image(String.valueOf(urlImageSol));

        URL urlImageSol2 = Main.class.getResource("dune.png");
        Image imageSol2 = new Image(String.valueOf(urlImageSol2));

        URL urlImageSol3 = Main.class.getResource("troue.png");
        Image imageSol3 = new Image(String.valueOf(urlImageSol3));

        URL urlImageSol4 = Main.class.getResource("cactus.png");
        Image imageSol4 = new Image(String.valueOf(urlImageSol4));

        URL urlImageSol5 = Main.class.getResource("eau.png");
        Image imageSol5 = new Image(String.valueOf(urlImageSol5));

        URL urlImageSol6 = Main.class.getResource("tente.png");
        Image imageSol6 = new Image(String.valueOf(urlImageSol6));

        URL urlImageChateau = Main.class.getResource("chateau.png");
        Image imageChateau = new Image(String.valueOf(urlImageChateau));

        URL urlImageGardienA = Main.class.getResource("Manele.png");
        Image imageGardienA = new Image(String.valueOf(urlImageGardienA));

        URL urlImageGardienB = Main.class.getResource("Yasmine.png");
        Image imageGardienB = new Image(String.valueOf(urlImageGardienB));

        URL urlImageGardienC = Main.class.getResource("Sahra.png");
        Image imageGardienC = new Image(String.valueOf(urlImageGardienC));

        URL urlImagePapa = Main.class.getResource("GrandPèreATerre.png");
        Image imagePapa = new Image(String.valueOf(urlImagePapa));

        URL urlImageBombeATerre = Main.class.getResource("BombeATerre.png");
        Image imageBombeATerre = new Image(String.valueOf(urlImageBombeATerre));

        URL urlImageArcATerre = Main.class.getResource("ArcATerre.png");
        Image imageArcATerre = new Image(String.valueOf(urlImageGardienC));



        for (int i = 0; i < terrain.getDonneeTerrain().length; i++) {
            for (int j = 0; j < terrain.getDonneeTerrain()[i].length; j++) {

                if (terrain.getDonneeTerrain()[i][j] == 0) {
                    ImageView iv1 = new ImageView(imageSol2);
                    this.tuile.getChildren().add(iv1);
                } else if (terrain.getDonneeTerrain()[i][j] == 1) {
                    ImageView iv2 = new ImageView(imageSol);
                    this.tuile.getChildren().add(iv2);
                } else if (terrain.getDonneeTerrain()[i][j] == 2) {
                    ImageView iv3 = new ImageView(imageSol3);
                    this.tuile.getChildren().add(iv3);
                } else if (terrain.getDonneeTerrain()[i][j] == 3) {
                    ImageView iv4 = new ImageView(imageSol4);
                    this.tuile.getChildren().add(iv4);
                } else if (terrain.getDonneeTerrain()[i][j] == 4) {
                    ImageView iv5 = new ImageView(imageSol5);
                    this.tuile.getChildren().add(iv5);
                } else if (terrain.getDonneeTerrain()[i][j] == 5) {
                    ImageView iv6 = new ImageView(imageSol6);
                    this.tuile.getChildren().add(iv6);
                } else if (terrain.getDonneeTerrain()[i][j] == 7) {
                    ImageView iv7 = new ImageView(imageChateau);
                    this.tuile.getChildren().add(iv7);
                } else  if (terrain.getDonneeTerrain()[i][j] == 8){
                    ImageView iv8 = new ImageView(imageGardienA);
                    this.tuile.getChildren().add(iv8);
                } else if (terrain.getDonneeTerrain()[i][j] == 9){
                    ImageView iv9 = new ImageView(imageGardienB);
                    this.tuile.getChildren().add(iv9);
                }else if (terrain.getDonneeTerrain()[i][j] == 13){
                    ImageView iv10 = new ImageView(imageGardienC);
                    this.tuile.getChildren().add(iv10);
                }else if (terrain.getDonneeTerrain()[i][j] == 10){
                    ImageView iv11 = new ImageView(imageBombeATerre);
                    this.tuile.getChildren().add(iv11);
                }else if (terrain.getDonneeTerrain()[i][j] == 11){
                    ImageView iv12 = new ImageView(imageArcATerre);
                    this.tuile.getChildren().add(iv12);
                }else if (terrain.getDonneeTerrain()[i][j] == 12){
                    ImageView iv13 = new ImageView(imagePapa);
                    this.tuile.getChildren().add(iv13);
                }

            }
        }
    }
}


