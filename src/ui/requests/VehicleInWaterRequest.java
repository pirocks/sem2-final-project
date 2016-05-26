package ui.requests;

import engine.tools.vehicles.Vehicle;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 * Created by bob on 5/26/2016.
 */
public class VehicleInWaterRequest extends Request {

	private Vehicle vehicle;

	public VehicleInWaterRequest(Vehicle vehicle) {
		this.vehicle =  vehicle;
	}

	@Override
	public void askUser() {
		Alert alert  = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("A vehicle hit water");
		alert.setContentText("A moving vehicle hit water and was unable to continue. \n Do you want to set a new course?");
		ButtonType no = new ButtonType("No");
		ButtonType yes = new ButtonType("Yes");
		alert.getButtonTypes().setAll(no,yes);
	}

}
