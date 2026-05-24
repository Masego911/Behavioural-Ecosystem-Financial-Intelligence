import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * BorrowerDAO
 *
 * Responsible ONLY for:
 * - persisting validated behavioural borrowers,
 * - storing explainable borrower intelligence,
 * - preserving informational opacity,
 * - and maintaining analytical persistence integrity.
 *
 * IMPORTANT:
 * - No parsing
 * - No validation
 * - No CSV ingestion
 * - No graph traversal
 * - No anomaly detection
 *
 * Research Alignment:
 * Modern behavioural intelligence systems preserve:
 * - uncertainty,
 * - informational opacity,
 * - behavioural signals,
 * - and explainable borrower state.
 *
 * Therefore:
 * missing income is now persisted as:
 * a first-class behavioural feature.
 *
 * Single Responsibility:
 * Behavioural borrower persistence.
 */
public class BorrowerDAO {

    /**
     * ==================================================
     * SQL INSERT STATEMENT
     * ==================================================
     *
     * Persists:
     * - behavioural borrower intelligence,
     * - informational opacity,
     * - repayment instability,
     * - and analytical borrower state.
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
     * insertBorrower()
     *
     * Persists:
     * - structured behavioural borrower,
     * - explainable borrower intelligence,
     * - and informational uncertainty.
     *
     * IMPORTANT:
     * Missing income is preserved as:
     * informational opacity.
     *
     * @param borrower
     * Structured behavioural borrower.
     */
    public void insertBorrower(
            Borrower borrower
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
                                INSERT_BORROWER_SQL
                        )

        ) {

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
             * 1 = informational opacity present
             * 0 = income observed
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
             * CREDIT STRESS FEATURES
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
             * EXECUTE ANALYTICAL INSERT
             * ==================================================
             */

            preparedStatement.executeUpdate();

            /**
             * ==================================================
             * INSERT OBSERVABILITY
             * ==================================================
             */

            System.out.println(

                    "Behavioural borrower persisted: "

                            + borrower.getApplicantIdHash()
            );
        }

        /**
         * ==================================================
         * SQL FAILURE HANDLING
         * ==================================================
         */

        catch (SQLException exception) {

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "BORROWER PERSISTENCE FAILURE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Borrower ID: "
                            + borrower.getApplicantIdHash()
            );

            System.out.println(
                    "Failure Reason: "
                            + exception.getMessage()
            );
        }
    }
}