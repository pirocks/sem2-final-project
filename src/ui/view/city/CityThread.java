package ui.view.city;

import engine.cities.City;
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
public class CityThread implements Runnable{
	private City city;
	private Country playersCountry;

	public CityThread(City city, Country playersCountry) {
		this.city = city;
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
		FXMLLoader loader = new FXMLLoader(getClass().getResource("cityview.fxml"));
		Parent root = null;
		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(102300);
		}
		CityController controller = loader.getController();
//		controller.updateVars(planet,playersCountry);
//		controller.updateAccordion();
		Stage primaryStage =  new Stage();
		primaryStage.setTitle(city.name);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
}
