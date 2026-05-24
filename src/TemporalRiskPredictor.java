import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TemporalRiskPredictor
 *
 * Responsible ONLY for:
 * - portfolio-level temporal forecasting,
 * - behavioural state projection,
 * - and future ecosystem risk analysis.
 *
 * IMPORTANT:
 * - No graph construction
 * - No anomaly detection
 * - No persistence
 * - No scoring
 *
 * Single Responsibility:
 * Temporal portfolio forecasting.
 *
 * Research Alignment:
 * Modern financial intelligence systems
 * increasingly model:
 * - behavioural migration,
 * - future instability,
 * - repayment deterioration,
 * - and ecosystem evolution.
 *
 * This class predicts:
 * future behavioural portfolio structure.
 */
public class TemporalRiskPredictor {

    /**
     * Behavioural state classifier.
     */
    private BehaviouralStateClassifier
            stateClassifier =
            new BehaviouralStateClassifier();

    /**
     * Markov behavioural engine.
     */
    private MarkovChainEngine
            markovChainEngine;

    /**
     * Constructor.
     *
     * @param markovChainEngine
     * Temporal behavioural engine.
     */
    public TemporalRiskPredictor(

            MarkovChainEngine markovChainEngine
    ) {

        this.markovChainEngine =
                markovChainEngine;
    }

    /**
     * predictPortfolioEvolution()
     *
     * Predicts:
     * future behavioural ecosystem evolution.
     *
     * @param borrowers
     * Behavioural borrowers.
     *
     * @param propagatedRiskScores
     * Graph-propagated instability scores.
     */
    public void predictPortfolioEvolution(

            List<Borrower> borrowers,

            Map<String, Integer>
                    propagatedRiskScores
    ) {

        /**
         * ==================================================
         * FUTURE STATE COUNTERS
         * ==================================================
         */

        Map<BehaviouralState, Integer>
                futureStateCounts =
                new HashMap<>();

        /**
         * ==================================================
         * INITIALISE STATE COUNTERS
         * ==================================================
         */

        for (

                BehaviouralState state
                : BehaviouralState.values()
        ) {

            futureStateCounts.put(

                    state,

                    0
            );
        }

        /**
         * ==================================================
         * PORTFOLIO EVOLUTION
         * ==================================================
         */

        for (

                Borrower borrower
                : borrowers
        ) {

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
             * future state count.
             */

            futureStateCounts.put(

                    futureState,

                    futureStateCounts.get(
                            futureState
                    ) + 1
            );
        }

        /**
         * ==================================================
         * EXECUTIVE REPORTING
         * ==================================================
         */

        printForecastReport(

                borrowers.size(),

                futureStateCounts
        );
    }

    /**
     * printForecastReport()
     *
     * Generates:
     * explainable temporal portfolio report.
     *
     * @param totalBorrowers
     * Total borrowers analysed.
     *
     * @param futureStateCounts
     * Future behavioural distribution.
     */
    private void printForecastReport(

            int totalBorrowers,

            Map<BehaviouralState, Integer>
                    futureStateCounts
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
                "TEMPORAL RISK FORECAST"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(

                "Borrowers Analysed: "
                        + totalBorrowers
        );

        /**
         * ==================================================
         * FUTURE DISTRIBUTION
         * ==================================================
         */

        System.out.println(

                "\nFUTURE BEHAVIOURAL DISTRIBUTION"
        );

        System.out.println(
                "--------------------------------------------------"
        );

        for (

                BehaviouralState state
                : futureStateCounts.keySet()
        ) {

            int count =
                    futureStateCounts.get(state);

            double percentage =

                    (
                            (double) count
                                    / totalBorrowers
                    ) * 100;

            System.out.println(

                    state
                            + ": "
                            + count
                            + " borrowers ("
                            + String.format(
                            "%.2f",
                            percentage
                    )
                            + "%)"
            );
        }

        /**
         * ==================================================
         * EXECUTIVE INTERPRETATION
         * ==================================================
         */

        printExecutiveInterpretation(
                futureStateCounts,
                totalBorrowers
        );
    }

    /**
     * printExecutiveInterpretation()
     *
     * Generates:
     * human-readable future portfolio intelligence.
     *
     * @param futureStateCounts
     * Future behavioural counts.
     *
     * @param totalBorrowers
     * Total analysed borrowers.
     */
    private void printExecutiveInterpretation(

            Map<BehaviouralState, Integer>
                    futureStateCounts,

            int totalBorrowers
    ) {

        /**
         * ==================================================
         * RETRIEVE HIGH-RISK STATES
         * ==================================================
         */

        int stressed =
                futureStateCounts.get(
                        BehaviouralState.STRESSED
                );

        int delinquent =
                futureStateCounts.get(
                        BehaviouralState.DELINQUENT
                );

        int highRisk =
                futureStateCounts.get(
                        BehaviouralState.HIGH_RISK
                );

        int defaulted =
                futureStateCounts.get(
                        BehaviouralState.DEFAULTED
                );

        int opaque =
                futureStateCounts.get(
                        BehaviouralState.OPAQUE
                );

        /**
         * ==================================================
         * COMBINED FUTURE INSTABILITY
         * ==================================================
         */

        int futureInstability =

                stressed
                        + delinquent
                        + highRisk
                        + defaulted;

        double instabilityRate =

                (
                        (double) futureInstability
                                / totalBorrowers
                ) * 100;

        /**
         * ==================================================
         * EXECUTIVE SUMMARY
         * ==================================================
         */

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "EXECUTIVE TEMPORAL INTERPRETATION"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * ==================================================
         * PORTFOLIO STABILITY
         * ==================================================
         */

        if (

                instabilityRate < 20
        ) {

            System.out.println(

                    "The portfolio currently exhibits relatively stable behavioural evolution."
            );
        }

        else if (

                instabilityRate < 40
        ) {

            System.out.println(

                    "Moderate behavioural deterioration signals are emerging across the portfolio."
            );
        }

        else {

            System.out.println(

                    "Elevated behavioural instability is projected across the portfolio."
            );
        }

        /**
         * ==================================================
         * DEFAULT EXPOSURE
         * ==================================================
         */

        if (

                defaulted > 0
        ) {

            System.out.println(

                    "\nProjected repayment failure exposure detected."
            );

            System.out.println(

                    "Some borrowers exhibit trajectories associated with future default risk."
            );
        }

        /**
         * ==================================================
         * INFORMATIONAL UNCERTAINTY
         * ==================================================
         */

        if (

                opaque > 0
        ) {

            System.out.println(

                    "\nInformational opacity remains present within the future behavioural ecosystem."
            );

            System.out.println(

                    "Future borrower visibility may remain partially constrained."
            );
        }

        /**
         * ==================================================
         * OPERATIONAL RECOMMENDATIONS
         * ==================================================
         */

        System.out.println(

                "\nOPERATIONAL RECOMMENDATIONS"
        );

        System.out.println(
                "--------------------------------------------------"
        );

        System.out.println(
                "- monitor behavioural deterioration trends"
        );

        System.out.println(
                "- investigate elevated instability ecosystems"
        );

        System.out.println(
                "- review future delinquency concentration"
        );

        System.out.println(
                "- improve visibility of opaque borrowers"
        );

        System.out.println(
                "- monitor future repayment stress acceleration"
        );
    }
}