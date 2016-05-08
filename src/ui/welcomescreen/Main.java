package ui.welcomescreen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
//	    System.out.print(getClass().getResource("simple.fxml").toString());
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
	    Parent root = loader.load();
	    Controller controller = (Controller)loader.getController();
		loader.setController(controller);
	    primaryStage.setTitle("Hello World");
	    primaryStage.setScene(new Scene(root, 300, 275));
	    primaryStage.show();
//	    controller.gjhv("jbkij");
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void play()
    {
        return;
    }
}
