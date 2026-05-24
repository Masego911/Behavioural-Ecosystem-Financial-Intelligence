/**
 * BehaviouralState
 *
 * Represents:
 * temporal behavioural borrower states.
 *
 * IMPORTANT:
 * These states are used by:
 * - Markov Chains,
 * - temporal risk modelling,
 * - behavioural trajectory analysis,
 * - and future-state prediction.
 *
 * Research Alignment:
 * Modern behavioural financial systems
 * model borrowers as dynamic entities
 * whose financial condition evolves over time.
 *
 * BCIP models:
 * behavioural state transitions
 * rather than static borrower snapshots.
 */
public enum BehaviouralState {

    /**
     * Financially healthy borrower.
     *
     * Characteristics:
     * - low DTI
     * - low utilisation
     * - stable repayment behaviour
     * - low propagated risk
     */
    STABLE,

    /**
     * Emerging behavioural concern.
     *
     * Characteristics:
     * - increasing utilisation
     * - moderate debt pressure
     * - early behavioural stress signals
     */
    WATCHLIST,

    /**
     * Elevated financial pressure.
     *
     * Characteristics:
     * - high DTI
     * - elevated utilisation
     * - financial instability
     */
    STRESSED,

    /**
     * Repayment instability state.
     *
     * Characteristics:
     * - delinquency behaviour
     * - missed payments
     * - elevated repayment pressure
     */
    DELINQUENT,

    /**
     * Severe behavioural risk.
     *
     * Characteristics:
     * - overlapping risk signals
     * - propagated instability
     * - anomaly overlap
     * - severe stress
     */
    HIGH_RISK,

    /**
     * Terminal default state.
     *
     * IMPORTANT:
     * In Markov modelling,
     * this may become:
     * an absorbing state.
     */
    DEFAULTED,

    /**
     * Informational uncertainty state.
     *
     * IMPORTANT:
     * Represents:
     * - thin-file borrowers,
     * - institutional invisibility,
     * - behavioural opacity,
     * - or insufficient observability.
     *
     * This state is one of the
     * major conceptual innovations
     * of BCIP.
     */
    OPAQUE
}