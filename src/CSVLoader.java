import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * CSVLoader
 *
 * Responsible ONLY for:
 * - reading CSV files,
 * - preserving raw values,
 * - converting rows into RawRecord objects,
 * - and exposing ingestion observability.
 *
 * IMPORTANT:
 * - No validation
 * - No parsing
 * - No SQL insertion
 * - No business logic
 *
 * Single Responsibility:
 * Raw behavioural ingestion.
 */
public class CSVLoader {

    /**
     * loadCSV()
     *
     * Loads behavioural CSV dataset.
     *
     * @param filePath
     * Behavioural dataset location.
     *
     * @return
     * Raw borrower records.
     */
    public List<RawRecord> loadCSV(
            String filePath
    ) {

        /**
         * Stores all raw behavioural rows.
         */
        List<RawRecord> rawRecords =
                new ArrayList<>();

        try (

                /**
                 * FileReader:
                 * Streams raw CSV file from disk.
                 */
                FileReader fileReader =
                        new FileReader(filePath);

                /**
                 * CSVReader:
                 * Parses CSV rows safely.
                 *
                 * Skip line 1 because:
                 * first row contains headers.
                 */
                CSVReader csvReader =
                        new CSVReaderBuilder(fileReader)
                                .withSkipLines(1)
                                .build()

        ) {

            /**
             * Stores current CSV row.
             */
            String[] row;

            /**
             * Row counter used for:
             * - observability,
             * - debugging,
             * - and ETL diagnostics.
             */
            int rowCounter = 0;

            /**
             * Read CSV rows sequentially.
             */
            while (
                    (row = csvReader.readNext()) != null
            ) {

                rowCounter++;

                /**
                 * Defensive ETL protection.
                 *
                 * Prevent malformed rows
                 * from corrupting pipeline state.
                 */
                if (row.length < 26) {

                    System.out.println(
                            "Skipping malformed row at row: "
                                    + rowCounter
                    );

                    continue;
                }

                /**
                 * DEBUGGING OBSERVABILITY
                 *
                 * Display first few rows only.
                 *
                 * Helps verify:
                 * - schema alignment,
                 * - column ordering,
                 * - and ingestion correctness.
                 */
                if (rowCounter <= 5) {

                    System.out.println(
                            "\n=================================================="
                    );

                    System.out.println(
                            "CSV INGESTION DEBUG"
                    );

                    System.out.println(
                            "=================================================="
                    );

                    System.out.println(
                            "Row Number: "
                                    + rowCounter
                    );

                    System.out.println(
                            "Column 0: "
                                    + row[0]
                    );

                    System.out.println(
                            "Column 1: "
                                    + row[1]
                    );

                    System.out.println(
                            "Column 2: "
                                    + row[2]
                    );

                    System.out.println(
                            "Column 3: "
                                    + row[3]
                    );

                    System.out.println(
                            "Column 4: "
                                    + row[4]
                    );

                    System.out.println(
                            "Column 5: "
                                    + row[5]
                    );

                    System.out.println(
                            "Column 6: "
                                    + row[6]
                    );

                    System.out.println(
                            "Column 7: "
                                    + row[7]
                    );

                    System.out.println(
                            "Column 8: "
                                    + row[8]
                    );

                    System.out.println(
                            "Column 9: "
                                    + row[9]
                    );

                    System.out.println(
                            "=================================================="
                    );
                }

                /**
                 * Construct raw behavioural record.
                 *
                 * IMPORTANT:
                 * RawRecord preserves:
                 * - original values,
                 * - original ordering,
                 * - and raw behavioural truth.
                 *
                 * No parsing occurs here.
                 */
                RawRecord rawRecord =
                        new RawRecord(

                                row[0],
                                row[1],
                                row[2],
                                row[3],
                                row[4],
                                row[5],
                                row[6],
                                row[7],
                                row[8],
                                row[9],
                                row[10],
                                row[11],
                                row[12],
                                row[13],
                                row[14],
                                row[15],
                                row[16],
                                row[17],
                                row[18],
                                row[19],
                                row[20],
                                row[21],
                                row[22],
                                row[23],
                                row[24],
                                row[25]
                        );

                /**
                 * Add raw behavioural record
                 * into ingestion collection.
                 */
                rawRecords.add(
                        rawRecord
                );
            }

            /**
             * Final ingestion metrics.
             */
            System.out.println(
                    rawRecords.size()
                            + " raw borrower records loaded."
            );

        }

        catch (FileNotFoundException exception) {

            throw new RuntimeException(
                    exception
            );
        }

        catch (IOException exception) {

            throw new RuntimeException(
                    exception
            );
        }

        catch (CsvValidationException exception) {

            throw new RuntimeException(
                    exception
            );
        }

        /**
         * Return raw behavioural ingestion layer.
         */
        return rawRecords;
    }
}