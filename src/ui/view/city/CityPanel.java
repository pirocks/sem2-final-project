package ui.view.city;

import engine.buildings.Building;
import engine.cities.City;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by bob on 5/15/2016.
 *
 */
public class CityPanel extends JPanel
{
	private City city;

	private ArrayList<CityBlockPanel> panels = new ArrayList<>();
	public CityPanel(City city)
	{
		super();
		this.city = city;
		for(Building b:city.getBuilding())
			add(new CityBlockPanel(b.getParentBlock(),b.getParentBlock().x,b.getParentBlock().y));
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
	}
}
