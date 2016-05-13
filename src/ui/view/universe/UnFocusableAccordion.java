package ui.view.universe;

import javafx.scene.control.Accordion;

/**
 * Created by bob on 5/12/2016.
 */
public class UnFocusableAccordion extends Accordion {
	public void requestFocus(){}
	public UnFocusableAccordion() {
		super();
		super.setDisable(true);
	}
}
