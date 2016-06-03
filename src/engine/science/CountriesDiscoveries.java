package engine.science;

import engine.universe.Country;

import java.util.ArrayList;

/**
 * Created by bob on 5/19/2016.
 */
public class CountriesDiscoveries
{
	private ArrayList<Discovery> discoveries;


	public CountriesDiscoveries(Country country) {
		discoveries = new ArrayList<>();
		ArrayList<Discovery> noPreq = new ArrayList<>();
		Economics economics = new Economics(noPreq);
		Graphene graphene = new Graphene(noPreq);
		HumanGenomeSequencing humanGenomeSequencing = new HumanGenomeSequencing(noPreq);
		MolecularCircuits molecularCircuits = new MolecularCircuits(noPreq);
		SolidRocketBoosters solidRocketBoosters = new SolidRocketBoosters(noPreq);
		SpaceShuttle spaceShuttle = new SpaceShuttle(new ArrayList<Discovery>(){{add(solidRocketBoosters);}});
		SuperConductors superConductors = new SuperConductors(new ArrayList<Discovery>(){{add(graphene);}});
		SpaceLivingOne spaceLivingOne = new SpaceLivingOne(new ArrayList<Discovery>(){{add(spaceShuttle);}});
		HyperLoop hyperLoop = new HyperLoop(noPreq);
		SpaceLivingTwo spaceLivingTwo = new SpaceLivingTwo(new ArrayList<Discovery>(){{}});
		Tasers  tasers = new Tasers(noPreq);
		LethalTasers lethalTasers =  new LethalTasers(new ArrayList<Discovery>(){{add(tasers);add(superConductors);}});
		Origami origami = new Origami(noPreq);
		discoveries.add(economics);
		discoveries.add(graphene);
		discoveries.add(humanGenomeSequencing);
		discoveries.add(molecularCircuits);
		discoveries.add(solidRocketBoosters);
		discoveries.add(spaceShuttle);
		discoveries.add(superConductors);
		discoveries.add(tasers);
		discoveries.add(hyperLoop);
		discoveries.add(lethalTasers);
		discoveries.add(spaceLivingTwo);
		discoveries.add(origami);
	}

	public ArrayList<Discovery> getDiscoveredDiscoveries() {
		ArrayList<Discovery> out = new ArrayList<>();
		for (Discovery discovery : discoveries) {
			if(discovery.discoveredQ())
				out.add(discovery);
		}
		return out;
	}
	public ArrayList<Discovery> getUnDiscovered(){
		ArrayList<Discovery> out = new ArrayList<>();
		for (Discovery discovery : discoveries) {
			if(!discovery.discoveredQ())
				out.add(discovery);
		}
		return out;
	}
}
