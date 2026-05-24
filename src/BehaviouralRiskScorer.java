import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BehaviouralRiskScorer
 *
 * Responsible ONLY for:
 * - unified behavioural risk scoring,
 * - uncertainty-aware borrower scoring,
 * - graph-influenced risk aggregation,
 * - and explainable intelligence scoring.
 *
 * IMPORTANT:
 * - No graph traversal
 * - No anomaly detection
 * - No validation
 * - No persistence
 * - No ML training
 *
 * Research Alignment:
 * Modern behavioural intelligence systems combine:
 * - financial stress,
 * - repayment instability,
 * - graph propagation,
 * - behavioural anomalies,
 * - and informational opacity.
 *
 * IMPORTANT:
 * Missing income is now treated as:
 * informational uncertainty,
 * not automatically as default behaviour.
 *
 * Single Responsibility:
 * Unified behavioural intelligence scoring.
 */
public class BehaviouralRiskScorer {

    /**
     * ==================================================
     * SCORE WEIGHTS
     * ==================================================
     *
     * IMPORTANT:
     * These weights represent:
     * behavioural contribution intensity.
     */

    /**
     * Financial stress weight.
     */
    private static final int HIGH_DTI_WEIGHT = 15;

    /**
     * Credit overextension weight.
     */
    private static final int HIGH_UTILISATION_WEIGHT = 15;

    /**
     * Repayment instability weight.
     */
    private static final int DELINQUENCY_WEIGHT = 20;

    /**
     * Aggressive borrowing behaviour weight.
     */
    private static final int INQUIRY_WEIGHT = 10;

    /**
     * Propagated graph instability weight.
     */
    private static final int PROPAGATED_RISK_WEIGHT = 10;

    /**
     * Behavioural uncertainty weight.
     *
     * IMPORTANT:
     * Missing income increases:
     * uncertainty,
     * not necessarily default probability directly.
     */
    private static final int INFORMATIONAL_OPACITY_WEIGHT = 12;

    /**
     * Historical default behaviour weight.
     */
    private static final int DEFAULT_HISTORY_WEIGHT = 25;

    /**
     * scoreBorrowers()
     *
     * Generates:
     * - unified behavioural intelligence scores,
     * - explainable borrower risk aggregation,
     * - and uncertainty-aware operational scoring.
     *
     * @param borrowers
     * Structured behavioural borrowers.
     *
     * @param propagatedRiskScores
     * Graph-propagated behavioural instability.
     *
     * @return
     * Borrower ID -> behavioural intelligence score.
     */
    public Map<String, Integer> scoreBorrowers(

            List<Borrower> borrowers,

            Map<String, Integer> propagatedRiskScores
    ) {

        /**
         * ==================================================
         * SCORE STORAGE
         * ==================================================
         */

        Map<String, Integer> borrowerScores =
                new HashMap<>();

        /**
         * Tracks:
         * scoring observability.
         */
        int highRiskBorrowers = 0;

        /**
         * ==================================================
         * SCORE EACH BORROWER
         * ==================================================
         */

        for (Borrower borrower : borrowers) {

            /**
             * ==================================================
             * INITIAL SCORE
             * ==================================================
             */

            int score = 0;

            /**
             * ==================================================
             * HIGH DTI DETECTION
             * ==================================================
             *
             * Behavioural interpretation:
             * Elevated debt pressure.
             */

            if (

                    borrower.getDtiRatio() != null

                            &&

                            borrower.getDtiRatio() > 40
            ) {

                score += HIGH_DTI_WEIGHT;
            }

            /**
             * ==================================================
             * HIGH UTILISATION DETECTION
             * ==================================================
             *
             * Behavioural interpretation:
             * Credit overextension.
             */

            if (

                    borrower.getCreditUtilisationPct() != null

                            &&

                            borrower.getCreditUtilisationPct() > 80
            ) {

                score += HIGH_UTILISATION_WEIGHT;
            }

            /**
             * ==================================================
             * DELINQUENCY DETECTION
             * ==================================================
             *
             * Behavioural interpretation:
             * Repayment instability.
             */

            if (

                    borrower.getNumDelinquencies2yr() != null

                            &&

                            borrower.getNumDelinquencies2yr() >= 3
            ) {

                score += DELINQUENCY_WEIGHT;
            }

            /**
             * ==================================================
             * HARD INQUIRY DETECTION
             * ==================================================
             *
             * Behavioural interpretation:
             * Aggressive credit-seeking behaviour.
             */

            if (

                    borrower.getNumHardInquiries6mo() != null

                            &&

                            borrower.getNumHardInquiries6mo() >= 5
            ) {

                score += INQUIRY_WEIGHT;
            }

            /**
             * ==================================================
             * PROPAGATED GRAPH RISK
             * ==================================================
             *
             * Behavioural interpretation:
             * Connected borrower instability.
             */

            int propagatedRisk =

                    propagatedRiskScores.getOrDefault(

                            borrower.getApplicantIdHash(),

                            0
                    );

            score +=
                    propagatedRisk
                            * PROPAGATED_RISK_WEIGHT;

            /**
             * ==================================================
             * INFORMATIONAL OPACITY
             * ==================================================
             *
             * IMPORTANT:
             * Missing income is now treated as:
             * behavioural uncertainty.
             *
             * Possible interpretations:
             * - thin-file borrower,
             * - informal employment,
             * - institutional invisibility,
             * - sparse reporting,
             * - or unstable economic identity.
             */

            if (

                    Boolean.TRUE.equals(

                            borrower.getMissingIncome()
                    )
            ) {

                score += INFORMATIONAL_OPACITY_WEIGHT;
            }

            /**
             * ==================================================
             * HISTORICAL DEFAULT SIGNAL
             * ==================================================
             *
             * Behavioural interpretation:
             * Historical repayment instability.
             */

            if (

                    Boolean.TRUE.equals(

                            borrower.getDefaultFlag()
                    )
            ) {

                score += DEFAULT_HISTORY_WEIGHT;
            }

            /**
             * ==================================================
             * STORE FINAL SCORE
             * ==================================================
             */

            borrowerScores.put(

                    borrower.getApplicantIdHash(),

                    score
            );

            /**
             * ==================================================
             * HIGH-RISK OBSERVABILITY
             * ==================================================
             */

            if (score >= 70) {

                highRiskBorrowers++;
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
                "BEHAVIOURAL RISK SCORING COMPLETE"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Borrowers Scored: "
                        + borrowers.size()
        );

        System.out.println(
                "High-Risk Borrowers: "
                        + highRiskBorrowers
        );

        System.out.println(
                "\nSCORING SIGNALS:"
        );

        System.out.println(
                "- financial stress"
        );

        System.out.println(
                "- repayment instability"
        );

        System.out.println(
                "- graph propagation"
        );

        System.out.println(
                "- informational opacity"
        );

        System.out.println(
                "- and behavioural uncertainty"
        );

        /**
         * ==================================================
         * RETURN SCORES
         * ==================================================
         */

        return borrowerScores;
    }
}