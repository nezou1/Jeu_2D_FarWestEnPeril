package universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.PNJs.Gardien2;
import universite_paris8.iut.lefarwestenperil.sae2_04.MyPackage.Entites.EtreVivants.Link2;


import java.util.ArrayList;
import java.util.List;

public class GestionGardien {
    private final ObservableList<Gardien2> gardiens;

    public GestionGardien() {
        this.gardiens= FXCollections.observableArrayList();
    }
    public ObservableList<Gardien2> getGardiens() {
        return gardiens;
    }
    public void ajouterGardien(Gardien2 gardien) {
        gardiens.add(gardien);
    }

    public void ajouterQuestionGardien(){
        List<String> choix = new ArrayList<>();
        choix.add("Oui");
        choix.add("Non");
        ajouterGardien(new Gardien2(2944, 544, "Lexpression «Creuse où tu te tiens » signifie-t-elle qu'on peut trouver des opportunités ou des solutions autour de soi sans chercher ailleurs ?", choix, "Oui", "Bien joué ! Récupère ton marteau qui te permet de casser des cactus pour sauver ton papa qui est coincé dedans(en changeant d'arme).", 0, null));
        ajouterGardien(new Gardien2(2144, 832, "L'expression indienne « Comme les rats quittent un navire qui coule » est-elle utilisée pour décrire les gens qui abandonnent une situation difficile ou désespérée ?", choix, "Oui", "Bonne réponse! Tu as 1 cœur de vie en plus !", 1, null));
        ajouterGardien(new Gardien2(1600, 1000, "Est-ce que l'expression indienne « Un chameau ne passe pas par le chas d'une aiguille » signifie qu'il est possible pour une personne arrogante de se montrer humble ?", choix, "Non", "Bonne réponse! Tu as 1 cœur de vie en plus !",1, null));
    }
    public Gardien2 verifierRencontreLinkGardien() {
        Link2 link = Environnement2.getLink2();
        for (Gardien2 gardien : gardiens) {
            if (link.getX()/32 == gardien.getX()/32 && link.getY()/32 == gardien.getY()/32) {
                return gardien;
            }
        }
        return null;
    }
}
