package engine.buildings;

import engine.buildings.workplaces.Warehouse;
import engine.cities.City;
import engine.universe.Resource;
import engine.universe.ResourceDemand;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

/**
 * Created by bob on 6/1/2016.
 */
public interface ResourceUser {
	City getCity();
	ResourceDemand getResourceDemand();
	default void addAddResourcesButton(VBox in){
		in.getChildren().add(new Button("add resources"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					City city = getCity();
					Resource totalResource = new Resource();
					for (Warehouse warehouse : city.getWarehouses()) {
						totalResource.unsafeAdd(warehouse.inStock);
					}

					Alert alert = new Alert(Alert.AlertType.INFORMATION);
					TextField IronField = new TextField("" +totalResource.getValues().get(Resource.Type.Iron));
					TextField OilField = new TextField("" +totalResource.getValues().get(Resource.Type.Oil));
					TextField UraniumField = new TextField("" +totalResource.getValues().get(Resource.Type.Uranium));
					TextField HeliumField = new TextField("" +totalResource.getValues().get(Resource.Type.Helium));
					TextField FoodField = new TextField("" +totalResource.getValues().get(Resource.Type.Food));
					TextField WaterField = new TextField("" +totalResource.getValues().get(Resource.Type.Water));
					TextField WoodField = new TextField("" +totalResource.getValues().get(Resource.Type.Wood));
					TextField SiliconField = new TextField("" +totalResource.getValues().get(Resource.Type.Silicon));
					setContent(alert, IronField, OilField, UraniumField, HeliumField, FoodField, WaterField, WoodField, SiliconField);
					ResourceDemand toPay = interpretContent(alert, IronField, OilField, UraniumField, HeliumField, FoodField, WaterField, WoodField, SiliconField);
					if (toPay == null) return;
					for (Warehouse warehouse : city.getWarehouses()) {
						toPay.pay(warehouse.inStock);
					}

				}

				@Nullable
				private ResourceDemand interpretContent(Alert alert, TextField ironField, TextField oilField, TextField uraniumField, TextField heliumField, TextField foodField, TextField waterField, TextField woodField, TextField siliconField) {
					Optional optional = alert.showAndWait();
					double IronNum = 0;
					double OilNum = 0;
					double UraniumNum = 0;
					double HeliumNum = 0;
					double FoodNum = 0;
					double WaterNum = 0;
					double WoodNum = 0;
					double SiliconNum = 0;
					try {
						IronNum = getNumNum(ironField);
						OilNum = getNumNum(oilField);
						UraniumNum = getNumNum(uraniumField);
						HeliumNum = getNumNum(heliumField);
						FoodNum = getNumNum(foodField);
						WaterNum = getNumNum(waterField);
						WoodNum = getNumNum(woodField);
						SiliconNum = getNumNum(siliconField);
					} catch (NumberFormatException e) {
						Alert alert1 = new Alert(Alert.AlertType.WARNING);
						alert1.setTitle("Please enter a valid number");
						alert1.setContentText("Please enter a valid number into all of the boxes");
						alert1.showAndWait();
						return null;
					}
					ResourceDemand toPay = new ResourceDemand(new Resource(new Resource.Type[]{Resource.Type.Iron,Resource.Type.Oil,Resource.Type.Uranium,Resource.Type.Helium,Resource.Type.Food,Resource.Type.Water,Resource.Type.Wood,Resource.Type.Silicon},new Double[]{IronNum,OilNum,UraniumNum,HeliumNum,FoodNum,WaterNum,WoodNum,SiliconNum}));
					return toPay;
				}

				private void setContent(Alert alert, final TextField ironField, final TextField oilField, final TextField uraniumField, final TextField heliumField, final TextField foodField, final TextField waterField, final TextField woodField, final TextField siliconField) {
					alert.getDialogPane().setContent(new Pane(){{
						VBox vbox = new VBox();
						vbox.getChildren().add(new Text("Select the amount of each you want to send to the factory."));
						vbox.getChildren().add(new Text("Iron"));
						vbox.getChildren().add(ironField);
						vbox.getChildren().add(new Text("Oil"));
						vbox.getChildren().add(oilField);
						vbox.getChildren().add(new Text("Uranium"));
						vbox.getChildren().add(uraniumField);
						vbox.getChildren().add(new Text("Helium"));
						vbox.getChildren().add(heliumField);
						vbox.getChildren().add(new Text("Food"));
						vbox.getChildren().add(foodField);
						vbox.getChildren().add(new Text("Water"));
						vbox.getChildren().add(waterField);
						vbox.getChildren().add(new Text("Wood"));
						vbox.getChildren().add(woodField);
						vbox.getChildren().add(new Text("Silicon"));
						vbox.getChildren().add(siliconField);
						setWidth(vbox.getWidth());
						setHeight(vbox.getHeight());
						getChildren().add(vbox);
					}});
				}
			});
		}});
	}

	default double getNumNum(TextField ironField) {
		return Double.parseDouble(ironField.getText());
	}
}
