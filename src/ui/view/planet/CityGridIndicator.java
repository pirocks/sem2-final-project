package ui.view.planet;

import engine.cities.City;
import ui.view.Controller;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by bob on 5/17/2016.
 */
public class CityGridIndicator extends JPanel implements MouseInputListener{

	private City city;
	private Controller controller;

	public CityGridIndicator(City city, Controller controller) {
		this.city = city;
		this.controller = controller;
		addMouseListener(this);
		add(new JLabel("City:\n" + city.name));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

	}

	/**
	 * Invoked when the mouse button has been clicked (pressed
	 * and released) on a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("clicked");
		controller.focusCityInAccordion(city);

	}

	/**
	 * Invoked when a mouse button has been pressed on a component.
	 *
	 * @param e
	 */
	@Override
	public void mousePressed(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button has been released on a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseReleased(MouseEvent e) {

	}

	/**
	 * Invoked when the mouse enters a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("entered");
		controller.focusCityInAccordion(city);
	}

	/**
	 * Invoked when the mouse exits a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseExited(MouseEvent e) {

	}

	/**
	 * Invoked when a mouse button is pressed on a component and then
	 * dragged.  <code>MOUSE_DRAGGED</code> events will continue to be
	 * delivered to the component where the drag originated until the
	 * mouse button is released (regardless of whether the mouse position
	 * is within the bounds of the component).
	 * <p>
	 * Due to platform-dependent Drag&amp;Drop implementations,
	 * <code>MOUSE_DRAGGED</code> events may not be delivered during a native
	 * Drag&amp;Drop operation.
	 *
	 * @param e
	 */
	@Override
	public void mouseDragged(MouseEvent e) {

	}

	/**
	 * Invoked when the mouse cursor has been moved onto a component
	 * but no buttons have been pushed.
	 *
	 * @param e
	 */
	@Override
	public void mouseMoved(MouseEvent e) {

	}
}
