package Graphs;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int data;
	int[] neighbours = new int[9];
	boolean isVisited;
	int cost;


	public Node(int data){
		this.data = data;
		this.cost = Integer.MAX_VALUE;
		for(int i=0; i<neighbours.length; i++){
			this.neighbours[i] = Integer.MAX_VALUE;
		}
	}

	@Override
	public int compareTo(Node o) {
		Node node = (Node)o;
		return this.cost - node.cost;
	}

	public String toString(){
		return "Data : "+data+" Cost : "+cost;
	}

}
public class DijkstraUsingHeap {

	Map<Integer, Node> mapOfNodes = new HashMap<Integer, Node>();

	public void addEdge(int i, int j, int cost){
		Node source;
		if(mapOfNodes.containsKey(i))
			source = mapOfNodes.get(i);
		else
			source = new Node(i);

		source.neighbours[j] = cost;
		mapOfNodes.put(i, source);
	}

	public void getShortestPath(int source){
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		Node start = mapOfNodes.get(source);
		start.cost = 0;
		start.isVisited = true;
		mapOfNodes.put(source, start);
		pq.add(start);
		while(!pq.isEmpty()){
			Node node = pq.poll();
			node.isVisited = true;
			mapOfNodes.put(node.data, node);
			for(int i=0; i<node.neighbours.length; i++){
				if(node.neighbours[i] != Integer.MAX_VALUE){
					Node temp = mapOfNodes.get(i);
					if((node.cost + node.neighbours[i]) < temp.cost){
						temp.cost = node.cost + node.neighbours[i];
						mapOfNodes.put(i, temp);
						pq.add(temp);
					}
				}
			}
			mapOfNodes.put(node.data, node);
		}
	}

	public static void main(String[] args) {

		DijkstraUsingHeap duh = new DijkstraUsingHeap();
		duh.addEdge(0, 1, 4);
		duh.addEdge(1, 0, 4);
		duh.addEdge(0, 7, 8);
		duh.addEdge(7, 0, 8);
		duh.addEdge(1, 7, 11);
		duh.addEdge(7, 1, 11);
		duh.addEdge(1, 2, 8);
		duh.addEdge(2, 1, 8);
		duh.addEdge(2, 8, 2);
		duh.addEdge(8, 2, 2);
		duh.addEdge(8, 6, 6);
		duh.addEdge(6, 8, 6);
		duh.addEdge(7, 6, 1);
		duh.addEdge(6, 7, 1);
		duh.addEdge(7, 2, 7);
		duh.addEdge(2, 7, 7);
		duh.addEdge(6, 5, 2);
		duh.addEdge(6, 5, 2);
		duh.addEdge(2, 5, 4);
		duh.addEdge(5, 2, 4);
		duh.addEdge(2, 3, 7);
		duh.addEdge(3, 2, 7);
		duh.addEdge(3, 5, 14);
		duh.addEdge(5, 3, 14);
		duh.addEdge(3, 4, 9);
		duh.addEdge(4, 3, 9);
		duh.addEdge(5, 4, 10);
		duh.addEdge(4, 5, 10);

		duh.getShortestPath(0);

		for(Map.Entry<Integer, Node> en : duh.mapOfNodes.entrySet())
			System.out.println(en.getKey()+" "+en.getValue().cost);

	}

}
