import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClusterAnalytics
 *
 * Responsible ONLY for:
 * - behavioural cluster analysis,
 * - graph ecosystem intelligence,
 * - propagated community analytics,
 * - uncertainty concentration analysis,
 * - and explainable cluster interpretation.
 *
 * IMPORTANT:
 * - No graph construction
 * - No anomaly detection
 * - No validation
 * - No persistence
 *
 * Research Alignment:
 * Modern graph-native behavioural systems analyze:
 * - behavioural ecosystems,
 * - uncertainty concentration,
 * - propagated instability,
 * - repayment contagion,
 * - and cluster-level financial stress.
 *
 * IMPORTANT:
 * Clusters are now interpreted as:
 * behavioural borrower ecosystems,
 * not simple grouped records.
 *
 * Single Responsibility:
 * Behavioural cluster intelligence analytics.
 */
public class ClusterAnalytics {

    /**
     * analyzeClusters()
     *
     * Analyzes:
     * - behavioural borrower ecosystems,
     * - uncertainty topology,
     * - propagated behavioural concentration,
     * - and explainable graph communities.
     *
     * @param borrowers
     * Structured behavioural borrowers.
     *
     * @param unionFind
     * Graph connectivity infrastructure.
     */
    public void analyzeClusters(

            List<Borrower> borrowers,

            UnionFind unionFind
    ) {

        /**
         * ==================================================
         * CLUSTER SIZE STORAGE
         * ==================================================
         *
         * Stores:
         * cluster root -> cluster size.
         */
        Map<String, Integer> clusterSizes =
                new HashMap<>();

        /**
         * ==================================================
         * CLUSTER FINANCIAL STRESS
         * ==================================================
         *
         * Stores:
         * cluster root -> cumulative DTI.
         */
        Map<String, Double> clusterDTI =
                new HashMap<>();

        /**
         * ==================================================
         * CLUSTER UTILISATION STRESS
         * ==================================================
         */

        Map<String, Double> clusterUtilisation =
                new HashMap<>();

        /**
         * ==================================================
         * CLUSTER INFORMATIONAL OPACITY
         * ==================================================
         *
         * Stores:
         * cluster root -> missing income count.
         */
        Map<String, Integer> clusterOpacity =
                new HashMap<>();

        /**
         * ==================================================
         * CLUSTER DELINQUENCY CONCENTRATION
         * ==================================================
         */

        Map<String, Integer> clusterDelinquencies =
                new HashMap<>();

        /**
         * ==================================================
         * STEP 1:
         * BUILD CLUSTER ANALYTICS
         * ==================================================
         */

        for (Borrower borrower : borrowers) {

            /**
             * Retrieve behavioural cluster root.
             */
            String clusterRoot =

                    unionFind.find(
                            borrower.getApplicantIdHash()
                    );

            /**
             * ==================================================
             * CLUSTER SIZE
             * ==================================================
             */

            clusterSizes.put(

                    clusterRoot,

                    clusterSizes.getOrDefault(
                            clusterRoot,
                            0
                    ) + 1
            );

            /**
             * ==================================================
             * DTI AGGREGATION
             * ==================================================
             */

            if (borrower.getDtiRatio() != null) {

                clusterDTI.put(

                        clusterRoot,

                        clusterDTI.getOrDefault(
                                clusterRoot,
                                0.0
                        )

                                +

                                borrower.getDtiRatio()
                );
            }

            /**
             * ==================================================
             * UTILISATION AGGREGATION
             * ==================================================
             */

            if (

                    borrower.getCreditUtilisationPct()
                            != null
            ) {

                clusterUtilisation.put(

                        clusterRoot,

                        clusterUtilisation.getOrDefault(
                                clusterRoot,
                                0.0
                        )

                                +

                                borrower.getCreditUtilisationPct()
                );
            }

            /**
             * ==================================================
             * INFORMATIONAL OPACITY
             * ==================================================
             *
             * IMPORTANT:
             * Missing income is now treated as:
             * behavioural uncertainty concentration.
             */

            if (

                    Boolean.TRUE.equals(

                            borrower.getMissingIncome()
                    )
            ) {

                clusterOpacity.put(

                        clusterRoot,

                        clusterOpacity.getOrDefault(
                                clusterRoot,
                                0
                        )

                                + 1
                );
            }

            /**
             * ==================================================
             * DELINQUENCY CONCENTRATION
             * ==================================================
             */

            if (

                    borrower.getNumDelinquencies2yr()
                            != null
            ) {

                clusterDelinquencies.put(

                        clusterRoot,

                        clusterDelinquencies.getOrDefault(
                                clusterRoot,
                                0
                        )

                                +

                                borrower.getNumDelinquencies2yr()
                );
            }
        }

        /**
         * ==================================================
         * GLOBAL CLUSTER ANALYTICS
         * ==================================================
         */

        int totalClusters =
                clusterSizes.size();

        int largestCluster = 0;

        int isolatedBorrowers = 0;

        int totalClusterMembers = 0;

        /**
         * ==================================================
         * COMPUTE GLOBAL STATISTICS
         * ==================================================
         */

        for (int clusterSize : clusterSizes.values()) {

            totalClusterMembers += clusterSize;

            /**
             * Largest behavioural ecosystem.
             */

            if (clusterSize > largestCluster) {

                largestCluster = clusterSize;
            }

            /**
             * Detect isolated borrowers.
             */

            if (clusterSize == 1) {

                isolatedBorrowers++;
            }
        }

        /**
         * ==================================================
         * AVERAGE CLUSTER SIZE
         * ==================================================
         */

        double averageClusterSize =

                totalClusters == 0

                        ? 0

                        :

                        (double) totalClusterMembers
                        / totalClusters;

        /**
         * ==================================================
         * DISPLAY ANALYTICS
         * ==================================================
         */

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL CLUSTER ANALYTICS"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Total Behavioural Clusters: "
                        + totalClusters
        );

        System.out.println(
                "Largest Behavioural Ecosystem: "
                        + largestCluster
        );

        System.out.println(
                "Isolated Borrowers: "
                        + isolatedBorrowers
        );

        System.out.println(
                "Average Cluster Size: "
                        + averageClusterSize
        );

        /**
         * ==================================================
         * CLUSTER-LEVEL INTELLIGENCE
         * ==================================================
         */

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "CLUSTER-LEVEL INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * ==================================================
         * ANALYZE EACH CLUSTER
         * ==================================================
         */

        for (String clusterRoot : clusterSizes.keySet()) {

            int clusterSize =
                    clusterSizes.get(clusterRoot);

            /**
             * ==================================================
             * AVERAGE DTI
             * ==================================================
             */

            double averageDTI =

                    clusterDTI.getOrDefault(
                            clusterRoot,
                            0.0
                    )

                            / clusterSize;

            /**
             * ==================================================
             * AVERAGE UTILISATION
             * ==================================================
             */

            double averageUtilisation =

                    clusterUtilisation.getOrDefault(
                            clusterRoot,
                            0.0
                    )

                            / clusterSize;

            /**
             * ==================================================
             * INFORMATIONAL OPACITY RATE
             * ==================================================
             */

            int opacityCount =

                    clusterOpacity.getOrDefault(
                            clusterRoot,
                            0
                    );

            double opacityRate =

                    (double) opacityCount
                            / clusterSize;

            /**
             * ==================================================
             * DELINQUENCY CONCENTRATION
             * ==================================================
             */

            int totalDelinquencies =

                    clusterDelinquencies.getOrDefault(
                            clusterRoot,
                            0
                    );

            /**
             * ==================================================
             * DISPLAY CLUSTER INTELLIGENCE
             * ==================================================
             */

            System.out.println(

                    "\n--------------------------------------------------"
            );

            System.out.println(
                    "Cluster Root: "
                            + clusterRoot
            );

            System.out.println(
                    "Cluster Size: "
                            + clusterSize
            );

            System.out.println(
                    "Average DTI: "
                            + averageDTI
            );

            System.out.println(
                    "Average Utilisation: "
                            + averageUtilisation
            );

            System.out.println(
                    "Opacity Rate: "
                            + opacityRate
            );

            System.out.println(
                    "Total Delinquencies: "
                            + totalDelinquencies
            );

            /**
             * ==================================================
             * EXPLAINABLE INTERPRETATION
             * ==================================================
             */

            System.out.println(
                    "\nINTERPRETATION:"
            );

            /**
             * Elevated financial stress.
             */

            if (averageDTI > 40) {

                System.out.println(
                        "- Cluster exhibits elevated financial stress."
                );
            }

            /**
             * Overextended borrower ecosystem.
             */

            if (averageUtilisation > 75) {

                System.out.println(
                        "- Cluster exhibits elevated credit overextension."
                );
            }

            /**
             * Informational uncertainty concentration.
             */

            if (opacityRate > 0.30) {

                System.out.println(
                        "- Cluster contains concentrated informational opacity."
                );

                System.out.println(
                        "- Possible thin-file borrower ecosystem."
                );

                System.out.println(
                        "- Possible institutional invisibility concentration."
                );
            }

            /**
             * Repayment instability concentration.
             */

            if (totalDelinquencies >= clusterSize * 2) {

                System.out.println(
                        "- Cluster exhibits repayment instability concentration."
                );
            }

            /**
             * Highly connected behavioural ecosystem.
             */

            if (clusterSize >= 10) {

                System.out.println(
                        "- Large behavioural borrower ecosystem detected."
                );
            }
        }

        /**
         * ==================================================
         * ANALYTICS COMPLETE
         * ==================================================
         */

        System.out.println(

                "\n=================================================="
        );

        System.out.println(
                "CLUSTER ANALYTICS COMPLETE"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Behavioural ecosystem analysis completed successfully."
        );
    }
}