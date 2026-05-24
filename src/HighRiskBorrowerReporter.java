import java.util.List;
import java.util.Map;

/**
 * HighRiskBorrowerReporter
 *
 * Responsible ONLY for:
 * - high-risk borrower reporting,
 * - explainable borrower intelligence,
 * - operational behavioural visibility,
 * - multidimensional risk interpretation,
 * - and borrower prioritisation.
 *
 * IMPORTANT:
 * - No graph construction
 * - No anomaly detection
 * - No persistence
 * - No scoring
 *
 * Research Alignment:
 * Modern behavioural credit systems require:
 * - explainable intelligence,
 * - uncertainty interpretation,
 * - graph-aware reporting,
 * - and multidimensional behavioural analysis.
 *
 * Therefore:
 * reporting is no longer:
 * simple score output.
 *
 * Instead:
 * reports explain:
 * - WHY borrowers are risky,
 * - WHAT behavioural signals exist,
 * - and HOW uncertainty propagates.
 *
 * Single Responsibility:
 * Explainable high-risk borrower reporting.
 */
public class HighRiskBorrowerReporter {

    /**
     * ==================================================
     * HIGH-RISK THRESHOLD
     * ==================================================
     *
     * Minimum propagated score required
     * for elevated operational concern.
     */
    private static final int HIGH_RISK_THRESHOLD = 3;

    /**
     * printHighRiskBorrowers()
     *
     * Displays:
     * - explainable behavioural intelligence,
     * - uncertainty-aware reporting,
     * - and graph-informed operational risk.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @param riskScores
     * Graph-propagated behavioural risk scores.
     */
    public void printHighRiskBorrowers(

            List<Borrower> borrowers,

            Map<String, Integer> riskScores
    ) {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "HIGH-RISK BEHAVIOURAL INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * Tracks:
         * operationally significant borrowers.
         */
        int highRiskBorrowerCount = 0;

        /**
         * ==================================================
         * ANALYSE BORROWERS
         * ==================================================
         */
        for (Borrower borrower : borrowers) {

            /**
             * Retrieve propagated graph risk.
             */
            int propagatedRisk =

                    riskScores.getOrDefault(

                            borrower.getApplicantIdHash(),

                            0
                    );

            /**
             * ==================================================
             * HIGH-RISK CLASSIFICATION
             * ==================================================
             */
            if (propagatedRisk >= HIGH_RISK_THRESHOLD) {

                highRiskBorrowerCount++;

                /**
                 * ==================================================
                 * DISPLAY CORE BORROWER PROFILE
                 * ==================================================
                 */

                System.out.println(
                        "\n=================================================="
                );

                System.out.println(
                        "HIGH-RISK BORROWER DETECTED"
                );

                System.out.println(
                        "=================================================="
                );

                System.out.println(
                        "Borrower ID: "
                                + borrower.getApplicantIdHash()
                );

                System.out.println(
                        "Propagated Risk Score: "
                                + propagatedRisk
                );

                System.out.println(
                        "Age: "
                                + borrower.getAge()
                );

                /**
                 * ==================================================
                 * NULL-SAFE INCOME DISPLAY
                 * ==================================================
                 */

                System.out.println(
                        "Annual Income: "
                                +

                                (
                                        borrower.getAnnualIncome()
                                                != null

                                                ?

                                                borrower.getAnnualIncome()

                                                :

                                                "MISSING"
                                )
                );

                System.out.println(
                        "DTI Ratio: "
                                + borrower.getDtiRatio()
                );

                System.out.println(
                        "Credit Utilisation: "
                                + borrower.getCreditUtilisationPct()
                );

                System.out.println(
                        "Delinquencies: "
                                + borrower.getNumDelinquencies2yr()
                );

                System.out.println(
                        "Hard Inquiries: "
                                + borrower.getNumHardInquiries6mo()
                );

                System.out.println(
                        "Default Flag: "
                                + borrower.getDefaultFlag()
                );

                /**
                 * ==================================================
                 * BEHAVIOURAL SIGNAL ANALYSIS
                 * ==================================================
                 */

                System.out.println(
                        "\nBEHAVIOURAL SIGNALS:"
                );

                /**
                 * ==================================================
                 * INFORMATIONAL OPACITY
                 * ==================================================
                 */

                if (

                        Boolean.TRUE.equals(

                                borrower.getMissingIncome()
                        )
                ) {

                    System.out.println(
                            "- Informational Opacity Detected"
                    );

                    System.out.println(
                            "  Interpretation:"
                    );

                    System.out.println(
                            "  Borrower exhibits missing income behaviour."
                    );

                    System.out.println(
                            "  Research-aligned interpretation suggests:"
                    );

                    System.out.println(
                            "  - thin-file borrower behaviour,"
                    );

                    System.out.println(
                            "  - institutional invisibility,"
                    );

                    System.out.println(
                            "  - informal economic participation,"
                    );

                    System.out.println(
                            "  - or elevated uncertainty."
                    );
                }

                /**
                 * ==================================================
                 * FINANCIAL STRESS
                 * ==================================================
                 */

                if (

                        borrower.getCreditUtilisationPct()
                                != null

                                &&

                                borrower.getCreditUtilisationPct()
                                        > 75
                ) {

                    System.out.println(
                            "- Elevated Financial Stress"
                    );

                    System.out.println(
                            "  Interpretation:"
                    );

                    System.out.println(
                            "  High revolving utilisation "
                                    + "suggests elevated liquidity pressure."
                    );
                }

                /**
                 * ==================================================
                 * HIGH DTI
                 * ==================================================
                 */

                if (

                        borrower.getDtiRatio()
                                != null

                                &&

                                borrower.getDtiRatio()
                                        > 40
                ) {

                    System.out.println(
                            "- Debt Overextension Detected"
                    );

                    System.out.println(
                            "  Interpretation:"
                    );

                    System.out.println(
                            "  Borrower exhibits elevated debt burden "
                                    + "relative to financial capacity."
                    );
                }

                /**
                 * ==================================================
                 * AGGRESSIVE CREDIT SEEKING
                 * ==================================================
                 */

                if (

                        borrower.getNumHardInquiries6mo()
                                != null

                                &&

                                borrower.getNumHardInquiries6mo()
                                        >= 6
                ) {

                    System.out.println(
                            "- Aggressive Credit-Seeking Behaviour"
                    );

                    System.out.println(
                            "  Interpretation:"
                    );

                    System.out.println(
                            "  Frequent hard inquiries may indicate:"
                    );

                    System.out.println(
                            "  - liquidity stress,"
                    );

                    System.out.println(
                            "  - aggressive borrowing,"
                    );

                    System.out.println(
                            "  - or elevated credit dependence."
                    );
                }

                /**
                 * ==================================================
                 * DEFAULT HISTORY
                 * ==================================================
                 */

                if (

                        Boolean.TRUE.equals(

                                borrower.getDefaultFlag()
                        )
                ) {

                    System.out.println(
                            "- Historical Default Behaviour"
                    );

                    System.out.println(
                            "  Interpretation:"
                    );

                    System.out.println(
                            "  Borrower exhibits confirmed repayment instability."
                    );
                }

                /**
                 * ==================================================
                 * GRAPH-BASED RISK
                 * ==================================================
                 */

                if (propagatedRisk >= 5) {

                    System.out.println(
                            "- Elevated Graph-Connected Instability"
                    );

                    System.out.println(
                            "  Interpretation:"
                    );

                    System.out.println(
                            "  Borrower is behaviourally connected "
                                    + "to multiple risky borrower communities."
                    );
                }

                /**
                 * ==================================================
                 * OVERALL EXPLAINABLE INTELLIGENCE
                 * ==================================================
                 */

                System.out.println(
                        "\nEXPLAINABLE RISK SUMMARY:"
                );

                /**
                 * ==================================================
                 * OPAQUE HIGH-STRESS ACTOR
                 * ==================================================
                 */

                if (

                        Boolean.TRUE.equals(
                                borrower.getMissingIncome()
                        )

                                &&

                                borrower.getCreditUtilisationPct()
                                        != null

                                &&

                                borrower.getCreditUtilisationPct()
                                        > 75
                ) {

                    System.out.println(
                            "Borrower exhibits elevated financial stress "
                                    + "combined with significant informational opacity."
                    );

                    System.out.println(
                            "This behavioural profile may indicate:"
                    );

                    System.out.println(
                            "- thin-file instability,"
                    );

                    System.out.println(
                            "- institutional underrepresentation,"
                    );

                    System.out.println(
                            "- or elevated repayment uncertainty."
                    );
                }

                /**
                 * ==================================================
                 * GRAPH-EXPOSED BORROWER
                 * ==================================================
                 */

                else if (propagatedRisk >= 5) {

                    System.out.println(
                            "Borrower exhibits elevated propagated instability "
                                    + "through graph-connected risky neighbours."
                    );
                }

                /**
                 * ==================================================
                 * STANDARD HIGH-RISK PROFILE
                 * ==================================================
                 */

                else {

                    System.out.println(
                            "Borrower exhibits elevated behavioural risk "
                                    + "through financial stress "
                                    + "and graph-connected instability."
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
                "HIGH-RISK REPORTING SUMMARY"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Operational High-Risk Borrowers: "
                        + highRiskBorrowerCount
        );

        System.out.println(
                "\nExplainable behavioural reporting completed."
        );
    }
}