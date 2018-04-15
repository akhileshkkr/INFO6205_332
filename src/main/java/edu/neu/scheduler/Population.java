package edu.neu.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Population {

    private static Logger LOGGER = LogManager.getLogger(Population.class.getName());
    EmpList[] empSet;

    public Population(int populationSize, Boolean flag, int numberOfEmps) {

        empSet = new EmpList[populationSize];

        if (flag) {
            for (int i = 0; i < populationSize; i++) {
                EmpList cs = new EmpList();
                cs.generateSet(numberOfEmps);
                setEmpList(i, cs);
            }
        }
    }

    public EmpList getEmpList(int index) {
        return empSet[index];
    }

    public void setEmpList(int index, EmpList empSet) {
        this.empSet[index] = empSet;
    }

    public EmpList getFittest() {

        EmpList cs = empSet[0];

        for (int i = 1; i < empSet.length; i++) {

            if (cs.getFitness() < empSet[i].getFitness()) {
                cs = empSet[i];
            }
        }

        return cs;

    }

    public int getSize() {
        return empSet.length;
    }

}
