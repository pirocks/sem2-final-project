package ui.welcomescreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("ui/welcomescreen/simple.fxml"));
	    Parent root = loader.load();
	    Controller controller = (Controller)loader.getController();
		loader.setController(controller);
	    controller.gjhv("jbkij");

	    primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void play()
    {
        return;
    }
}
