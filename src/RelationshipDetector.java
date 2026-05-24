import java.util.ArrayList;
import java.util.List;

/**
 * RelationshipDetector
 *
 * Responsible ONLY for:
 * - behavioural relationship discovery,
 * - borrower similarity analysis,
 * - explainable graph edge generation,
 * - behavioural overlap analysis,
 * - and semantic relationship intelligence.
 *
 * IMPORTANT:
 * - No clustering
 * - No propagation
 * - No anomaly detection
 * - No persistence
 *
 * Research Alignment:
 * Modern behavioural graph systems connect borrowers
 * using:
 * - behavioural similarity,
 * - uncertainty overlap,
 * - financial stress similarity,
 * - and relational behavioural patterns.
 *
 * Therefore:
 * relationships are no longer:
 * simple symbolic matches.
 *
 * Instead:
 * relationships represent:
 * explainable behavioural connectivity.
 *
 * Single Responsibility:
 * Behavioural relationship detection.
 */
public class RelationshipDetector {

    /**
     * Minimum similarity score required
     * to preserve graph relationship.
     *
     * IMPORTANT:
     * Prevents:
     * - noisy graph edges,
     * - weak similarity,
     * - and graph explosion.
     */
    private static final double MINIMUM_SIMILARITY_SCORE = 0.60;

    /**
     * detectRelationships()
     *
     * Detects:
     * - behavioural borrower relationships,
     * - shared financial behaviour,
     * - informational opacity overlap,
     * - and graph-based borrower similarity.
     *
     * @param borrowers
     * Collection of validated analytical borrowers.
     *
     * @return
     * Collection of explainable behavioural graph edges.
     */
    public List<BorrowerRelationship> detectRelationships(

            List<Borrower> borrowers
    ) {

        /**
         * Stores:
         * behavioural graph edges.
         */
        List<BorrowerRelationship> relationships =
                new ArrayList<>();

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL RELATIONSHIP DETECTION"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * ==================================================
         * PAIRWISE BEHAVIOURAL COMPARISON
         * ==================================================
         */
        for (

                int i = 0;

                i < borrowers.size();

                i++
        ) {

            for (

                    int j = i + 1;

                    j < borrowers.size();

                    j++
            ) {

                Borrower borrowerA =
                        borrowers.get(i);

                Borrower borrowerB =
                        borrowers.get(j);

                /**
                 * ==================================================
                 * SHARED BEHAVIOURAL SIGNALS
                 * ==================================================
                 */

                List<String> sharedSignals =
                        new ArrayList<>();

                /**
                 * Tracks:
                 * behavioural overlap strength.
                 */
                int similaritySignals = 0;

                /**
                 * ==================================================
                 * SAME REGION
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Geographic proximity may indicate:
                 * - shared economic conditions,
                 * - regional lending behaviour,
                 * - or localised financial stress.
                 */
                if (

                        borrowerA.getRegion() != null

                                &&

                                borrowerB.getRegion() != null

                                &&

                                borrowerA.getRegion().equals(

                                        borrowerB.getRegion()
                                )
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SHARED_REGION"
                    );
                }

                /**
                 * ==================================================
                 * SAME EMAIL DOMAIN TYPE
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Similar communication infrastructure
                 * may indicate:
                 * - behavioural similarity,
                 * - institutional overlap,
                 * - or coordinated activity.
                 */
                if (

                        borrowerA.getEmailDomainType() != null

                                &&

                                borrowerB.getEmailDomainType() != null

                                &&

                                borrowerA.getEmailDomainType().equals(

                                        borrowerB.getEmailDomainType()
                                )
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SHARED_EMAIL_DOMAIN"
                    );
                }

                /**
                 * ==================================================
                 * SAME BRANCH
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Shared origination branch
                 * may indicate:
                 * - local borrower communities,
                 * - behavioural concentration,
                 * - or institutional overlap.
                 */
                if (

                        borrowerA.getBranchCodeId() != null

                                &&

                                borrowerB.getBranchCodeId() != null

                                &&

                                borrowerA.getBranchCodeId().equals(

                                        borrowerB.getBranchCodeId()
                                )
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SHARED_BRANCH"
                    );
                }

                /**
                 * ==================================================
                 * SIMILAR DELINQUENCY BEHAVIOUR
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Similar delinquency patterns
                 * may indicate:
                 * - repayment instability,
                 * - shared financial stress,
                 * - or behavioural similarity.
                 */
                if (

                        borrowerA.getNumDelinquencies2yr()
                                != null

                                &&

                                borrowerB.getNumDelinquencies2yr()
                                        != null

                                &&

                                Math.abs(

                                        borrowerA.getNumDelinquencies2yr()

                                                -

                                                borrowerB.getNumDelinquencies2yr()

                                ) <= 1
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SIMILAR_DELINQUENCY"
                    );
                }

                /**
                 * ==================================================
                 * SIMILAR DTI STRUCTURE
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Similar debt pressure profiles
                 * may indicate:
                 * - comparable repayment stress,
                 * - shared financial exposure,
                 * - or behavioural similarity.
                 */
                if (

                        borrowerA.getDtiRatio() != null

                                &&

                                borrowerB.getDtiRatio() != null

                                &&

                                Math.abs(

                                        borrowerA.getDtiRatio()

                                                -

                                                borrowerB.getDtiRatio()

                                ) < 5
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SIMILAR_DTI"
                    );
                }

                /**
                 * ==================================================
                 * SIMILAR UTILISATION
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Similar utilisation profiles
                 * may indicate:
                 * - shared liquidity stress,
                 * - borrowing pressure,
                 * - or financial behaviour overlap.
                 */
                if (

                        borrowerA.getCreditUtilisationPct()
                                != null

                                &&

                                borrowerB.getCreditUtilisationPct()
                                        != null

                                &&

                                Math.abs(

                                        borrowerA.getCreditUtilisationPct()

                                                -

                                                borrowerB.getCreditUtilisationPct()

                                ) < 10
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SIMILAR_UTILISATION"
                    );
                }

                /**
                 * ==================================================
                 * INFORMATIONAL OPACITY OVERLAP
                 * ==================================================
                 *
                 * Research Interpretation:
                 * Shared missing income behaviour
                 * may indicate:
                 * - thin-file communities,
                 * - institutional invisibility,
                 * - or behavioural uncertainty overlap.
                 */
                if (

                        Boolean.TRUE.equals(

                                borrowerA.getMissingIncome()
                        )

                                &&

                                Boolean.TRUE.equals(

                                        borrowerB.getMissingIncome()
                                )
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SHARED_INFORMATIONAL_OPACITY"
                    );
                }

                /**
                 * ==================================================
                 * AGGRESSIVE CREDIT-SEEKING OVERLAP
                 * ==================================================
                 *
                 * Behavioural Interpretation:
                 * Similar inquiry behaviour
                 * may indicate:
                 * - liquidity pressure,
                 * - aggressive borrowing,
                 * - or coordinated credit seeking.
                 */
                if (

                        borrowerA.getNumHardInquiries6mo()
                                != null

                                &&

                                borrowerB.getNumHardInquiries6mo()
                                        != null

                                &&

                                Math.abs(

                                        borrowerA.getNumHardInquiries6mo()

                                                -

                                                borrowerB.getNumHardInquiries6mo()

                                ) <= 1
                ) {

                    similaritySignals++;

                    sharedSignals.add(
                            "SIMILAR_CREDIT_SEEKING"
                    );
                }

                /**
                 * ==================================================
                 * NORMALISE SIMILARITY SCORE
                 * ==================================================
                 */

                double similarityScore =
                        similaritySignals / 7.0;

                /**
                 * ==================================================
                 * CANDIDATE PRUNING
                 * ==================================================
                 *
                 * IMPORTANT:
                 * Only preserve:
                 * behaviourally meaningful edges.
                 */
                if (

                        similarityScore
                                >=
                                MINIMUM_SIMILARITY_SCORE
                ) {

                    /**
                     * ==================================================
                     * GENERATE EXPLAINABLE NARRATIVE
                     * ==================================================
                     */

                    String relationshipNarrative =
                            generateRelationshipNarrative(
                                    sharedSignals
                            );

                    /**
                     * ==================================================
                     * CREATE EXPLAINABLE GRAPH EDGE
                     * ==================================================
                     */

                    relationships.add(

                            new BorrowerRelationship(

                                    borrowerA.getApplicantIdHash(),

                                    borrowerB.getApplicantIdHash(),

                                    "BEHAVIOURAL_SIMILARITY",

                                    similarityScore,

                                    sharedSignals,

                                    relationshipNarrative
                            )
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
                "Relationships Generated: "
                        + relationships.size()
        );

        System.out.println(
                "Behavioural relationship detection completed."
        );

        return relationships;
    }

    /**
     * generateRelationshipNarrative()
     *
     * Generates explainable behavioural edge narrative.
     *
     * @param sharedSignals
     * Shared behavioural overlap signals.
     *
     * @return
     * Explainable relationship interpretation.
     */
    private String generateRelationshipNarrative(

            List<String> sharedSignals
    ) {

        /**
         * Shared financial stress.
         */
        if (

                sharedSignals.contains(
                        "SIMILAR_DTI"
                )

                        &&

                        sharedSignals.contains(
                                "SIMILAR_UTILISATION"
                        )
        ) {

            return
                    "Borrowers exhibit shared financial stress behaviour "
                            + "through similar debt pressure and liquidity utilisation.";
        }

        /**
         * Shared informational opacity.
         */
        if (

                sharedSignals.contains(
                        "SHARED_INFORMATIONAL_OPACITY"
                )
        ) {

            return
                    "Borrowers exhibit overlapping informational opacity "
                            + "which may indicate thin-file behaviour "
                            + "or institutional invisibility.";
        }

        /**
         * Shared aggressive borrowing.
         */
        if (

                sharedSignals.contains(
                        "SIMILAR_CREDIT_SEEKING"
                )
        ) {

            return
                    "Borrowers exhibit similar aggressive credit-seeking behaviour.";
        }

        /**
         * Default narrative.
         */
        return
                "Borrowers exhibit behavioural similarity "
                        + "across multiple financial dimensions.";
    }
}