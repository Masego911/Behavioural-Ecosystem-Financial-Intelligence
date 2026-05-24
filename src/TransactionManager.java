
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * TransactionManager
 *
 * Responsible ONLY for:
 * - shared database connection management,
 * - transaction lifecycle control,
 * - commit handling,
 * - and rollback operations.

 * Single Responsibility:
 * Transaction infrastructure management.
 */
public class TransactionManager {


    private Connection connection;
    private static final String DATABASE_URL = "jdbc:sqlite:credit_system.db";

    public TransactionManager() {

        try {


            connection = DriverManager.getConnection(DATABASE_URL);

            /**
             * Disable auto-commit.
             *
             * IMPORTANT: control transaction boundaries manually.
             */
            connection.setAutoCommit(false);

            System.out.println("Transaction manager initialized.");

        }
        catch (SQLException exception) {

            System.out.println("Transaction manager initialization failed: " + exception.getMessage());
        }
    }

    /**
     * getConnection()
     *
     * Returns shared database connection.
     *
     * @return
     * Shared SQLite connection.
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * commit() -> Commits current transaction.
     */
    public void commit() {

        try {

            //Persist transaction permanently.
            connection.commit();
            System.out.println("Transaction committed successfully.");

        }
        catch (SQLException exception) {

            System.out.println("Transaction commit failed: " + exception.getMessage());
        }
    }

    /**
     * rollback()
     *
     * Reverts transaction state.
     *
     * Used when:
     * - batch insertion fails,
     * - corruption occurs,
     * - or partial writes happen.
     */
    public void rollback() {

        try {

            //Revert uncommitted changes.
            connection.rollback();
            System.out.println("Transaction rolled back.");

        }
        catch (SQLException exception) {

            System.out.println("Rollback failed: " + exception.getMessage());
        }
    }

    /**
     * close() -> Closes shared database connection.
     */
    public void close() {

        try {

            //Close active SQLite connection.
            connection.close();
            System.out.println("Transaction connection closed.");

        }
        catch (SQLException exception) {

            System.out.println("Connection close failed: " + exception.getMessage());
        }
    }
}

