package engine.tools.vehicles;

import engine.tools.weapons.Attackable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by bob on 5/22/2016.
 */
public interface Liver {
	Set<Liver> livers = new HashSet<>();
	//1 = one day
	void doLife(double time);
	boolean sanityCheck();
	default void registerLiver() {
		Liver.register(this);
	}
	static void register(Liver liver){
		livers.add(liver);
	}
	static void doLifeAll(long time) {
		Set<Liver> workingCopy = new HashSet<>(livers);
		for (Liver liver : workingCopy) {
			if(liver instanceof CityBuilder)
				System.out.println(liver.toString() + ((CityBuilder)liver).getLocation().get(0).getBlocky());
			try {
				liver.sanityCheck();
			} catch(Exception e){
				e.printStackTrace();
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
				doLifeAll(1);
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

}
