import java.sql.SQLException;

/**
 * RawRecordDAO
 *
 * Responsible ONLY for:
 * - persisting RawRecord objects
 * into the raw_borrowers table.
 *
 * IMPORTANT:
 * - No parsing
 * - No validation
 * - No CSV reading
 * - No business logic
 *
 * Single Responsibility:
 * Raw behavioural persistence.
 */


public class RawRecordDAO {

    /**
     * SQL insert statement.
     *
     * Parameter placeholders (?) are used
     * for safe prepared statement binding.
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
     * insertRawRecord()
     *
     * Persists a RawRecord into SQLite.
     *
     * @param rawRecord
     * Raw behavioural borrower record.
     */
    public void insertRawRecord(RawRecord rawRecord) {


        try (
                //Get SQLite database connection.
                java.sql.Connection connection = DatabaseManager.getConnection();
                // Create prepared SQL statement.
                java.sql.PreparedStatement preparedStatement = connection.prepareStatement(INSERT_RAW_RECORD_SQL)
        )
        {

            /*
             * Bind RawRecord values to SQL parameters.
             *
             * IMPORTANT:
             * We preserve raw values exactly as received.
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

            //Execute SQL insert.
            preparedStatement.executeUpdate();

        }

        /**
         * Handle SQL persistence problems.
         */
        catch (SQLException exception) {

            System.out.println("Raw record insertion failed: " + exception.getMessage());
        }
    }

}
