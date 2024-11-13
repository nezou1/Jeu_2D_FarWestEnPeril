module universite_paris8.iut.lefarwestenperil.sae2_04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.swing;
    requires org.apache.logging.log4j;

    opens universite_paris8.iut.lefarwestenperil.sae2_04 to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Controleur to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.Personnage to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Etats;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Etats to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Gestionnaire;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Gestionnaire to javafx.fxml;
}