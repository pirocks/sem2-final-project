package ui.view.city;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bob on 5/16/2016.
 *
 */
public class emptyCityBlock extends JPanel {
	public emptyCityBlock()
	{
		super();
		setPreferredSize(new Dimension(100,100));
		add(new JLabel("empty"));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		g.fillRect(0,0,100,100);
	}
}
