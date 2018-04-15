package edu.neu.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Random;
import java.util.stream.IntStream;


public class EmpList {

    private static Logger LOGGER = LogManager.getLogger(EmpList.class.getName());

    int[] empSet;

    public EmpList() {
        empSet = new int[ScheduleGenerator.getVertexCount()];
    }


    public void generateSet(int numberOfEmp) {

        Random random = new Random();

        for (int i = 0; i < empSet.length; i++) {

            empSet[i] = random.nextInt(numberOfEmp) + 1;
        }

    }


    public int getEmp(int index) {
        return empSet[index];
    }

    //Set emp of particular node
    public void setEmp(int index, int emp) {
        this.empSet[index] = emp;
    }

    public int getFitness() {

        int count = 0;

        int[][] graph = ScheduleGenerator.getGraph();

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && empSet[i] != empSet[j]) {
                    count++;
                }
            }
        }

        return count;
    }

    public void displayWrongEmp() {
        int[][] graph = ScheduleGenerator.getGraph();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 1 && empSet[i] == empSet[j]) {
                    LOGGER.info(String.format("Problem with Scheduling : %d \t %d", i, j));
                }
            }
        }


    }

    public boolean containsEmp(int i) {
        return IntStream.of(empSet).anyMatch(x -> x == i);
    }

    public int getSize() {
        return empSet.length;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        for (int i : empSet) {
            sb.append(i).append("\t");
        }
        return sb.toString();
    }


}
