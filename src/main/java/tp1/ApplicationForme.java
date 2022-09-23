package tp1;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * @author Antoine-Matis Boudreau
 * @author Francois Marchand
 *
 * Contrôleur pour le Tp1
 *
 */
public class ApplicationForme extends Application {
	VueForme vue;
	@Override
	public void start(Stage stage) throws Exception {
		// Instancier la vue
		vue = new VueForme();

		stage.setTitle("TP1 Graphiques A22");

		// Joindre la vue au stage
		Scene scene = vue.getScene();
		stage.setScene(scene);

		// Mettre le stage au size de la scene
		stage.setMinHeight(scene.getHeight() + 25);
		stage.setMinWidth(scene.getWidth() - 120);

		associeDialogAuxBoutons(vue.getBoutonGenere(), vue.getReinitialiser(), vue.getQuitter());
		ajouterUnGrapique(vue.getBoutonAjouterGraph());

		stage.show();
	}

	/**
	 * @author Francois Marchand
	 *
	 * associate a dialog to the buttons
	 *
	 * @param boutons to associate
	 */
	private void associeDialogAuxBoutons(Button... boutons) {
		for (int i = 0; i < boutons.length; i++) {
			boutons[i].setOnAction(new InnerAction());
		}
	}

	/**
	 * @author Antoine-Matis Boudreau
	 *
	 * set the button to the action add a graph
	 *
	 * @param bouton that will add the action
	 */
	private void ajouterUnGrapique(Button bouton){
		bouton.setOnAction(new InnerActionGraph());
	}

	public class InnerActionGraph implements EventHandler {
		@Override
		public void handle(Event event) {
			addGraph();
		}
	}

	/**
	 * @author Antoine-Matis Boudreau
	 * @author Francois Marchand
	 *
	 * the graph that will be added
	 */
	private void addGraph() {
		Grapher grapher = new Grapher();

		final NumberAxis xAxis = new NumberAxis();
		xAxis.setLabel("x");
		final NumberAxis yAxis = new NumberAxis();
		yAxis.setLabel("y");

		LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
		lineChart.getData().add(grapher.createGraph(new Grapher.Parameters(vue.getX(), vue.getY(), null)));
		lineChart.setLegendVisible(false);

		lineChart.setPrefSize(100,100);

		vue.getCenter().getChildren().add(lineChart);
	}

	public class InnerAction implements EventHandler {
		private String headerText = "Antoine-Matis Boudreau" + System.lineSeparator() + "Francois Marchand";
		private String titre = "TP1 420-203 A22";

		@Override
		public void handle(Event event) {
			showAlert(titre,headerText);
		}
	}

	private void showAlert(String titre, String headerText) {

		Alert dialog = new Alert(Alert.AlertType.INFORMATION);
		dialog.setTitle(titre);
		dialog.setHeaderText(headerText);
		dialog.setContentText("La fonctionnalité n'est pas en service");
		dialog.showAndWait();

	}

	public static void main(String[] args) {
		launch();
	}
}
