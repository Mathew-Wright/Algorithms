/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;
import java.util.*;

/**
 * Given N activities with their start and finish times.
 * Select the maximum number of activities that can be performed by a single person,
 * assuming that a person can only work on a single activity at a time.
 * 
 * 
 * https://practice.geeksforgeeks.org/problems/activity-selection/0
 * @author Mathew Wright
 */
class MaxActivitySelection {

    /**
     * Takes console input for activity start/end times and outputs
     * the max number of activities that can be performed by a single person,
     * assuming only one activity can be conducted at a time.
     * 
     * 
     * Input:
     * The first line contains T denoting the number of test cases.
     * Then follows description of test cases. 
     * First line is N number of activities 
     * then second line contains N numbers which are starting time of activities.
     * Third line contains N finishing time of activities.
     * 
     * Output:
     * For each test case, output a single number denoting maximum activities which can be performed in new line.
     * 
     * Example:
     * Input:
     * 2
     * 6
     * 1 3 2 5 8 5
     * 2 4 6 7 9 9
     * 4
     * 1 3 2 5
     * 2 4 3 6
     * 
     * Output:
     * 4
     * 4
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();

        while (testCases > 0) {
            int n = scan.nextInt();

            int[][] activities = new int[n][2];

            for (int i = 0; i < n; i++) {
                activities[i][0] = scan.nextInt();

            }

            for (int i = 0; i < n; i++) {
                activities[i][1] = scan.nextInt();
            }

            MaxActivitySelection gfg = new MaxActivitySelection();
            System.out.println("output: "+gfg.maxActivities(activities));

            testCases--;
        }
    }

    /**
     * Handler method for MaximumActivitySelection problem.
     * Given a list of start and end times for activities, returns the number of maximum
     * activities one person can complete from the list.
     * @param activities the activities, outer index = activity, 
     *      inner index0 = start time,
     *      inner index1 = end time
     * @return the number of maximum activities one person can complete from the list.
     */
    private int maxActivities(int[][] activities) {
        if (activities.length == 0) {
            return 0;
        }

        Arrays.sort(activities, Comparator.comparingInt(arr -> arr[1]));//sort by activity ending time

        int count = 0;
        int lastCompletedActivityTime = 0;

        for (int i = 0; i < activities.length; i++) {
            if (activities[i][0] >= lastCompletedActivityTime) {//if activity starting time is >= time of last completed activity
                //'complete' the activity
                count++;
                lastCompletedActivityTime = activities[i][1];//update time of last completed activity
            }
        }
        return count;
    }
}
