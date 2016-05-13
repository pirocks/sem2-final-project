package ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by bob on 5/12/2016.
 *
 */
public class ImagePanel extends JPanel
{
	public BufferedImage getImage() {
		return image;
	}

	private BufferedImage image;
	public ImagePanel(File image)
	{
		try {
			this.image = ImageIO.read(image);
		} catch (IOException e) {
			System.out.print("culd not load image file");
			assert (false);
			throw new IllegalStateException(e);
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image,0,0,null);
	}
}
