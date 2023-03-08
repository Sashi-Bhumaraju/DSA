package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Fib {

   // top to bottom approach memorization
   public static int getFibNumbers(int n,int[] mem) {
         if(n == 0) return 0;
         if(n == 1) return 1;
         if( mem[n-1] != 0 ) return mem[n-1];
         int r =  getFibNumbers(n-1,mem) +  getFibNumbers(n-2,mem);
         mem[n-1] = r;
         return r;
    }

   //  bottom to top approach DS
   public static int getFibBTT(int n) {
         int first = 0;
         int second = 1;
         for(int i = 2; i <= n; i++) {
              int temp = first + second;
              first = second;
              second = temp;
         }
        return second;  
   }
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int r = getFibNumbers(n,new int[n ]);
      System.out.println(r);
      System.out.print(getFibBTT(n));

    }
}
