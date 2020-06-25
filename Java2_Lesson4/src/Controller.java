import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    HBox msgPanel;

    @FXML
    TextField msgField;
    @FXML
    TextArea areaField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Запуск формы чата");
    }

    public void sendMsg() {
       if (msgField.getText().length()>0){
           areaField.appendText(msgField.getText()+System.lineSeparator());
           msgField.clear();
           msgField.requestFocus();
       }
    }
}