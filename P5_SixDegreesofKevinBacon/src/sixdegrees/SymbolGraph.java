/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sixdegrees;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

public class SymbolGraph {
    private Graph G;
	private Map<String, Integer> tm = new TreeMap<>();
	private String[] keys; 

    /**  
     * Initializes a graph from a file using the specified delimiter.
     * Each line in the file contains
     * the name of a vertex, followed by a list of the names
     * of the vertices adjacent to that vertex, separated by the delimiter.
     * @param filename the name of the file
     * @param delimiter the delimiter between fields
     */
    public SymbolGraph(String filename, String delimiter) throws FileNotFoundException, IOException {
        // First pass builds the index by reading strings to associate
        // distinct strings with an index
        BufferedReader reader = new BufferedReader(new FileReader(
            new File(filename)));
        String line;
        int counter = 0; 
        while ((line = reader.readLine()) != null) {  
            String[] data = line.split(delimiter);
            for (String s: data) 
            	if (!tm.containsKey(s))  
                    tm.put(s, counter++);
        }
        System.out.println("Done reading " + filename);
        keys = new String[tm.size()];
        for (String name: tm.keySet()) 
        	keys[tm.get(name)] = name;
        // second pass builds the graph by connecting first vertex on each
        // line to all others  
        G = new Graph(counter);
        reader = new BufferedReader(new FileReader(
            new File(filename)));
        while ((line = reader.readLine()) != null) { 
            String[] data = line.split(delimiter);
            int v = tm.get(data[0]);
            for (int i = 1; i < data.length; i++) { 
            	G.addEdge(v, tm.get(data[i]));
            }
        }
    }

    /**
     * Does the graph contain the vertex named s
     * @param s the name of a vertex
     * @return true if s is the name of a vertex, and false otherwise
     */
    public boolean contains(String s) {
        return tm.containsKey(s);
    }
    /**
     * return the adjacent vertices of a vertex named s
     */
    public Bag<String> neighbors(String s){
        Bag<String> ls = new Bag<>();
        for (int w: G.adj(tm.get(s))) 
        	ls.add(keys[w]);
        return ls;
    }
    /**
     * return a list of movie title, actors, or actresses 
     * if their names have s as a substring
     */
    public Bag<String> list(String s){
        Bag<String> ls = new Bag<>();
        for(Map.Entry<String,Integer> entry: tm.entrySet()) {
        	  String key = entry.getKey();
        	  if (key.contains(s)) ls.add(key);
        }
        return ls;
    }
    /**
     * Returns the integer associated with the vertex named s.
     * @param s the name of a vertex
     * @return the integer (between 0 and V - 1) associated with the vertex named s
     */
    public int index(String s) {
    	return tm.get(s);
    }

    /**
     * Returns the name of the vertex associated with the integer v.
     * @param v the integer corresponding to a vertex (between 0 and V - 1) 
     * @return the name of the vertex associated with the integer <tt>v</tt>
     */
    public String name(int v) {
    	return keys[v];
    }

    /**
     * Returns the graph associated with the symbol graph. It is the client's responsibility
     * not to mutate the graph.
     * @return the graph associated with the symbol graph
     */
    public Graph G() {
        return G;
    }
}