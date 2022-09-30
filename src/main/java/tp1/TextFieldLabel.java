package tp1;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

/**
 * @author Antoine-Matis Boudreau
 *
 * Create the text field and the label.
 */

public class TextFieldLabel extends HBox {

    private TextField textField;
    private Label label;

    public TextField getTextField() {
        return textField;
    }

    public TextFieldLabel() {
        this("");
    }


    /**
     * @author Antoine-Matis Boudreau
     *
     * merge textfield and label to simplify the code and
     *
     * @param s
     */
    public TextFieldLabel(String s) {
        super();
        this.getChildren();
        
        this.textField = new TextField();
        this.label = new Label(s);

        this.getChildren().addAll(label, textField);
    }

    /**
     * @author Antoine-Matis Boudreau
     *
     * Returns the character sequence backing the text field's content.
     * 
     * @return the character sequence backing the text field's content
     */
    public CharSequence getCharacthers() {
        return textField.getCharacters();
    }

    /**
     * @author Francois Marchand
     *
     * Returns the double in the textfield if it's a double
     *
     * @return the double in the textfield if it's a double
     */
    public Double getDouble() {
        return Double.parseDouble(textField.getText());
    }

    /**
     *  @author Antoine-Matis Boudreau
     *
     * Set the new label text
     */
    public void setText(String label) {
        this.label.setText(label);
    }


}
