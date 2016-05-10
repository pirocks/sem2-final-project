package ui.view.planet;

import engine.planets.Planet;
import engine.universe.Country;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by bob on 5/9/2016.
 *
 */
public class PlanetThread implements Runnable {
	private Planet planet;
	private Country playersCountry;
	public PlanetThread(Planet planet, Country playersCountry) {
		this.planet = planet;
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("planetview.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(102300);
		}
		PlanetController controller = loader.getController();
		controller.updateVars(planet,playersCountry);
		controller.updateAccordion();
		Stage primaryStage =  new Stage();
		primaryStage.setTitle(planet.name);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
