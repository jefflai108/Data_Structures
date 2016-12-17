package graph;

public class DepthFirstSearch {
    private boolean[] marked;    // marked[v] = is there an s-v path?
    private int count;           // number of vertices connected to s


    public DepthFirstSearch(Graph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    // depth first search from v
    private void dfs(Graph G, int v) {
        count++;
        System.out.print(v+",");
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    
    public boolean isCyclic(Graph g){
		for(int i = 0; i < marked.length; i++){
			marked[i] = false;
		}
		return isCyclic(g,0,-1);
	}
	
	private boolean isCyclic(Graph g, int s, int parent){
		System.out.print(s+",");
		marked[s] = true;
		Iterable<Integer> iter = g.adj(s);
		for(int t: iter){
			if(!marked[t]){
				return isCyclic(g,t,s);
			}else{
				if(t != parent) 
					return true;
			}
		}
		return false;
	}

    /**
     * Is there a path between the source vertex <tt>s</tt> and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, <tt>false</tt> otherwise
     */
    public boolean marked(int v) {
        return marked[v];
    }

    /**
     * Returns the number of vertices connected to the source vertex <tt>s</tt>.
     * @return the number of vertices connected to the source vertex <tt>s</tt>
     */
    public int count() {
        return count;
    }

    /**
     * Unit tests the <tt>DepthFirstSearch</tt> data type.
     */
    public static void main(String[] args) {
        /*
         *   (0) -----------(2)               /(6)
         *    |              |  \            /  |
         *    |              |    \         /   |
         *    |              |     (4)----(5)   |
         *    |	             |    /         \   |
         *    |              |   /           \  |
         *   (1)------------(3) /             \(7)
         * 
         * 
         * 
         */
    	
    	
        Graph G = new Graph(8);
        G.addEdge(0, 1);
        G.addEdge(0, 2);
        G.addEdge(1,3);
        G.addEdge(2, 3);
        G.addEdge(2, 4);
        G.addEdge(3, 4);
        G.addEdge(4, 5);
        G.addEdge(5, 6);
        G.addEdge(5, 7);
        G.addEdge(6, 7);
        System.out.println(G);
        int s = 0;
        System.out.println("Depth First Search:");
        DepthFirstSearch search = new DepthFirstSearch(G, s);
        
        if(search.isCyclic(G)){
			System.out.println("\nCycle detected");
		}else{
			System.out.println("\nNo cycle found");
		}
        
        
        System.out.println("\nConnected vertices:");
        for (int v = 0; v < G.V(); v++) {
            if (search.marked(v))
                System.out.print(v + " ");
        }

        System.out.println();
        if (search.count() != G.V()) System.out.println("NOT connected");
        else                         System.out.println("connected");
    }

}
