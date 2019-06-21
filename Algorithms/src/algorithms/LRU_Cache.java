/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 * The task is to design and implement methods of an LRU cache. The class has two methods get() and set() which are defined as follows.
 * get(x)   : Returns the value of the key x if the key exists in the cache otherwise returns -1.
 * set(x,y) : inserts the value if the key x is not already present. If the cache reaches its capacity
 * it should invalidate the least recently used item before inserting the new item.
 * In the constructor of the class the size of the cache should be initialised.
 * 
 * Example(To be used only for expected output):
 * Input:
 * 2
 * 2
 * 2
 * SET 1 2 GET 1
 * 2
 * 7
 * SET 1 2 SET 2 3 SET 1 5 SET 4 5 SET 6 7 GET 4 GET 1
 * 
 * Output:
 * 2
 * 5 -1
 * 
 * https://practice.geeksforgeeks.org/problems/lru-cache/1
 * @author Mathew Wright
 */
import java.util.Scanner;
import java.util.*;

/**
 * Converts formatted input to LRU_Cache instructions
 * 
 * @author This class is provided by Geeks for Geeks
 */
class LRU_Cache {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            Set<Integer> s = new HashSet<Integer>();
            int n = sc.nextInt();
            LRUCache g = new LRUCache(n);
            int q = sc.nextInt();

            while (q > 0) {

                String c = sc.next();
                //	System.out.println(c);
                if (c.equals("GET")) {
                    int x = sc.nextInt();
                    System.out.print(g.get(x) + " ");
                }
                if (c.equals("SET")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();
                    g.set(x, y);
                }

                q--;
                //System.out.println();
            }
            t--;
            System.out.println();
        }
    }
}


/*This is a function problem.You only need to complete the function given below*/
/*You are required to complete below class */

/**
 * Implementation of a Least Recently Used Cache
 * @author Mathew Wright
 */
class LRUCache {

    private HashMap<Integer, Integer> map;
    private int capacity;
    private Queue<Integer> queue;


    /**
     * Initialise an LRU cache with size N
     * @param N size of cache
     */
    public LRUCache(int N) {
        map = new HashMap<>();
        capacity = N;
        queue = new LinkedList<>();
    }


    /**
     * Returns the value of the key x if present else returns -1
     * @param x the key of the value you wish to get
     * @return the value assigned to the key x, -1 if key not found
     */
    public int get(int x) {

        if (map.containsKey(x)) {
            queue.remove(x);
            queue.add(x);
            return map.get(x);
        }
        return -1;
    }


    /**
     * Sets the key x with value y in the LRU cache
     * @param x key
     * @param y value
     */
    public void set(int x, int y) {

        if (map.containsKey(x)) {
            map.put(x, y);
            queue.remove(x);

        } else {
            if (map.size() == capacity) {
                map.remove(queue.poll());
            }
            map.put(x, y);

        }
        queue.add(x);
    }
}
