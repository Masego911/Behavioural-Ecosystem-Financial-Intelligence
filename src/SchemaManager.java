
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * SchemaManager
 *
 * Responsible ONLY for:
 * - database schema creation,
 * - behavioural intelligence infrastructure,
 * - schema evolution handling,
 * - and analytical persistence setup.
 *
 * IMPORTANT:
 * During active development:
 * old tables are dropped and recreated.
 *
 * This prevents:
 * - schema drift,
 * - stale SQLite structures,
 * - missing column failures,
 * - and behavioural persistence inconsistencies.
 *
 * Single Responsibility:
 * Behavioural database schema management.
 */
public class SchemaManager {

    /**
     * initializeDatabase()
     *
     * Creates:
     * - behavioural persistence schema,
     * - explainable graph infrastructure,
     * - uncertainty-aware borrower storage,
     * - and analytical warehouse structures.
     *
     * IMPORTANT:
     * Existing tables are dropped during development.
     *
     * @throws SQLException
     * Database infrastructure failure.
     */
    public void initializeDatabase()
            throws SQLException {

        try (

                /**
                 * Shared SQLite connection.
                 */
                Connection connection =
                        DatabaseManager.getConnection();

                /**
                 * SQL execution interface.
                 */
                Statement statement =
                        connection.createStatement()

        ) {

            /**
             * ==================================================
             * DEVELOPMENT SCHEMA RESET
             * ==================================================
             *
             * IMPORTANT:
             * Prevents SQLite schema drift.
             *
             * SQLite does NOT automatically evolve:
             * CREATE TABLE IF NOT EXISTS structures.
             *
             * Therefore:
             * old schemas must be removed during
             * active architecture evolution.
             */

            statement.execute("DROP TABLE IF EXISTS raw_borrowers;");

            statement.execute("DROP TABLE IF EXISTS validated_borrowers;");

            statement.execute("DROP TABLE IF EXISTS pipeline_logs;");

            statement.execute("DROP TABLE IF EXISTS behavioural_flags;");

            statement.execute("DROP TABLE IF EXISTS behavioural_relationships;");

            statement.execute("DROP TABLE IF EXISTS behavioural_clusters;");

            /**
             * ==================================================
             * RAW BORROWERS TABLE
             * ==================================================
             */
            String rawBorrowersTable = """

                    CREATE TABLE raw_borrowers (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        applicant_id_hash TEXT,
                        age TEXT,
                        annual_income TEXT,
                        employment_length_years TEXT,
                        home_ownership TEXT,
                        region TEXT,
                        num_open_accounts TEXT,
                        num_delinquencies_2yr TEXT,
                        total_revolving_balance TEXT,
                        credit_utilisation_pct TEXT,
                        months_since_oldest_account TEXT,
                        num_hard_inquiries_6mo TEXT,
                        loan_amount TEXT,
                        interest_rate TEXT,
                        loan_purpose TEXT,
                        dti_ratio TEXT,
                        months_since_last_delinquency TEXT,
                        pct_accounts_current TEXT,
                        application_date TEXT,
                        application_dow TEXT,
                        branch_code_id TEXT,
                        months_at_current_address TEXT,
                        email_domain_type TEXT,
                        phone_verified TEXT,
                        default_flag TEXT,
                        dataset_split TEXT
                    );
                    """;

            /**
             * ==================================================
             * VALIDATED BORROWERS TABLE
             * ==================================================
             *
             * IMPORTANT:
             * missing_income_flag preserves:
             * informational opacity.
             */
            String validatedBorrowersTable = """

                    CREATE TABLE validated_borrowers (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        applicant_id_hash TEXT,

                        age INTEGER,

                        annual_income REAL,

                        missing_income_flag INTEGER,

                        home_ownership TEXT,

                        region TEXT,

                        credit_utilisation_pct REAL,

                        num_hard_inquiries_6mo INTEGER,

                        dti_ratio REAL,

                        num_delinquencies_2yr INTEGER,

                        branch_code_id TEXT,

                        email_domain_type TEXT,

                        default_flag INTEGER
                    );
                    """;

            /**
             * ==================================================
             * PIPELINE LOGS TABLE
             * ==================================================
             */
            String pipelineLogsTable = """

                    CREATE TABLE pipeline_logs (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        timestamp TEXT,

                        record_id TEXT,

                        stage TEXT,

                        issue_type TEXT,

                        issue_message TEXT
                    );
                    """;

            /**
             * ==================================================
             * BEHAVIOURAL FLAGS TABLE
             * ==================================================
             */
            String behaviouralFlagsTable = """

                    CREATE TABLE behavioural_flags (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        applicant_id_hash TEXT,

                        flag_type TEXT,

                        flag_description TEXT,

                        uncertainty_level TEXT
                    );
                    """;

            /**
             * ==================================================
             * BEHAVIOURAL RELATIONSHIPS TABLE
             * ==================================================
             */
            String behaviouralRelationshipsTable = """

                    CREATE TABLE behavioural_relationships (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        borrower_a TEXT,

                        borrower_b TEXT,

                        relationship_strength REAL,

                        relationship_type TEXT,

                        shared_signals TEXT,

                        relationship_narrative TEXT
                    );
                    """;

            /**
             * ==================================================
             * BEHAVIOURAL CLUSTERS TABLE
             * ==================================================
             */
            String behaviouralClustersTable = """

                    CREATE TABLE behavioural_clusters (

                        id INTEGER PRIMARY KEY AUTOINCREMENT,

                        applicant_id_hash TEXT,

                        cluster_id TEXT,

                        cluster_persona TEXT
                    );
                    """;

            /**
             * ==================================================
             * EXECUTE TABLE CREATION
             * ==================================================
             */

            statement.execute(rawBorrowersTable);

            statement.execute(validatedBorrowersTable);

            statement.execute(pipelineLogsTable);

            statement.execute(behaviouralFlagsTable);

            statement.execute(behaviouralRelationshipsTable);

            statement.execute(behaviouralClustersTable);

            /**
             * ==================================================
             * ANALYTICAL INDEXES
             * ==================================================
             */

            statement.execute("""
                    CREATE INDEX idx_validated_applicant
                    ON validated_borrowers(applicant_id_hash);
                    """);

            statement.execute("""
                    CREATE INDEX idx_region
                    ON validated_borrowers(region);
                    """);

            statement.execute("""
                    CREATE INDEX idx_missing_income
                    ON validated_borrowers(missing_income_flag);
                    """);

            statement.execute("""
                    CREATE INDEX idx_default_flag
                    ON validated_borrowers(default_flag);
                    """);

            statement.execute("""
                    CREATE INDEX idx_relationship_a
                    ON behavioural_relationships(borrower_a);
                    """);

            statement.execute("""
                    CREATE INDEX idx_relationship_b
                    ON behavioural_relationships(borrower_b);
                    """);

            /**
             * ==================================================
             * EXECUTION SUMMARY
             * ==================================================
             */

            System.out.println(
                    "\n=================================================="
            );

            System.out.println(
                    "BCIP SCHEMA INITIALIZED"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Behavioural intelligence infrastructure created."
            );

            System.out.println(
                    "Informational opacity persistence enabled."
            );

            System.out.println(
                    "Explainable graph persistence enabled."
            );

            System.out.println(
                    "Schema reset completed successfully."
            );
        }
    }
}
