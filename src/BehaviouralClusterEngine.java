import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * BehaviouralClusterEngine
 *
 * Responsible ONLY for:
 * - behavioural cluster construction,
 * - graph connectivity orchestration,
 * - and Union-Find integration.
 *
 * Single Responsibility:
 * Behavioural connectivity orchestration.
 */
public class BehaviouralClusterEngine {

    // Union-Find connectivity infrastructure
    private UnionFind unionFind = new UnionFind();

    /**
     * buildClusters()
     *
     * Builds behavioural borrower clusters
     * using relationship graph edges.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @param relationships
     * Collection of behavioural graph edges.
     */
    public void buildClusters(List<Borrower> borrowers, List<BorrowerRelationship> relationships) {

        /**
         * STEP 1:
         * Create isolated borrower sets.
         */
        for (Borrower borrower : borrowers) {

            unionFind.makeSet(borrower.getApplicantIdHash());
        }

        //STEP 2:Merge connected borrowers.
        for (BorrowerRelationship relationship : relationships) {

            unionFind.union(relationship.getBorrowerA(), relationship.getBorrowerB());
        }

        System.out.println("Behavioural clusters constructed successfully.");
    }

    /**
     * areConnected()
     *
     * Determines whether borrowers belong
     * to same behavioural cluster.
     *
     * @param borrowerA
     * First borrower identifier.
     *
     * @param borrowerB
     * Second borrower identifier.
     *
     * @return
     * true if connected
     * false otherwise.
     */
    public boolean areConnected(String borrowerA, String borrowerB) {

        return unionFind.connected(borrowerA, borrowerB);
    }

    /**
     * countUniqueClusters()
     *
     * Counts behavioural cluster groups.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @return
     * Total unique behavioural clusters.
     */
    public int countUniqueClusters(List<Borrower> borrowers) {

        // Stores unique cluster representatives
        Set<String> uniqueClusters = new HashSet<>();

        //Find unique cluster roots.
        for (Borrower borrower : borrowers) {

            uniqueClusters.add(unionFind.find(borrower.getApplicantIdHash()));
        }

        return uniqueClusters.size();
    }

    /**
     * getUnionFind()
     *
     * Returns Union-Find infrastructure.
     *
     * @return
     * Behavioural connectivity engine.
     */
    public UnionFind getUnionFind() {

        return unionFind;
    }
}
