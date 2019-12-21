package com.and.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class AndSibling {

    /**
     * Given a string that contains digits which form an integer, returns all
     * AND-Siblings as a string separated by commas of the formed integer sorted
     * in descending order. Two non-negative integers are called AND-Siblings if
     * they can be obtained by each other by rearranging the digits of their
     * decimal representations.
     *
     * @param input input positive integer, all non-digits are ignored.
     * @return comma separated AND-Siblings of input
     * @throws NumberFormatException when input contains no digits
     */
    public static String solution(String input) throws NumberFormatException {
        //remove all non digits [0..9]
        input = input.replaceAll("\\D", "");
        //check exception case (contains no digits)
        if (input.length() == 0) {
            throw new NumberFormatException("input doesn't contain any digits");
        }

        Set<String> setResult = uniquePermutations("", input);//get all unique permutations

        //store in Integer array
        Integer[] myIntArray = new Integer[setResult.size()];
        Iterator<String> it = setResult.iterator();
        int j = 0;
        while(it.hasNext()){
            myIntArray[j] = Integer.parseInt(it.next());
            j++;
        }

        //sort descending order
        Arrays.sort(myIntArray, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        //convert array to string without spaces
        String result = "";

        for (int i : myIntArray) {
            result += i;
            result += ",";
        }
        result = result.substring(0, result.length() - 1);//remove last comma

        System.out.println(result);

        return result;

    }
    
    /**
     * Given a fixed prefix and the remaining chars, returns all permutations
     * that start with the fixed prefix and contains the permutations chars
     *
     * @param fixedPrefix fixed prefix for child permutations (initial value =
     * "")
     * @param rem remaining chars to get permutations for
     * @return all permutations that start with the fixed prefix and contains
     * the permutations chars
     */
    private static Set<String> uniquePermutations(String fixedPrefix, String rem) {
        
        Set<String> results = new HashSet<>();
        if (rem.length() == 0){//base case - no more child permutations
            results.add(fixedPrefix);
        }else{
            
            for (int i = 0; i < rem.length(); i++){    
                results.addAll(uniquePermutations(fixedPrefix + rem.charAt(i), rem.substring(0, i) + rem.substring(i+1)));
            }
        }
        return results;
    }

    /**
     * provided main method. Gets all AND-siblings of 326
     * @param args 
     */
    public static void main(String args[]) {
        solution("326");
    }

}
