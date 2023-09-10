package Arrays;

import java.io.Console;
import java.util.HashMap;

public class TwoNumberSum {

    public static void main(String[] args) {
        int array[] = {3,5,-4,8,11,1,-1,6};
        System.out.println(twoNumberSum(array, 10)[0]);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) { 
    // Write your code here.
    HashMap<Integer,Integer> result = new HashMap<>(); 
    int i = 0; 
    while ( i < array.length ) { 
          if ( result.containsKey(array[i]) ) { return new int[] { array[i],result.get(array[i]) };  }
          else {  result.put(targetSum - array[i], array[i]); } 
          i++; 
    }
    System.out.println(result); 
    return new int[2]; 
  }

}
