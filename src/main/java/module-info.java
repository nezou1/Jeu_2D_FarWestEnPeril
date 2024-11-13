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
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.Personnage to javafx.fxml;
    //exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele;
    //opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Etats to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Utilitaires to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Entites.PNJs to javafx.fxml;
    exports universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire;
    opens universite_paris8.iut.lefarwestenperil.sae2_04.Modele.Gestionnaire to javafx.fxml;
}