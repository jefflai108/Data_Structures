package loopbag;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

/**
 *
 * @author anwar mamat
 */
public class Main {

    public static void main(String[] args) {
        LoopBag<Integer> bag1 = new Bag(5);
        LoopBag<Integer> bag2 = new Bag(5);
        bag1.insert(1);
        bag1.insert(2);
        bag1.insert(3);
        bag2.insert(1);
        bag2.insert(4);
        bag2.insert(5);
        bag2.insert(6);
        bag1.union(bag2);
        String answer="2,3,4,5,6,";
        System.out.println(bag1.toString());
//    		LoopBag<Integer> bag = new Bag(5);  
//    		LoopBag<Integer> bag2 = new Bag(5);  
//    		for(int i = 1; i <= 5; i++){
//    			bag.insert(i);
//    		}
//    		System.out.println(bag.toString());
//    		bag2.insert(5);
//    		bag2.insert(6);
//    		bag2.insert(7);
//    		bag2.insert(8);
//    		bag2.insert(1);
//    		bag.union(bag2);
//    		System.out.println(bag.toString());
    }
}
