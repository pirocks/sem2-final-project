package ui.view.city;

import engine.cities.CityBlock;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bob on 5/16/2016.
 *
 */
public class CityBlockPanel extends JPanel
{
	private CityBlock cityBlock;
	private int xCoordinate;
	private int yCoordinate;

	public CityBlockPanel(CityBlock cityBlock,int x, int y) {
		super();
		this.cityBlock = cityBlock;
		this.xCoordinate = x;
		this.yCoordinate = y;
		if(cityBlock.getBuilding() != null)
			add(cityBlock.getBuilding().name,new JLabel(cityBlock.getBuilding().name));
		else
			add(new JLabel("dfcgvhbjnkmljnhugytf"));
		add(new JLabel("\nx:" + x + "y:" + y));
		setPreferredSize(new Dimension(100,100));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		if(cityBlock.getBuilding() != null) {
			g.setColor(Color.BLUE);
		g.fillRect(0,0,100,100);
		}

	}
}