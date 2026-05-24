import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * DatabaseManager
 *
 * Responsible ONLY for:
 * - establishing SQLite database connections,
 * - centralising database configuration,
 * - and providing reusable access to the database.
 *
 * This class is part of:
 * - the infrastructure layer
 * of the BCIP architecture.
 *
 * IMPORTANT:
 * - No SQL inserts
 * - No schema creation
 * - No validation
 * - No ingestion logic
 *
 * Single Responsibility:
 * Database connection management.
 */
public class DatabaseManager {


    private static final String DATABASE_URL = "jdbc:sqlite:credit_system.db";


    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(DATABASE_URL);
    }
}