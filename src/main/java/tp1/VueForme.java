package tp1;


import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Stream;

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
        Pane top = doMakeTop();

        root.setTop(top);

        Scene scene = new Scene(root, LARGEUR_SCENE, HATEUR_SCENE);
        return scene;
    }

    private ImageView loadImage(String url, int largeur, int hauteur) throws FileNotFoundException {
        return new ImageView(new Image(new FileInputStream(url), largeur, hauteur,false,true));
    }

    /**
     * @author Antoine-Matis Boudreau
     * The main view is splited up into panes to avoid clogging the primary scene method.
     * This method locates the images making the top pane and loads them into a Pane.
     *
     * @return the top pane
     */
    private Pane doMakeTop() {
        Pane top = new HBox(ESPACE_ENTRE_IMAGE_HAUT);

        Pattern imageExtensionPattern = Pattern.compile(".(jpeg|jpg|png)$");
        // Filter images only

        File directory = new File("images fournies/image pour le dessus");

        assert directory != null;

        Stream<File> images = Stream.of(directory.listFiles(file -> imageExtensionPattern.matcher(file.getName()).find()));

        assert images != null; //is everything really ok?

        images.forEach(image -> { // If it is alright, we proceed!
            try {
                top.getChildren().add(loadImage(image.getCanonicalPath(), TOP_IMAGE_LARGEUR, TOP_IMAGE_HAUTEUR));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return top;
    }
}
