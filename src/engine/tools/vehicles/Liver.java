package engine.tools.vehicles;

import engine.tools.weapons.Attackable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.util.Duration;

import java.util.ArrayList;

/**
 * Created by bob on 5/22/2016.
 */
public interface Liver {
	ArrayList<Liver> livers = new ArrayList<>();
	void doLife(long time);
	boolean sanityCheck();
	default void registerLiver() {
		Liver.register(this);
	}
	static void register(Liver liver){
		livers.add(liver);
	}
	static void doLifeAll(long time) {
		for (Liver liver : livers) {
			if(liver instanceof CityBuilder)
				System.out.println(liver.toString() + ((CityBuilder)liver).getLocation().get(0).getBlocky());
			try {
				liver.sanityCheck();
			} catch(Exception e){
				Alert alert = new Alert(Alert.AlertType.WARNING);
				alert.setTitle("An object failed its sanity check. It will now die.");
				alert.setContentText(e.toString());

				if(liver instanceof Attackable)
					((Attackable)liver).die();
			}
			liver.doLife(time);
		}
		//update display // TODO: 5/26/2016

	}
	static void doGame(){
		Timeline timeline = new Timeline(new KeyFrame(new Duration(100), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				doLifeAll(100);
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}
}
