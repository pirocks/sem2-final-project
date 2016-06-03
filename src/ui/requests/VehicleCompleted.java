package ui.requests;

import engine.cities.City;
import engine.tools.vehicles.Vehicle;
import engine.tools.vehicles.Weighable;
import engine.tools.weapons.Weapon;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**
 * Created by bob on 6/2/2016.
 */
public class VehicleCompleted {
	public VehicleCompleted(Vehicle vehicle,City city) {
		Alert alert = new Alert(Alert.AlertType.NONE,"A vehicle was completed");
		if(city.getWaiting().size() == 0) {
			alert.setContentText("A vehicle was created and added on the planet tab");
		}else{
			alert.setContentText("A vehicle was created and added on the planet tab. If you want to add weapons to " +
					"this vehicle select from the below options");
			for (Weapon weapon : city.getWaiting()) {
				alert.getButtonTypes().add(new ButtonType(weapon.getClass().getSimpleName()));
			}
			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					Optional<ButtonType> buttonType = alert.showAndWait();
					if (buttonType.isPresent()) {
						Weapon w = null;
						for (Weapon weapon : city.getWaiting()) {
							if(buttonType.get().getText().equals(weapon.getClass().getSimpleName())){
								w = weapon;
							}
						}
						if(w!= null) {
							try {
								vehicle.loadObject(w);
							} catch (Weighable.ToHeavyException e) {
								e.printStackTrace();// TODO: 6/2/2016
							}
						}

					}
				}
			});
		}
	}
}
