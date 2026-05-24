import java.util.Map;

/**
 * MarkovChainEngine
 *
 * Responsible ONLY for:
 * - temporal behavioural evolution,
 * - future-state prediction,
 * - and Markov behavioural transitions.
 *
 * IMPORTANT:
 * - No graph construction
 * - No anomaly detection
 * - No scoring
 * - No persistence
 *
 * Single Responsibility:
 * Temporal behavioural prediction.
 *
 * Research Alignment:
 * Markov Chains model:
 * behavioural state evolution over time.
 *
 * BCIP uses Markov modelling to investigate:
 * - repayment deterioration,
 * - behavioural recovery,
 * - financial instability progression,
 * - and uncertainty evolution.
 */
public class MarkovChainEngine {

    /**
     * Transition probability infrastructure.
     */
    private MarkovTransitionMatrix transitionMatrix;

    /**
     * Constructor.
     *
     * @param transitionMatrix
     * Behavioural transition probability matrix.
     */
    public MarkovChainEngine(

            MarkovTransitionMatrix transitionMatrix
    ) {

        this.transitionMatrix =
                transitionMatrix;
    }

    /**
     * predictNextState()
     *
     * Predicts:
     * most probable future behavioural state.
     *
     * IMPORTANT:
     * Current implementation uses:
     * maximum transition probability.
     *
     * Future versions may include:
     * - stochastic simulation,
     * - Monte Carlo evolution,
     * - probabilistic sampling,
     * - and multi-step forecasting.
     *
     * @param currentState
     * Current behavioural state.
     *
     * @return
     * Predicted future behavioural state.
     */
    public BehaviouralState predictNextState(

            BehaviouralState currentState
    ) {

        /**
         * ==================================================
         * RETRIEVE STATE TRANSITIONS
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
         * DEFENSIVE EMPTY CHECK
         * ==================================================
         */

        if (transitions.isEmpty()) {

            return currentState;
        }

        /**
         * ==================================================
         * MAXIMUM PROBABILITY SEARCH
         * ==================================================
         */

        BehaviouralState mostLikelyState =
                currentState;

        double highestProbability =
                0.0;

        /**
         * Iterate through:
         * all possible future states.
         */

        for (

                BehaviouralState futureState
                : transitions.keySet()
        ) {

            double probability =
                    transitions.get(futureState);

            /**
             * Track:
             * highest-probability transition.
             */

            if (

                    probability > highestProbability
            ) {

                highestProbability =
                        probability;

                mostLikelyState =
                        futureState;
            }
        }

        return mostLikelyState;
    }

    /**
     * calculateTransitionProbability()
     *
     * Retrieves:
     * probability of behavioural movement.
     *
     * @param currentState
     * Current behavioural state.
     *
     * @param futureState
     * Future behavioural state.
     *
     * @return
     * Transition probability.
     */
    public double calculateTransitionProbability(

            BehaviouralState currentState,

            BehaviouralState futureState
    ) {

        return transitionMatrix
                .getTransitionProbability(

                        currentState,

                        futureState
                );
    }

    /**
     * predictFutureTrajectory()
     *
     * Simulates:
     * multi-step behavioural evolution.
     *
     * IMPORTANT:
     * This method predicts:
     * behavioural trajectories over time.
     *
     * Example:
     *
     * STABLE
     * -> WATCHLIST
     * -> STRESSED
     * -> DELINQUENT
     *
     * @param initialState
     * Starting behavioural state.
     *
     * @param steps
     * Number of future transitions.
     */
    public void predictFutureTrajectory(

            BehaviouralState initialState,

            int steps
    ) {

        /**
         * ==================================================
         * EXECUTION HEADER
         * ==================================================
         */

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "MARKOV BEHAVIOURAL TRAJECTORY"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * Track:
         * evolving behavioural state.
         */

        BehaviouralState currentState =
                initialState;

        System.out.println(
                "\nINITIAL STATE: "
                        + currentState
        );

        /**
         * ==================================================
         * TEMPORAL EVOLUTION LOOP
         * ==================================================
         */

        for (

                int step = 1;

                step <= steps;

                step++
        ) {

            /**
             * Predict:
             * next behavioural state.
             */

            BehaviouralState nextState =
                    predictNextState(
                            currentState
                    );

            /**
             * Retrieve:
             * transition probability.
             */

            double probability =
                    calculateTransitionProbability(

                            currentState,

                            nextState
                    );

            /**
             * Display:
             * behavioural evolution.
             */

            System.out.println(

                    "\nSTEP "
                            + step
            );

            System.out.println(

                    "FROM: "
                            + currentState
            );

            System.out.println(

                    "TO: "
                            + nextState
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

            printTrajectoryInterpretation(

                    currentState,

                    nextState
            );

            /**
             * Advance:
             * behavioural timeline.
             */

            currentState =
                    nextState;
        }
    }

    /**
     * printTrajectoryInterpretation()
     *
     * Generates:
     * explainable temporal intelligence.
     *
     * @param currentState
     * Current behavioural state.
     *
     * @param nextState
     * Future behavioural state.
     */
    private void printTrajectoryInterpretation(

            BehaviouralState currentState,

            BehaviouralState nextState
    ) {

        System.out.println(
                "\nINTERPRETATION:"
        );

        /**
         * ==================================================
         * STABILITY MAINTENANCE
         * ==================================================
         */

        if (

                currentState == BehaviouralState.STABLE
                        &&
                        nextState == BehaviouralState.STABLE
        ) {

            System.out.println(

                    "Borrower behaviour remains financially stable."
            );

            System.out.println(

                    "Current behavioural signals indicate low immediate repayment stress."
            );
        }

        /**
         * ==================================================
         * EARLY DETERIORATION
         * ==================================================
         */

        else if (

                currentState == BehaviouralState.STABLE
                        &&
                        nextState == BehaviouralState.WATCHLIST
        ) {

            System.out.println(

                    "Early behavioural stress signals detected."
            );

            System.out.println(

                    "Borrower may be entering a financially vulnerable state."
            );
        }

        /**
         * ==================================================
         * FINANCIAL DETERIORATION
         * ==================================================
         */

        else if (

                nextState == BehaviouralState.STRESSED
        ) {

            System.out.println(

                    "Behavioural pressure is increasing."
            );

            System.out.println(

                    "Debt burden and repayment instability may be worsening."
            );
        }

        /**
         * ==================================================
         * DELINQUENCY ESCALATION
         * ==================================================
         */

        else if (

                nextState == BehaviouralState.DELINQUENT
        ) {

            System.out.println(

                    "Repayment instability trajectory detected."
            );

            System.out.println(

                    "Borrower may begin experiencing repayment failures."
            );
        }

        /**
         * ==================================================
         * HIGH-RISK ESCALATION
         * ==================================================
         */

        else if (

                nextState == BehaviouralState.HIGH_RISK
        ) {

            System.out.println(

                    "Severe behavioural instability detected."
            );

            System.out.println(

                    "Multiple overlapping risk signals are intensifying."
            );
        }

        /**
         * ==================================================
         * DEFAULT TRAJECTORY
         * ==================================================
         */

        else if (

                nextState == BehaviouralState.DEFAULTED
        ) {

            System.out.println(

                    "Borrower trajectory indicates severe repayment failure risk."
            );

            System.out.println(

                    "Behavioural state has transitioned into default."
            );
        }

        /**
         * ==================================================
         * INFORMATIONAL UNCERTAINTY
         * ==================================================
         */

        else if (

                nextState == BehaviouralState.OPAQUE
        ) {

            System.out.println(

                    "Behavioural observability has deteriorated."
            );

            System.out.println(

                    "Borrower may exhibit elevated informational uncertainty."
            );
        }

        /**
         * ==================================================
         * GENERAL FALLBACK
         * ==================================================
         */

        else {

            System.out.println(

                    "Behavioural transition detected."
            );
        }
    }
}