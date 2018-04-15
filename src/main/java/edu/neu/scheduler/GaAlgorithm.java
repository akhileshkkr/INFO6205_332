package edu.neu.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GaAlgorithm {

    private static Logger LOGGER = LogManager.getLogger(GaAlgorithm.class.getName());

    //GA parameters
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    public static Population evolvePopulation(Population pop) {

        Population newPopulation = new Population(pop.getSize(), false, 0);

        int eliteOffset = 0;

        if (elitism) {
            newPopulation.setEmpList(0, pop.getFittest());
            eliteOffset = 1;
        }

        for (int i = eliteOffset; i < newPopulation.getSize(); i++) {
            EmpList parent1 = tournamentSelection(pop);
            EmpList parent2 = tournamentSelection(pop);
            EmpList child = crossOver(parent1, parent2);
            newPopulation.setEmpList(i, child);
        }

        for (int i = eliteOffset; i < newPopulation.getSize(); i++) {
            mutate(newPopulation.getEmpList(i));
        }
        return newPopulation;
    }



    public static EmpList crossOver(EmpList parent1, EmpList parent2) {

        EmpList child = new EmpList();
        int setLength = parent1.getSize();
        int startPosition = (int) (Math.random() * setLength);
        int endPosition = startPosition;
        while (endPosition == startPosition) {
            endPosition = (int) (Math.random() * setLength);
        }

        for (int i = 0; i < parent1.getSize(); i++) {

            if (startPosition < endPosition && i > startPosition && i < endPosition) {
                child.setEmp(i, parent1.getEmp(i));
            } else if (startPosition > endPosition) {
                if (!(i < startPosition && i > endPosition)) {
                    child.setEmp(i, parent1.getEmp(i));
                }
            }
        }

        for (int i = 0; i < parent2.getSize(); i++) {

            if ((!child.containsEmp(parent2.getEmp(i))) || child.getEmp(i) == 0) {

                for (int ii = 0; ii < parent2.getSize(); ii++) {
                    if (child.getEmp(ii) == 0) {
                        child.setEmp(ii, parent2.getEmp(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    public static void mutate(EmpList parent) {

        for (int empSet = 0; empSet < parent.getSize(); empSet++) {

            if (Math.random() < mutationRate) {
                int randomID = (int) (Math.random() * parent.getSize());

                int emp1 = parent.getEmp(empSet);
                int emp2 = parent.getEmp(randomID);

                parent.setEmp(empSet, emp2);
                parent.setEmp(randomID, emp1);
            }
        }
    }

    public static EmpList tournamentSelection(Population pop) {
        Population selectionCandidate = new Population(tournamentSize, false, 0);

        for (int i = 0; i < tournamentSize; i++) {
            int randomID = (int) (Math.random() * (pop.getSize()));
            selectionCandidate.setEmpList(i, pop.getEmpList(randomID));
        }

        return selectionCandidate.getFittest();

    }
}
