import java.util.HashMap;
import java.util.Map;

/**
 * MarkovTransitionMatrix
 *
 * Responsible ONLY for:
 * - behavioural state transition storage,
 * - temporal probability management,
 * - and Markov behavioural movement representation.
 *
 * IMPORTANT:
 * - No graph analytics
 * - No scoring
 * - No borrower classification
 * - No propagation
 *
 * Single Responsibility:
 * Behavioural transition probability storage.
 *
 * Research Alignment:
 * Markov Chains model:
 * probabilistic movement
 * between finite behavioural states.
 *
 * This class represents:
 * the temporal behavioural transition matrix.
 */
public class MarkovTransitionMatrix {

    /**
     * ==================================================
     * TRANSITION MATRIX
     * ==================================================
     *
     * Structure:
     *
     * FROM_STATE
     *      ->
     *          TO_STATE
     *              ->
     *                  PROBABILITY
     *
     * Example:
     *
     * STABLE
     *      ->
     *          STRESSED
     *              ->
     *                  0.15
     */
    private Map<BehaviouralState,

            Map<BehaviouralState, Double>>

            transitionMatrix =
            new HashMap<>();

    /**
     * Constructor.
     *
     * Initializes:
     * default behavioural transition probabilities.
     */
    public MarkovTransitionMatrix() {

        initializeTransitionMatrix();
    }

    /**
     * initializeTransitionMatrix()
     *
     * Builds:
     * default behavioural transition probabilities.
     *
     * IMPORTANT:
     * These probabilities are:
     * conceptual starting values.
     *
     * In future versions:
     * probabilities should be learned
     * from real historical behavioural data.
     */
    private void initializeTransitionMatrix() {

        /**
         * ==================================================
         * STABLE TRANSITIONS
         * ==================================================
         */

        addTransition(

                BehaviouralState.STABLE,

                BehaviouralState.STABLE,

                0.80
        );

        addTransition(

                BehaviouralState.STABLE,

                BehaviouralState.WATCHLIST,

                0.15
        );

        addTransition(

                BehaviouralState.STABLE,

                BehaviouralState.STRESSED,

                0.05
        );

        /**
         * ==================================================
         * WATCHLIST TRANSITIONS
         * ==================================================
         */

        addTransition(

                BehaviouralState.WATCHLIST,

                BehaviouralState.STABLE,

                0.25
        );

        addTransition(

                BehaviouralState.WATCHLIST,

                BehaviouralState.WATCHLIST,

                0.45
        );

        addTransition(

                BehaviouralState.WATCHLIST,

                BehaviouralState.STRESSED,

                0.25
        );

        addTransition(

                BehaviouralState.WATCHLIST,

                BehaviouralState.DELINQUENT,

                0.05
        );

        /**
         * ==================================================
         * STRESSED TRANSITIONS
         * ==================================================
         */

        addTransition(

                BehaviouralState.STRESSED,

                BehaviouralState.WATCHLIST,

                0.20
        );

        addTransition(

                BehaviouralState.STRESSED,

                BehaviouralState.STRESSED,

                0.45
        );

        addTransition(

                BehaviouralState.STRESSED,

                BehaviouralState.DELINQUENT,

                0.25
        );

        addTransition(

                BehaviouralState.STRESSED,

                BehaviouralState.HIGH_RISK,

                0.10
        );

        /**
         * ==================================================
         * DELINQUENT TRANSITIONS
         * ==================================================
         */

        addTransition(

                BehaviouralState.DELINQUENT,

                BehaviouralState.STRESSED,

                0.20
        );

        addTransition(

                BehaviouralState.DELINQUENT,

                BehaviouralState.DELINQUENT,

                0.40
        );

        addTransition(

                BehaviouralState.DELINQUENT,

                BehaviouralState.HIGH_RISK,

                0.25
        );

        addTransition(

                BehaviouralState.DELINQUENT,

                BehaviouralState.DEFAULTED,

                0.15
        );

        /**
         * ==================================================
         * HIGH-RISK TRANSITIONS
         * ==================================================
         */

        addTransition(

                BehaviouralState.HIGH_RISK,

                BehaviouralState.HIGH_RISK,

                0.50
        );

        addTransition(

                BehaviouralState.HIGH_RISK,

                BehaviouralState.DEFAULTED,

                0.35
        );

        addTransition(

                BehaviouralState.HIGH_RISK,

                BehaviouralState.STRESSED,

                0.15
        );

        /**
         * ==================================================
         * DEFAULTED STATE
         * ==================================================
         *
         * IMPORTANT:
         * Absorbing state.
         *
         * Once defaulted:
         * borrower remains defaulted.
         */

        addTransition(

                BehaviouralState.DEFAULTED,

                BehaviouralState.DEFAULTED,

                1.0
        );

        /**
         * ==================================================
         * OPAQUE STATE
         * ==================================================
         *
         * Informational uncertainty transitions.
         */

        addTransition(

                BehaviouralState.OPAQUE,

                BehaviouralState.OPAQUE,

                0.55
        );

        addTransition(

                BehaviouralState.OPAQUE,

                BehaviouralState.WATCHLIST,

                0.20
        );

        addTransition(

                BehaviouralState.OPAQUE,

                BehaviouralState.STRESSED,

                0.15
        );

        addTransition(

                BehaviouralState.OPAQUE,

                BehaviouralState.STABLE,

                0.10
        );
    }

    /**
     * addTransition()
     *
     * Adds behavioural transition probability.
     *
     * @param fromState
     * Current behavioural state.
     *
     * @param toState
     * Future behavioural state.
     *
     * @param probability
     * Transition probability.
     */
    public void addTransition(

            BehaviouralState fromState,

            BehaviouralState toState,

            double probability
    ) {

        /**
         * Create transition bucket if missing.
         */

        if (

                !transitionMatrix.containsKey(fromState)
        ) {

            transitionMatrix.put(

                    fromState,

                    new HashMap<>()
            );
        }

        /**
         * Store transition probability.
         */

        transitionMatrix
                .get(fromState)
                .put(toState, probability);
    }

    /**
     * getTransitionProbability()
     *
     * Retrieves:
     * behavioural transition probability.
     *
     * @param fromState
     * Current behavioural state.
     *
     * @param toState
     * Future behavioural state.
     *
     * @return
     * Transition probability.
     */
    public double getTransitionProbability(

            BehaviouralState fromState,

            BehaviouralState toState
    ) {

        /**
         * Defensive lookup protection.
         */

        if (

                !transitionMatrix.containsKey(fromState)
        ) {

            return 0.0;
        }

        return transitionMatrix
                .get(fromState)
                .getOrDefault(toState, 0.0);
    }

    /**
     * getTransitionsFromState()
     *
     * Retrieves:
     * all outgoing transitions.
     *
     * @param state
     * Source behavioural state.
     *
     * @return
     * Transition probability map.
     */
    public Map<BehaviouralState, Double>
    getTransitionsFromState(

            BehaviouralState state
    ) {

        return transitionMatrix.getOrDefault(

                state,

                new HashMap<>()
        );
    }

    /**
     * printTransitionMatrix()
     *
     * Displays:
     * behavioural transition probabilities.
     *
     * IMPORTANT:
     * Used for:
     * explainability,
     * observability,
     * and operational intelligence.
     */
    public void printTransitionMatrix() {

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "MARKOV TRANSITION MATRIX"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * Print all behavioural transitions.
         */

        for (

                BehaviouralState fromState
                : transitionMatrix.keySet()
        ) {

            System.out.println(

                    "\nFROM STATE: "
                            + fromState
            );

            Map<BehaviouralState, Double>
                    transitions =
                    transitionMatrix.get(fromState);

            for (

                    BehaviouralState toState
                    : transitions.keySet()
            ) {

                System.out.println(

                        "   -> "
                                + toState
                                + " : "
                                + transitions.get(toState)
                );
            }
        }
    }
}