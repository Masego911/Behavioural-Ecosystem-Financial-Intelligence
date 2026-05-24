import java.util.ArrayList;
import java.util.List;

/**
 * BorrowerRelationship
 *
 * Represents:
 * - behavioural borrower connectivity,
 * - graph edge semantics,
 * - behavioural similarity strength,
 * - uncertainty overlap,
 * - and explainable relationship intelligence.
 *
 * IMPORTANT:
 * This is now more than:
 * simple graph connectivity.
 *
 * This class represents:
 * explainable behavioural graph structure.
 *
 * Research Alignment:
 * Modern behavioural graph systems require:
 * - interpretable edges,
 * - semantic relationship meaning,
 * - similarity weighting,
 * - and behavioural explainability.
 *
 * Therefore:
 * graph edges now preserve:
 * - relationship strength,
 * - shared behavioural signals,
 * - and relationship narratives.
 *
 * IMPORTANT:
 * This class is NOT responsible for:
 * - graph traversal,
 * - propagation,
 * - clustering,
 * - scoring,
 * - or anomaly detection.
 *
 * Single Responsibility:
 * Behavioural relationship representation.
 */
public class BorrowerRelationship {

    /**
     * ==================================================
     * CORE GRAPH CONNECTIVITY
     * ==================================================
     */

    //First borrower identifier.
    private String borrowerA;

    //Second borrower identifier.
    private String borrowerB;

    /**
     * ==================================================
     * RELATIONSHIP SEMANTICS
     * ==================================================
     */

    /**
     * Relationship category.
     *
     * Examples:
     * - BEHAVIOURAL_SIMILARITY
     * - SHARED_FINANCIAL_STRESS
     * - SHARED_INFORMATIONAL_OPACITY
     * - AGGRESSIVE_CREDIT_SEEKING
     */
    private String relationshipType;

    /**
     * ==================================================
     * BEHAVIOURAL SIMILARITY
     * ==================================================
     */

    /**
     * Relationship strength.
     *
     * IMPORTANT:
     * Represents:
     * behavioural similarity confidence.
     *
     * Example:
     * 0.90 = very strong similarity.
     */
    private double similarityScore;

    /**
     * ==================================================
     * SHARED BEHAVIOURAL SIGNALS
     * ==================================================
     */

    /**
     * Shared behavioural overlap.
     *
     * Examples:
     * - HIGH_UTILISATION
     * - HIGH_DTI
     * - SHARED_OPACITY
     * - AGGRESSIVE_INQUIRIES
     */
    private List<String> sharedSignals;

    /**
     * ==================================================
     * EXPLAINABLE RELATIONSHIP NARRATIVE
     * ==================================================
     */

    /**
     * Human-readable behavioural interpretation.
     *
     * IMPORTANT:
     * Enables:
     * - explainable graph intelligence,
     * - behavioural reporting,
     * - anomaly interpretation,
     * - and graph transparency.
     */
    private String relationshipNarrative;

    /**
     * ==================================================
     * CONSTRUCTOR
     * ==================================================
     */

    /**
     * Constructs explainable behavioural graph edge.
     *
     * @param borrowerA
     * First borrower identifier.
     *
     * @param borrowerB
     * Second borrower identifier.
     *
     * @param relationshipType
     * Behavioural relationship category.
     *
     * @param similarityScore
     * Behavioural similarity strength.
     *
     * @param sharedSignals
     * Shared behavioural overlap signals.
     *
     * @param relationshipNarrative
     * Explainable behavioural interpretation.
     */
    public BorrowerRelationship(

            String borrowerA,

            String borrowerB,

            String relationshipType,

            double similarityScore,

            List<String> sharedSignals,

            String relationshipNarrative
    ) {

        /**
         * ==================================================
         * CORE GRAPH ASSIGNMENT
         * ==================================================
         */

        this.borrowerA =
                borrowerA;

        this.borrowerB =
                borrowerB;

        /**
         * ==================================================
         * RELATIONSHIP SEMANTICS
         * ==================================================
         */

        this.relationshipType =
                relationshipType;

        /**
         * ==================================================
         * SIMILARITY ASSIGNMENT
         * ==================================================
         */

        this.similarityScore =
                similarityScore;

        /**
         * ==================================================
         * SHARED SIGNAL ASSIGNMENT
         * ==================================================
         *
         * Defensive allocation prevents:
         * null graph semantics.
         */
        this.sharedSignals =

                sharedSignals != null

                        ?

                        sharedSignals

                        :

                        new ArrayList<>();

        /**
         * ==================================================
         * EXPLAINABLE NARRATIVE
         * ==================================================
         */

        this.relationshipNarrative =
                relationshipNarrative;
    }

    /**
     * ==================================================
     * GETTERS
     * ==================================================
     */

    /**
     * Returns first borrower identifier.
     */
    public String getBorrowerA() {

        return borrowerA;
    }

    /**
     * Returns second borrower identifier.
     */
    public String getBorrowerB() {

        return borrowerB;
    }

    /**
     * Returns relationship category.
     */
    public String getRelationshipType() {

        return relationshipType;
    }

    /**
     * Returns behavioural similarity strength.
     */
    public double getSimilarityScore() {

        return similarityScore;
    }

    /**
     * Returns shared behavioural overlap.
     */
    public List<String> getSharedSignals() {

        return sharedSignals;
    }

    /**
     * Returns explainable relationship narrative.
     */
    public String getRelationshipNarrative() {

        return relationshipNarrative;
    }

    /**
     * ==================================================
     * EXPLAINABLE STRING REPRESENTATION
     * ==================================================
     */

    /**
     * Displays:
     * - graph connectivity,
     * - behavioural overlap,
     * - similarity strength,
     * - and explainable edge intelligence.
     *
     * @return
     * Structured behavioural relationship.
     */
    @Override
    public String toString() {

        return

                "\n=================================================="

                        +

                        "\nBORROWER RELATIONSHIP"

                        +

                        "\n=================================================="

                        +

                        "\nBorrower A: "
                        + borrowerA

                        +

                        "\nBorrower B: "
                        + borrowerB

                        +

                        "\nRelationship Type: "
                        + relationshipType

                        +

                        "\nSimilarity Score: "
                        + similarityScore

                        +

                        "\nShared Signals: "
                        + sharedSignals

                        +

                        "\nRelationship Narrative: "
                        + relationshipNarrative;
    }
}