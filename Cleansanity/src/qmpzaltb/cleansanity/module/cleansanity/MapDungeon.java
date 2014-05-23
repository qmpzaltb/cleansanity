package qmpzaltb.cleansanity.module.cleansanity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

import qmpzaltb.cleansanity.game.GameMap;
import qmpzaltb.cleansanity.game.MapTile;

public class MapDungeon extends GameMap{

	class Edge {
		int i1;
		int i2;
		int weight;
	}
	
	final int seed;
	public static final int MAP_SIZE_X_MINIMUM = 32; //32
	public static final int MAP_SIZE_X_MAXIMUM = 128; //128
	public static final int MAP_SIZE_Y_MINIMUM = 32; //32
	public static final int MAP_SIZE_Y_MAXIMUM = 128; //128
	
	public static final int MAP_POINT_MINIMUM = 64; //64
	public static final int MAP_POINT_MAXIMUM = 128; //128
	public static final int MAP_LOOP_MINIMUM = 16; //16
	public static final int MAP_LOOP_MAXIMUM = 32; //32
	
	public MapDungeon(int seed){
		System.out.println("SEED = " + seed);
		this.seed = seed;
		Random rng = new Random(seed);
		int sizeX = rng.nextInt(MAP_SIZE_X_MAXIMUM - MAP_SIZE_X_MINIMUM) + MAP_SIZE_X_MINIMUM;
		int sizeY = rng.nextInt(MAP_SIZE_Y_MAXIMUM - MAP_SIZE_Y_MINIMUM) + MAP_SIZE_Y_MINIMUM;
		initMap(sizeX, sizeY);
		
		for (int i = 0; i < sizeX; i ++) {
			for (int j = 0; j < sizeY; j ++) {
				tiles[i][j] = new TileWall();
			}
		}
		
		int pointAmt = rng.nextInt(MAP_POINT_MAXIMUM - MAP_POINT_MINIMUM) + MAP_POINT_MINIMUM;
		
		int[] xPoints = new int[pointAmt];
		int[] yPoints = new int[pointAmt];
		
		

		
		
		for (int i = 0; i < pointAmt; i ++) {
			xPoints[i] = rng.nextInt(sizeX);
			yPoints[i] = rng.nextInt(sizeY);
		}
		
	
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		for (int i = 0; i < pointAmt; i ++) {
			for (int j = i + 1; j < pointAmt; j ++) {
				Edge newEdge = new Edge();
				newEdge.i1 = i;
				newEdge.i2 = j;
				newEdge.weight = ((xPoints[j] - xPoints[i]) * (xPoints[j] - xPoints[i])) + ((yPoints[j] - yPoints[i]) * (yPoints[j] - yPoints[i]));
				edges.add(newEdge);
			}
		}
		
		//Prim's
		ArrayList<Edge> shortestSpanningTree = spanningTree(edges, pointAmt);
		
		ArrayList<Edge> inverseEdges = new ArrayList<Edge>();
		
		for (Edge e : edges) {
			Edge newEdge = new Edge();
			newEdge.i1 = e.i1;
			newEdge.i2 = e.i2;
			newEdge.weight = - e.weight;
			inverseEdges.add(newEdge);
		}
		
		ArrayList<Edge> inverseSST = spanningTree(inverseEdges, pointAmt / 4);
		
		/*for (Edge e : inverseSST) {
			int i = e.i1;
			int j = e.i2;
			makePathStraight(xPoints[i], yPoints[i], xPoints[j], yPoints[j]);
		}*/
		for (Edge e : shortestSpanningTree) {
			int i = e.i1;
			int j = e.i2;
			makePathStraight(xPoints[i], yPoints[i], xPoints[j], yPoints[j], 1);
		}
		/*
		for (Edge e : edges) {
			int i = e.i1;
			int j = e.i2;
			makePathStraight(xPoints[i], yPoints[i], xPoints[j], yPoints[j]);
		}*/
		
		
		ArrayList<Edge> loopmakers = new ArrayList<Edge>(edges);
		loopmakers.removeAll(shortestSpanningTree);
		
		//int loopAmt = rng.nextInt(MAP_LOOP_MAXIMUM - MAP_LOOP_MINIMUM) + MAP_LOOP_MINIMUM;
		
		/*for (int i = 0; i < loopAmt; i ++) {
			Edge e = removeLowestEdge(loopmakers);
			int j = e.i1;
			int k = e.i2;
			makePathStraight(xPoints[j], yPoints[j], xPoints[k], yPoints[k], 1);
			
		}*/
		
		
		printMapDebug();
		
	}
	
	private ArrayList<Edge> spanningTree(ArrayList<Edge> edges, int pointAmt) {
		ArrayList<Edge> primsEdges = new ArrayList<Edge>();
		ArrayList<Edge> activeEdges = new ArrayList<Edge>();
		HashSet<Integer> points = new HashSet<Integer>();
		
		points.add(0);

		while (primsEdges.size() < pointAmt - 1) {
			activeEdges = new ArrayList<Edge>();
			
			for (Edge e : edges) {
				for (Integer i : points) {
					if (i == e.i1 || i == e.i2) {
						activeEdges.add(e);
					}
				}
			}
			
			activeEdges.removeAll(primsEdges);
			Iterator<Edge> ie = activeEdges.iterator();
			while (ie.hasNext()) {
				Edge e = ie.next();
				if (points.contains(e.i1) && points.contains(e.i2)) {
					ie.remove();
				}
			}
			
			Edge lowest = null;
			int lowestWeight = Integer.MAX_VALUE;
			for (Edge e : activeEdges) {
				if (e.weight < lowestWeight) {
					lowest = e;
					lowestWeight = e.weight;
				}
			}
			
			points.add(lowest.i1);
			points.add(lowest.i2);
			primsEdges.add(lowest);
			
		}
		return primsEdges;
	}
	
	private Edge removeLowestEdge(ArrayList<Edge> edges) {
		Edge lowestEdge = null;
		int edgeWeight = Integer.MAX_VALUE;
		Iterator<Edge> i = edges.iterator();
		while (i.hasNext()) {
			Edge e = i.next();
			if (e.weight < edgeWeight) {
				lowestEdge = e;
				edgeWeight = e.weight;
			}
		}
		edges.remove(lowestEdge);
		return lowestEdge;
	}
	
	private void makePathStraight(int x1, int y1, int x2, int y2){
		makePathStraight(x1, y1, x2, y2, 0);
	}
	
	private void makePathStraight(int x1, int y1, int x2, int y2, int radius) {

		System.out.println("Creating straight path from (" + x1 + ", " + y1 + ") to (" + x2 + ", " + y2 + ")");
		
		tiles[x1][y1] = new TileFloor();
		if (x1 == x2 && y1 == y2) {
			return;
		}
		
		int x = x1;
		int y = y1;
		
		int iterateX = 0;
		int iterateY = 0;
		if (x2 > x1) {
			iterateX = 1;
		} else if (x2 < x1) {
			iterateX = -1;
		}
		if (y2 > y1) {
			iterateY = 1;
		} else if (y2 < y1) {
			iterateY = -1;
		}
		
		
		float desiredSlopeMagnitude = Math.abs((float) (y2 - y1)  / (x2 - x1));
		/*if (desiredSlopeMagnitude > 1) {
			y += iterateY;
		} else {
			x += iterateX;
		}
		tiles[x][y] = new TileFloor();*/
		while (x != x2 || y != y2) {
			float currentSlopeMagnitude = Math.abs((float) (y - y1) / (x - x1) );
			if (desiredSlopeMagnitude == Float.POSITIVE_INFINITY) {
				y += iterateY;
			} else if (desiredSlopeMagnitude == 0) {
				x += iterateX;
			} else if (currentSlopeMagnitude > desiredSlopeMagnitude) {
				x += iterateX;
			} else {
				y += iterateY;
			}
			tiles[x][y] = new TileFloor();
			
			int startX = Math.max(x - radius, 0);
			int startY = Math.max(y - radius, 0);
			
			int endX = Math.min(x + radius, sizeX - 1);
			int endY = Math.min(y + radius, sizeY - 1);
			
			for (int sx = startX; sx <= endX; sx ++) {
				for (int sy = startY; sy <= endY; sy ++) {
					tiles[sx][sy] = new TileFloor();
				}
			}
			
		}
		
		
	}
	
	private void printMapDebug() {
		for (int y = 0; y < sizeY; y ++) {
			for (int x = 0; x < sizeX; x ++) {
				if (tiles[x][y] instanceof TileFloor) {
					System.out.print("+");
				} else if (tiles[x][y] instanceof TileWall) {
					System.out.print("#");
				} else {
					System.out.print("?");
				}
			}
			System.out.println();
		}
	}
	
}
