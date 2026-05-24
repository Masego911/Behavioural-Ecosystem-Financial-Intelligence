import java.util.Map;

/**
 * BehaviouralStateClassifier
 *
 * Responsible ONLY for:
 * - behavioural state classification,
 * - temporal state assignment,
 * - and borrower behavioural interpretation.
 *
 * IMPORTANT:
 * - No graph propagation
 * - No Markov transitions
 * - No scoring
 * - No anomaly detection
 *
 * Single Responsibility:
 * Behavioural temporal state classification.
 *
 * Research Alignment:
 * Markov Chains require:
 * finite behavioural states.
 *
 * This class transforms:
 * raw borrower behaviour
 * into:
 * interpretable temporal states.
 */
public class BehaviouralStateClassifier {

    /**
     * classifyState()
     *
     * Converts borrower behaviour
     * into a temporal behavioural state.
     *
     * @param borrower
     * Behavioural borrower entity.
     *
     * @param propagatedRiskScores
     * Graph-propagated instability scores.
     *
     * @return
     * Behavioural temporal state.
     */
    public BehaviouralState classifyState(

            Borrower borrower,

            Map<String, Integer> propagatedRiskScores
    ) {

        /**
         * ==================================================
         * RETRIEVE PROPAGATED RISK
         * ==================================================
         */

        int propagatedRisk =
                propagatedRiskScores.getOrDefault(

                        borrower.getApplicantIdHash(),

                        0
                );

        /**
         * ==================================================
         * NULL-SAFE FEATURE EXTRACTION
         * ==================================================
         */

        Double dti =
                borrower.getDtiRatio();

        Double utilisation =
                borrower.getCreditUtilisationPct();

        Integer delinquencies =
                borrower.getNumDelinquencies2yr();

        Boolean defaultFlag =
                borrower.getDefaultFlag();

        Boolean missingIncome =
                borrower.getMissingIncome();

        /**
         * ==================================================
         * DEFAULTED STATE
         * ==================================================
         *
         * IMPORTANT:
         * Default is treated as:
         * terminal behavioural failure.
         */

        if (

                Boolean.TRUE.equals(defaultFlag)
        ) {

            return BehaviouralState.DEFAULTED;
        }

        /**
         * ==================================================
         * OPAQUE STATE
         * ==================================================
         *
         * IMPORTANT:
         * Missing income may indicate:
         * - institutional invisibility
         * - thin-file borrowers
         * - behavioural uncertainty
         */

        if (

                Boolean.TRUE.equals(missingIncome)
        ) {

            return BehaviouralState.OPAQUE;
        }

        /**
         * ==================================================
         * DEFENSIVE NULL PROTECTION
         * ==================================================
         */

        if (

                dti == null
                        ||
                        utilisation == null
                        ||
                        delinquencies == null
        ) {

            return BehaviouralState.WATCHLIST;
        }

        /**
         * ==================================================
         * HIGH-RISK STATE
         * ==================================================
         *
         * Severe overlapping behavioural instability.
         */

        if (

                dti >= 45
                        &&
                        utilisation >= 90
                        &&
                        delinquencies >= 3
                        &&
                        propagatedRisk >= 3
        ) {

            return BehaviouralState.HIGH_RISK;
        }

        /**
         * ==================================================
         * DELINQUENT STATE
         * ==================================================
         *
         * Repayment instability detected.
         */

        if (

                delinquencies >= 2
        ) {

            return BehaviouralState.DELINQUENT;
        }

        /**
         * ==================================================
         * STRESSED STATE
         * ==================================================
         *
         * Elevated financial pressure.
         */

        if (

                dti >= 35
                        ||
                        utilisation >= 75
                        ||
                        propagatedRisk >= 2
        ) {

            return BehaviouralState.STRESSED;
        }

        /**
         * ==================================================
         * WATCHLIST STATE
         * ==================================================
         *
         * Early behavioural instability.
         */

        if (

                dti >= 25
                        ||
                        utilisation >= 50
        ) {

            return BehaviouralState.WATCHLIST;
        }

        /**
         * ==================================================
         * STABLE STATE
         * ==================================================
         *
         * Financially healthy borrower.
         */

        return BehaviouralState.STABLE;
    }
}