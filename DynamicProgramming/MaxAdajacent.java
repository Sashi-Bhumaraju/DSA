package DynamicProgramming;

public class MaxAdajacent {
    //  top to bttom approach
    public static int maxAdajacentMem (int arr[], int n, int[] mem) {
        if(n == 0) {
            return arr[n];
        }
        if(n < 0) return 0;
        if(mem[n] != 0) return mem[n];
        System.out.print("called.....");
        int cur = arr[n];  
        int left = cur +  maxAdajacentMem ( arr,  n-2, mem );
        int right = maxAdajacentMem ( arr,  n-1, mem );
        return mem[n] = Math.max(left, right);
    }

      //  bottom to top approach
      public static int maxAdajacentTab (int arr[]) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[1],arr[0]);
        for(int i =2 ; i < arr.length; i++) {
            int pick = arr[i] + dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick,notPick);
        }
      return  Math.max(dp[arr.length -1 ], dp[arr.length-2]);
    }

    public static void main(String[] args) {
        int[] arr = { 2,1,4,9  };
        int[] mem = new int[arr.length];
        // int r  = maxAdajacentMem ( arr,  3, mem);
        int r  = maxAdajacentTab ( arr);
        System.out.print(r);

    }
}
