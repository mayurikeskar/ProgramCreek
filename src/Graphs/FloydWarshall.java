package Graphs;

import java.util.Scanner;

public class FloydWarshall {
	int[][] distMatrix;
	int size;

	public FloydWarshall(int n){
		distMatrix = new int[n+1][n+1];
		size = n;
	}

	public void getShortestPath(int[][] adjMatrix){

		for (int source = 1; source <= size; source++) {
			for (int destination = 1; destination <= size; destination++) {
				if(source == destination){
					distMatrix[source][destination] = 0;
					continue;
				}
				
				if(adjMatrix[source-1][destination-1] == 0){
					distMatrix[source][destination] = 999;
				}
				else
					distMatrix[source][destination] = adjMatrix[source- 1][destination-1];
			}
		}

		for (int intermediate = 1; intermediate <= size; intermediate++)
		{
			for (int source = 1; source <= size; source++)
			{
				for (int destination = 1; destination <= size; destination++)
				{
					if (distMatrix[source][intermediate] + distMatrix[intermediate][destination]
							< distMatrix[source][destination])
						distMatrix[source][destination] = distMatrix[source][intermediate] 
								+ distMatrix[intermediate][destination];
				}
			}
		}

		for (int source = 1; source <= size; source++)
			System.out.print("\t" + source);

		System.out.println();
		for (int source = 1; source <= size; source++)
		{
			System.out.print(source + "\t");
			for (int destination = 1; destination <= size; destination++)
			{
				System.out.print(distMatrix[source][destination] + "\t");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n  = 4;
		FloydWarshall warshall = new FloydWarshall(4);
		int[][] adjMatrix = {{0, 0, 3, 0}, {2, 0, 0, 0}, {0, 7, 0, 1}, {6, 0, 0, 0}};
		
		warshall.getShortestPath(adjMatrix);
	}


}
