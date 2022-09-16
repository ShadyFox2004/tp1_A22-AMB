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

    public TextField getTextField() {
        return textField;
    }

    public TextFieldLabel(String s) {
        super();
        this.getChildren();
        this.textField = new TextField(s);
        this.getChildren().addAll(new Label(), textField);
    }

    /**
     * Returns the character sequence backing the text field's content.
     * 
     * @return the character sequence backing the text field's content
     */
    public CharSequence getCharacthers() {
        return textField.getCharacters();
    }
}
