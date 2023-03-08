package Recursion;

import java.lang.reflect.Array;
import java.util.ArrayList;

class RemoveChar {
   public static void main(String[] args) {
    
    // helper("baccad",0);
     System.out.println(  helper("bacapplecad"));
   }




  static  ArrayList<Character> helper(String src) {
    if(src.isEmpty()) {
        ArrayList<Character>  r = new ArrayList<Character>();
        return r;  }
        // System.out.print(src);
        ArrayList<Character>  r = new ArrayList<Character>();
    if( src.startsWith("app") ){
           r.addAll( helper( src.substring(3)));
    } else {
       r.add(src.charAt(0));
    r.addAll(  helper( src.substring(1)));
    }
    return r;
   }



}