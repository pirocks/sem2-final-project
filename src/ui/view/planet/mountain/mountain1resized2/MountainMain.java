package ui.view.planet.mountain.mountain1resized2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

/**
 * Created by bob on 5/18/2016.
 *
 */
public class MountainMain  extends Application{
	public static void main(String[] args)
	{
		launch(args);
	}

	/**
	 * The main entry point for all JavaFX applications.
	 * The start method is called after the init method has returned,
	 * and after the system is ready for the application to begin running.
	 * <p>
	 * <p>
	 * NOTE: This method is called on the JavaFX Application Thread.
	 * </p>
	 *
	 * @param primaryStage the primary stage for this application, onto which
	 *                     the application scene can be set. The primary stage will be embedded in
	 *                     the browser if the application was launched as an applet.
	 *                     Applications may create other stages, if needed, but they will not be
	 *                     primary stages and will not be embedded in the browser.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("mountain/mountain1resized2/mountain1resized2.fxml"));
		Parent root = loader.load();
		PerspectiveCamera camera = new PerspectiveCamera();
		camera.setTranslateX(0);
		camera.setTranslateY(0);
		camera.setTranslateZ(0);
//		AmbientLight ambientLight = new AmbientLight();
		Group group = new Group(root,new Sphere(100));
		primaryStage.setTitle("Hello World");
		primaryStage.setScene(new Scene(group,1000,1000,true, SceneAntialiasing.BALANCED){{setCamera(camera);}});
		primaryStage.show();
	}
}
