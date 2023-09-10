package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateSubsequence {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(5,1,22,25,6,-1,8,10));
        ArrayList<Integer> sequence = new ArrayList<>(Arrays.asList(1,6,-1,10));
        System.out.println(isValidSubsequence(array, sequence));
    }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
    int i = 0;
    for ( int j = 0; j < array.size(); j++) {  if( i < sequence.size() && array.get(j) == sequence.get(i)  ) i++; };
    return i == sequence.size();
  }

}
