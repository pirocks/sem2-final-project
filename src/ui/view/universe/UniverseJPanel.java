package ui.view.universe;

import engine.universe.SolarSystem;
import engine.universe.Universe;

import javax.swing.*;
import java.awt.*;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by bob on 5/8/2016.
 *
 */
public class UniverseJPanel extends JPanel
{
	private Universe universe;
	public UniverseJPanel(Universe universe)
	{
		this.universe = universe;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<SolarSystem> systems = universe.getSolarSystems();
		BigDecimal x = new BigDecimal(0);
		BigDecimal y = new BigDecimal(0);
		BigDecimal z = new BigDecimal(0);
		for(SolarSystem s: systems)
		{
			x = s.getXInUniverse();
			y = s.getYInUniverse();
			z = s.getZInUniverse();
			// TODO: 5/8/2016 fix magic numbers
			double locx = x.divide(new BigDecimal(1000000)).doubleValue();
			double locy = y.divide(new BigDecimal(1000000)).doubleValue();
			double locz = z.divide(new BigDecimal(1000000)).doubleValue();
			g.draw3DRect((int)locx,(int)locy,10,10,true);
		}
	}
}
