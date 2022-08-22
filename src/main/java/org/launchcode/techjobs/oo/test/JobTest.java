package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job jobTest = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(jobTest.getName() instanceof String);
        assertTrue(jobTest.getEmployer() instanceof Employer);
        assertTrue(jobTest.getLocation() instanceof Location);
        assertTrue(jobTest.getPositionType() instanceof PositionType);
        assertTrue(jobTest.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(jobTest.getName(), "Product tester");
        assertEquals(jobTest.getEmployer().getValue(), "ACME");
        assertEquals(jobTest.getLocation().getValue(), "Dessert");
        assertEquals(jobTest.getPositionType().getValue(),"Quality control");
        assertEquals(jobTest.getCoreCompetency().getValue(),"Persistence" );
    }

    @Test
    public void testJobsForEquality() {
        Job testJob1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job testJob2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(testJob1.equals(testJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job test1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals('\n', test1.toString().charAt(0));
        assertEquals('\n', test1.toString().charAt(test1.toString().length()-1));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job test2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String expectedResult = "\nID: 1\nName: Job job\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality\nCore Competency: Persistence\n";
        assertEquals(test2.toString(), expectedResult);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job test3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String expectedResult = "\nID: 2\nName: Job job\nEmployer: ACME\nLocation: Desert\nPosition Type: Quality\nCore Competency: Persistence\n";
        assertEquals(test3.toString(), expectedResult);
    }

}
