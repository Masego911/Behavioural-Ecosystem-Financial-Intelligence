import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * IndexedRelationshipDetector
 *
 * Responsible ONLY for:
 * - scalable behavioural relationship discovery,
 * - indexed borrower grouping,
 * - composite behavioural indexing,
 * - candidate pruning,
 * - explainable behavioural similarity,
 * - and hash-based relationship optimisation.
 *
 * IMPORTANT:
 * - No persistence
 * - No clustering
 * - No anomaly detection
 * - No scoring
 *
 * Research Alignment:
 * Modern behavioural graph systems connect borrowers
 * using:
 * - financial similarity,
 * - behavioural overlap,
 * - informational opacity,
 * - repayment instability,
 * - and credit-seeking behaviour.
 *
 * Therefore:
 * relationships are now:
 * explainable behavioural graph edges.
 *
 * Single Responsibility:
 * Indexed behavioural relationship detection.
 */
public class IndexedRelationshipDetector {

    /**
     * Maximum neighbour relationships
     * allowed per borrower.
     *
     * IMPORTANT:
     * Prevents graph explosion.
     */
    private static final int MAX_RELATIONSHIPS_PER_BORROWER = 10;

    /**
     * Minimum similarity score
     * required for graph preservation.
     */
    private static final double MINIMUM_SIMILARITY_SCORE = 0.80;

    /**
     * detectRelationships()
     *
     * Detects behavioural relationships
     * using:
     * - behavioural locality,
     * - indexed neighbour pruning,
     * - and explainable similarity analysis.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @return
     * Explainable behavioural graph edges.
     */
    public List<BorrowerRelationship> detectRelationships(
            List<Borrower> borrowers
    ) {

        /**
         * Stores behavioural graph edges.
         */
        List<BorrowerRelationship> relationships =
                new ArrayList<>();

        /**
         * Composite behavioural index.
         *
         * KEY:
         * behavioural locality bucket.
         *
         * VALUE:
         * borrowers inside same locality.
         */
        Map<String, List<Borrower>> behaviouralIndex =
                new HashMap<>();

        /**
         * ==================================================
         * STEP 1:
         * BUILD COMPOSITE BEHAVIOURAL INDEX
         * ==================================================
         */
        for (Borrower borrower : borrowers) {

            /**
             * Generate behavioural locality key.
             */
            String behaviouralKey =
                    generateBehaviouralKey(
                            borrower
                    );

            /**
             * Create locality bucket if missing.
             */
            if (
                    !behaviouralIndex.containsKey(
                            behaviouralKey
                    )
            ) {

                behaviouralIndex.put(

                        behaviouralKey,

                        new ArrayList<>()
                );
            }

            /**
             * Insert borrower into locality bucket.
             */
            behaviouralIndex.get(
                    behaviouralKey
            ).add(
                    borrower
            );
        }

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "INDEXED RELATIONSHIP DETECTION"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Behavioural Buckets Created: "
                        + behaviouralIndex.size()
        );

        /**
         * ==================================================
         * STEP 2:
         * LOCAL BEHAVIOURAL COMPARISON
         * ==================================================
         */
        for (
                String behaviouralKey
                : behaviouralIndex.keySet()
        ) {

            List<Borrower> localBorrowers =
                    behaviouralIndex.get(
                            behaviouralKey
                    );

            /**
             * Skip tiny behavioural groups.
             */
            if (localBorrowers.size() < 2) {

                continue;
            }

            /**
             * Pairwise local comparison.
             */
            for (
                    int i = 0;
                    i < localBorrowers.size();
                    i++
            ) {

                Borrower borrowerA =
                        localBorrowers.get(i);

                /**
                 * Prevent excessive neighbour growth.
                 */
                int neighbourCount = 0;

                for (
                        int j = i + 1;
                        j < localBorrowers.size();
                        j++
                ) {

                    /**
                     * Prevent graph explosion.
                     */
                    if (
                            neighbourCount >=
                                    MAX_RELATIONSHIPS_PER_BORROWER
                    ) {

                        break;
                    }

                    Borrower borrowerB =
                            localBorrowers.get(j);

                    /**
                     * ==================================================
                     * COMPUTE EXPLAINABLE BEHAVIOURAL SIMILARITY
                     * ==================================================
                     */
                    BehaviouralSimilarityResult similarityResult =
                            calculateSimilarity(
                                    borrowerA,
                                    borrowerB
                            );

                    /**
                     * ==================================================
                     * CANDIDATE PRUNING
                     * ==================================================
                     *
                     * Preserve only:
                     * high-confidence behavioural edges.
                     */
                    if (

                            similarityResult.getSimilarityScore()

                                    >=

                                    MINIMUM_SIMILARITY_SCORE
                    ) {

                        /**
                         * Create explainable graph edge.
                         */
                        relationships.add(

                                new BorrowerRelationship(

                                        borrowerA.getApplicantIdHash(),

                                        borrowerB.getApplicantIdHash(),

                                        "BEHAVIOURAL_SIMILARITY",

                                        similarityResult.getSimilarityScore(),

                                        similarityResult.getSharedSignals(),

                                        similarityResult.getNarrative()
                                )
                        );

                        neighbourCount++;
                    }
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
                "Indexed behavioural relationship detection completed."
        );

        return relationships;
    }

    /**
     * generateBehaviouralKey()
     *
     * Creates behavioural locality bucket.
     *
     * Combines:
     * - region,
     * - home ownership,
     * - DTI category,
     * - utilisation category.
     */
    private String generateBehaviouralKey(
            Borrower borrower
    ) {

        return

                borrower.getRegion()

                        + "_"

                        + borrower.getHomeOwnership()

                        + "_"

                        + getDTIBucket(
                        borrower.getDtiRatio()
                )

                        + "_"

                        + getUtilisationBucket(
                        borrower.getCreditUtilisationPct()
                );
    }

    /**
     * getDTIBucket()
     *
     * Categorises DTI behaviour.
     */
    private String getDTIBucket(
            double dti
    ) {

        if (dti < 20) {

            return "LOW_DTI";
        }

        if (dti < 40) {

            return "MEDIUM_DTI";
        }

        return "HIGH_DTI";
    }

    /**
     * getUtilisationBucket()
     *
     * Categorises utilisation behaviour.
     */
    private String getUtilisationBucket(
            double utilisation
    ) {

        if (utilisation < 30) {

            return "LOW_UTIL";
        }

        if (utilisation < 70) {

            return "MEDIUM_UTIL";
        }

        return "HIGH_UTIL";
    }

    /**
     * calculateSimilarity()
     *
     * Computes:
     * - behavioural similarity,
     * - shared behavioural overlap,
     * - and explainable graph semantics.
     *
     * @param borrowerA
     * First borrower.
     *
     * @param borrowerB
     * Second borrower.
     *
     * @return
     * Explainable behavioural similarity result.
     */
    private BehaviouralSimilarityResult calculateSimilarity(
            Borrower borrowerA,
            Borrower borrowerB
    ) {

        /**
         * Shared behavioural overlap signals.
         */
        List<String> sharedSignals =
                new ArrayList<>();

        /**
         * Behavioural overlap counter.
         */
        int similaritySignals = 0;

        /**
         * ==================================================
         * DTI SIMILARITY
         * ==================================================
         */

        if (

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
         * UTILISATION SIMILARITY
         * ==================================================
         */

        if (

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
         * DELINQUENCY SIMILARITY
         * ==================================================
         */

        if (

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
         * CREDIT-SEEKING SIMILARITY
         * ==================================================
         */

        if (

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
         * INFORMATIONAL OPACITY OVERLAP
         * ==================================================
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
         * NORMALISE SIMILARITY SCORE
         * ==================================================
         */

        double similarityScore =
                similaritySignals / 5.0;

        /**
         * ==================================================
         * GENERATE EXPLAINABLE NARRATIVE
         * ==================================================
         */

        String narrative =
                generateRelationshipNarrative(
                        sharedSignals
                );

        /**
         * ==================================================
         * RETURN EXPLAINABLE RESULT
         * ==================================================
         */

        return new BehaviouralSimilarityResult(

                similarityScore,

                sharedSignals,

                narrative
        );
    }

    /**
     * generateRelationshipNarrative()
     *
     * Generates explainable behavioural narrative.
     *
     * @param sharedSignals
     * Shared behavioural overlap.
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
         * Shared opacity.
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

    /**
     * ==================================================
     * INNER HELPER CLASS
     * ==================================================
     *
     * Represents explainable behavioural similarity.
     */
    private class BehaviouralSimilarityResult {

        /**
         * Behavioural similarity strength.
         */
        private double similarityScore;

        /**
         * Shared behavioural overlap.
         */
        private List<String> sharedSignals;

        /**
         * Explainable relationship narrative.
         */
        private String narrative;

        /**
         * Constructor.
         */
        public BehaviouralSimilarityResult(

                double similarityScore,

                List<String> sharedSignals,

                String narrative
        ) {

            this.similarityScore =
                    similarityScore;

            this.sharedSignals =
                    sharedSignals;

            this.narrative =
                    narrative;
        }

        /**
         * Returns similarity score.
         */
        public double getSimilarityScore() {

            return similarityScore;
        }

        /**
         * Returns shared signals.
         */
        public List<String> getSharedSignals() {

            return sharedSignals;
        }

        /**
         * Returns explainable narrative.
         */
        public String getNarrative() {

            return narrative;
        }
    }
}