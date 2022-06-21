package Graphs;
import java.util.*;

public class Graph {
	private int V;
	private LinkedList<Integer> adjlist[];

	// Create a graph
	Graph(int v) {
		V = v;
		adjlist = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adjlist[i] = new LinkedList();
	}

	// Add edges to the graph
	void addEdge(int v, int w) {
		adjlist[v].add(w);
	}

	// BFS Algorithm
	void BFS(int s) {
		LinkedList<Integer> queue = new LinkedList();
		boolean visited[] = new boolean[V];
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adjlist[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}
	}

	//DFS Algorithm
	void DFS(int v) {
		boolean visited[] = new boolean[V];
		dfs(v, visited);
	}

	void dfs(int v, boolean visited[]) {
		visited[v] = true;
		System.out.print(v + " ");
		Iterator<Integer> i = adjlist[v].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				dfs(n, visited);
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(7);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 5);
		g.addEdge(3, 6);
		g.addEdge(3, 4);
		g.addEdge(1, 0);
		g.addEdge(2, 0);
		g.addEdge(5, 3);
		g.addEdge(6, 3);
		g.addEdge(4, 3);

		System.out.print("Breadth First Traversal (starting from vertex 0) : ");
		g.BFS(0);
		System.out.println();
		System.out.print("Depth First Traversal (starting from vertex 0) : ");
		g.DFS(0);
	}
}
