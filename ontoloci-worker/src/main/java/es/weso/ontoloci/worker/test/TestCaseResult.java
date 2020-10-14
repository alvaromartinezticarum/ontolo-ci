package es.weso.ontoloci.worker.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Models the result of a test execution. The result of a test execution is composed of the tests case that was
 * executed, the result of the execution and a metadata map that can store execution time or other things like
 * profiling if enabled.
 *
 * @author Guillermo Facundo Colunga
 * @version 20201007
 */
public class TestCaseResult {

    // LOGGER CREATION
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCaseResultStatus.class);

    // Final fields
    private final TestCase testCase;

    // Non final fields.
    private TestCaseResultStatus status;
    private Map<String, String> metadata;

    /**
     * Factory method to create new instances of the test case result from the test case.
     * It initializes the test case result to the status waiting and empty metadata map.
     *
     * @param testCase from which to create the test case result.
     * @return the new instance of the rest case result.
     */
    public static TestCaseResult from(TestCase testCase) {
        LOGGER.debug("Static factory for creating a new test case result for " + testCase);
        return new TestCaseResult(testCase, TestCaseResultStatus.WAITING, new HashMap<>());
    }

    /**
     * Private constructor for test case results where need to set the test case,
     * the initial status and the metadata map.
     *
     * @param testCase that has been executed.
     * @param status of the test case execution.
     * @param metadata is a map with the test execution metadata.
     */
    private TestCaseResult(TestCase testCase, TestCaseResultStatus status, Map<String, String> metadata) {
        this.testCase = testCase;
        this.status = status;
        this.metadata = metadata;

        LOGGER.debug("Creating new test case result for " + this.toString());
    }

    /**
     * Gets the test case linked with this result test case.
     *
     * @return the test case linked with this result test case.
     */
    public TestCase getTestCase() {
        LOGGER.debug("Getting the value of the test case " + this.testCase.toString()
        + " from " + this);

        return this.testCase;
    }

    /**
     * Gets the status of the execution of the linked tests case.
     *
     * @return the status of the execution of the linked tests case.
     */
    public TestCaseResultStatus getStatus() {
        LOGGER.debug("Getting the value of the test case result status " + this.status.toString()
                + " from " + this);

        return status;
    }

    /**
     * Sets the status of the result test case.
     *
     * @param status to set.
     */
    public void setStatus(TestCaseResultStatus status) {
        LOGGER.debug("Setting the value of the test case result status from " + this.status.toString() + " to "
                + status.toString()
                + " from " + this);

        this.status = status;
    }

    /**
     * Gets the metadata map associated to the result test case.
     *
     * @return the metadata map.
     */
    public Map<String, String> getMetadata() {
        LOGGER.debug("Getting the metadata of the test case result " + this.metadata.toString()
                + " from " + this);

        return Collections.unmodifiableMap(this.metadata);
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "TestCaseResult{" +
                    "testCase=" + testCase +
                    ", metadata=" + metadata +
                    ", status=" + status +
                '}';
    }
}