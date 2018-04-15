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

        EmpList el = empSet[0];

        for (int i = 1; i < empSet.length; i++) {

            if (el.getFitness() < empSet[i].getFitness()) {
                el = empSet[i];
            }
        }

        return el;

    }

    public int getSize() {
        return empSet.length;
    }

    public void printSchedule() {

        EmpList el = empSet[0];
        String days[] = {"M", "T", "W", "TH", "F", "S", "SU"};
        String batch[] = {"M", "E", "N"};

        String shiftComb[] = new String[21];
        int o = 0;
        for (int t = 0; t < 7; t++) {
            for (int u = 0; u < 3; u++) {
                int k = t % 7;
                int l = u % 3;
                System.out.print(days[k] + batch[l]+"\t");
                
            }

        }
        System.out.println();
        int k = 0;
        for (int j = 0; j < 21; j++) {

            System.out.print("Emp"+el.empSet[k++] + "\t");
            
        }
        System.out.println();
    }

}
