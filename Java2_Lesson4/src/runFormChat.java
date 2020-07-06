import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class runFormChat  extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("formChat.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Chat");
        primaryStage.setScene(new Scene(root, 400, 220));
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
