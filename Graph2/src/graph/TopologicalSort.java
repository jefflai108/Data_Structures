package graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {

	private EdgeWeightedDigraph G;
	public TopologicalSort(EdgeWeightedDigraph g){
		this.G = g;
	}
	// A recursive function used by topologicalSort
    void topologicalSortUtil(int v, Boolean visited[], Stack stack)
    {
        // Mark the current node as visited.
        visited[v] = true;
        DirectedEdge e;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<DirectedEdge> it = G.adj(v).iterator();
        while (it.hasNext())
        {
            e = it.next();
            //System.out.println(i);
            if (!visited[e.to()])
                topologicalSortUtil(e.to(), visited, stack);
        }
 
        // Push current vertex to stack which stores result
        stack.push(new Integer(v));
    }
 
    // The function to do Topological Sort. It uses recursive
    // topologicalSortUtil()
    void topologicalSort()
    {
        Stack stack = new Stack();
 
        // Mark all the vertices as not visited
        Boolean visited[] = new Boolean[G.V()];
        for (int i = 0; i < G.V(); i++)
            visited[i] = false;
 
        // Call the recursive helper function to store Topological
        // Sort starting from all vertices one by one
        for (int i = 0; i < G.V(); i++)
            if (visited[i] == false)
                topologicalSortUtil(i, visited, stack);
 
        // Print contents of stack
        while (stack.empty()==false)
            System.out.print(stack.pop() + " ");
    }
 
	
	public static void main(String[] args) {
		
/**		
		(5)           (4)
	    /    \        / \
	  //       \\   //   \\
	 (2)        (0)     (1)
	  \                //
 	    \            /
	       \\      /
 	         (3)
*/
		// Create a graph given in the above diagram
		EdgeWeightedDigraph g = new EdgeWeightedDigraph(6);
        g.addEdge(new DirectedEdge(5, 2,1));
        g.addEdge(new DirectedEdge(5, 0,1));
        g.addEdge(new DirectedEdge(4, 0,1));
        g.addEdge(new DirectedEdge(4, 1,1));
        g.addEdge(new DirectedEdge(2, 3,1));
        g.addEdge(new DirectedEdge(3, 1,1));
 
        System.out.println("Following is a Topological " +
                           "sort of the given graph");
        TopologicalSort s = new TopologicalSort(g);
        s.topologicalSort();
	}

}
