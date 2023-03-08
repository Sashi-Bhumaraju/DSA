package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.print.attribute.IntegerSyntax;

public class Subset {
    public static void main(String[] args) {
        ArrayList<Integer> n = new ArrayList<Integer>();
        n.add(1);
        n.add(2);
        n.add(3);
    System.out.println(    subsetIteration(n) );
    }

    //recursion
  static  ArrayList<String> subset(String p, String up ) {

        if(up.length() == 0) {
            ArrayList<String> ans = new ArrayList<String>();
            ans.add(p);
            return ans;
            // System.out.println(p);
        }
        ArrayList<String> ans = new ArrayList<String>();

     String np = p+ up.charAt(0);
        up = up.substring(1);
        ans.addAll( subset(p,up));
        ans.addAll( subset( np,up ));
        return ans;
       
    }


    //  Iteration
   static   ArrayList<ArrayList<Integer>> subsetIteration ( ArrayList<Integer> num ) {
      ArrayList<ArrayList<Integer>> outerArray = new   ArrayList<ArrayList<Integer>>();
      ArrayList<Integer> k= new ArrayList<Integer>();
      k.add(1);

           outerArray.add(k);
            for(int nu : num){
                    for(int i = 0; i < outerArray.size(); i++ ) {
                        ArrayList<Integer> inner = new   ArrayList<>(outerArray.get(i));
                        inner.add(nu);
                        outerArray.add(inner);
                    }



            };
            return outerArray;
   }

}
