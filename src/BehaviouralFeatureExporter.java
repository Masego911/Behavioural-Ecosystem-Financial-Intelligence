import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * BehaviouralFeatureExporter
 *
 * Responsible ONLY for:
 * - ML feature engineering,
 * - behavioural dataset generation,
 * - explainable feature export,
 * - and AI-ready analytical persistence.
 *
 * IMPORTANT:
 * - No graph traversal
 * - No validation
 * - No anomaly detection
 * - No scoring logic
 * - No behavioural interpretation
 *
 * Research Alignment:
 * Modern behavioural intelligence systems export:
 * - financial stress signals,
 * - graph intelligence,
 * - propagated instability,
 * - informational opacity,
 * - and explainable uncertainty features.
 *
 * IMPORTANT:
 * Missing income is now treated as:
 * behavioural intelligence,
 * not simple missing data.
 *
 * Single Responsibility:
 * Behavioural ML feature export.
 */
public class BehaviouralFeatureExporter {

    /**
     * ==================================================
     * EXPORT FILE LOCATION
     * ==================================================
     *
     * Output:
     * ML-ready behavioural dataset.
     */
    private static final String EXPORT_FILE =

            "behavioural_features.csv";

    /**
     * exportFeatures()
     *
     * Exports:
     * - behavioural borrower features,
     * - graph intelligence,
     * - propagated instability,
     * - anomaly indicators,
     * - and explainable uncertainty signals.
     *
     * @param borrowers
     * Structured behavioural borrowers.
     *
     * @param propagatedRiskScores
     * Graph-propagated behavioural risk.
     *
     * @param behaviouralScores
     * Unified behavioural intelligence scores.
     *
     * @param anomalies
     * Suspicious borrower identifiers.
     */
    public void exportFeatures(

            List<Borrower> borrowers,

            Map<String, Integer> propagatedRiskScores,

            Map<String, Integer> behaviouralScores,

            List<String> anomalies
    ) {

        /**
         * ==================================================
         * TRY-WITH-RESOURCES
         * ==================================================
         *
         * Automatically closes:
         * - file writer,
         * - buffered writer,
         * - and IO resources.
         */
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(EXPORT_FILE))) {

            /**
             * ==================================================
             * CSV HEADER
             * ==================================================
             *
             * IMPORTANT:
             * This dataset combines:
             * - financial behaviour,
             * - graph intelligence,
             * - uncertainty modelling,
             * - and repayment instability.
             */
            writer.write(

                    "borrower_id,"

                            + "age,"

                            + "annual_income,"

                            + "missing_income_flag,"

                            + "dti_ratio,"

                            + "credit_utilisation_pct,"

                            + "num_delinquencies_2yr,"

                            + "num_hard_inquiries_6mo,"

                            + "propagated_risk_score,"

                            + "behavioural_score,"

                            + "anomaly_flag,"

                            + "default_flag,"

                            + "region,"

                            + "home_ownership,"

                            + "email_domain_type"

            );

            writer.newLine();

            /**
             * ==================================================
             * EXPORT BORROWER FEATURES
             * ==================================================
             */

            for (Borrower borrower : borrowers) {

                /**
                 * ==================================================
                 * BORROWER IDENTIFIER
                 * ==================================================
                 */

                String borrowerId =
                        borrower.getApplicantIdHash();

                /**
                 * ==================================================
                 * PROPAGATED GRAPH RISK
                 * ==================================================
                 */

                int propagatedRisk =

                        propagatedRiskScores.getOrDefault(

                                borrowerId,

                                0
                        );

                /**
                 * ==================================================
                 * UNIFIED BEHAVIOURAL SCORE
                 * ==================================================
                 */

                int behaviouralScore =

                        behaviouralScores.getOrDefault(

                                borrowerId,

                                0
                        );

                /**
                 * ==================================================
                 * ANOMALY INDICATOR
                 * ==================================================
                 */

                int anomalyFlag =

                        anomalies.contains(
                                borrowerId
                        )

                                ? 1

                                : 0;

                /**
                 * ==================================================
                 * INFORMATIONAL OPACITY
                 * ==================================================
                 *
                 * Missing income is now:
                 * behavioural intelligence.
                 */
                int missingIncomeFlag =

                        Boolean.TRUE.equals(

                                borrower.getMissingIncome()
                        )

                                ? 1

                                : 0;

                /**
                 * ==================================================
                 * DEFAULT FLAG
                 * ==================================================
                 */

                int defaultFlag =

                        Boolean.TRUE.equals(

                                borrower.getDefaultFlag()
                        )

                                ? 1

                                : 0;

                /**
                 * ==================================================
                 * CONSTRUCT CSV ROW
                 * ==================================================
                 */

                String row =

                        borrowerId + ","

                                + safeValue(
                                borrower.getAge()
                        ) + ","

                                + safeValue(
                                borrower.getAnnualIncome()
                        ) + ","

                                + missingIncomeFlag + ","

                                + safeValue(
                                borrower.getDtiRatio()
                        ) + ","

                                + safeValue(
                                borrower.getCreditUtilisationPct()
                        ) + ","

                                + safeValue(
                                borrower.getNumDelinquencies2yr()
                        ) + ","

                                + safeValue(
                                borrower.getNumHardInquiries6mo()
                        ) + ","

                                + propagatedRisk + ","

                                + behaviouralScore + ","

                                + anomalyFlag + ","

                                + defaultFlag + ","

                                + safeValue(
                                borrower.getRegion()
                        ) + ","

                                + safeValue(
                                borrower.getHomeOwnership()
                        ) + ","

                                + safeValue(
                                borrower.getEmailDomainType()
                        );

                /**
                 * ==================================================
                 * WRITE FEATURE ROW
                 * ==================================================
                 */

                writer.write(row);

                writer.newLine();
            }

            /**
             * ==================================================
             * EXPORT SUMMARY
             * ==================================================
             */

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "BEHAVIOURAL FEATURE EXPORT COMPLETE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Export File: "
                            + EXPORT_FILE
            );

            System.out.println(
                    "Borrowers Exported: "
                            + borrowers.size()
            );

            System.out.println(
                    "Informational opacity features included."
            );

            System.out.println(
                    "Graph intelligence features included."
            );

            System.out.println(
                    "Behavioural ML dataset ready."
            );
        }

        /**
         * ==================================================
         * IO FAILURE HANDLING
         * ==================================================
         */

        catch (IOException exception) {

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "FEATURE EXPORT FAILURE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println("Failure Reason: " + exception.getMessage());
        }
    }

    /**
     * safeValue()
     *
     * Converts:
     * null values into safe CSV placeholders.
     *
     * IMPORTANT:
     * Prevents:
     * malformed CSV rows.
     *
     * @param value
     * Feature value.
     *
     * @return
     * Safe CSV representation.
     */
    private String safeValue(Object value) {

        /**
         * Null-safe export handling.
         */
        if (value == null) {

            return "NULL";
        }

        /**
         * Convert value to string.
         */
        return value.toString();
    }
}