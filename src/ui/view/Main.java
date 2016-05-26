package ui.view;

import engine.tools.vehicles.Liver;
import engine.universe.Universe;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by bob on 5/14/2016.
 *
 */
public class Main implements Runnable{
	private static Universe universe;
	public Main(Universe universe) {
		Main.universe = universe;
	}

	/**
	 * When an object implementing interface <code>Runnable</code> is used
	 * to create a thread, starting the thread causes the object's
	 * <code>run</code> method to be called in that separately executing
	 * thread.
	 * <p>
	 * The general contract of the method <code>run</code> is that it may
	 * take any action whatsoever.
	 *
	 * @see Thread#run()
	 */
	@Override
	public void run() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Controller controller = loader.getController();
		Stage primaryStage = new Stage();
		primaryStage.setTitle("Game Window");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		Liver.doGame();
	}

	public static Universe getUniverse() {
		return universe;
	}
}
