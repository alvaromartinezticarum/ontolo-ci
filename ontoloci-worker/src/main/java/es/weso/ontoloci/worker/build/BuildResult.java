package es.weso.ontoloci.worker.build;

import es.weso.ontoloci.worker.test.TestCaseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collection;

public class BuildResult {

    // LOGGER CREATION
    private static final Logger LOGGER = LoggerFactory.getLogger(BuildResult.class);

    private Collection<TestCaseResult> testCaseResults;

    /**
     * Factory method that creates a new instance of build result from an array of test case results.
     *
     * @param testCaseResults from which to create the build result instance.
     * @return a new instance of build result from an array of test case results.
     */
    public static BuildResult from(final TestCaseResult... testCaseResults) {
        return new BuildResult(Arrays.asList(testCaseResults));
    }

    /**
     * Factory method that creates a new instance of build result from a collection of test case results.
     *
     * @param testCaseResults from which to create the build result instance.
     * @return a new instance of build result from an array of test case results.
     */
    public static BuildResult from(final Collection<TestCaseResult> testCaseResults) {
        return new BuildResult(testCaseResults);
    }

    /**
     * Private constructor for build results. It takes a collection of the test results.
     *
     * @param testCaseResults from which to create the build result.
     */
    private BuildResult(final Collection<TestCaseResult> testCaseResults) {
        this.testCaseResults = testCaseResults;

        LOGGER.debug("Creating a new build result for " + testCaseResults);
    }
}
