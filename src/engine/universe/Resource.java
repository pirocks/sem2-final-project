package engine.universe;

import engine.tools.vehicles.Weighable;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Resource implements Serializable,Weighable
{
	public Resource() {
		this(new ArrayList<>(),new ArrayList<Double>());
	}

	@Override
	public double getWeightActual() {
		return getWeight();
	}

	public void mult(int num) {
		for (Type type : values.keySet()) {
			values.put(type,values.get(type)*num);
		}

	}

	public void unsafeAdd(Resource r) {
		for (Type type : r.getValues().keySet()) {
			values.put(type,values.get(type) + r.getValues().get(type));
		}
	}

	public enum Type
    {
	        Iron,Oil,Uranium,Helium,Food,Water,Wood,Silicon
    }

	private Map<Type,Double> values;
	@Deprecated static double IronValue;
	@Deprecated static double OilValue;
	@Deprecated static double UraniumValue;
	@Deprecated static double HeliumValue;
	@Deprecated static double FoodValue;
	@Deprecated static double WoodValue;
	@Deprecated static double WaterValue;
	@Deprecated static double SiliconValue;
	public static double IronWeight = 3;
	public static double OilWeight = 2;
	public static double UraniumWeight = 5;
	public static double HeliumWeight = 0.1;
	public static double FoodWeight = 1;
	public static double WaterWeight = 2;
	public static double WoodWeight = 1.2;
	public static double SiliconWeight = 2;
	public static double getTypeValue(Type type) {
    	switch(type)
    	{
	        case Iron:
	        	return IronValue;
	        case Oil:
	        	return OilValue;
	        case Uranium:
	        	return UraniumValue;
	        case Helium:
	        	return HeliumValue;
	        case Food:
	        	return FoodValue;
	        case Water:
	        	return WaterValue;
		    case Wood:
			    return WoodValue;
		    case Silicon:
			    return SiliconValue;
		    default:
	        	assert(false);
	        	throw new IllegalStateException();
    	}
    }
	public Resource(Type[] types,Double[] quantities) {
		this(new ArrayList<Type>(Arrays.asList(types)),new ArrayList<Double>(Arrays.asList(quantities)));
	}
	public Resource(ArrayList<Type> types, ArrayList<Double> quantities) {
		assert (types.size() == quantities.size());
		values = new HashMap<>();
		values.put(Type.Iron,new Double(0));
		values.put(Type.Oil,new Double(0));
		values.put(Type.Uranium,new Double(0));
		values.put(Type.Helium,new Double(0));
		values.put(Type.Food,new Double(0));
		values.put(Type.Wood,new Double(0));
		values.put(Type.Water,new Double(0));
		values.put(Type.Silicon,new Double(0));
		for (int i = 0; i < types.size(); i++) {
			Type type = types.get(i);
			double val = quantities.get(i);
			values.put(type,val);
		}
	}
	public Resource(Type type)
	{
		this(new ArrayList<Type>(){{add(type);}},new ArrayList<Double>(){{add(Double.NaN);}});
	}
	public Resource(Type type,double quantity)
	{
		this(new ArrayList<Type>(){{add(type);}},new ArrayList<Double>(){{add(quantity);}});
	}
	public void add(Resource r) {
		sanityCheck();
		for (Type type : r.getValues().keySet()) {
			values.put(type,values.get(type) + r.getValues().get(type));
		}
		sanityCheck();
	}
	public double getQuantity(Type type)
	{
		sanityCheck();
		return values.get(type);
	}
	private void subtract(Resource r) {
		for (Type type : r.getValues().keySet()) {
			values.put(type,values.get(type) - r.getValues().get(type));
		}
		sanityCheck();
	}
	public void pay(ResourceDemand r) {
		subtract(r.getResource());
	}
	@Override
	public double getWeight() {
		double weight = 0;
		for (Type type : values.keySet()) {
			weight += getWeightType(type)* values.get(type);
		}
		return weight;
	}

	@Override
	public int getCount() {
		return 1;//meaningless
	}

	private static double getWeightType(Type type)
	{
		switch (type)
		{
			case Iron:
				return IronWeight;
			case Oil:
				return OilWeight;
			case Uranium:
				return UraniumWeight;
			case Helium:
				return HeliumWeight;
			case Food:
				return FoodWeight;
			case Water:
				return WaterWeight;
			case Wood:
				return WoodWeight;
			case Silicon:
				return SiliconWeight;
			default:
				throw new IllegalStateException();
		}
	}
	private void sanityCheck()
	{
		for (Type type : values.keySet()) {
			if(values.get(type) < 0){
				values.put(type, 0.0);
				System.out.print("fix me");
			}
		}


	}
	public Map<Type, Double> getValues() {
		return values;
	}

	@Override
	public String toString() {
		sanityCheck();
		return values.toString();
	}

	public GridPane toTable()
	{
		GridPane out = new GridPane();
		int row = 0;
		for (Type type : values.keySet()) {
			double val = values.get(type);
			out.add(new Text(type.toString()),0,row);
			out.add(new Text(""+val),1,row);
		}
		return out;

	}
	public VBox toVbox()
	{
		VBox out = new VBox();
		int row = 0;
		for (Type type : values.keySet()) {
			double val = values.get(type);
			out.getChildren().add(new Text(type.toString()));
			out.getChildren().add(new Text(""+val));
		}
		return out;
	}
}