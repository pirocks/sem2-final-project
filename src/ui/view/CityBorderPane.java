package ui.view;

import engine.buildings.Building;
import engine.cities.City;
import javafx.event.EventHandler;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import ui.view.city.NewBuildingPane;

import java.util.ArrayList;

/**
 * Created by bob on 5/31/2016.
 */
public class CityBorderPane{

	private City city;
	private Controller controller;
	private BorderPane borderPane;
	private ScrollPane cityScrollPane;


	public void initVars(City city, Controller controller, BorderPane borderPane){

		this.city = city;
		this.controller = controller;
		this.borderPane = borderPane;
	}

	public void init(){
		GridPane gridPane = new GridPane();
		gridPane.setHgap(0);
		gridPane.setVgap(0);
		ArrayList<Point> points =  new ArrayList<>();

		for (Building b : city.getBuilding()) {
			int x = b.getParentBlock().x;
			int y = b.getParentBlock().y;

			ImageView buildingImageView = new ImageView();
			buildingImageView.setImage(controller.getImage(b).getImage());
			buildingImageView.setPreserveRatio(true);
			buildingImageView.setFitHeight(200);
			buildingImageView.setFitWidth(200);
			buildingImageView.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					controller.focusBuildingInAccordion(b);
				}
			});
			points.add(new Point(x, y));
			gridPane.add(buildingImageView,x,y);
		}
		addEmptyWrapper(points,gridPane);//add new building locations
		cityScrollPane = new ScrollPane(gridPane);
		borderPane.setCenter(cityScrollPane);
	}
	private static class Point {
		int x,y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Point)
				if(((Point) obj).x == x && ((Point) obj).y == y)
					return true;
			return false;
		}

		@Override
		public String toString() {
			return "x" + x + "y" + y  + "\n";
		}

		public boolean isValid() {
			if(x < 101 && x > -1)
				if(y < 101 && y > -1)
					return true;
			return false;
		}
	}
	private void addEmptyWrapper(ArrayList<Point> points, GridPane gridPane) {
		for(Point p:points)
			addEmpty(points,p,gridPane,2);
	}
	private void addEmpty(ArrayList<Point> points,Point p,GridPane gridPane,int depth) {
		if(!contains(points,p)) {
			if(p.isValid())
				gridPane.add(new ImageView(Controller.images.emptyImage.getImage()){{
					setPreserveRatio(true);
					setFitHeight(200);
					setFitWidth(200);
					setOnMouseClicked(new EventHandler<MouseEvent>() {
						@Override
						public void handle(MouseEvent event) {
							int i = controller.cityAccordion.getPanes().size() - 1;
							NewBuildingPane newBuildingPane;
							if(controller.cityAccordion.getPanes().get(i) instanceof NewBuildingPane) {
								controller.cityAccordion.getPanes().remove(i);
							}
							newBuildingPane = new NewBuildingPane(controller,city, p.x, p.y);
							controller.cityAccordion.getPanes().add(newBuildingPane);
							cityScrollPane.setVvalue(cityScrollPane.getVmax());
							newBuildingPane.setExpanded(true);
						}
					});}}, p.x, p.y);
		}
		if(depth == 0)
			return;
		addEmpty(points, new Point(p.x + 1, p.y),gridPane,depth - 1);
		addEmpty(points, new Point(p.x + 1, p.y + 1),gridPane,depth - 1);
		addEmpty(points, new Point(p.x + 1, p.y - 1),gridPane,depth - 1);
		addEmpty(points, new Point(p.x, p.y + 1), gridPane, depth - 1);
		addEmpty(points, new Point(p.x, p.y - 1), gridPane, depth - 1);
		addEmpty(points, new Point(p.x - 1, p.y + 1),gridPane,depth - 1);
		addEmpty(points, new Point(p.x - 1, p.y), gridPane, depth - 1);
		addEmpty(points, new Point(p.x, p.y),gridPane,depth - 1);

	}
	private boolean contains(ArrayList<Point> points,Point point) {
		for(Point p:points)
			if(point.x == p.x && point.y == p.y)
				return true;
		return false;
	}
}
