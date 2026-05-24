import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * BatchBorrowerDAO
 *
 * Responsible ONLY for:
 * - scalable behavioural borrower persistence,
 * - batch analytical ingestion,
 * - explainable borrower warehousing,
 * - and transactional batch optimisation.
 *
 * IMPORTANT:
 * - No parsing
 * - No validation
 * - No graph traversal
 * - No anomaly detection
 * - No business logic
 *
 * Research Alignment:
 * Modern behavioural intelligence systems preserve:
 * - informational opacity,
 * - uncertainty signals,
 * - behavioural explainability,
 * - and graph-compatible borrower features.
 *
 * Therefore:
 * batch ingestion now preserves:
 * behavioural intelligence state.
 *
 * Single Responsibility:
 * Batch behavioural borrower persistence.
 */
public class BatchBorrowerDAO {

    /**
     * ==================================================
     * BATCH WINDOW SIZE
     * ==================================================
     *
     * Defines:
     * transaction execution window.
     *
     * IMPORTANT:
     * Prevents:
     * - excessive memory growth,
     * - transaction explosion,
     * - and database pressure.
     */
    private static final int BATCH_SIZE = 1000;

    /**
     * ==================================================
     * SQL INSERT STATEMENT
     * ==================================================
     *
     * Persists:
     * - behavioural borrower intelligence,
     * - informational opacity,
     * - repayment instability,
     * - and explainable borrower state.
     */
    private static final String INSERT_BORROWER_SQL = """

            INSERT INTO validated_borrowers (

                applicant_id_hash,

                age,

                annual_income,

                missing_income_flag,

                home_ownership,

                region,

                credit_utilisation_pct,

                num_hard_inquiries_6mo,

                dti_ratio,

                num_delinquencies_2yr,

                branch_code_id,

                email_domain_type,

                default_flag

            ) VALUES (

                ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?
            );
            """;

    /**
     * insertBatch()
     *
     * Persists:
     * - validated behavioural borrowers,
     * - uncertainty-aware borrower entities,
     * - and graph-compatible analytical features.
     *
     * Uses:
     * scalable transactional batching.
     *
     * @param borrowers
     * Collection of validated borrowers.
     *
     * @param transactionManager
     * Shared transaction infrastructure.
     */
    public void insertBatch(

            List<Borrower> borrowers,

            TransactionManager transactionManager
    ) {

        /**
         * ==================================================
         * SHARED DATABASE CONNECTION
         * ==================================================
         */

        Connection connection =
                transactionManager.getConnection();

        /**
         * ==================================================
         * DEFENSIVE CONNECTION VALIDATION
         * ==================================================
         */

        if (connection == null) {

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "BATCH PERSISTENCE ABORTED"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "No active database connection."
            );

            return;
        }

        /**
         * ==================================================
         * PREPARED BATCH STATEMENT
         * ==================================================
         */

        try (

                PreparedStatement preparedStatement =

                        connection.prepareStatement(
                                INSERT_BORROWER_SQL
                        )

        ) {

            /**
             * Tracks:
             * transactional batch progress.
             */
            int batchCount = 0;

            /**
             * ==================================================
             * PROCESS VALIDATED BORROWERS
             * ==================================================
             */

            for (Borrower borrower : borrowers) {

                /**
                 * ==================================================
                 * CORE BORROWER IDENTITY
                 * ==================================================
                 */

                preparedStatement.setString(

                        1,

                        borrower.getApplicantIdHash()
                );

                /**
                 * ==================================================
                 * DEMOGRAPHIC FEATURES
                 * ==================================================
                 */

                preparedStatement.setObject(

                        2,

                        borrower.getAge()
                );

                /**
                 * ==================================================
                 * FINANCIAL FEATURES
                 * ==================================================
                 */

                preparedStatement.setObject(

                        3,

                        borrower.getAnnualIncome()
                );

                /**
                 * ==================================================
                 * INFORMATIONAL OPACITY
                 * ==================================================
                 *
                 * IMPORTANT:
                 * SQLite stores booleans numerically.
                 *
                 * 1 = informational opacity
                 * 0 = observed income
                 */
                preparedStatement.setObject(

                        4,

                        borrower.getMissingIncome() == null

                                ? null

                                :

                                borrower.getMissingIncome() ? 1 : 0
                );

                /**
                 * ==================================================
                 * BEHAVIOURAL LOCALITY
                 * ==================================================
                 */

                preparedStatement.setString(

                        5,

                        borrower.getHomeOwnership()
                );

                preparedStatement.setString(

                        6,

                        borrower.getRegion()
                );

                /**
                 * ==================================================
                 * FINANCIAL STRESS FEATURES
                 * ==================================================
                 */

                preparedStatement.setObject(

                        7,

                        borrower.getCreditUtilisationPct()
                );

                preparedStatement.setObject(

                        8,

                        borrower.getNumHardInquiries6mo()
                );

                preparedStatement.setObject(

                        9,

                        borrower.getDtiRatio()
                );

                preparedStatement.setObject(

                        10,

                        borrower.getNumDelinquencies2yr()
                );

                /**
                 * ==================================================
                 * INFRASTRUCTURE FEATURES
                 * ==================================================
                 */

                preparedStatement.setString(

                        11,

                        borrower.getBranchCodeId()
                );

                preparedStatement.setString(

                        12,

                        borrower.getEmailDomainType()
                );

                /**
                 * ==================================================
                 * REPAYMENT INSTABILITY
                 * ==================================================
                 *
                 * SQLite stores booleans numerically.
                 */
                preparedStatement.setObject(

                        13,

                        borrower.getDefaultFlag() == null

                                ? null

                                :

                                borrower.getDefaultFlag() ? 1 : 0
                );

                /**
                 * ==================================================
                 * ADD TO TRANSACTION BATCH
                 * ==================================================
                 */

                preparedStatement.addBatch();

                batchCount++;

                /**
                 * ==================================================
                 * EXECUTE TRANSACTION WINDOW
                 * ==================================================
                 */

                if (batchCount % BATCH_SIZE == 0) {

                    preparedStatement.executeBatch();

                    transactionManager.commit();

                    System.out.println(

                            batchCount
                                    + " behavioural borrowers persisted."
                    );
                }
            }

            /**
             * ==================================================
             * EXECUTE REMAINING BATCH
             * ==================================================
             */

            preparedStatement.executeBatch();

            transactionManager.commit();

            /**
             * ==================================================
             * EXECUTION SUMMARY
             * ==================================================
             */

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "BATCH BEHAVIOURAL PERSISTENCE COMPLETE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Total Borrowers Persisted: "
                            + borrowers.size()
            );

            System.out.println(
                    "Informational opacity preserved successfully."
            );

            System.out.println(
                    "Behavioural intelligence persistence completed."
            );
        }

        /**
         * ==================================================
         * FAILURE HANDLING
         * ==================================================
         */

        catch (SQLException exception) {

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "BATCH PERSISTENCE FAILURE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Failure Reason: "
                            + exception.getMessage()
            );

            /**
             * ==================================================
             * TRANSACTION ROLLBACK
             * ==================================================
             */

            transactionManager.rollback();
        }
    }
}