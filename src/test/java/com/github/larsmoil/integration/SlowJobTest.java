package com.github.larsmoil.integration;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Lars-Olof Moilanen
 *         Date: 4/17/12
 *         Time: 8:38 PM
 */
@ContextConfiguration(locations = {"classpath:/test-services.xml"})
public class SlowJobTest extends AbstractTestNGSpringContextTests {

    private JobLauncherTestUtils slowJobLauncherTestUtils;
    private JobLauncherTestUtils parallelJobLauncherTestUtils;

    @BeforeClass
    public void doOnce() {
        slowJobLauncherTestUtils = applicationContext.getBean("slowJobLauncherTestUtils", JobLauncherTestUtils.class);
        parallelJobLauncherTestUtils = applicationContext.getBean("parallelJobLauncherTestUtils", JobLauncherTestUtils.class);
    }

    @Test
    public void testSlowJob() throws Exception {
        assertEquals(ExitStatus.COMPLETED, slowJobLauncherTestUtils.launchJob().getExitStatus());
    }

    @Test
    public void testParallelJob() throws Exception {
        assertEquals(ExitStatus.COMPLETED, parallelJobLauncherTestUtils.launchJob().getExitStatus());
    }

}
