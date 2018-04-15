package edu.neu.scheduler;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private static Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws ScheduleGenerator.InvalidEdgeCountException
    {
            
        final int generations = 100;
        final int populationSize = 50;
        final int NumberOfEmps = 4;
        
        int NumberOfDays = 7;
        int numberOfShifts = 6;
        int graphLength = NumberOfDays * numberOfShifts;

        
        ScheduleGenerator schedule = new ScheduleGenerator(graphLength);

        Population pop = new Population(populationSize, true, NumberOfEmps);

        LOGGER.info("Current fittest employee shift list : "+ pop.getFittest().toString());
        LOGGER.info("fitness : " + pop.getFittest().getFitness());
        pop.getFittest().displayWrongEmp();

        for (int i = 0; i < generations; i++) {
            pop = GaAlgorithm.evolvePopulation(pop);
        }

        LOGGER.info(String.format("After %d breed the employee shift list : ", generations));
        LOGGER.info(pop.getFittest().toString() + "fitness : " + pop.getFittest().getFitness());
        pop.getFittest().displayWrongEmp();
    }
}