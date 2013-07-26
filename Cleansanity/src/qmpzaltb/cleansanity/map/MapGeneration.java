package qmpzaltb.cleansanity.map;

import java.util.Random;

public class MapGeneration {

	public static void generateEntities(MapArea theMap){

	}

	public static void generateTerrain(MapArea theMap){


		Random rng = theMap.getRandom();

		int areaOfMap = theMap.getXSize() * theMap.getYSize();

		int minAmtOfPoints = (int)Math.round(Math.pow(areaOfMap , 0.25));
		int maxAmtOfPoints = minAmtOfPoints + 4;

		int mapAmtOfPoints = rng.nextInt(maxAmtOfPoints - minAmtOfPoints) + minAmtOfPoints;

		int[] xCoords = new int[mapAmtOfPoints];
		int[] yCoords = new int[mapAmtOfPoints];

		for (int i = 0; i < mapAmtOfPoints; i ++){
			xCoords[i] = rng.nextInt(theMap.getXSize() - 2) + 1;
			yCoords[i] = rng.nextInt(theMap.getYSize() - 2) + 1;
		}
		
		for (int i = 0; i < mapAmtOfPoints; i ++){
			for (int j = 0; j < mapAmtOfPoints; j ++){
				makeRandomPath(theMap, xCoords[i], yCoords[i], xCoords[j], yCoords[j], TileType.FLOOR);
			}
		}
		
	}
	
	private static void makeRoom(MapArea theMap, int xCenter, int yCenter, int width, int height){
		
		
		
		
	}

	private static void makeRandomPath(MapArea theMap, int x1, int y1, int x2, int y2, TileType pathType){

		theMap.getTile(x1, y1).setTileType(pathType);
		theMap.getTile(x2, y2).setTileType(pathType);



		int verticalShift = 1;
		int horizontalShift = 1;
		int currentX = x1;
		int currentY = y1;

		if (x1 > x2){
			horizontalShift = -1;
		}
		if (y1 > y2){
			verticalShift = -1;
		}

		double randomPercentage;


		//Builds a path of FLOOR to the end point by moving tile by tile in the direction of the end point.
		//There is a chance of moving away from the end point, to create non-linear paths.
		while (currentX != x2 && currentY != y2){
			if (currentX == x2){
				currentY += verticalShift;
			}
			if (currentY == y2){
				currentX += horizontalShift;
			}
			if (!(currentX == x2 && currentY == y2)) {
				randomPercentage = theMap.getRandom().nextDouble();
				if (randomPercentage < 0.5){
					if (randomPercentage < 0.125 && currentX >= 0 && currentX < theMap.getXSize()){
						currentX -= horizontalShift;
					} else {
						currentX += horizontalShift;
					}
				} else {
					if (randomPercentage < 0.625 && currentY >= 0 && currentY < theMap.getYSize()){
						currentY -= verticalShift;
					} else {
						currentY += verticalShift;
					}

				}
			} else {
				break;
			}
			
			currentX = Math.max(1, currentX);
			currentX = Math.min(theMap.getXSize() - 1, currentX);
			
			currentY = Math.max(1, currentY);
			currentY = Math.min(theMap.getYSize() - 1, currentY);
			
			theMap.getTile(currentX, currentY).setTileType(TileType.FLOOR);
			
		}
	}



}