package ui.view.planet;

import engine.planets.Grid;
import engine.planets.TerrainType;

import javax.swing.*;
import java.awt.*;

/**
 * Created by bob on 5/17/2016.
 */
public class GridPanel extends JPanel{
	private Grid grid;

	public GridPanel(Grid grid) {
		super();
		this.grid = grid;
	}



	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		TerrainType type = grid.getTerrainType();
		System.out.println("painting x:"+grid.getX()+"y:" + grid.getY() + "color:" + type.toString());
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
				g.setColor(Color.GRAY);
				break;
			case Hills:
				g.setColor(Color.green);
				break;
			case Wasteland:
				g.setColor(Color.LIGHT_GRAY);
				break;
		}
		g.fillRect(0,0,100,100);
	}
}
