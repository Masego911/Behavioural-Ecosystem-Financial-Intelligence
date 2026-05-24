import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TemporalContagionAnalyzer
 *
 * Responsible ONLY for:
 * - temporal ecosystem contagion analysis,
 * - behavioural instability evolution,
 * - and future borrower ecosystem interpretation.
 *
 * IMPORTANT:
 * - No persistence
 * - No anomaly scoring
 * - No graph construction
 * - No ML training
 *
 * Single Responsibility:
 * Temporal behavioural contagion intelligence.
 *
 * Research Alignment:
 * Financial instability often spreads through:
 * connected behavioural ecosystems.
 *
 * This class investigates:
 * how behavioural deterioration evolves
 * across borrower communities over time.
 */
public class TemporalContagionAnalyzer {

    /**
     * Behavioural state classifier.
     */
    private BehaviouralStateClassifier
            stateClassifier =
            new BehaviouralStateClassifier();

    /**
     * Temporal behavioural engine.
     */
    private MarkovChainEngine
            markovChainEngine;

    /**
     * Constructor.
     *
     * @param markovChainEngine
     * Temporal behavioural engine.
     */
    public TemporalContagionAnalyzer(

            MarkovChainEngine markovChainEngine
    ) {

        this.markovChainEngine =
                markovChainEngine;
    }

    /**
     * analyzeTemporalContagion()
     *
     * Analyzes:
     * future behavioural contagion
     * inside borrower ecosystems.
     *
     * @param borrowers
     * Behavioural borrowers.
     *
     * @param propagatedRiskScores
     * Graph-propagated instability scores.
     *
     * @param unionFind
     * Behavioural connectivity infrastructure.
     */
    public void analyzeTemporalContagion(

            List<Borrower> borrowers,

            Map<String, Integer>
                    propagatedRiskScores,

            UnionFind unionFind
    ) {

        /**
         * ==================================================
         * CLUSTER FUTURE STATE STORAGE
         * ==================================================
         */

        Map<String,

                Map<BehaviouralState, Integer>>

                clusterStateCounts =

                new HashMap<>();

        /**
         * ==================================================
         * ECOSYSTEM EVOLUTION ANALYSIS
         * ==================================================
         */

        for (

                Borrower borrower
                : borrowers
        ) {

            /**
             * Retrieve:
             * behavioural cluster.
             */

            String clusterRoot =

                    unionFind.find(

                            borrower.getApplicantIdHash()
                    );

            /**
             * Create:
             * cluster container if missing.
             */

            if (

                    !clusterStateCounts.containsKey(
                            clusterRoot
                    )
            ) {

                clusterStateCounts.put(

                        clusterRoot,

                        new HashMap<>()
                );

                /**
                 * Initialise:
                 * all behavioural states.
                 */

                for (

                        BehaviouralState state
                        : BehaviouralState.values()
                ) {

                    clusterStateCounts
                            .get(clusterRoot)
                            .put(state, 0);
                }
            }

            /**
             * Determine:
             * current behavioural state.
             */

            BehaviouralState currentState =

                    stateClassifier.classifyState(

                            borrower,

                            propagatedRiskScores
                    );

            /**
             * Predict:
             * future behavioural state.
             */

            BehaviouralState futureState =

                    markovChainEngine
                            .predictNextState(
                                    currentState
                            );

            /**
             * Increment:
             * future ecosystem state count.
             */

            Map<BehaviouralState, Integer>
                    stateCounts =

                    clusterStateCounts
                            .get(clusterRoot);

            stateCounts.put(

                    futureState,

                    stateCounts.get(futureState) + 1
            );
        }

        /**
         * ==================================================
         * PRINT ECOSYSTEM ANALYSIS
         * ==================================================
         */

        printTemporalContagionReport(
                clusterStateCounts
        );
    }

    /**
     * printTemporalContagionReport()
     *
     * Generates:
     * explainable ecosystem contagion report.
     *
     * @param clusterStateCounts
     * Future ecosystem distributions.
     */
    private void printTemporalContagionReport(

            Map<String,

                    Map<BehaviouralState, Integer>>

                    clusterStateCounts
    ) {

        /**
         * ==================================================
         * REPORT HEADER
         * ==================================================
         */

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "TEMPORAL CONTAGION ANALYSIS"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * ==================================================
         * ANALYZE EACH ECOSYSTEM
         * ==================================================
         */

        for (

                String clusterRoot
                : clusterStateCounts.keySet()
        ) {

            Map<BehaviouralState, Integer>
                    stateCounts =

                    clusterStateCounts
                            .get(clusterRoot);

            /**
             * ==================================================
             * TOTAL ECOSYSTEM SIZE
             * ==================================================
             */

            int totalMembers = 0;

            for (

                    int count
                    : stateCounts.values()
            ) {

                totalMembers += count;
            }

            /**
             * Skip:
             * tiny ecosystems.
             */

            if (

                    totalMembers < 5
            ) {

                continue;
            }

            /**
             * ==================================================
             * RETRIEVE HIGH-RISK STATES
             * ==================================================
             */

            int stressed =
                    stateCounts.get(
                            BehaviouralState.STRESSED
                    );

            int delinquent =
                    stateCounts.get(
                            BehaviouralState.DELINQUENT
                    );

            int highRisk =
                    stateCounts.get(
                            BehaviouralState.HIGH_RISK
                    );

            int opaque =
                    stateCounts.get(
                            BehaviouralState.OPAQUE
                    );

            /**
             * ==================================================
             * CONTAGION RATE
             * ==================================================
             */

            int instabilityTotal =

                    stressed
                            + delinquent
                            + highRisk;

            double contagionRate =

                    (
                            (double) instabilityTotal
                                    / totalMembers
                    ) * 100;

            /**
             * ==================================================
             * ECOSYSTEM REPORT
             * ==================================================
             */

            System.out.println(

                    "\n--------------------------------------------------"
            );

            System.out.println(

                    "ECOSYSTEM ROOT: "
                            + clusterRoot
            );

            System.out.println(

                    "Ecosystem Members: "
                            + totalMembers
            );

            System.out.println(

                    "Projected Instability Rate: "
                            + String.format(
                            "%.2f",
                            contagionRate
                    )
                            + "%"
            );

            System.out.println(

                    "Projected Opaque Borrowers: "
                            + opaque
            );

            /**
             * ==================================================
             * HUMAN INTERPRETATION
             * ==================================================
             */

            System.out.println(
                    "\nINTERPRETATION:"
            );

            /**
             * ==================================================
             * LOW CONTAGION
             * ==================================================
             */

            if (

                    contagionRate < 20
            ) {

                System.out.println(

                        "This behavioural ecosystem currently appears relatively stable."
                );
            }

            /**
             * ==================================================
             * MODERATE CONTAGION
             * ==================================================
             */

            else if (

                    contagionRate < 40
            ) {

                System.out.println(

                        "Moderate behavioural deterioration is projected across this ecosystem."
                );
            }

            /**
             * ==================================================
             * HIGH CONTAGION
             * ==================================================
             */

            else {

                System.out.println(

                        "Elevated behavioural contagion risk detected."
                );

                System.out.println(

                        "Financial instability may spread across connected borrowers."
                );
            }

            /**
             * ==================================================
             * INFORMATIONAL OPACITY
             * ==================================================
             */

            if (

                    opaque > 0
            ) {

                System.out.println(

                        "\nInformational opacity remains present inside this behavioural ecosystem."
                );

                System.out.println(

                        "Limited borrower visibility may constrain future risk assessment."
                );
            }

            /**
             * ==================================================
             * OPERATIONAL RECOMMENDATIONS
             * ==================================================
             */

            System.out.println(
                    "\nOPERATIONAL RECOMMENDATIONS:"
            );

            System.out.println(
                    "- monitor ecosystem deterioration"
            );

            System.out.println(
                    "- investigate shared instability drivers"
            );

            System.out.println(
                    "- monitor behavioural contagion acceleration"
            );

            System.out.println(
                    "- evaluate concentrated repayment stress"
            );
        }
    }
}