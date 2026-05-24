import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * AnomalyDetectionEngine
 *
 * Responsible ONLY for:
 * - behavioural anomaly detection,
 * - graph-aware anomaly intelligence,
 * - uncertainty anomaly interpretation,
 * - suspicious borrower analysis,
 * - and explainable anomaly reporting.
 *
 * IMPORTANT:
 * - No persistence
 * - No graph construction
 * - No clustering
 * - No validation
 *
 * Research Alignment:
 * Modern behavioural anomaly systems detect:
 * - financial instability,
 * - informational opacity,
 * - propagated behavioural exposure,
 * - and relational inconsistencies.
 *
 * Therefore:
 * anomalies are no longer:
 * simple numeric outliers only.
 *
 * Instead:
 * anomalies represent:
 * unusual behavioural configurations.
 *
 * Single Responsibility:
 * Behavioural anomaly intelligence.
 */
public class AnomalyDetectionEngine {

    /**
     * detectAnomalies()
     *
     * Detects:
     * - behavioural anomalies,
     * - graph-driven anomalies,
     * - uncertainty anomalies,
     * - and propagated instability.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @param propagatedRiskScores
     * Graph-propagated behavioural risk scores.
     *
     * @return
     * Collection of suspicious borrower identifiers.
     */
    public List<String> detectAnomalies(List<Borrower> borrowers, Map<String, Integer> propagatedRiskScores) {

        /**
         * Stores:
         * suspicious borrower identifiers.
         */
        List<String> anomalies = new ArrayList<>();

        /**
         * ==================================================
         * ANOMALY METRICS
         * ==================================================
         */

        int stressAnomalies = 0;

        int opacityAnomalies = 0;

        int propagatedRiskAnomalies = 0;

        int aggressiveBorrowingAnomalies = 0;

        int contradictionAnomalies = 0;

        /**
         * ==================================================
         * STEP 1:
         * ANALYSE BORROWER BEHAVIOUR
         * ==================================================
         */
        for (Borrower borrower : borrowers) {

            String borrowerId = borrower.getApplicantIdHash();

            /**
             * Retrieve propagated graph risk.
             */
            int propagatedRisk = propagatedRiskScores.getOrDefault(borrowerId, 0);

            /**
             * ==================================================
             * FINANCIAL STRESS ANOMALY
             * ==================================================
             *
             * Behavioural Interpretation:
             * Extreme debt pressure
             * combined with high utilisation
             * may indicate elevated repayment instability.
             */
            boolean financialStressAnomaly = borrower.getCreditUtilisationPct() != null && borrower.getDtiRatio() != null && borrower.getCreditUtilisationPct() > 90 && borrower.getDtiRatio() > 45;

            /**
             * ==================================================
             * INFORMATIONAL OPACITY ANOMALY
             * ==================================================
             *
             * Research Interpretation:
             * Missing income combined with:
             * - financial stress,
             * - aggressive borrowing,
             * - or graph instability
             * may indicate elevated uncertainty.
             */
            boolean opacityAnomaly = Boolean.TRUE.equals(borrower.getMissingIncome()) && (borrower.getCreditUtilisationPct() != null && borrower.getCreditUtilisationPct()> 7);

            /**
             * ==================================================
             * AGGRESSIVE CREDIT-SEEKING ANOMALY
             * ==================================================
             *
             * Behavioural Interpretation:
             * Frequent hard inquiries
             * may indicate:
             * - liquidity pressure,
             * - aggressive borrowing,
             * - or financial instability.
             */
            boolean aggressiveBorrowingAnomaly = borrower.getNumHardInquiries6mo() != null && borrower.getNumHardInquiries6mo() >= 6;

            /**
             * ==================================================
             * PROPAGATED GRAPH RISK ANOMALY
             * ==================================================
             *
             * Research Interpretation:
             * Elevated propagated risk suggests:
             * graph-connected behavioural instability.
             */
            boolean propagatedRiskAnomaly = propagatedRisk >= 3;

            /**
             * ==================================================
             * RELATIONAL CONTRADICTION ANOMALY
             * ==================================================
             *
             * IMPORTANT:
             * Detects borrowers who appear:
             * financially stable locally,
             * but behaviourally unstable relationally.
             *
             * This is a graph-aware anomaly.
             */
            boolean contradictionAnomaly = borrower.getCreditUtilisationPct() != null && borrower.getCreditUtilisationPct()< 30 && borrower.getDtiRatio() != null && borrower.getDtiRatio()< 20 && propagatedRisk >= 4;

            /**
             * ==================================================
             * FLAG SUSPICIOUS BORROWERS
             * ==================================================
             */
            if (financialStressAnomaly || opacityAnomaly || aggressiveBorrowingAnomaly || propagatedRiskAnomaly || contradictionAnomaly) {

                anomalies.add(borrowerId);

                /**
                 * ==================================================
                 * EXPLAINABLE ANOMALY REPORTING
                 * ==================================================
                 */

                System.out.println(
                        "\n=================================================="
                );

                System.out.println("BEHAVIOURAL ANOMALY DETECTED");

                System.out.println("==================================================");

                System.out.println("Borrower ID: " + borrowerId);

                /**
                 * ==================================================
                 * FINANCIAL STRESS
                 * ==================================================
                 */

                if (financialStressAnomaly) {stressAnomalies++;
                    System.out.println("\nANOMALY TYPE:");

                    System.out.println(
                            "- Financial Stress Anomaly"
                    );

                    System.out.println(
                            "Interpretation:"
                    );

                    System.out.println(
                            "Borrower exhibits elevated financial stress "
                                    + "through extreme utilisation "
                                    + "and debt pressure."
                    );
                }

                /**
                 * ==================================================
                 * INFORMATIONAL OPACITY
                 * ==================================================
                 */

                if (opacityAnomaly) {

                    opacityAnomalies++;

                    System.out.println(
                            "\nANOMALY TYPE:"
                    );

                    System.out.println(
                            "- Informational Opacity Anomaly"
                    );

                    System.out.println(
                            "Interpretation:"
                    );

                    System.out.println(
                            "Borrower exhibits missing income "
                                    + "combined with elevated financial stress."
                    );

                    System.out.println(
                            "Research-aligned interpretation suggests:"
                    );

                    System.out.println(
                            "- thin-file borrower behaviour,"
                    );

                    System.out.println(
                            "- institutional invisibility,"
                    );

                    System.out.println(
                            "- behavioural opacity,"
                    );

                    System.out.println(
                            "- or elevated uncertainty."
                    );
                }

                /**
                 * ==================================================
                 * AGGRESSIVE BORROWING
                 * ==================================================
                 */

                if (aggressiveBorrowingAnomaly) {

                    aggressiveBorrowingAnomalies++;

                    System.out.println(
                            "\nANOMALY TYPE:"
                    );

                    System.out.println(
                            "- Aggressive Credit-Seeking Anomaly"
                    );

                    System.out.println(
                            "Interpretation:"
                    );

                    System.out.println(
                            "Borrower demonstrates elevated credit-seeking behaviour "
                                    + "through excessive hard inquiries."
                    );
                }

                /**
                 * ==================================================
                 * PROPAGATED RISK
                 * ==================================================
                 */

                if (propagatedRiskAnomaly) {

                    propagatedRiskAnomalies++;

                    System.out.println(
                            "\nANOMALY TYPE:"
                    );

                    System.out.println(
                            "- Propagated Graph Risk Anomaly"
                    );

                    System.out.println(
                            "Interpretation:"
                    );

                    System.out.println(
                            "Borrower exhibits elevated graph-connected "
                                    + "behavioural instability."
                    );

                    System.out.println(
                            "Propagated Risk Score: "
                                    + propagatedRisk
                    );
                }

                /**
                 * ==================================================
                 * RELATIONAL CONTRADICTION
                 * ==================================================
                 */

                if (contradictionAnomaly) {

                    contradictionAnomalies++;

                    System.out.println(
                            "\nANOMALY TYPE:"
                    );

                    System.out.println(
                            "- Relational Contradiction Anomaly"
                    );

                    System.out.println(
                            "Interpretation:"
                    );

                    System.out.println(
                            "Borrower appears financially stable locally "
                                    + "but remains embedded within "
                                    + "high-risk behavioural communities."
                    );

                    System.out.println(
                            "This may indicate:"
                    );

                    System.out.println(
                            "- hidden relational instability,"
                    );

                    System.out.println(
                            "- behavioural inconsistency,"
                    );

                    System.out.println(
                            "- or graph-connected exposure."
                    );
                }
            }
        }

        /**
         * ==================================================
         * EXECUTION SUMMARY
         * ==================================================
         */

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL ANOMALY INTELLIGENCE SUMMARY"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Stress Anomalies: "
                        + stressAnomalies
        );

        System.out.println(
                "Opacity Anomalies: "
                        + opacityAnomalies
        );

        System.out.println(
                "Aggressive Borrowing Anomalies: "
                        + aggressiveBorrowingAnomalies
        );

        System.out.println(
                "Propagated Risk Anomalies: "
                        + propagatedRiskAnomalies
        );

        System.out.println(
                "Relational Contradiction Anomalies: "
                        + contradictionAnomalies
        );

        System.out.println(
                "Total Suspicious Borrowers: "
                        + anomalies.size()
        );

        System.out.println(
                "\nResearch-aligned behavioural anomaly detection completed."
        );

        return anomalies;
    }
}

