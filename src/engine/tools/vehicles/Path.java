package engine.tools.vehicles;

import engine.planets.Grid;
import engine.planets.LocationPlanet;
import engine.planets.TerrainType;

import java.util.ArrayList;

/**
 * Created by bob on 6/2/2016.
 */
public class Path {
	ArrayList<LocationPlanet> locationPlanets;

	public Path(ArrayList<LocationPlanet> locationPlanets) {
		if (locationPlanets == null)
			throw new IllegalArgumentException();
		this.locationPlanets = locationPlanets;
	}

	public Path(Path path, LocationPlanet locationPlanet) {
		if (path.locationPlanets == null)
			throw new IllegalArgumentException();
		locationPlanets = new ArrayList<>();
		locationPlanets.addAll(path.locationPlanets);
		locationPlanets.add(locationPlanet);
	}

	public Path(LocationPlanet locationPlanet) {
		this(new ArrayList<LocationPlanet>() {{
			add(locationPlanet);
		}});
	}

	public Path(LocationPlanet begin, LocationPlanet end, boolean waterOkQ, boolean landOkQ) {
		try {
			locationPlanets = getAllPathToDestination(begin, end, waterOkQ, landOkQ).locationPlanets;
		} catch (NullPointerException ignored) {

		}
	}

	public double getLength() {
		double out = 0;
		LocationPlanet prev = locationPlanets.get(0);
		for (LocationPlanet locationPlanet : locationPlanets) {
			out += locationPlanet.distanceBetween(prev);
			prev = locationPlanet;
		}
		return out;
	}

	public ArrayList<Path> getPathsGoingFrom(boolean waterOkQ, boolean landOkQ) {
		LocationPlanet start = getLast();
		ArrayList<Path> possiblePaths = new ArrayList<>();
		if (validQ(this, new LocationPlanet(start) {{
			moveGrid(start.getGridx(), start.getGridy());
		}}, waterOkQ, landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx(), start.getGridy());
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx(), start.getGridy() + 1);
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx(), start.getGridy() + 1);
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx(), start.getGridy() - 1);
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx(), start.getGridy() - 1);
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx() + 1, start.getGridy());
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx() + 1, start.getGridy());
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx() + 1, start.getGridy() + 1);
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx() + 1, start.getGridy() + 1);
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx() + 1, start.getGridy() - 1);
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx() + 1, start.getGridy() - 1);
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx() - 1, start.getGridy());
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx() - 1, start.getGridy());
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx() - 1, start.getGridy() + 1);
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx() - 1, start.getGridy() + 1);
			}}));
		if (validQ(this, new LocationPlanet(start) {{
					moveGrid(start.getGridx() - 1, start.getGridy() - 1);
				}}, waterOkQ,
				landOkQ))
			possiblePaths.add(new Path(this, new LocationPlanet(start) {{
				moveGrid(start.getGridx() - 1, start.getGridy() - 1);
			}}));
		return possiblePaths;
	}

	private boolean validQ(Path previous, LocationPlanet locationPlanet, boolean waterOkQ, boolean landOkQ) {
		if (locationPlanet.equals(previous.getLast()))
			return false;
		Grid grid;
		try {
			grid = locationPlanet.getGrid();
		} catch (ArrayIndexOutOfBoundsException e) {
			return false;
		}
		if (grid.getTerrainType() == TerrainType.Sea) {
			if (waterOkQ) {
				return true;
			}
		} else {
			if (landOkQ) {
				return true;
			}
		}
		return false;
	}

	public LocationPlanet getLast() {
		return locationPlanets.get(locationPlanets.size() - 1);
	}

	public ArrayList<Path> getAllPathToDestination(Path begin, LocationPlanet end, int depth, boolean waterOkQ, boolean landOkQ) {
		if (end == begin.getLast())
			return new ArrayList<Path>() {{
				add(begin);
			}};
		if (depth == 0) {
			return new ArrayList<>();
		}
		ArrayList<Path> paths = new ArrayList<>();
		for (Path path : begin.getPathsGoingFrom(waterOkQ, landOkQ)) {
			ArrayList<Path> allPathToDestination = getAllPathToDestination(path, end, depth - 1, waterOkQ, landOkQ);
			if (allPathToDestination.size() > 0)
				return allPathToDestination;
		}
		return paths;
	}

	public Path getAllPathToDestination(LocationPlanet begin, LocationPlanet end, boolean waterOkQ, boolean landOkQ) {
		ArrayList<Path> allPathToDestination = getAllPathToDestination(new Path(new LocationPlanet(begin)), end, 10, waterOkQ, landOkQ);
		if (allPathToDestination.size() == 0)
			return null;
		return allPathToDestination.get(0);
	}

	public LocationPlanet getFirst() {
		return locationPlanets.get(0);
	}

	public void removeFirst() {
		locationPlanets.remove(0);
	}

	@Override
	public String toString() {
		try {
			return locationPlanets.toString();
		} catch (NullPointerException e) {

		}
		return "";
	}
}
