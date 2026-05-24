import java.util.Map;

/**
 * BehaviouralTrajectoryReporter
 *
 * Responsible ONLY for:
 * - explainable temporal reporting,
 * - behavioural trajectory interpretation,
 * - and operational future-state intelligence.
 *
 * IMPORTANT:
 * - No graph analytics
 * - No scoring
 * - No transition calculation
 * - No persistence
 *
 * Single Responsibility:
 * Explainable behavioural trajectory reporting.
 *
 * Research Alignment:
 * Modern financial intelligence systems require:
 * - explainability,
 * - operational interpretability,
 * - and human-readable behavioural forecasting.
 *
 * This class transforms:
 * Markov state transitions
 * into:
 * operational behavioural intelligence.
 */
public class BehaviouralTrajectoryReporter {

    /**
     * Transition probability infrastructure.
     */
    private MarkovTransitionMatrix transitionMatrix;

    /**
     * Constructor.
     *
     * @param transitionMatrix
     * Behavioural transition matrix.
     */
    public BehaviouralTrajectoryReporter(

            MarkovTransitionMatrix transitionMatrix
    ) {

        this.transitionMatrix =
                transitionMatrix;
    }

    /**
     * generateTrajectoryReport()
     *
     * Generates:
     * explainable behavioural evolution report.
     *
     * @param currentState
     * Current borrower behavioural state.
     */
    public void generateTrajectoryReport(

            BehaviouralState currentState
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
                "BEHAVIOURAL TRAJECTORY REPORT"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(

                "CURRENT BEHAVIOURAL STATE: "
                        + currentState
        );

        /**
         * ==================================================
         * STATE DESCRIPTION
         * ==================================================
         */

        printStateExplanation(
                currentState
        );

        /**
         * ==================================================
         * RETRIEVE FUTURE TRANSITIONS
         * ==================================================
         */

        Map<BehaviouralState, Double>
                transitions =

                transitionMatrix
                        .getTransitionsFromState(
                                currentState
                        );

        /**
         * ==================================================
         * FUTURE EVOLUTION ANALYSIS
         * ==================================================
         */

        System.out.println(

                "\nPOTENTIAL FUTURE TRAJECTORIES"
        );

        System.out.println(
                "--------------------------------------------------"
        );

        /**
         * Analyze:
         * all future transitions.
         */

        for (

                BehaviouralState futureState
                : transitions.keySet()
        ) {

            double probability =
                    transitions.get(futureState);

            /**
             * Display:
             * future transition.
             */

            System.out.println(

                    "\nFUTURE STATE: "
                            + futureState
            );

            System.out.println(

                    "TRANSITION PROBABILITY: "
                            + probability
            );

            /**
             * ==================================================
             * HUMAN INTERPRETATION
             * ==================================================
             */

            interpretTransition(

                    currentState,

                    futureState,

                    probability
            );
        }

        /**
         * ==================================================
         * OPERATIONAL SUMMARY
         * ==================================================
         */

        printOperationalSummary(
                currentState
        );
    }

    /**
     * printStateExplanation()
     *
     * Explains:
     * current behavioural condition.
     *
     * @param state
     * Behavioural state.
     */
    private void printStateExplanation(

            BehaviouralState state
    ) {

        System.out.println(
                "\nCURRENT STATE INTERPRETATION:"
        );

        /**
         * ==================================================
         * STABLE
         * ==================================================
         */

        if (

                state == BehaviouralState.STABLE
        ) {

            System.out.println(

                    "Borrower currently exhibits financially stable behaviour."
            );

            System.out.println(

                    "Current behavioural indicators suggest relatively low repayment stress."
            );
        }

        /**
         * ==================================================
         * WATCHLIST
         * ==================================================
         */

        else if (

                state == BehaviouralState.WATCHLIST
        ) {

            System.out.println(

                    "Early behavioural instability indicators detected."
            );

            System.out.println(

                    "Borrower may be entering a financially vulnerable phase."
            );
        }

        /**
         * ==================================================
         * STRESSED
         * ==================================================
         */

        else if (

                state == BehaviouralState.STRESSED
        ) {

            System.out.println(

                    "Borrower currently exhibits elevated financial pressure."
            );

            System.out.println(

                    "Debt pressure and utilisation behaviour suggest worsening repayment resilience."
            );
        }

        /**
         * ==================================================
         * DELINQUENT
         * ==================================================
         */

        else if (

                state == BehaviouralState.DELINQUENT
        ) {

            System.out.println(

                    "Repayment instability behaviour detected."
            );

            System.out.println(

                    "Borrower exhibits delinquency-related behavioural deterioration."
            );
        }

        /**
         * ==================================================
         * HIGH RISK
         * ==================================================
         */

        else if (

                state == BehaviouralState.HIGH_RISK
        ) {

            System.out.println(

                    "Severe behavioural instability detected."
            );

            System.out.println(

                    "Multiple overlapping risk signals are present."
            );
        }

        /**
         * ==================================================
         * DEFAULTED
         * ==================================================
         */

        else if (

                state == BehaviouralState.DEFAULTED
        ) {

            System.out.println(

                    "Borrower has entered terminal repayment failure state."
            );
        }

        /**
         * ==================================================
         * OPAQUE
         * ==================================================
         */

        else if (

                state == BehaviouralState.OPAQUE
        ) {

            System.out.println(

                    "Borrower exhibits elevated informational uncertainty."
            );

            System.out.println(

                    "Financial visibility and behavioural observability are limited."
            );
        }
    }

    /**
     * interpretTransition()
     *
     * Generates:
     * human-readable transition interpretation.
     *
     * @param currentState
     * Current behavioural state.
     *
     * @param futureState
     * Future behavioural state.
     *
     * @param probability
     * Transition probability.
     */
    private void interpretTransition(

            BehaviouralState currentState,

            BehaviouralState futureState,

            double probability
    ) {

        /**
         * ==================================================
         * STABILITY
         * ==================================================
         */

        if (

                futureState == BehaviouralState.STABLE
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Borrower may maintain or recover financial stability."
            );
        }

        /**
         * ==================================================
         * WATCHLIST
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.WATCHLIST
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Early warning behavioural signals may intensify."
            );
        }

        /**
         * ==================================================
         * STRESSED
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.STRESSED
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Financial pressure trajectory appears to be worsening."
            );
        }

        /**
         * ==================================================
         * DELINQUENCY
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.DELINQUENT
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Repayment instability risk may increase."
            );
        }

        /**
         * ==================================================
         * HIGH RISK
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.HIGH_RISK
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Borrower may transition into severe behavioural instability."
            );
        }

        /**
         * ==================================================
         * DEFAULT
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.DEFAULTED
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Behavioural trajectory indicates elevated default vulnerability."
            );
        }

        /**
         * ==================================================
         * OPAQUE
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.OPAQUE
        ) {

            System.out.println(

                    "Interpretation:"
            );

            System.out.println(

                    "Behavioural observability may deteriorate further."
            );
        }

        /**
         * ==================================================
         * SEVERITY INTERPRETATION
         * ==================================================
         */

        System.out.println(

                "\nSEVERITY:"
        );

        if (probability >= 0.70) {

            System.out.println(
                    "Very High Probability Transition"
            );
        }

        else if (probability >= 0.40) {

            System.out.println(
                    "Moderate Probability Transition"
            );
        }

        else {

            System.out.println(
                    "Lower Probability Transition"
            );
        }
    }

    /**
     * printOperationalSummary()
     *
     * Generates:
     * operational recommendations.
     *
     * @param currentState
     * Current behavioural state.
     */
    private void printOperationalSummary(

            BehaviouralState currentState
    ) {

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "OPERATIONAL RECOMMENDATIONS"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * ==================================================
         * STATE-SPECIFIC RECOMMENDATIONS
         * ==================================================
         */

        if (

                currentState == BehaviouralState.STABLE
        ) {

            System.out.println(
                    "- continue standard monitoring"
            );

            System.out.println(
                    "- maintain behavioural observation"
            );
        }

        else if (

                currentState == BehaviouralState.WATCHLIST
        ) {

            System.out.println(
                    "- increase behavioural monitoring"
            );

            System.out.println(
                    "- monitor utilisation growth"
            );
        }

        else if (

                currentState == BehaviouralState.STRESSED
        ) {

            System.out.println(
                    "- perform affordability review"
            );

            System.out.println(
                    "- monitor repayment deterioration"
            );

            System.out.println(
                    "- assess financial pressure escalation"
            );
        }

        else if (

                currentState == BehaviouralState.DELINQUENT
        ) {

            System.out.println(
                    "- escalate repayment monitoring"
            );

            System.out.println(
                    "- evaluate intervention strategies"
            );
        }

        else if (

                currentState == BehaviouralState.HIGH_RISK
        ) {

            System.out.println(
                    "- initiate enhanced governance review"
            );

            System.out.println(
                    "- evaluate severe instability exposure"
            );

            System.out.println(
                    "- increase operational oversight"
            );
        }

        else if (

                currentState == BehaviouralState.OPAQUE
        ) {

            System.out.println(
                    "- improve borrower observability"
            );

            System.out.println(
                    "- investigate informational uncertainty"
            );

            System.out.println(
                    "- review missing behavioural information"
            );
        }
    }
}