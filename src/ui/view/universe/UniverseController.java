package ui.view.universe;

import engine.universe.Universe;
import javafx.embed.swing.SwingNode;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Accordion;
import javafx.scene.control.MenuItem;

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
	SwingNode swingNode;
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
		swingNode.setContent(new UniverseJPanel(Universe.universe));
	}

	@FXML
	public void onClose()
	{
		// TODO: 5/8/2016 implement global close
		System.exit(0);
	}
}
