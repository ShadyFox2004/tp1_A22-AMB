package tp1;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.io.*;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Vue pour le Tp1 sur les équations
 *
 * @author Martin Simoneau
 *         version avec les équations
 */
public class VueForme {

    private final static Border BORDER = new Border(
            new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, new CornerRadii(23), BorderWidths.DEFAULT, null));
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
    private static final String TOP_IMAGE_PATH = "images fournies/image pour le dessus";

    public static final Button genere = new Button("Générer");
    public static final Button reinitialiser = new Button("Réinitialiser");
    public static final Button quitter = new Button("Quitter");
    public static final Button boutonAjouterGraph = new Button("Ajoutez un graphique");
    public static final Button boutonEffacerGraph = new Button("Effacer les graphiques");

    public static final TilePane center = new TilePane();
//    public static LineChart<Number,Number> lineChart = null;

    public List<Double> xList = null;
    public List<Double> yList = null;

    public Scene getScene() throws IOException {
        BorderPane root = new BorderPane();
        Pane top = doMakeTop();
        Pane left = doMakeLeft();
        Pane right = doMakeRight();
        Pane bottom = doMakeBottom();
        Pane center = this.center;

        root.setLeft(left);
        root.setTop(top);
        root.setRight(right);
        root.setBottom(bottom);
        root.setCenter(center);

        Scene scene = new Scene(root, LARGEUR_SCENE, HATEUR_SCENE);
        return scene;
    }

    private ImageView loadImage(String url, int largeur, int hauteur) throws FileNotFoundException {
        return new ImageView(new Image(new FileInputStream(url), largeur, hauteur, false, true));
    }

    /**
     * The main view is splited up into panes to avoid clogging the primary scene
     * method.
     * This method locates the images making the top pane and loads them into a
     * Pane.
     *
     * @return the top pane
     */
    private Pane doMakeTop() {
        Pane top = new HBox(ESPACE_ENTRE_IMAGE_HAUT);
        top.setMinWidth(10); // Francois Marchand
        top.setMaxWidth(4000);

        Pattern imageExtensionPattern = Pattern.compile(".(jpeg|jpg|png)$");
        // Filter images only

        File directory = new File(TOP_IMAGE_PATH);

        assert directory != null;

        Stream<File> images = Stream
                .of(directory.listFiles(file -> imageExtensionPattern.matcher(file.getName()).find()));

        assert images != null; // is everything really ok?

        images.forEach(image -> { // If it is alright, we proceed!
            try {
                top.getChildren().add(loadImage(image.getCanonicalPath(), TOP_IMAGE_LARGEUR, TOP_IMAGE_HAUTEUR));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        return top;
    }

    /**
     * The main view is splited up into panes to avoid clogging the primary scene
     * method.
     * This method locates creates the left pane.
     *
     * @return the top pane
     */
    private Pane doMakeLeft() throws FileNotFoundException {
        GridPane gridPane = new GridPane();

        gridPane.setMaxSize(100, 250);

        ImageView image1 = loadImage("images fournies/mage pour le côté gauche/science1.png", 50, 50);
        GridPane.setConstraints(image1, 0, 0, 1, 1);

        ImageView image2 = loadImage("images fournies/mage pour le côté gauche/science2.png", 50, 50);
        GridPane.setConstraints(image2, 0, 1, 1, 1);

        ImageView image3 = loadImage("images fournies/mage pour le côté gauche/science3.png", 50, 100);
        GridPane.setConstraints(image3, 1, 0, 1, 2);

        ImageView image4 = loadImage("images fournies/mage pour le côté gauche/science5.png", 100, 50);
        GridPane.setConstraints(image4, 0, 2, 2, 1);

        ImageView image5 = loadImage("images fournies/mage pour le côté gauche/science4.png", 100, 100);
        GridPane.setConstraints(image5, 0, 3, 2, 2);

        gridPane.getChildren().addAll(image1, image2, image3, image4, image5);

        return gridPane;
    }

    /**
     * The main view is splited up into panes to avoid clogging the primary scene
     * method.
     * This method locates creates the right VBox.
     *
     * @return the right VBox
     */
    private VBox doMakeRight() {
        TextFieldLabel x[] = new TextFieldLabel[NUMBER_OF_DATA];
        TextFieldLabel y[] = new TextFieldLabel[NUMBER_OF_DATA];

        Label auteurs = new Label("Auteurs");
        TextArea nomAuteurs1 = new TextArea("Antoine-Matis Boudreau" + "\n" + "Francois Marchand");

        VBox right = new VBox(20);
        right.setAlignment(Pos.CENTER);

        right.getChildren().addAll(auteurs,nomAuteurs1);

        nomAuteurs1.setPrefSize(100,70);
        nomAuteurs1.setEditable(false);
        right.setBorder(new Border(
                new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null, new BorderWidths(1,20,1,20), null)));

        GridPane gridPane = new GridPane();

        gridPane.setHgap(EXPACEMENT_ENTRE_X_Y);
        gridPane.setBorder(BORDER);

        right.setBackground(Background.fill(Color.DARKGRAY));
        right.getChildren().add(gridPane);



        for (int i = 0; i < NUMBER_OF_DATA; i++) {
            x[i] = new TextFieldLabel("x" + i + "  ");
            GridPane.setConstraints(x[i], 0, i);
            x[i].setPadding(new Insets(0, 5, 5, 5));
            x[i].getTextField().setPrefWidth(35);


            y[i] = new TextFieldLabel("y" + i + "  ");
            GridPane.setConstraints(y[i], 1, i);
            y[i].setPadding(new Insets(0, 5, 5, 5));
            y[i].getTextField().setPrefWidth(35);


            gridPane.getChildren().addAll(x[i],y[i]);
        }

        GridPane.setHalignment(boutonAjouterGraph, HPos.CENTER);
        GridPane.setHalignment(boutonEffacerGraph, HPos.CENTER);

        gridPane.add(boutonAjouterGraph, 0, NUMBER_OF_DATA, 2,1);
        gridPane.add(boutonEffacerGraph, 0, NUMBER_OF_DATA+1, 2,1);
        
        gridPane.setPadding(new Insets(20, 10, 20, 20));

//        Grapher.Parameters parameters = new Grapher.Parameters(xList,yList,"1");
//
//        lineChart = Grapher.createGraph(parameters);

        return right;
    }

    /**
     * The main view is splited up into panes to avoid clogging the primary scene
     * method.
     * This method locates creates the Bottom HBox.
     *
     * @return the bottom HBox
     */
    private HBox doMakeBottom() {
        HBox bottom = new HBox();

        setWidth(genere,125,125,500);

        setWidth(reinitialiser,125,125,500);

        setWidth(quitter,65,65,400);

        bottom.getChildren().addAll(genere,reinitialiser,quitter);

        HBox.setHgrow(genere, Priority.ALWAYS);
        HBox.setHgrow(reinitialiser, Priority.ALWAYS);
        HBox.setHgrow(quitter, Priority.SOMETIMES);

        bottom.setAlignment(Pos.BOTTOM_CENTER);
        bottom.setSpacing(ESPACE_ENTRE_BOUTONS_BAS);

        Border bottomBorder = new Border(
                new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, null, BorderWidths.DEFAULT, null));

        bottom.setBorder(bottomBorder);

        return bottom;
    }

    public void setWidth(Button boutton,double pref,double min, double max){
        boutton.setPrefWidth(pref);
        boutton.setMinWidth(min);
        boutton.setMaxWidth(max);
    }
}
