/**
 * Given an undirected graph G having positive weights and N vertices.
 * You start with having a sum of M money. For passing through a vertex i, you must pay S[i] money.
 * If you don’t have enough money – you can’t pass through that vertex. Find the shortest path from 
 * vertex 1 to vertex N, respecting the above conditions; or state that such path doesn’t exist
 */
package DynamicProg;

public class MoneySpentOnTheWay {
	
	public static void main(String[] args) {
		
		int max = 10000;
		int n = 5;
		int money = 5;
		int[][] graph = {{0, 2, 1, max, max}, {2, 0, 2, 1, 3}, {1, 2, 0, 2, max}, {max, 1, 2, 0, 1},
				{max, 3, max, 1, 0}};
		
		int[] left = new int[n];
		for(int i=0; i<left.length; i++){
			left[i] = -max;
		}
		
		left[0] = money;
		
		for(int i=0; i<graph.length; i++){
			for(int j=i+1; j<graph[i].length; j++){
				if(left[i] - graph[i][j] > left[j])
					left[j] = left[i] - graph[i][j];
			}
		}
		
		for(int i=0; i<left.length; i++)
			System.out.println(left[i]);
		
		System.out.println("Money required to reach from source to destination is :"+(money - left[n-1]));
	}
}
