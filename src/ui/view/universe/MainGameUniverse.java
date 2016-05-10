package ui.view.universe;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by bob on 5/8/2016.
 *
 */
public class MainGameUniverse implements Runnable {
	public MainGameUniverse()
	{

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
		//init the Universe window
//		System.out.print("running");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("universeview.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(102300);
		}
		Stage primaryStage =  new Stage();
		primaryStage.setScene(new Scene(root));
		primaryStage.setTitle("Universe");
		primaryStage.show();
		primaryStage.setFullScreen(true);
	}
}
