import java.util.HashMap;
import java.util.Map;

/**
 * UnionFind
 *
 * Responsible ONLY for:
 * - graph connectivity management,
 * - behavioural cluster construction,
 * - borrower ecosystem linkage,
 * - and scalable graph grouping.
 *
 * IMPORTANT:
 * - No anomaly detection
 * - No behavioural scoring
 * - No persistence
 * - No analytics
 * - No relationship detection
 *
 * Research Alignment:
 * Modern graph-native behavioural systems use:
 * - connected component analysis,
 * - graph grouping,
 * - behavioural ecosystem construction,
 * - and scalable borrower connectivity infrastructure.
 *
 * IMPORTANT:
 * Union-Find enables:
 * - efficient cluster construction,
 * - scalable graph merging,
 * - near-constant connectivity checks,
 * - and behavioural ecosystem discovery.
 *
 * Single Responsibility:
 * Behavioural graph connectivity infrastructure.
 */
public class UnionFind {

    /**
     * ==================================================
     * PARENT MAP
     * ==================================================
     *
     * Stores:
     * borrower -> parent node.
     *
     * IMPORTANT:
     * Root nodes are:
     * behavioural cluster representatives.
     */
    private Map<String, String> parent =
            new HashMap<>();

    /**
     * ==================================================
     * RANK MAP
     * ==================================================
     *
     * Stores:
     * borrower -> tree rank.
     *
     * IMPORTANT:
     * Rank optimisation prevents:
     * deep graph trees.
     */
    private Map<String, Integer> rank =
            new HashMap<>();

    /**
     * makeSet()
     *
     * Creates:
     * isolated behavioural borrower node.
     *
     * IMPORTANT:
     * Every borrower initially belongs to:
     * its own behavioural ecosystem.
     *
     * @param borrowerId
     * Unique borrower identifier.
     */
    public void makeSet(
            String borrowerId
    ) {

        /**
         * ==================================================
         * DEFENSIVE DUPLICATE PROTECTION
         * ==================================================
         */

        if (parent.containsKey(borrowerId)) {

            return;
        }

        /**
         * ==================================================
         * INITIAL SELF-PARENTING
         * ==================================================
         *
         * Initially:
         * borrower is its own cluster root.
         */

        parent.put(

                borrowerId,

                borrowerId
        );

        /**
         * ==================================================
         * INITIAL TREE RANK
         * ==================================================
         */

        rank.put(

                borrowerId,

                0
        );
    }

    /**
     * find()
     *
     * Finds:
     * behavioural cluster root.
     *
     * IMPORTANT:
     * Uses:
     * path compression optimisation.
     *
     * Path compression:
     * flattens graph structure,
     * improving future lookup performance.
     *
     * @param borrowerId
     * Borrower node identifier.
     *
     * @return
     * Behavioural cluster representative.
     */
    public String find(
            String borrowerId
    ) {

        /**
         * ==================================================
         * DEFENSIVE NODE INITIALISATION
         * ==================================================
         *
         * IMPORTANT:
         * Prevents:
         * missing-node failures.
         */

        if (!parent.containsKey(borrowerId)) {

            makeSet(borrowerId);
        }

        /**
         * Retrieve current parent.
         */

        String currentParent =
                parent.get(borrowerId);

        /**
         * ==================================================
         * ROOT NODE DETECTION
         * ==================================================
         */

        if (currentParent.equals(borrowerId)) {

            return borrowerId;
        }

        /**
         * ==================================================
         * PATH COMPRESSION
         * ==================================================
         *
         * Recursively compress:
         * borrower -> root path.
         */

        String root =
                find(currentParent);

        /**
         * Update compressed parent reference.
         */

        parent.put(

                borrowerId,

                root
        );

        return root;
    }

    /**
     * union()
     *
     * Merges:
     * behavioural borrower ecosystems.
     *
     * IMPORTANT:
     * Uses:
     * union-by-rank optimisation.
     *
     * This prevents:
     * inefficient graph growth.
     *
     * @param borrowerA
     * First borrower.
     *
     * @param borrowerB
     * Second borrower.
     */
    public void union(

            String borrowerA,

            String borrowerB
    ) {

        /**
         * ==================================================
         * FIND CLUSTER ROOTS
         * ==================================================
         */

        String rootA =
                find(borrowerA);

        String rootB =
                find(borrowerB);

        /**
         * ==================================================
         * ALREADY CONNECTED
         * ==================================================
         */

        if (rootA.equals(rootB)) {

            return;
        }

        /**
         * ==================================================
         * RETRIEVE TREE RANKS
         * ==================================================
         */

        int rankA =
                rank.get(rootA);

        int rankB =
                rank.get(rootB);

        /**
         * ==================================================
         * UNION BY RANK
         * ==================================================
         *
         * Smaller tree attaches to:
         * larger tree.
         */

        if (rankA < rankB) {

            parent.put(

                    rootA,

                    rootB
            );
        }

        else if (rankA > rankB) {

            parent.put(

                    rootB,

                    rootA
            );
        }

        /**
         * ==================================================
         * EQUAL TREE HEIGHT
         * ==================================================
         *
         * Choose one root
         * and increment rank.
         */

        else {

            parent.put(

                    rootB,

                    rootA
            );

            rank.put(

                    rootA,

                    rankA + 1
            );
        }
    }

    /**
     * isConnected()
     *
     * Determines:
     * whether two borrowers belong to:
     * the same behavioural ecosystem.
     *
     * @param borrowerA
     * First borrower.
     *
     * @param borrowerB
     * Second borrower.
     *
     * @return
     * true if behaviourally connected.
     */
    public boolean connected(

            String borrowerA,

            String borrowerB
    ) {

        return find(borrowerA)
                .equals(
                        find(borrowerB)
                );
    }

    /**
     * getParentMap()
     *
     * Exposes:
     * behavioural connectivity structure.
     *
     * Useful for:
     * - analytics,
     * - debugging,
     * - explainability,
     * - and graph inspection.
     *
     * @return
     * Borrower parent structure.
     */
    public Map<String, String> getParentMap() {

        return parent;
    }

    /**
     * getRankMap()
     *
     * Exposes:
     * graph tree hierarchy structure.
     *
     * @return
     * Rank infrastructure.
     */
    public Map<String, Integer> getRankMap() {

        return rank;
    }
}