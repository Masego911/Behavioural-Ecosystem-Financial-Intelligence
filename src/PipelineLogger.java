import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;

/**
 * PipelineLogger
 *
 * Responsible ONLY for:
 * - behavioural pipeline observability,
 * - explainable intelligence logging,
 * - uncertainty event recording,
 * - graph intelligence traceability,
 * - and operational governance visibility.
 *
 * IMPORTANT:
 * - No parsing
 * - No validation
 * - No graph traversal
 * - No anomaly detection
 * - No business intelligence logic
 *
 * Research Alignment:
 * Modern behavioural intelligence systems require:
 * - explainability,
 * - lineage tracking,
 * - behavioural observability,
 * - and uncertainty-aware governance.
 *
 * IMPORTANT:
 * Logging now distinguishes:
 *
 * 1. structural invalidity
 * from
 * 2. behavioural uncertainty.
 *
 * Single Responsibility:
 * Behavioural pipeline observability infrastructure.
 */
public class PipelineLogger {

    /**
     * ==================================================
     * SQL INSERT STATEMENT
     * ==================================================
     *
     * Persists:
     * - behavioural events,
     * - uncertainty events,
     * - anomaly intelligence,
     * - propagation observability,
     * - and operational pipeline lineage.
     */
    private static final String INSERT_LOG_SQL = """

            INSERT INTO pipeline_logs (

                timestamp,

                record_id,

                stage,

                issue_type,

                issue_message

            ) VALUES (?, ?, ?, ?, ?);
            """;

    /**
     * log()
     *
     * Records:
     * - behavioural pipeline events,
     * - explainable intelligence signals,
     * - uncertainty events,
     * - and governance lineage.
     *
     * IMPORTANT:
     * This logger now supports:
     * - behavioural uncertainty,
     * - graph propagation observability,
     * - anomaly escalation,
     * - explainable scoring,
     * - and operational governance tracking.
     *
     * Example event types:
     * - STRUCTURAL_INVALIDITY
     * - MISSING_INCOME
     * - GRAPH_PROPAGATION
     * - ANOMALY_DETECTED
     * - HIGH_RISK_CLASSIFICATION
     *
     * @param recordId
     * Borrower identifier.
     *
     * @param stage
     * Behavioural pipeline stage.
     *
     * @param issueType
     * Behavioural event classification.
     *
     * @param issueMessage
     * Explainable event description.
     */
    public void log(

            String recordId,

            String stage,

            String issueType,

            String issueMessage
    ) {

        /**
         * ==================================================
         * TRY-WITH-RESOURCES
         * ==================================================
         *
         * Automatically closes:
         * - database connection,
         * - prepared statement,
         * - and JDBC resources.
         */
        try (

                /**
                 * Shared SQLite connection.
                 */
                Connection connection =
                        DatabaseManager.getConnection();

                /**
                 * Prepared analytical statement.
                 */
                PreparedStatement preparedStatement =

                        connection.prepareStatement(
                                INSERT_LOG_SQL
                        )

        ) {

            /**
             * ==================================================
             * EVENT TIMESTAMP
             * ==================================================
             *
             * IMPORTANT:
             * Enables:
             * - event chronology,
             * - auditability,
             * - and pipeline lineage reconstruction.
             */
            String timestamp =

                    LocalDateTime.now().toString();

            /**
             * ==================================================
             * BIND LOG PARAMETERS
             * ==================================================
             */

            preparedStatement.setString(

                    1,

                    timestamp
            );

            preparedStatement.setString(

                    2,

                    recordId
            );

            preparedStatement.setString(

                    3,

                    stage
            );

            preparedStatement.setString(

                    4,

                    issueType
            );

            preparedStatement.setString(

                    5,

                    issueMessage
            );

            /**
             * ==================================================
             * EXECUTE LOG INSERT
             * ==================================================
             */

            preparedStatement.executeUpdate();

            /**
             * ==================================================
             * CONSOLE OBSERVABILITY
             * ==================================================
             *
             * IMPORTANT:
             * Enables:
             * real-time behavioural observability.
             */
            System.out.println(

                    "\n[PIPELINE LOG]"
            );

            System.out.println(
                    "Timestamp: "
                            + timestamp
            );

            System.out.println(
                    "Record ID: "
                            + recordId
            );

            System.out.println(
                    "Stage: "
                            + stage
            );

            System.out.println(
                    "Issue Type: "
                            + issueType
            );

            System.out.println(
                    "Message: "
                            + issueMessage
            );
        }

        /**
         * ==================================================
         * LOGGING FAILURE HANDLING
         * ==================================================
         */

        catch (SQLException exception) {

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "PIPELINE LOGGING FAILURE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Record ID: "
                            + recordId
            );

            System.out.println(
                    "Failure Reason: "
                            + exception.getMessage()
            );

            /**
             * IMPORTANT:
             * Logging failures should NOT:
             * terminate pipeline execution.
             *
             * Observability degradation is logged
             * but pipeline execution continues.
             */
        }
    }
}