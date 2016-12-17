/**
* Word frequency counter
 */
package frequency;
import java.util.Iterator;
/**
 *
 * @author UMD CS
 */
public class Frequency implements Iterable<String>{
    private Node first;
    private int N;
    Frequency(){
        N = 0;
        first = null;
    }

    @Override
    public Iterator<String> iterator() {
        return new ListIterator();
    }
    /**
     * 
     * List iterator
     *
     */
    private class ListIterator implements Iterator<String>{
        private Node current;
        private int index;
        ListIterator(){
            current = first;
            index = 0;
        }
                
        @Override
        public boolean hasNext() {
            return current != null;
        }

        
        public String next() {
            if(!hasNext()){
                return null;
            }
            String word = current.key;
            int count = current.count;
            String r = "("+word + "," + Integer.toString(count)+")";
            current = current.next;
            return r;
        }

        @Override
        public void remove() {
            
        } 
    }
    /**
     * 
     * Node class
     *
     */
    private class Node {
        private String key;
        private int count;
        private Node next;
        Node(String item){
            key = item;
            count = 1;
            next = null;
        }
        @Override 
        public String toString(){
        	return "("+key +","+count+")";
        }
    }
    
    /*
     * Inserts a word into the linked list. If the word exists, increment the 
     * count by q. 
     * @param String word 
     */
    public void insert(String word){
        if(word.equals("")) return; 
        Node current;
    	Node prev = null; 
    	Node temp = processNode(word);
    	current = first; 
        if (temp != null) { // the list contains the word
            if (first == null) { 
            	first = temp; 
            	N++; 
            	return; 
            }
            if (temp.count > first.count) {
            	Node oldfirst = first;
            	first = temp;
            	first.next = oldfirst;
            	N++;
            	return;
            } 
            if (temp.count == current.count && current.key.compareTo(word) >= 0) {
            	Node oldfirst = first;
            	first = temp;
            	first.next = oldfirst;
            	N++;
            	return;
            }
            prev = current;
            current = current.next;
            while (current != null) { 
            	if (current.count < temp.count) { 
            		prev.next = temp; 
            		temp.next = current;
            		N++;
            		return;            		
            	}
            	if (current.count == temp.count && current.key.compareTo(word) > 0) { 
            		prev.next = temp; 
            		temp.next = current;
            		N++;
            		return; 
            	} 
            	prev = current; 
            	current = current.next;
            	if (prev.count < temp.count) break; 
            }
            if (current == null)
            	prev.next = temp; 
            N++;
            return;
        } else { // there's no such word in the list
	        temp = new Node(word);
	        if (first == null) { 
	        	first = new Node(word); 
	        	N++;
	        	return; 
	        }
	        if (current.count == 1 && current.key.compareTo(word) > 0) {
	    		Node oldfirst = first;
	    		first = temp; 
	    		first.next = oldfirst; 
	    		N++; 
	    		return; 
	    	}
	        prev = current;
	        current = current.next;
	        while (current != null) { 
	        	if (current.count == 1 && current.key.compareTo(word) > 0) { 
	        		prev.next = temp; 
	        		temp.next = current;
	        		N++;
	        		return; 
	        	} 
	        	prev = current; 
	        	current = current.next;
	        }
	        if (current == null)
	        	prev.next = temp; 
	        N++;
	        return; 
        } 
    }
    
    /**
    * This method take out the Node from the list and increment count by 1  
    * @param word 
    * @return Node 
    */
    private Node processNode(String word) {
    	Node prev = null; 
    	Node current = first; 
    	Node temp; 
    	if (current == null) { 
    		return null; 
    	}
    	if (current.key.equals(word)) { 
    		temp = first; 
    		first = first.next; 
    		temp.count++; 
    		return temp; 
    	}
    	prev = current; 
		current = current.next; 
    	while (current != null) { 
    		if (current.key.equals(word)) { 
    			temp = current; 
    			prev.next = current.next; 
    			temp.count++; 
    			return temp; 
    		}
    		prev = current; 
    		current = current.next; 
    	}
    	return null; 
    }
    
     /**
     * 
     * @param str input string
     * This method splits a string into words and pass the words to insert method
     * 
     */
    public void insertWords(String str){
        String delims = "[ .,?!'\"()}{;/<>&=#-:\\ _]+";
        String[] words = str.split(delims);
        for(String s: words){
            s = s.toLowerCase();
            insert(s);
        }
    }
    /**
     *  prints the word frequency list
     */
    
    public void print(){
        Node c = first;
        while(c != null){
            System.out.print("("+c.key + "," + c.count+")");
            c = c.next;
        }
        System.out.print("\n");
    }
}
   