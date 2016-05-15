package ui.view.solarsystem;

import engine.universe.Country;
import engine.universe.SolarSystem;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by bob on 5/9/2016.
 *
 */
public class SolarSystemThread implements Runnable {
	private SolarSystem solarSystem;
	private Country playersCountry;

	public SolarSystemThread(SolarSystem s, Country playersCountry)
	{
		solarSystem = s;
		this.playersCountry = playersCountry;
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
//		System.out.print("clicked");
		FXMLLoader loader = new FXMLLoader(getClass().getResource("solarsystem.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(102300);
		}
		SolarSystemController controller = loader.getController();
		controller.updateVars(solarSystem,playersCountry);
		controller.updateAccordion();
		controller.updateTabs();
		Stage primaryStage =  new Stage();
		primaryStage.setTitle(solarSystem.name);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
