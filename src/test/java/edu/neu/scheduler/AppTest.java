package edu.neu.scheduler;

import edu.neu.scheduler.ScheduleGenerator;
import edu.neu.scheduler.EmpList;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testFitness() throws ScheduleGenerator.InvalidEdgeCountException {
        int shifts = 7;
        ScheduleGenerator graph = new ScheduleGenerator(shifts);
        EmpList mySet = new EmpList();
        assertEquals(mySet.getFitness(), 0);
    }

    @Test
    public void testFitness1() {
        
        EmpList mySet = new EmpList();
        assertEquals(mySet.getFitness(), 0);
        
    }

    @Test
    public void testGraphGenerator() throws ScheduleGenerator.InvalidEdgeCountException {
        int shifts = 7;
        ScheduleGenerator graph2 = new ScheduleGenerator(shifts);
    }

    @Test
    public void testGraphGenerator1() throws ScheduleGenerator.InvalidEdgeCountException {
       int shifts = 7;
       int days = 7;
        ScheduleGenerator graph1 = new ScheduleGenerator(shifts);
        assertEquals(shifts, graph1.getVertexCount());
    }
}