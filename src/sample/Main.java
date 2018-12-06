package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.CustomTableView;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        CustomTableView customTableView = new CustomTableView();
        primaryStage.setScene(new Scene(customTableView, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
