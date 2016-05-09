package ui.view.universe;

import engine.universe.SolarSystem;
import engine.universe.Universe;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
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
		super.setPreferredSize(new Dimension(1280,1381));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<SolarSystem> systems = universe.getSolarSystems();
		System.out.print(universe.getSolarSystems());
		BigDecimal x = new BigDecimal(0);
		BigDecimal y = new BigDecimal(0);
		BigDecimal z = new BigDecimal(0);
		g.setColor(Color.black);
		for (SolarSystem s : systems) {
			x = s.getXInUniverse();
			y = s.getYInUniverse();
			z = s.getZInUniverse();
			// TODO: 5/8/2016 fix magic numbers
			double locx = x.divide(new BigDecimal(10000000)).doubleValue();
			double locy = y.divide(new BigDecimal(10000000)).doubleValue();
			double locz = z.divide(new BigDecimal(10000000)).doubleValue();
			g.fillRect((int) locx, (int) locy, 10, 10);
		}
		BufferedImage background = null;
		try {
			background = ImageIO.read(this.getClass().getResource("universe_background_image.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(35467);
		}
		add(new JLabel(new ImageIcon(background)));
//		g.fillRect(0,100,100,100);
//		g.fillRect(-1000,-1000,2000000,2000000);
	}
}
