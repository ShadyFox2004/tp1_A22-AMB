package tp1;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import static tp1.VueForme.*;

/**
 * Contrôleur pour le Tp1
 *

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

		associeDialogAuxBoutons(genere,reinitialiser,quitter);
		ajouterUnGrapique(boutonAjouterGraph);

		stage.show();
	}

	private void associeDialogAuxBoutons(Button... boutons) {
		for (int i = 0; i < boutons.length; i++) {
			boutons[i].setOnAction(new InnerAction());
		}
	}

	private void ajouterUnGrapique(Button bouton){
		bouton.setOnAction(new InnerActionGraph());
	}

	public class InnerActionGraph implements EventHandler {

		@Override
		public void handle(Event event) {
			addGraph();
		}
	}

	private void addGraph(){
//		center.getChildren().add(lineChart);
	}

	public class InnerAction implements EventHandler {

		private String headerText = "Vos Noms";
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
