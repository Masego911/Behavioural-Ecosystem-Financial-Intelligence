// Import Connection interface
// Represents active database session
import java.sql.Connection;

// Import PreparedStatement
// Used for safe parameterized SQL batching
import java.sql.PreparedStatement;

// Import SQLException
// Handles database-related failures
import java.sql.SQLException;

// Import List interface
// Represents ordered collection of RawRecord objects
import java.util.List;

/**
 * BatchRawRecordDAO
 *
 * Responsible ONLY for:
 * - batched persistence of RawRecord objects,
 * - transaction-based insertion,
 * - and scalable ingestion operations.
 *
 * IMPORTANT:
 * - No validation
 * - No parsing
 * - No CSV ingestion
 * - No business logic
 *
 * Single Responsibility:
 * Batch raw behavioural persistence.
 */
public class BatchRawRecordDAO {

    /**
     * Defines how many records
     * are inserted before commit.
     *
     * Batch processing improves:
     * - throughput,
     * - scalability,
     * - and database efficiency.
     */
    private static final int BATCH_SIZE = 1000;

    /**
     * SQL insert statement
     * for raw borrower persistence.
     */
    private static final String INSERT_RAW_RECORD_SQL = """

            INSERT INTO raw_borrowers (

                applicant_id_hash,
                age,
                annual_income,
                employment_length_years,
                home_ownership,
                region,
                num_open_accounts,
                num_delinquencies_2yr,
                total_revolving_balance,
                credit_utilisation_pct,
                months_since_oldest_account,
                num_hard_inquiries_6mo,
                loan_amount,
                interest_rate,
                loan_purpose,
                dti_ratio,
                months_since_last_delinquency,
                pct_accounts_current,
                application_date,
                application_dow,
                branch_code_id,
                months_at_current_address,
                email_domain_type,
                phone_verified,
                default_flag,
                dataset_split

            ) VALUES (

                ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,
                ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?

            );
            """;

    /**
     * insertBatch()
     *
     * Inserts collection of raw borrower records
     * using scalable batch persistence.
     *
     * @param rawRecords
     * Collection of raw behavioural records.
     *
     * @param transactionManager
     * Shared transaction infrastructure.
     */
    public void insertBatch(List<RawRecord> rawRecords, TransactionManager transactionManager) {

        //Retrieve shared database connection.

        Connection connection = transactionManager.getConnection();

        if (connection == null) {

            System.out.println("Batch insertion aborted: no active database connection.");

            return;
        }

        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RAW_RECORD_SQL))
        {

            //Tracks current batch size.
            int batchCount = 0;

            //Process each raw borrower record.
            for (RawRecord rawRecord : rawRecords) {

                /**
                 * Bind raw behavioural values.
                 *
                 * IMPORTANT:
                 * We preserve raw borrower truth exactly as received.
                 */

                preparedStatement.setString(1, rawRecord.getApplicantIdHash());

                preparedStatement.setString(2, rawRecord.getAge());

                preparedStatement.setString(3, rawRecord.getAnnualIncome());

                preparedStatement.setString(4, rawRecord.getEmploymentLengthYears());

                preparedStatement.setString(5, rawRecord.getHomeOwnership());

                preparedStatement.setString(6, rawRecord.getRegion());

                preparedStatement.setString(7, rawRecord.getNumOpenAccounts());

                preparedStatement.setString(8, rawRecord.getNumDelinquencies2yr());

                preparedStatement.setString(9, rawRecord.getTotalRevolvingBalance());

                preparedStatement.setString(10, rawRecord.getCreditUtilisationPct());

                preparedStatement.setString(11, rawRecord.getMonthsSinceOldestAccount());

                preparedStatement.setString(12, rawRecord.getNumHardInquiries6mo());

                preparedStatement.setString(13, rawRecord.getLoanAmount());

                preparedStatement.setString(14, rawRecord.getInterestRate());

                preparedStatement.setString(15, rawRecord.getLoanPurpose());

                preparedStatement.setString(16, rawRecord.getDtiRatio());

                preparedStatement.setString(17, rawRecord.getMonthsSinceLastDelinquency());

                preparedStatement.setString(18, rawRecord.getPctAccountsCurrent());

                preparedStatement.setString(19, rawRecord.getApplicationDate());

                preparedStatement.setString(20, rawRecord.getApplicationDow());

                preparedStatement.setString(21, rawRecord.getBranchCodeId());

                preparedStatement.setString(22, rawRecord.getMonthsAtCurrentAddress());

                preparedStatement.setString(23, rawRecord.getEmailDomainType());

                preparedStatement.setString(24, rawRecord.getPhoneVerified());

                preparedStatement.setString(25, rawRecord.getDefaultFlag());

                preparedStatement.setString(26, rawRecord.getDatasetSplit());

                //Add current borrower to SQL batch queue.
                preparedStatement.addBatch();

                //Increment batch counter.
                batchCount++;

                //Execute batch window once threshold reached.
                if (batchCount % BATCH_SIZE == 0) {

                    //Execute queued SQL operations.
                    preparedStatement.executeBatch();

                    //Commit transaction window.
                    transactionManager.commit();

                    //Console progress feedback.
                    System.out.println(batchCount + " raw borrower records inserted.");
                }
            }

            //Execute remaining records not yet committed.
            preparedStatement.executeBatch();

            //Final transaction commit.
            transactionManager.commit();

            System.out.println("Final raw batch insertion completed successfully.");

        }
        catch (SQLException exception) {

            System.out.println("Batch raw insertion failed: " + exception.getMessage());

            /**
             * Roll back transaction state
             * to preserve database consistency.
             */
            transactionManager.rollback();
        }
    }
}