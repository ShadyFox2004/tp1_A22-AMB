package tp1;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * Vue pour le Tp1 sur les équations
 *
 * @author Martin Simoneau
 * version avec les équations
 */
public class VueForme {

    private final static Border BORDER = new Border(
            new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, null, null));
    public static final int NUMBER_OF_DATA = 5;
    public static final int LARGEUR_SCENE = 600;
    public static final int HATEUR_SCENE = 500;
    public static final int TOP_IMAGE_HAUTEUR = 40;
    public static final int TOP_IMAGE_LARGEUR = 100;
    public static final int IMAGE_GAUCHE_TAILLE_SIMPLE = 50;
    public static final int ESPACE_ENTRE_BOUTONS_BAS = 40;
    public static final int ESPACE_VERTICAL_ENTRE_DONNEES_DU_GRAPHIQUE = 10;
    public static final int LARGEUR_MIN_ETIQUETTE_DONNEES = 20;
    public static final int LARGEUR_MIN_TEXTFIELD_DONNEES = 40;
    public static final int EXPACEMENT_ENTRE_X_Y = 10;
    public static final int ESPACE_ENTRE_IMAGE_HAUT = 5;
    public static final double LARGEUR_MIN_SECTION_HAUT = 200.0;


    public Scene getScene() throws IOException {
        BorderPane root = new BorderPane();
        Pane top = new HBox(ESPACE_ENTRE_IMAGE_HAUT);

        root.setTop(top);
        File directory = new File("images fournies/image pour le dessus");
        System.out.println("directory = " + directory.getName());
        File image[] = directory.listFiles();
        for (int i = 0; i < image.length; i++) {
            String url = image[i].getCanonicalPath();

            System.out.println("url = " + url);

            new ImageView(new Image(url, 10, 10,false,true));
        }



        Scene scene = new Scene(root, LARGEUR_SCENE, HATEUR_SCENE);
        return scene;
    }

    private ImageView loadImage(String url, int largeur, int hauteur) {
        return new ImageView(new Image(url, largeur, hauteur,false,true));
    }
}
