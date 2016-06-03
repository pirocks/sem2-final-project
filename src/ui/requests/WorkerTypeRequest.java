package ui.requests;

import engine.buildings.workplaces.School;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;

/**
 * Created by user on 4/13/2016.
 *
 */
public class WorkerTypeRequest extends Request
{
	private School school;
	public WorkerTypeRequest(School school){
		super();
		this.school = school;
		Dialog dialog = new Dialog();
		dialog.setContentText("Select the type of worker you want to build");
		dialog.setTitle("Select the type of worker you want to build");
		DialogPane pane = new DialogPane();
		pane.getChildren().add(new Button("Build 250 teachers"){{
			setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent event) {
					// TODO: 6/2/2016
				}
			});
		}});
		// TODO: 6/2/2016
		dialog.setDialogPane(pane);
		dialog.showAndWait();
	}
}
