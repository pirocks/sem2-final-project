package ui.view.universe;

import engine.universe.Country;
import engine.universe.SolarSystem;
import engine.universe.Universe;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.PerspectiveCamera;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Sphere;
import javafx.scene.text.Text;
import ui.view.solarsystem.SolarSystemThread;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/7/2016.
 *
 */
public class UniverseController implements Initializable {

	@FXML
	Accordion accordion;
	@FXML
	MenuItem  about;
	@FXML
	MenuItem closeButton;
	@FXML
	BorderPane borderPane;
	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	PerspectiveCamera camera;
	SubScene subScene;


	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		swingNode.setContent(new UniverseJPanel(Universe.universe));
		Pane threeDPane = new Pane();
		for(SolarSystem s: Universe.universe.getSolarSystems()) {
			VBox pane = new VBox();
			pane.getChildren().add(new Text(s.toString()));
			Button button = new SolarSystemButton(s, "Go To SolarSystem", Universe.playersCountry);
			pane.getChildren().add(button);
			accordion.getPanes().add(
					new TitledPane(s.name, pane));
			Sphere solarSystemSphere = new Sphere(100);
			solarSystemSphere.setTranslateX(0);
			solarSystemSphere.setTranslateY(0);
			solarSystemSphere.setTranslateZ(0);
			threeDPane.getChildren().add(solarSystemSphere);
		}
		camera = new PerspectiveCamera();
		threeDPane.getChildren().add(new Sphere(100));
		subScene = new SubScene(threeDPane,1000,1000,true,SceneAntialiasing.BALANCED);
		subScene.requestFocus();
		borderPane.setBottom(new TabPane(new Tab("Universe")));
	}

	class SolarSystemButton extends Button
	{
		private SolarSystem solarSystem;
		private Country playersCountry;

		public SolarSystemButton(SolarSystem s, String string, Country playersCountry)
		{
			super(string);
			solarSystem = s;
			this.playersCountry = playersCountry;
			super.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					new SolarSystemThread(solarSystem, SolarSystemButton.this.playersCountry).run();
				}
			});
		}
	}


	@FXML
	public void onClose()
	{
		// TODO: 5/8/2016 implement global close
		System.exit(0);
	}

	public void up(){
		camera.setTranslateY(100 + camera.getTranslateY());
	}
	public void down(){
		camera.setTranslateY(0 - 100 + camera.getTranslateY());
	}
	public void forward(){
		camera.setTranslateZ(100 + camera.getTranslateZ());
	}
	public void backward(){
		camera.setTranslateZ(0 - 100 + camera.getTranslateZ());
	}
	public void right(){
		camera.setTranslateX(100 + camera.getTranslateX());
	}
	public void left(){
		camera.setTranslateX(0 - 100 + camera.getTranslateX());
	}

	@FXML
	public void keyPressed(KeyEvent keyEvent)
	{
		System.out.println("key pressed");
		KeyCode code = keyEvent.getCode();
		switch (code)
		{
			case PAGE_UP:
				forward();
				break;
			case PAGE_DOWN:
				backward();
				break;
			case LEFT:
				left();
				break;
			case UP:
				up();
				break;
			case RIGHT:
				right();
				break;
			case DOWN:
				down();
				break;
			case A:
				left();
				break;
			case D:
				right();
				break;
			case E:
				down();
				break;
			case Q:
				up();
				break;
			case S:
				backward();
				break;
			case W:
				forward();
				break;
		}
	}
}
