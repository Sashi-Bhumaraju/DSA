package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetsIteration {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>();
        array.add(1);
        array.add(2);
        array.add(3);
   System.out.println(     powerset( array) );
    
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        // Write your code here.
        List<Integer> result = new ArrayList<Integer>();
        return helper(result,array);
      }
    

      static  List<List<Integer>>  helper(List<Integer> result, List<Integer> array) {
          if(array.size() == 0) {
              List<List<Integer>> answer = new ArrayList<>();
              List<Integer> a = new ArrayList<Integer>(result);
             
              answer.add(a);
              // System.out.println(result);
              return answer;
          }
             List<List<Integer>> answer = new  ArrayList<>();
        
             List<Integer> newResult = new ArrayList<Integer>(result);
             List<Integer> tempArray = new ArrayList<Integer>(array);
        
            System.out.println(newResult);
             Integer num =  Integer.valueOf(tempArray.get(0));
             newResult.add(num);
              System.out.println(newResult);
         
              tempArray.remove(0);
            
            //   System.out.println(newResult);
              answer.addAll(  helper(result,tempArray));
              answer.addAll(helper(newResult,tempArray));
        
         return answer;
          
        
      }
}
