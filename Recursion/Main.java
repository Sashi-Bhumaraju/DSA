package Recursion;


import java.util.*;
public class Main
{
public static void main (String[]args)
{

List < Integer > array = new ArrayList < Integer > ();
array.add (1);
array.add (2);
array.add(3);
// System.out.println( 
       getPermutations(array);
    //    );

}

public static void getPermutations (List < Integer > array)
{
    helperInteration(array,0);
// System.out.println( helper (array,0) );

}




static  List<List<Integer>> helper (List < Integer > array, int idx)
{

if (array.size ()-1 == idx)
{
    List<List<Integer>> result = new ArrayList<>();
   result.add(array);
   return result;
}
List<List<Integer>> result = new ArrayList<>();

for (int i = idx; i < array.size (); i++)
{
     Collections.swap(array,idx,i);
     result.addAll( helper (array, idx+1) );
     Collections.swap(array,idx,i);
}
  return result;
}




static void helperInteration ( List<Integer> array,int idx){
    List<List<Integer>> outer = new ArrayList<>();
    outer.add(array);
    int i = 0;
    // System.out.print(array.size());
    while( i < array.size()) {
        
        int size = outer.size();
        for(int j = 0; j < size; j++) {
           
            for(int k = i + 1; k < array.size();k++) {
                ArrayList<Integer> inner = new ArrayList<Integer>(outer.get(j));
                Collections.swap(inner,i,k);
                outer.add(inner);
                System.out.print(outer.size());
                System.out.print(inner);
                Collections.swap(inner,i,k);
            }
        }
        i++;
    }
    // System.out.print(outer);
    return ;


 

}

}

