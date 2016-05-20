package ui.view.planet;

import engine.cities.City;
import engine.planets.Grid;
import engine.planets.TerrainType;
import engine.universe.Universe;
import ui.view.Controller;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Created by bob on 5/17/2016.
 */
public class GridPanel extends JPanel implements MouseInputListener
{
	private Controller controller;
	private Grid grid;
	private boolean redQ = true;

	public GridPanel(Controller controller, Grid grid) {
		super();
		this.controller = controller;
		addMouseListener(this);
		this.grid = grid;
		setPreferredSize(new Dimension(110,110));
		add(new JLabel(grid.toString()));
		if(grid.getCitys().size() != 0)
			for(City city:grid.getCitys())
				add(new CityGridIndicator(city, this.controller));
		if(grid.getParentCountry() == Universe.playersCountry)
			redQ = false;
	}



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		TerrainType type = grid.getTerrainType();
//		System.out.println("painting x:"+grid.getX()+"y:" + grid.getY() + "color:" + types.toString());
		g.setColor(Color.GREEN);
		if(redQ)
			g.setColor(Color.RED);
		g.fillRect(0,0,110,110);
		switch (type)
		{
			case Land:
				g.setColor(Color.GREEN);
				break;
			case Sea:
				g.setColor(Color.BLUE);
				break;
			case Coast:
				g.setColor(Color.cyan);
				break;
			case Mountains:
				g.setColor(Color.DARK_GRAY);
				break;
			case Hills:
				g.setColor(Color.GRAY);
				break;
			case Wasteland:
				g.setColor(Color.LIGHT_GRAY);
				break;
		}
		g.fillRect(5,5,100,100);
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
