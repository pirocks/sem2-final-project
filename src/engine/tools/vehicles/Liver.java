package engine.tools.vehicles;

import engine.tools.weapons.Attackable;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import ui.view.Controller;

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
	static void deregister(Liver liver){
		livers.remove(liver);
	}
	static void register(Liver liver){
		livers.add(liver);
	}
	static void doLifeAll(double time) {
		Set<Liver> workingCopy = new HashSet<>(livers);
		for (Liver liver : workingCopy) {
//			if(liver instanceof CityBuilder)
//				System.out.println(liver.toString() + ((CityBuilder)liver).getLocation().getImage(0).getBlocky());
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
		Controller.controller.liverUpdate();
	}
	static void doGame(){
		Timeline timeline = new Timeline(new KeyFrame(new Duration(10), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
//				System.out.print("do");
				doLifeAll(0.015);
			}
		}));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

}
