package edu.neu.scheduler;

import java.util.Random;


public class ScheduleGenerator {
    
    
//    static int NumberOfDays = 7;
//    static int numberOfShifts = 3;
//    static int graphLength = NumberOfDays * numberOfShifts;
    static int[][] graph = new int[100][100];

    public ScheduleGenerator(int v) throws InvalidEdgeCountException {
        
        int[][] graph = new int[v][v];
        ScheduleGenerator.graph = connectedShifts(graph);

    }

    public static int getVertexCount() {
        return graph.length;
    }

    public static int[][] getGraph() {
        return graph;
    }

    private int[][] connectedShifts(int[][] graph) {
//        Random random = new Random();
        
//            int e1 = random.nextInt(graph.length);
//            int e2 = random.nextInt(graph.length);
            for(int i=0;i<graph.length-1;i++){
            graph[i][i+1]=1;
            graph[i+1][i]=1;
            }
               
            
       
        return graph;
    }

    class InvalidEdgeCountException extends Exception {
        public InvalidEdgeCountException(String s) {
            super(s);
        }
    }

}
