package engine.buildings;

import engine.buildings.workplaces.Warehouse;
import engine.cities.City;
import engine.universe.Resource;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * Created by bob on 6/1/2016.
 */
public interface ResourceUser {
	City getCity();
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

					Alert alert = new Alert(Alert.AlertType.INFORMATION,"Available resources");

					alert.setDialogPane(new DialogPane(){{

					}});
				}
			});
		}});
	}
}
