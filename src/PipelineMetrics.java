/**
 * PipelineMetrics
 *
 * Responsible ONLY for:
 * - pipeline execution timing,
 * - throughput measurement,
 * - validation metrics,
 * - and operational observability.
 *
 * IMPORTANT:
 * - No parsing
 * - No validation
 * - No SQL logic
 * - No business logic
 *
 * Single Responsibility:
 * Pipeline operational intelligence.
 */
public class PipelineMetrics {

    // Stores pipeline start time
    private long startTime;

    // Stores pipeline end time
    private long endTime;

    // Tracks total processed records
    private int totalRecords;

    // Tracks successful analytical borrowers
    private int successfulBorrowers;

    // Tracks failed validation borrowers
    private int failedBorrowers;

    /**
     * startPipelineTimer()
     *
     * Starts execution timer.
     */
    public void startPipelineTimer() {

        startTime = System.currentTimeMillis();

        System.out.println("Pipeline execution timer started.");
    }

    /**
     * stopPipelineTimer()
     *
     * Stops execution timer.
     */
    public void stopPipelineTimer() {

        endTime = System.currentTimeMillis();

        System.out.println("Pipeline execution timer stopped.");
    }

    /**
     * setTotalRecords()
     *
     * Stores total ingestion volume.
     *
     * @param totalRecords
     * Total borrower records processed.
     */
    public void setTotalRecords(int totalRecords) {

        this.totalRecords = totalRecords;
    }

    /**
     * setSuccessfulBorrowers()
     *
     * Stores successful borrower count.
     *
     * @param successfulBorrowers
     * Total validated analytical borrowers.
     */
    public void setSuccessfulBorrowers(int successfulBorrowers) {

        this.successfulBorrowers = successfulBorrowers;
    }

    /**
     * setFailedBorrowers()
     *
     * Stores validation failure count.
     *
     * @param failedBorrowers
     * Total failed borrowers.
     */
    public void setFailedBorrowers(int failedBorrowers) {

        this.failedBorrowers = failedBorrowers;
    }

    /**
     * getExecutionTimeSeconds()
     *
     * Calculates pipeline duration.
     *
     * @return
     * Execution duration in seconds.
     */
    public double getExecutionTimeSeconds() {

        return (endTime - startTime) / 1000.0;
    }

    /**
     * getThroughputPerSecond()
     *
     * Calculates ingestion throughput.
     *
     * @return
     * Records processed per second.
     */
    public double getThroughputPerSecond() {

        double executionTime = getExecutionTimeSeconds();

        // Prevent division by zero
        if (executionTime == 0) {

            return 0;
        }

        return totalRecords / executionTime;
    }

    /**
     * getValidationSuccessRate()
     *
     * Calculates validation success rate.
     *
     * @return
     * Percentage of valid borrowers.
     */
    public double getValidationSuccessRate() {

        // Prevent division by zero
        if (totalRecords == 0) {

            return 0;
        }

        return (successfulBorrowers * 100.0) / totalRecords;
    }

    /**
     * getValidationFailureRate()
     *
     * Calculates validation failure rate.
     *
     * @return
     * Percentage of failed borrowers.
     */
    public double getValidationFailureRate() {

        // Prevent division by zero
        if (totalRecords == 0) {

            return 0;
        }

        return (failedBorrowers * 100.0) / totalRecords;
    }

    /**
     * printMetrics()
     *
     * Displays operational pipeline metrics.
     */
    public void printMetrics() {

        System.out.println("\n========== BCIP PIPELINE METRICS ==========");

        System.out.println("Total Records Processed: " + totalRecords);

        System.out.println("Successful Borrowers: " + successfulBorrowers);

        System.out.println("Failed Borrowers: " + failedBorrowers);

        System.out.println("Execution Time (Seconds): " + getExecutionTimeSeconds());

        System.out.println("Throughput (Records/Second): " + getThroughputPerSecond());

        System.out.println("Validation Success Rate (%): " + getValidationSuccessRate());

        System.out.println("Validation Failure Rate (%): " + getValidationFailureRate());
    }
}