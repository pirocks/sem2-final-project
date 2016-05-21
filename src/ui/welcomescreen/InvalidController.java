package ui.welcomescreen;

import engine.universe.UniverseConstructionContext;
import engine.universe.UniverseGenerator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by bob on 5/21/2016.
 *
 */
public class InvalidController implements Initializable {
	@FXML
	Button button;
	private UniverseConstructionContext constructionContext;

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

	}
	@FXML
	public void continueNormally()
	{
		UniverseGenerator generator = new UniverseGenerator(constructionContext);
//		Thread universeGenerationThread = new Thread(generator);
//		universeGenerationThread.run();
		generator.run();
	}
	@FXML
	public void goBack()
	{
		((Stage)button.getScene().getWindow()).close();
	}

	public void setConstructionContext(UniverseConstructionContext constructionContext) {
		this.constructionContext = constructionContext;
	}
}
