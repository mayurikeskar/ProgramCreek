/**
 * You are given a graph with no cycles, each node representing different cities and there are stadiums for baseball games in all cities. 
 * Each node contains a value representing the population of the city, and a list of neighbors. (feel free to extend data structure) 
 * Every time there is a baseball game at a city, everyone from all the different cities will go to the city with the baseball game. 
 * Return the maximum traffic between a city and its neighbors when there is a game at that city, for all cities. (Does not have to be sorted) 
 * The total run-time after returning everything should be O(n). 
 */

package Graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class TravelToCity{
	public static void main(String[] args) {

		City c1 = new City(1);
		City c2 = new City(2);
		City c3 = new City(3);
		City c4 = new City(4);
		City c5 = new City(5);
		City c7 = new City(7);
		City c15 = new City(15);
		City c8 = new City(8);
		City c38 = new City(38);

		c1.neighbors.add(c5);
		c2.neighbors.add(c5);
		c3.neighbors.add(c5);
		c4.neighbors.add(c5);
		c2.neighbors.add(c7);
		c2.neighbors.add(c15);
		c5.neighbors.add(c1);
		c5.neighbors.add(c3);
		c5.neighbors.add(c4);
		c5.neighbors.add(c2);
		c7.neighbors.add(c2);
		c15.neighbors.add(c2);
		c8.neighbors.add(c7);
		c7.neighbors.add(c8);
		c8.neighbors.add(c38);
		c38.neighbors.add(c8);

		Queue<City> queue = new LinkedList<City>();

		int totalPopulation = 0;
		for (City c : new City[] { c1, c2, c3, c4, c5, c7, c15, c8 , c38 }) {
			totalPopulation += c.population;
			if (c.neighbors.size() == 1) {
				queue.add(c);
			}
		}

		while (!queue.isEmpty()) {
			City c = queue.remove();
			int maxPopulation = totalPopulation - c.sumPopulation - c.population;
			maxPopulation = maxPopulation > c.maxPopulation ? maxPopulation : c.maxPopulation;
			System.out.println(c.population + ":" + maxPopulation);
			if (c.neighbors.isEmpty()) {
				continue;
			}
			City linked = c.neighbors.iterator().next();
			linked.neighbors.remove(c);
			if (linked.neighbors.size()==1) {
				queue.offer(linked);
			}

			linked.maxPopulation = linked.maxPopulation < c.sumPopulation + c.population ? c.sumPopulation
					+ c.population : linked.maxPopulation;
			linked.sumPopulation += c.population + c.sumPopulation;
		}

	}
}
class City {
	int population;

	Set<City> neighbors = new HashSet<City>();

	// helpers
	int maxPopulation;
	int sumPopulation;

	City(int population) {
		this.population = population;
	}
	
	public String toString(){
		return ""+population;
	}
}


