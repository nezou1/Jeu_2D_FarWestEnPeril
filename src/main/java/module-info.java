module universite_paris8.iut.lefarwestenperil.sae2_04 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires javafx.swing;

    opens universite_paris8.iut.lefarwestenperil.sae2_04 to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Controleur;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Controleur to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Etats;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Etats to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Utilitaires to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs to javafx.fxml;
}