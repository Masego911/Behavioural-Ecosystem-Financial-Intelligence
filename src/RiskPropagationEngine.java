import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * RiskPropagationEngine
 *
 * Responsible ONLY for:
 * - behavioural risk propagation,
 * - propagated uncertainty modelling,
 * - neighbour influence amplification,
 * - graph-based behavioural contagion,
 * - and multidimensional borrower intelligence.
 *
 * IMPORTANT:
 * - No persistence
 * - No clustering
 * - No anomaly detection
 * - No validation
 *
 * Research Alignment:
 * Modern behavioural credit systems propagate:
 * - financial distress,
 * - informational opacity,
 * - aggressive borrowing behaviour,
 * - and graph-connected instability.
 *
 * Therefore:
 * propagation is no longer:
 * binary default spread only.
 *
 * Instead:
 * multiple behavioural signals
 * influence connected borrowers.
 *
 * Single Responsibility:
 * Graph-based behavioural propagation.
 */
public class RiskPropagationEngine {

    /**
     * propagateRisk()
     *
     * Propagates:
     * - default exposure,
     * - behavioural uncertainty,
     * - financial stress,
     * - and aggressive credit behaviour
     * across graph-connected borrowers.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @param relationships
     * Behavioural graph edges.
     *
     * @return
     * Borrower propagated behavioural scores.
     */
    public Map<String, Integer> propagateRisk(

            List<Borrower> borrowers,

            List<BorrowerRelationship> relationships
    ) {

        /**
         * ==================================================
         * PROPAGATED DEFAULT RISK
         * ==================================================
         *
         * Represents:
         * neighbour default exposure.
         */
        Map<String, Integer> propagatedRiskScores =
                new HashMap<>();

        /**
         * ==================================================
         * PROPAGATED INFORMATIONAL UNCERTAINTY
         * ==================================================
         *
         * Represents:
         * neighbour behavioural opacity.
         */
        Map<String, Integer> propagatedOpacityScores =
                new HashMap<>();

        /**
         * ==================================================
         * PROPAGATED FINANCIAL STRESS
         * ==================================================
         *
         * Represents:
         * neighbour financial instability.
         */
        Map<String, Integer> propagatedStressScores =
                new HashMap<>();

        /**
         * ==================================================
         * PROPAGATED CREDIT AGGRESSION
         * ==================================================
         *
         * Represents:
         * neighbour aggressive credit seeking.
         */
        Map<String, Integer> propagatedAggressionScores =
                new HashMap<>();

        /**
         * ==================================================
         * STEP 1:
         * INITIALISE PROPAGATION SCORES
         * ==================================================
         */
        for (Borrower borrower : borrowers) {

            String borrowerId =
                    borrower.getApplicantIdHash();

            propagatedRiskScores.put(
                    borrowerId,
                    0
            );

            propagatedOpacityScores.put(
                    borrowerId,
                    0
            );

            propagatedStressScores.put(
                    borrowerId,
                    0
            );

            propagatedAggressionScores.put(
                    borrowerId,
                    0
            );
        }

        /**
         * ==================================================
         * STEP 2:
         * BUILD BORROWER LOOKUP INDEX
         * ==================================================
         *
         * Improves:
         * - graph traversal,
         * - scalability,
         * - and neighbour retrieval.
         */
        Map<String, Borrower> borrowerIndex =
                new HashMap<>();

        for (Borrower borrower : borrowers) {

            borrowerIndex.put(

                    borrower.getApplicantIdHash(),

                    borrower
            );
        }

        /**
         * ==================================================
         * PROPAGATION METRICS
         * ==================================================
         */

        int defaultPropagationEvents = 0;

        int opacityPropagationEvents = 0;

        int stressPropagationEvents = 0;

        int aggressionPropagationEvents = 0;

        /**
         * ==================================================
         * STEP 3:
         * GRAPH-BASED PROPAGATION
         * ==================================================
         */
        for (
                BorrowerRelationship relationship
                : relationships
        ) {

            String borrowerA =
                    relationship.getBorrowerA();

            String borrowerB =
                    relationship.getBorrowerB();

            /**
             * Retrieve source borrower.
             */
            Borrower sourceBorrower =
                    borrowerIndex.get(
                            borrowerA
                    );

            /**
             * Defensive graph protection.
             */
            if (sourceBorrower == null) {

                continue;
            }

            /**
             * ==================================================
             * DEFAULT RISK PROPAGATION
             * ==================================================
             *
             * Research Interpretation:
             * Default behaviour may propagate
             * through behavioural communities.
             */
            if (

                    Boolean.TRUE.equals(

                            sourceBorrower.getDefaultFlag()
                    )
            ) {

                propagatedRiskScores.put(

                        borrowerB,

                        propagatedRiskScores.get(
                                borrowerB
                        ) + 1
                );

                defaultPropagationEvents++;
            }

            /**
             * ==================================================
             * INFORMATIONAL OPACITY PROPAGATION
             * ==================================================
             *
             * IMPORTANT:
             * Missing income is interpreted as:
             * behavioural uncertainty.
             *
             * Research Interpretation:
             * Informational opacity may cluster
             * behaviourally across graph-connected
             * borrower communities.
             */
            if (

                    Boolean.TRUE.equals(

                            sourceBorrower.getMissingIncome()
                    )
            ) {

                propagatedOpacityScores.put(

                        borrowerB,

                        propagatedOpacityScores.get(
                                borrowerB
                        ) + 1
                );

                opacityPropagationEvents++;
            }

            /**
             * ==================================================
             * FINANCIAL STRESS PROPAGATION
             * ==================================================
             *
             * Behavioural Interpretation:
             * High utilisation and high DTI
             * may represent elevated
             * repayment instability.
             */
            if (

                    sourceBorrower.getCreditUtilisationPct()
                            != null

                            &&

                            sourceBorrower.getDtiRatio()
                                    != null

                            &&

                            sourceBorrower.getCreditUtilisationPct()
                                    > 75

                            &&

                            sourceBorrower.getDtiRatio()
                                    > 40
            ) {

                propagatedStressScores.put(

                        borrowerB,

                        propagatedStressScores.get(
                                borrowerB
                        ) + 1
                );

                stressPropagationEvents++;
            }

            /**
             * ==================================================
             * CREDIT AGGRESSION PROPAGATION
             * ==================================================
             *
             * Behavioural Interpretation:
             * Frequent hard inquiries may indicate:
             * - aggressive borrowing,
             * - liquidity stress,
             * - or elevated credit dependence.
             */
            if (

                    sourceBorrower.getNumHardInquiries6mo()
                            != null

                            &&

                            sourceBorrower.getNumHardInquiries6mo()
                                    > 5
            ) {

                propagatedAggressionScores.put(

                        borrowerB,

                        propagatedAggressionScores.get(
                                borrowerB
                        ) + 1
                );

                aggressionPropagationEvents++;
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
                "MULTIDIMENSIONAL RISK PROPAGATION"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Relationships Processed: "
                        + relationships.size()
        );

        System.out.println(
                "Default Propagation Events: "
                        + defaultPropagationEvents
        );

        System.out.println(
                "Opacity Propagation Events: "
                        + opacityPropagationEvents
        );

        System.out.println(
                "Stress Propagation Events: "
                        + stressPropagationEvents
        );

        System.out.println(
                "Aggression Propagation Events: "
                        + aggressionPropagationEvents
        );

        /**
         * ==================================================
         * INTERPRETATION
         * ==================================================
         */

        System.out.println(
                "\nINTERPRETATION:"
        );

        System.out.println(
                "- Default propagation models graph-connected repayment instability."
        );

        System.out.println(
                "- Opacity propagation models behavioural uncertainty spread."
        );

        System.out.println(
                "- Stress propagation models graph-connected financial pressure."
        );

        System.out.println(
                "- Aggression propagation models elevated credit-seeking behaviour."
        );

        System.out.println(
                "\nBehavioural propagation completed."
        );

        /**
         * ==================================================
         * RETURN PRIMARY PROPAGATED RISK
         * ==================================================
         *
         * IMPORTANT:
         * For now:
         * return propagated default risk scores.
         *
         * Future evolution:
         * create composite propagation object.
         */
        return propagatedRiskScores;
    }
}