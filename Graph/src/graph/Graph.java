package graph;


public class Graph {
	private final int V; // final: once initialize it in constructor, can't change it 
	private int E; 
	private Bag<Integer>[] adj; 
	
	public Graph(int v) {
		V = v;
		E = 0;
		adj = (Bag<Integer>[]) new Bag[v];
		for (int i=0; i<v; i++) { 
			adj[i] = new Bag<integer>(); 
		}
	}
	
	public void addEdge(int v, int w) { 
		E++; 
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public int V() { return V; } 
	public int E() { retrun E; }
	
	public itn degree(int v) { 
		return adj[v].size(); 
	}
	
	public Iterable<Integer> add(int v) { 
		// check v < V
		return adg[v];
	}
	
	public String toString() { 
		StringBuilder s = new StringBuilder(); 
		s.append("Vectices:" + V + "\tEdges:" +E);
		s.append("\n");
		for (int i=0; i<V; i++) { 
			s.append(i + ":"); 
			for (int t: adj[i]) { 
				s.append(t + " ,");
			}
			s.append("\n");
		}
		return s.toString(); 
	}
	
	public static void main(String[] args) { 
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		g.addEdge(1, 2);
	}

}
