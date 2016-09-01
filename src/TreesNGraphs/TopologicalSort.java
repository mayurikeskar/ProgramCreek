package TreesNGraphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	boolean[][] adjMatrix;

	public TopologicalSort(int n){
		adjMatrix = new boolean[n][n];
	}

	public void addEdge(int source, int dest){
		adjMatrix[source][dest] = true;
	}

	public Stack<Integer> execute(){
		boolean[] isVisited = new boolean[adjMatrix.length];

		Stack<Integer> stack = new Stack<Integer>();
		List<Integer> set = new ArrayList<Integer>();
		Stack<Integer> result = new Stack<Integer>();
		int random = (int)(Math.random() * 5);

		stack.push(random);
		set.add(random);
		//isVisited[random] = true;

		while(!stack.isEmpty()){
			boolean flag = false;
			int temp = stack.pop();
			isVisited[temp] = true;
			for(int i=0; i<adjMatrix.length; i++){
				if(adjMatrix[temp][i] && !isVisited[i]){
					stack.push(i);
					set.add(i);
					flag = true;
					break;
				}
			}

			if(!flag){
				while(!set.isEmpty()){
					result.push(set.remove(0));
				}

				while(true){
					random = (int) (Math.random() * 5);
					if(!isVisited[random]){
						stack.push(random);
						set.add(random);
						break;
					}
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {

		int n = 8;
		TopologicalSort sort = new TopologicalSort(n);
		sort.addEdge(0, 2);
		sort.addEdge(1, 2);
		sort.addEdge(1, 3);
		sort.addEdge(2, 7);
		sort.addEdge(2, 4);
		sort.addEdge(4, 5);
		sort.addEdge(5, 6);

		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				System.out.print(sort.adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
		Stack<Integer> s = sort.execute();

		while(!s.isEmpty())
			System.out.print(s.pop()+" ");
	}

}
