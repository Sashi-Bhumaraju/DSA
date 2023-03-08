package DynamicProgramming;

public class FrogJump {
    //  top to bottom 
    public static int frogJump ( int n, int[] array) {
        if( n == 0) return 0;
        int oneStep = frogJump(n-1,array) +  Math.abs(array[n-1] - array[n]);
        int twoStep = (n > 2)? frogJump(n-2,array) +  Math.abs(array[n-2] - array[n]) : Integer.MAX_VALUE;
        return Math.min(oneStep, twoStep);
    }

    //  bottom to top
    public static int frogJumpBTT (int[] array) {
        int dp[] = new int[array.length];
        dp[0] = 0;
        for(int i = 1; i < array.length; i++) {
            int onestep = dp[i-1] + Math.abs( array[i]-array[i-1]);
            int twoStep = (i >= 2)? dp[i-2] + Math.abs( array[i]-array[i-2]) : Integer.MAX_VALUE;
            dp[i] = Math.min(onestep, twoStep);
        }
       return dp[array.length-1];
    }
    public static void main(String[] args) {
        int[] a = {10,20,30,10};
        System.out.println(frogJump(a.length-1, a));
        System.out.print(frogJumpBTT( a));
    }
}
