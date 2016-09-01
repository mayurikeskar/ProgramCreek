/**
 * Given a undirected graph with weights, return the sum of the weight of each path between two nodes (shortest path between two vertices). Assume there are no cycles. 

Example:


Input:
       A
       | 1
       B
   2 /   \ 3
    C     D

Output:
18
since 
A to B has weight 1
A to C has weight 3
A to D has weight 4
B to C has weight 2
B to D has weight 3
C to D has weight 5
 */

// Used Floyd Warshall approach. Can be solved using Djikstas as well
package Graphs;

public class PathBetweenTwoNodes {

	int[][] distMatrix;
	int size;
	public PathBetweenTwoNodes(int n){
		distMatrix = new int[n+1][n+1];
		for(int i=1; i<distMatrix.length; i++){
			for(int j=1; j<distMatrix.length; j++){
				if(i == j)
					distMatrix[i][j] = 0;
				else
					distMatrix[i][j] = 999;
			}
		}
		size = n;
	}

	public void addEdge(int source, int dest, int cost){
		distMatrix[source+1][dest+1] = cost;
	}

	public int getPathSum(){

		for(int k=1; k<=size; k++){
			for(int i=1; i<=size; i++){
				for(int j=1; j<=size; j++){
					if(distMatrix[i][k] + distMatrix[k][j] < distMatrix[i][j]){
						distMatrix[i][j] = distMatrix[i][k] + distMatrix[k][j];
					}
				}
			}
		}
		
		int total =0 ;
		for(int i=1; i<=size; i++){
			for(int j=i; j<=size; j++){
				total = total + distMatrix[i][j];
			}
		}
		
		return total;
	}
	
	public static void main(String[] args) {
		PathBetweenTwoNodes path = new PathBetweenTwoNodes(4);
		path.addEdge(0, 1, 1);
		path.addEdge(1, 2, 2);
		path.addEdge(1, 3, 3);
		path.addEdge(1, 0, 1);
		path.addEdge(2, 1, 2);
		path.addEdge(3, 1, 1);
		
		System.out.println(path.getPathSum());
	}
}
