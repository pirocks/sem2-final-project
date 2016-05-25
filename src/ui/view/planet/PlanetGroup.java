package ui.view.planet;

import engine.cities.City;
import engine.planets.Grid;
import engine.tools.vehicles.Vehicle;
import engine.universe.Country;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import ui.view.Controller;

import static ui.view.Controller.cityImage;

/**
 * Created by bob on 5/23/2016.
 */
public class PlanetGroup extends Pane
{
	private static Image red= new Image(PlanetGroup.class.getResourceAsStream("redImage.jpg"));
	private static Image blue = new Image(PlanetGroup.class.getResourceAsStream("blueImage.png"));
	static Image mountainImage = new Image(PlanetGroup.class.getResourceAsStream("mountainImage.jpg"));

	/**
	 * Constructs a group.//intellij thinks it's  clever by putting this comment
	 */
	public static Pane getPlanetGroup(Grid grid, Country playersCountry, final Controller controller) {
		Pane out = new Pane();
		terrain(grid, out);
		GridPane usableItems = new GridPane();
		int usableItemsX = 0;
		int usableItemsY = 0;
		for (City c : grid.getCitys()) {
			ImageView cityImageView = new ImageView();
			cityImageView.setOnMouseMoved(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					controller.focusCityInAccordion(c);
				}
			});
			cityImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					controller.switchTo(c);
				}
			});
			cityImageView.setImage(cityImage);
			cityImageView.setPreserveRatio(true);
			cityImageView.setFitWidth(50);
			cityImageView.setFitHeight(50);
			usableItems.add(cityImageView, usableItemsX, usableItemsY);
			usableItemsX++;
			usableItemsY++;
			if(usableItemsX > 4) {
				usableItemsX = 0;
				usableItemsY++;
			}
		}
		backGroundColor(grid, playersCountry, out);
		for (Vehicle vehicle : grid.getVehicles()) {
			Image vehicleImage = vehicle.getImage();
			if(vehicleImage == null) {
				Group background = new Group();
				background.getChildren().add(new Text(vehicle.getClass().getSimpleName()){{
					setFill(Color.RED);
					setFont(new Font("Verdana",16));
				}});
				usableItems.add(background,usableItemsX,usableItemsY);
				usableItemsX++;
				if(usableItemsX > 4) {
					usableItemsX = 0;
					usableItemsY++;
				}
			}
			else{
				usableItems.add(new ImageView(vehicleImage),usableItemsX,usableItemsX);
			}
		}
		out.getChildren().add(usableItems);
		return out;

	}

	public static void terrain(Grid grid, Pane out) {
		ImageView terrainImageView = new ImageView();
		terrainImageView.setImage(Controller.getImage(grid.getTerrainType()));
		terrainImageView.setPreserveRatio(true);
		terrainImageView.setFitHeight(140);
		terrainImageView.setFitWidth(190);
		out.getChildren().add(terrainImageView);
	}

	public static void backGroundColor(Grid grid, Country playersCountry, Pane out) {
		if(grid.getParentCountry() == playersCountry) {
			ImageView redBorder = new ImageView(red);
			redBorder.setFitHeight(150);
			redBorder.setFitWidth(200);
			out.getChildren().add(0,redBorder);
		}
		else{
			ImageView blueBorder = new ImageView(blue);
			blueBorder.setFitHeight(150);
			blueBorder.setFitWidth(200);
			out.getChildren().add(0,blueBorder);
		}
	}

}
