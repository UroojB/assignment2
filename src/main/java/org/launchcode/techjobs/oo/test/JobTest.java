package org.launchcode.techjobs.oo.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest extends JobField {
    private Job job1, job2, job3, job4;
    @Before
    public void createTestJobs(){
        job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
//    define a test called testSettingJobId.
    @Test
    public void testSettingJobId(){
        assertNotEquals(job3.getId(), job4.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
    assertEquals(job3.getName(),"Product tester");
    assertEquals(job3.getEmployer().getValue(), "ACME");
    assertEquals(job3.getLocation().getValue(), "Desert");
    assertEquals(job3.getPositionType().getValue(), "Quality control");
    assertEquals(job3.getCoreCompetency().getValue(), "Persistence");

    assertTrue(job3.getEmployer() instanceof Employer);
    assertTrue(job3.getLocation() instanceof Location);
    assertTrue(job3.getPositionType() instanceof PositionType);
    assertTrue(job3.getCoreCompetency()instanceof CoreCompetency);
    }

    @Test
    public void testJobsForEquality(){
    assertNotEquals(job3,job4);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        String firstLine = job3.toString().substring(0,1);
        String lastLine = job3.toString().substring(job3.toString().length() - 1);
        assertEquals(firstLine, lastLine);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        String output =
                "\nID: " + job3.getId() +
                "\nName: " + job3.getName() +
                "\nEmployer: " + job3.getEmployer() +
                "\nLocation: " + job3.getLocation() +
                "\nPosition Type: " + job3.getPositionType() +
                "\nCore Competency: " + job3.getCoreCompetency() +
                "\n";
        assertEquals(output, job3.toString());
    }

    @Test
    public void testToStringHandlesEmptyField(){
        job4.getEmployer().setValue("");
        job4.getLocation().setValue("");
        job4.getPositionType().setValue("");
        job4.getCoreCompetency().setValue("");
        String output = "\n" +
                "ID: " + job4.getId() +
                "\nName: " + job4.getName() +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available" + "\n";
        assertEquals(output, job4.toString());
    }
}
