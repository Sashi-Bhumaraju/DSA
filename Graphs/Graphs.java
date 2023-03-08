package Graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class Graphs {
   public static class Graph {
        HashMap<Integer,ArrayList<Integer>> adjList = new HashMap<>();
        Graph(int n) {
           for(int i = 0 ; i < n ; i++ ) {
            adjList.put(i, new ArrayList<Integer>());
           }
        }

        void addEdge(int u, int v) {
             adjList.get(u).add(v);
             adjList.get(v).add(u);
        }

        void print() {
            System.out.println(adjList);
        }

        void BFS () {
            
        }

    }
    public static void main(String[] args) {
        Graph g = new Graph(5);
        int[][] e = { {0,1},{0,4}, {1,3}, {1,2}, {2,3}, {3,4}};
        for(int i = 0; i < e.length; i++) {
                g.addEdge(e[i][0], e[i][1]);
        }
        g.print();


    }
}
