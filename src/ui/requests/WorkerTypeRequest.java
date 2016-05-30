package ui.requests;

import engine.buildings.workplaces.School;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;

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

		}});
		dialog.setDialogPane(pane);
		dialog.showAndWait();
	}


		// TODO: 4/13/2016  implment this
		//todo also think about wether this will be imediately callled or request will be run through afterward, I think tht imediately called is a better Idea,, so call in constructor.
}
