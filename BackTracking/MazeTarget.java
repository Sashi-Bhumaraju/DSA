package BackTracking;

import java.nio.file.Path;

public class MazeTarget {

    public static int findAllPossibleWays(String path, int r , int c) {
        if(r == 1 || c == 1 ) { 
            System.out.println(path);
            return 1;}
        
       return findAllPossibleWays(path+"D",r-1,c) +  findAllPossibleWays(path+"R",r,c-1);
    }

    // in right and down directions only
    public static void findAllPossiblePaths(String path, int r , int c) {
        if(r == 1 && c == 1 ) { 
            System.out.println(path);
           }
        if( r > 1)  {
            findAllPossiblePaths( path+"D" ,  r-1 , c);
        } 
        if( c > 1) {
            findAllPossiblePaths( path+"R" ,  r , c-1);
        }
       
    }

    // right down diagnolly 
    public static void findAllPossiblePathsDaignolly(String path, int r , int c) {
        if(r == 1 && c == 1 ) { 
            System.out.println(path);
           }
        if( r > 1)  {
            findAllPossiblePaths( path+"D" ,  r-1 , c);
        } 
        if(r > 1 && c > 1)
        findAllPossiblePaths( path+"C" ,  r-1 , c-1);
        if( c > 1) {
            findAllPossiblePaths( path+"R" ,  r , c-1);
        }
       
    }

    // maze with obstacles 
    public static void obstacleMazePath ( String path, int[][] maze, int r, int c) {
        if( r == maze.length-1 && c == maze[0].length - 1 ) {
            System.out.println(path);
        }

        if( maze[r][c] == 0) return;
        if( r < maze.length - 1 )  obstacleMazePath (path+"V"  ,  maze,  r+1,  c); 
        // if( r < maze.length -1 && c < maze[0].length -1 )  obstacleMazePath (path+"D",  maze,  r+1,  c);  
        if( c < maze[0].length -1 ) obstacleMazePath (path+"H"  ,  maze,  r,  c+1); 
    }

    public static void main(String[] args) {
        // System.out.println( findAllPossibleWays("",3,3));
        // findAllPossiblePaths("",3,3);
        // findAllPossiblePathsDaignolly("",3,3);
        int[][] maze = {
                        {1,1,1},
                        {1,0,1},
                        {1,1,1},
        };
        obstacleMazePath (  "",  maze,  0,  0) ;
    }
}
