package tp1;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * Create the text field and the label.
 * @author Antoine-Matis Boudreau
 */

public class TextFieldLabel extends HBox {

    private TextField textField;
    private Label label;
    private int nbPixel;

    public TextField getTextField() {
        return textField;
    }

    public TextFieldLabel() {
        this("");
    }

    public TextFieldLabel(String s) {
        super();
        this.getChildren();
        
        this.textField = new TextField();
        this.label = new Label(s);
        this.nbPixel = 40;

        textField.setPrefWidth(this.nbPixel);

        this.getChildren().addAll(label, textField);
    }

    /**
     * Returns the character sequence backing the text field's content.
     * 
     * @return the character sequence backing the text field's content
     */
    public CharSequence getCharacthers() {
        return textField.getCharacters();
    }

    /**
     * Set the new label text
     */
    public void setText(String label) {
        this.label.setText(label);
    }


}
