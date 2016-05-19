package ui.view.solarsystem;

import engine.planets.Planet;
import engine.universe.SolarSystem;
import javafx.application.Platform;
import ui.view.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by bob on 5/18/2016.
 *
 */
public class SolarSystemJPanel extends JPanel implements MouseListener,MouseMotionListener
{
	private SolarSystem solarSystem;
	private double scale;
	private Controller controller;

	public SolarSystemJPanel(SolarSystem solarSystem, Controller controller) {
		super();
		this.controller = controller;
		addMouseListener(this);
		addMouseMotionListener(this);
		this.solarSystem = solarSystem;
		setPreferredSize(new Dimension(3000,1000));
		double maxRadius = -1;
		for(Planet p:solarSystem.getPlanets())
		{
			if(maxRadius < p.getSolarSystemRadius())
				maxRadius = p.getSolarSystemRadius();
		}
		scale = maxRadius/2500;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.YELLOW);
		drawCircle(g,0,500,200);
		g.setColor(Color.green);
		for(Planet planet:solarSystem.getPlanets())
		{
			int radius = 10*(int)(planet.getplanetRadius());//the 10 is that yu can actually see the planets in question
			drawCircle(g,(int)(planet.getSolarSystemRadius()/scale),500,radius);
		}
	}
	private void drawCircle(Graphics g,int x,int y,int r)
	{
		g.fillOval(x - r,y - r,2*r,2*r);
	}

	/**
	 * Invoked when the mouse button has been clicked (pressed
	 * and released) on a component.
	 *
	 * @param e
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.print("moved x:" + x + "y:" + y);
		for(Planet p:solarSystem.getPlanets())
		{
			int xPosition = (int) (p.getSolarSystemRadius()/scale);
			int dx = x - xPosition;
			int dy = y - 500;
			if(Math.sqrt(dx*dx+dy*dy) < 10*p.getplanetRadius())
			{
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						controller.switchTo(p);
					}
				});
				break;
			}
		}
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
		int x = e.getX();
		int y = e.getY();
		System.out.print("moved x:" + x + "y:" + y);
		for(Planet p:solarSystem.getPlanets())
		{
			int xPosition = (int) (p.getSolarSystemRadius()/scale);
			int dx = x - xPosition;
			int dy = y - 500;
			if(Math.sqrt(dx*dx+dy*dy) < 10*p.getplanetRadius())
			{
				controller.focusPlanetInAccordion(p);
				break;
			}
		}
	}
}
