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
public class JobTest {
    private Job job1, job2, job3, job4;
    @Before
    public void createTestJobs(){
    job1 = new Job();
    job2 = new Job();
    job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
//    define a test called testSettingJobId.
    @Test
    public void testSettingJobId(){
        assertNotEquals(job1.getId(), job2.getId());
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
}
