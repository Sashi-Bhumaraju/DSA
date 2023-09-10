package DynamicProgramming;

public class AllPaths {
    static int n = 0;
    public static int maxPaths(int[][] a,int i, int j,int[][] mem) {
        if(i == 0 || j == 0) return 1;
        System.out.println(n++);
        if( mem[i][j] != 0 ) return mem[i][j];
       
       int res =  maxPaths(a, i, j-1,mem) +   maxPaths(a, i-1, j,mem);
        mem[i][j] =  res;
        return res;
    }
    public static void main(String[] args) {
        int[][] a = {{0,0,0},
                     {0,0,0},
                     {0,0,0}}; 
        int[][] mem =   {{0,0,0,0},
                        {0,0,0,0}, 
                        {0,0,0,0}, 
                        {0,0,0,0}};             
      
       int m = maxPaths(a,3,3,mem);
       System.out.println(m);
    }
}
