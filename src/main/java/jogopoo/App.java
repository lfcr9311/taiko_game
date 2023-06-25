package jogopoo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    private static Scene scene;
    private Stage stage = new Stage();

    @Override
    public void start(Stage stage) throws IOException {
        firstStage();
    }

    public void firstStage() throws IOException{
        scene = new Scene(loadFXML("primary"));
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        scene.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}