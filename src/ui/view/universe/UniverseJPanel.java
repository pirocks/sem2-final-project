package ui.view.universe;

import engine.universe.SolarSystem;
import engine.universe.Universe;
import ui.ImagePanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by bob on 5/8/2016.
 * this class was really irritating. It was easier to do stuff in 3d
 */
@Deprecated public class UniverseJPanel extends JPanel
{
	private Universe universe;
	private ImagePanel image;
	public UniverseJPanel(Universe universe)
	{
		this.universe = universe;
		super.setPreferredSize(new Dimension(1280,1381));
		image = new ImagePanel(new File(getClass().getResource("universe_background_image.jpg").getPath()));
//		add(image);
		BufferedImage wPic = null;
		try {
			wPic = ImageIO.read(this.getClass().getResource("universe_background_image.jpg"));
		} catch (IOException e) {

		}
		JLabel wIcon = new JLabel(new ImageIcon(wPic));
		add(wIcon);
//		setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<SolarSystem> systems = universe.getSolarSystems();
		System.out.print(universe.getSolarSystems());
		double x = 0;
		double y = 0;
		double z = 0;
		g.setColor(Color.black);
		for (SolarSystem s : systems) {
			x = s.getXInUniverse();
			y = s.getYInUniverse();
			z = s.getZInUniverse();
			// TODO: 5/8/2016 fix magic numbers
			double shrinkConstant = 1;
			double locx = x/shrinkConstant;
			double locy = y/shrinkConstant;
			double locz = z/shrinkConstant;
			g.fillRect((int) locx, (int) locy, 10, 10);
		}
//		g.drawImage(image.getImage(),0,0,null);
	}
}
