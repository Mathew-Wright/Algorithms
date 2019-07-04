/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

//Initial Template for Java from G4G
import java.util.*;

/**
 * A group of connected 1's forms an island. 
 * The task is to complete the method findIslands() which returns the number of islands present. 
 * The function takes three arguments the first is the boolean matrix A 
 * and then the next two arguments are N and M denoting the size(N*M) of the matrix A.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/find-the-number-of-islands/1
 * @author template provided by G4G
 */
class NumberOfIslands{
    /**
     * Takes formulated console input for an 'area' and prints out the number of islands in the area
     * 
     * Input:
     * The first line of input will be the number of test cases T, 
     * then T test cases follow. 
     * The first line of each test case contains two space separated integers N and M. 
     * Then in the next line are the NxM inputs of the matrix A separated by space.
     * 
     * Output:
     * For each test case in a new line, print the number of islands present.
     * 
     * Input
     * 2
     * 3 3
     * 1 1 0 0 0 1 1 0 1
     * 4 4
     * 1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0
     *  
     * Output
     * 2
     * 2
     * @param args 
     */
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
            
            // creating arraylist of arraylist
            for(int i = 0; i < N; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }
            
            // adding elements to the arraylist of arraylist
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < M; j++)
                {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }
            
            
            System.out.println("output: "+new Islands().findIslands(list, N, M));
            
        }
    }
}

class Islands{
    /**
     * Given a grid which represents an area, return the number of island in the area.
     * An island consists of adjacent 1's in the grid.
     * 
     * @param list the area to check
     * @param N number of columns in area
     * @param M number of rows in area
     * @return 
     */
    static int findIslands(ArrayList<ArrayList<Integer>> list, int N, int M){
        
        int yLen = N;
        int xLen = M;
        
        int islands = 0;
        int[][] area = new int[yLen][xLen];
        
        for (int y = 0; y < yLen; y++){
            for (int x = 0; x < xLen; x++){
                area[y][x] = list.get(y).get(x);
            }
        }
        
        for (int y = 0; y < yLen; y++){
            for (int x = 0; x < xLen; x++){
                
                if (area[y][x] == 1){
                    expandIsland(area, y, x, yLen, xLen);
                    islands++;
                }
            }
        }
        return islands;
    }
    
    
    /**
     * Recursively does DFS to attach adjacent '1' nodes to the initial node 
     * 
     * @param area the area to pull islands from
     * @param y initial y coord
     * @param x initial x coord
     * @param yLimit number of columns in area grid
     * @param xLimit number of rows in area grid
     */
    private static void expandIsland(int[][] area, int y, int x, int yLimit, int xLimit){
        area[y][x] = 0;
        int[][] neighbors = {{-1,-1},{-1,0},{-1,+1},
                           {0,-1},        {0,+1},
                           {+1,-1},{+1,0},{+1,+1}};
                           
        int nextY;
        int nextX;
        for (int[] neighbor : neighbors){
            nextY = y + neighbor[1];
            nextX = x + neighbor[0];
            if(nextY >= 0 && nextY<yLimit && nextX>=0 && nextX < xLimit){
                if (area[nextY][nextX] == 1){
                    expandIsland(area, nextY, nextX, yLimit, xLimit);
                }    
            }
            
        }    
        
    }
    
}