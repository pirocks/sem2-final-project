package ui.view;

import engine.cities.City;
import engine.planets.Grid;
import engine.tools.vehicles.Vehicle;
import engine.universe.Country;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

/**
 * Created by bob on 5/23/2016.
 */
public class PlanetGroup extends Group
{
	private static Image red= new Image("http://images.all-free-download" +
			".com/images/graphiclarge/solid_red_background_209961.jpg");// TODO: 5/23/2016
	private static Image blue = new Image("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/Solid_blue.svg/2000px-Solid_blue.svg.png");// TODO: 5/23/2016
	/**
	 * Constructs a group.//intellij thinks it's  clever by putting this comment
	 */
	public PlanetGroup(Grid grid, Country playersCountry,Controller controller) {
		super();
		ImageView terrainImageView = new ImageView();
		terrainImageView.setImage(Controller.getImage(grid.getTerrainType()));
		terrainImageView.setPreserveRatio(true);
		terrainImageView.setFitHeight(190);
		terrainImageView.setFitWidth(190);
		ArrayList<Node> imageList = new ArrayList<>();
		imageList.add(terrainImageView);
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
			cityImageView.setImage(Controller.cityImage);
			cityImageView.setPreserveRatio(true);
			cityImageView.setFitWidth(50);
			cityImageView.setFitHeight(50);
			imageList.add(cityImageView);
		}
		super.getChildren().addAll(imageList);
		if(grid.getParentCountry() == playersCountry) {
			ImageView redBorder = new ImageView(red);
			redBorder.setFitHeight(200);
			redBorder.setFitWidth(200);
			super.getChildren().add(redBorder);
		}
		else{
			ImageView blueBorder = new ImageView(blue);
			blueBorder.setFitHeight(200);
			blueBorder.setFitWidth(200);
			super.getChildren().add(blueBorder);
		}
		for (Vehicle vehicle : grid.getVehicles()) {

		}

	}
}
