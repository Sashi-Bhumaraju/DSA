package Recursion;

import java.util.ArrayList;

public class Permutation {
    public static void main(String[] args) {
     System.out.println(   permutation(" ", "abc"));
    }


    static ArrayList<String> permutation(String result, String input) {
           if(input.isEmpty()) {
            ArrayList<String> list = new ArrayList<String>();
            list.add(result);
            return list;
           }

           ArrayList<String> temp =new  ArrayList<String>();

           char addThisChar = input.charAt(0);
           for(int i = 0; i < result.length(); i ++ ) {

               String  left = result.substring(0, i);
               String right = result.substring(i);
               String newResult = left + addThisChar + right;
             temp.addAll(  permutation(newResult,input.substring(1)));
           }

          return temp;
    }


    



}
