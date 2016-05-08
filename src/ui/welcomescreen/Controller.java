package ui.welcomescreen;

import engine.universe.utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.*;



public class Controller implements Initializable{
	@FXML
	TextField textField;
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
		System.out.println("working");
//		textField.setText("jvh");
	}
	public void gjhv(String s)
	{
		utils.sleep(100);
		textField.setText(s);
//		textField.setText(s);
	}
}
