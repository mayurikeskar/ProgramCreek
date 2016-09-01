/**
 * Given an undirected graph G having N (1<N<=1000) vertices and positive weights. 
 * Find the shortest path from vertex 1 to vertex N, or state that such path doesn’t exist.
 */
package DynamicProg;

public class ShortestPath {
	
	public static void main(String[] args) {
		
		int max = 10000;
		int[][] graph = {{0, -1, 4, max, max}, {max, 0, 3, 2, 2}, {max, max, 0, max, max}, 
				{max, 1, 5, 0, max}, {max, max, max, -3, 0}};
		
		int[] dist = new int[5];
		dist[0] =0;
		for(int i=1; i<dist.length; i++){
			dist[i] = max;
		}
		
		for(int i=0; i<graph.length; i++){
			for(int j=0; j<graph[i].length; j++){
				if(graph[i][j] + graph[0][i] < dist[j])
					dist[j] = graph[i][j] + graph[0][i];
			}
		}
		
		for(int i=0; i<dist.length; i++)
			System.out.println(dist[i]);
	}

}
