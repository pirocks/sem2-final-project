package ui.view.planet;

import engine.planets.Grid;
import engine.planets.Planet;
import ui.view.Controller;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by bob on 5/18/2016.
 *
 */
public class GridViewPanel extends JPanel implements MouseInputListener
{

	private Controller controller;
	private Grid[][] grids;

	public GridViewPanel(Planet planet, Controller controller)
	{
		grids  = planet.getGrids();
		this.controller = controller;
		addMouseListener(this);
		setLayout(new GridLayout(grids.length,grids[0].length){{setVgap(0);setHgap(0);}});
		for(Grid[] row:grids)
			for(Grid grid:row)
			{
				add(new GridPanel(controller,grid));
			}
	}

	/**
	 * Invoked when the mouse button has been clicked (pressed
	 * and released) on a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {

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
