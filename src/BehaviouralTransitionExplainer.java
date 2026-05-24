import java.util.Map;

/**
 * BehaviouralTransitionExplainer
 *
 * Responsible ONLY for:
 * - explainable behavioural transitions,
 * - temporal causality interpretation,
 * - and borrower evolution reasoning.
 *
 * IMPORTANT:
 * - No graph construction
 * - No scoring
 * - No persistence
 * - No transition calculation
 *
 * Single Responsibility:
 * Explainable behavioural transition intelligence.
 *
 * Research Alignment:
 * Modern explainable AI systems require:
 * not only prediction,
 * but behavioural reasoning.
 *
 * This class explains:
 * WHY behavioural transitions occur.
 */
public class BehaviouralTransitionExplainer {

    /**
     * explainTransition()
     *
     * Generates:
     * explainable behavioural evolution reasoning.
     *
     * @param borrower
     * Behavioural borrower.
     *
     * @param currentState
     * Current behavioural state.
     *
     * @param futureState
     * Predicted future behavioural state.
     *
     * @param propagatedRiskScores
     * Graph-propagated instability scores.
     */
    public void explainTransition(

            Borrower borrower,

            BehaviouralState currentState,

            BehaviouralState futureState,

            Map<String, Integer>
                    propagatedRiskScores
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
                "BEHAVIOURAL TRANSITION EXPLAINER"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(

                "Borrower ID: "
                        + borrower.getApplicantIdHash()
        );

        System.out.println(

                "Current State: "
                        + currentState
        );

        System.out.println(

                "Predicted Future State: "
                        + futureState
        );

        /**
         * ==================================================
         * FEATURE EXTRACTION
         * ==================================================
         */

        Double dti =
                borrower.getDtiRatio();

        Double utilisation =
                borrower.getCreditUtilisationPct();

        Integer delinquencies =
                borrower.getNumDelinquencies2yr();

        Boolean missingIncome =
                borrower.getMissingIncome();

        int propagatedRisk =
                propagatedRiskScores.getOrDefault(

                        borrower.getApplicantIdHash(),

                        0
                );

        /**
         * ==================================================
         * EXPLANATION SECTION
         * ==================================================
         */

        System.out.println(
                "\nTRANSITION DRIVERS"
        );

        System.out.println(
                "--------------------------------------------------"
        );

        /**
         * ==================================================
         * DTI PRESSURE
         * ==================================================
         */

        if (

                dti != null
                        &&
                        dti >= 35
        ) {

            System.out.println(

                    "- Elevated debt-to-income pressure detected."
            );

            System.out.println(

                    "  A large proportion of borrower income is committed to debt obligations."
            );
        }

        /**
         * ==================================================
         * UTILISATION PRESSURE
         * ==================================================
         */

        if (

                utilisation != null
                        &&
                        utilisation >= 75
        ) {

            System.out.println(

                    "- High credit utilisation behaviour detected."
            );

            System.out.println(

                    "  Borrower may be experiencing liquidity pressure or financial stress."
            );
        }

        /**
         * ==================================================
         * DELINQUENCY HISTORY
         * ==================================================
         */

        if (

                delinquencies != null
                        &&
                        delinquencies >= 2
        ) {

            System.out.println(

                    "- Delinquency behaviour contributes to repayment instability."
            );

            System.out.println(

                    "  Historical repayment disruption increases future behavioural deterioration risk."
            );
        }

        /**
         * ==================================================
         * PROPAGATED RISK
         * ==================================================
         */

        if (

                propagatedRisk >= 2
        ) {

            System.out.println(

                    "- Graph-propagated instability detected."
            );

            System.out.println(

                    "  Connected borrower ecosystems may be amplifying behavioural risk."
            );
        }

        /**
         * ==================================================
         * INFORMATIONAL OPACITY
         * ==================================================
         */

        if (

                Boolean.TRUE.equals(
                        missingIncome
                )
        ) {

            System.out.println(

                    "- Informational opacity detected."
            );

            System.out.println(

                    "  Borrower visibility is partially constrained due to missing financial information."
            );
        }

        /**
         * ==================================================
         * FUTURE STATE INTERPRETATION
         * ==================================================
         */

        printFutureStateInterpretation(
                futureState
        );

        /**
         * ==================================================
         * OPERATIONAL RECOMMENDATIONS
         * ==================================================
         */

        printOperationalRecommendations(
                futureState
        );
    }

    /**
     * printFutureStateInterpretation()
     *
     * Explains:
     * predicted behavioural evolution.
     *
     * @param futureState
     * Predicted future behavioural state.
     */
    private void printFutureStateInterpretation(

            BehaviouralState futureState
    ) {

        System.out.println(

                "\nFUTURE STATE INTERPRETATION"
        );

        System.out.println(
                "--------------------------------------------------"
        );

        /**
         * ==================================================
         * STABLE
         * ==================================================
         */

        if (

                futureState == BehaviouralState.STABLE
        ) {

            System.out.println(

                    "Borrower is likely to maintain financial stability."
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

                    "Borrower may enter an early behavioural risk phase."
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

                    "Financial pressure trajectory appears to be increasing."
            );
        }

        /**
         * ==================================================
         * DELINQUENT
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.DELINQUENT
        ) {

            System.out.println(

                    "Repayment instability probability is increasing."
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

                    "Multiple overlapping behavioural risks are intensifying."
            );
        }

        /**
         * ==================================================
         * DEFAULTED
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.DEFAULTED
        ) {

            System.out.println(

                    "Borrower trajectory indicates severe repayment failure vulnerability."
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

                    "Behavioural visibility deterioration is projected."
            );
        }
    }

    /**
     * printOperationalRecommendations()
     *
     * Generates:
     * operational guidance.
     *
     * @param futureState
     * Predicted future state.
     */
    private void printOperationalRecommendations(

            BehaviouralState futureState
    ) {

        System.out.println(

                "\nOPERATIONAL RECOMMENDATIONS"
        );

        System.out.println(
                "--------------------------------------------------"
        );

        /**
         * ==================================================
         * LOW RISK
         * ==================================================
         */

        if (

                futureState == BehaviouralState.STABLE
        ) {

            System.out.println(
                    "- maintain standard monitoring"
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
                    "- increase behavioural observation"
            );

            System.out.println(
                    "- monitor financial stress acceleration"
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
                    "- perform affordability review"
            );

            System.out.println(
                    "- monitor repayment resilience"
            );
        }

        /**
         * ==================================================
         * DELINQUENT
         * ==================================================
         */

        else if (

                futureState == BehaviouralState.DELINQUENT
        ) {

            System.out.println(
                    "- escalate repayment monitoring"
            );

            System.out.println(
                    "- evaluate intervention strategies"
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
                    "- initiate enhanced governance review"
            );

            System.out.println(
                    "- investigate severe behavioural instability"
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
                    "- evaluate repayment recovery strategies"
            );

            System.out.println(
                    "- initiate severe-risk operational procedures"
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
                    "- improve borrower observability"
            );

            System.out.println(
                    "- investigate missing behavioural information"
            );
        }
    }
}