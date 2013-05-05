package saneMap;

/**
 * Describes the fluids that occupy a tile - gases & liquids.
 * 
 *
 */
public class TileFluid {

	boolean isLiquid;	//True: Fluid is a liquid.
						//False: Fluid is gaseous.
	
	int fluidViscosity;	//Thickness of the fluid. Affects movement rate and inter-tile fluid transfer rates.
	
}
