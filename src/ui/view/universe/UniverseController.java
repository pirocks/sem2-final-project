package ui.view.universe;

import engine.universe.SolarSystem;
import engine.universe.Universe;
import javafx.embed.swing.SwingNode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import ui.view.solarsystem.SolarSystemThread;

import javax.swing.*;
import java.awt.*;
import java.net.URL;
import java.util.*;
import java.util.List;

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
	SwingNode swingNode;
	@FXML
	AnchorPane anchorPane;
	public static AnchorPane pane;
	/**
	 * Called to initialize a controller after its root element has been
	 * completely processed.
	 *
	 * @param location  The location used to resolve relative paths for the root object, or
	 *                  <tt>null</tt> if the location is not known.
	 * @param resources The resources used to localize the root object, or <tt>null</tt> if
	 */
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		swingNode.setContent(new UniverseJPanel(Universe.universe));
		JPanel panel = new UniverseJPanel(Universe.universe);
		swingNode.setContent(panel);
		for(SolarSystem s: Universe.universe.getSolarSystems()) {
			VBox pane = new VBox();
			pane.getChildren().add(new Text(s.toString()));
			Button button = new SolarSystemButton(s,"Go To SolarSystem");
			pane.getChildren().add(button);
			accordion.getPanes().add(
					new TitledPane(s.name, pane));
		}
//		anchorPane.autosize();
//		pane  = anchorPane;
	}

	public class SolarSystemButton extends Button
	{
		private SolarSystem solarSystem;
		public SolarSystemButton(SolarSystem s,String string)
		{
			super(string);
			solarSystem = s;
			super.setOnAction(new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e) {
					new SolarSystemThread(solarSystem).run();
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
}
