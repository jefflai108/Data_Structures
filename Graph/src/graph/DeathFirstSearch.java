package graph;

public class DeathFirstSearch {
	private boolean visited[]; 
	public DeathFirstSearch(Graph g, int s) { 
		visited = new boolean[g.V()];
		dfs(g, s);
	}
	private dfs(Graph g, int s) { 
		System.out.println(s);
		visited[s] = true; 
		for (int t: g.adj(s)) { 
			if (!visited[t]) dfs(g,t);
		}
	}
	public static void main(String[] args) { 
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 2);
		DeathFirstSearch d = new DeathFirstSearch(g,0);
	}
}
