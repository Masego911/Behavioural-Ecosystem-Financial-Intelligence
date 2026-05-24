import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BehaviouralPersonaReporter
 *
 * Responsible ONLY for:
 * - behavioural cluster interpretation,
 * - persona generation,
 * - explainable intelligence reporting,
 * - uncertainty interpretation,
 * - and behavioural narrative generation.
 *
 * IMPORTANT:
 * - No graph construction
 * - No anomaly detection
 * - No persistence
 * - No scoring
 *
 * Research Alignment:
 * Modern behavioural credit systems interpret:
 * - uncertainty,
 * - missingness,
 * - graph connectivity,
 * - and propagated behaviour
 * as explainable behavioural intelligence.
 *
 * Therefore:
 * missing income is treated as:
 * - informational opacity,
 * - thin-file behaviour,
 * - institutional invisibility,
 * - or elevated uncertainty.
 *
 * Single Responsibility:
 * Behavioural persona intelligence.
 */
public class BehaviouralPersonaReporter {

    /**
     * generatePersonas()
     *
     * Generates:
     * - behavioural personas,
     * - uncertainty narratives,
     * - and explainable cluster intelligence.
     *
     * @param borrowers
     * Collection of analytical borrowers.
     *
     * @param unionFind
     * Behavioural connectivity infrastructure.
     */
    public void generatePersonas(List<Borrower> borrowers, UnionFind unionFind) {

        /**
         * Stores:
         * cluster root -> borrowers.
         */
        Map<String, List<Borrower>> clusterMap =
                new HashMap<>();

        /**
         * ==================================================
         * STEP 1:
         * GROUP BORROWERS BY CLUSTER ROOT
         * ==================================================
         */
        for (Borrower borrower : borrowers) {

            String clusterRoot = unionFind.find(borrower.getApplicantIdHash());

            /**
             * Create cluster bucket if missing.
             */
            if (!clusterMap.containsKey(clusterRoot)) {

                clusterMap.put(clusterRoot, new ArrayList<>());
            }

            /**
             * Insert borrower into behavioural cluster.
             */
            clusterMap.get(clusterRoot).add(borrower);
        }

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL PERSONA INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        /**
         * ==================================================
         * STEP 2:
         * ANALYSE EACH BEHAVIOURAL CLUSTER
         * ==================================================
         */
        for (String clusterId : clusterMap.keySet()) {

            List<Borrower> clusterBorrowers = clusterMap.get(clusterId);

            /**
             * Ignore tiny clusters.
             *
             * Tiny clusters often contain:
             * - noisy relationships,
             * - weak behavioural meaning,
             * - or unstable graph structures.
             */
            if (clusterBorrowers.size() < 5) {

                continue;
            }

            /**
             * ==================================================
             * AGGREGATED BEHAVIOURAL METRICS
             * ==================================================
             */

            double totalDTI = 0;

            double totalUtilisation = 0;

            int totalDelinquencies = 0;

            int totalInquiries = 0;

            int defaultCount = 0;

            int missingIncomeCount = 0;

            /**
             * ==================================================
             * AGGREGATE CLUSTER SIGNALS
             * ==================================================
             */
            for (Borrower borrower : clusterBorrowers) {

                /**
                 * Aggregate DTI.
                 */
                if (borrower.getDtiRatio() != null) {

                    totalDTI += borrower.getDtiRatio();
                }

                /**
                 * Aggregate utilisation.
                 */
                if (borrower.getCreditUtilisationPct() != null) {

                    totalUtilisation += borrower.getCreditUtilisationPct();
                }

                /**
                 * Aggregate delinquency behaviour.
                 */
                if (borrower.getNumDelinquencies2yr() != null) {

                    totalDelinquencies += borrower.getNumDelinquencies2yr();
                }

                /**
                 * Aggregate inquiry behaviour.
                 */
                if (borrower.getNumHardInquiries6mo() != null) {

                    totalInquiries += borrower.getNumHardInquiries6mo();
                }

                /**
                 * ==================================================
                 * NULL-SAFE DEFAULT DETECTION
                 * ==================================================
                 */
                if (Boolean.TRUE.equals(borrower.getDefaultFlag())) {

                    defaultCount++;
                }

                /**
                 * ==================================================
                 * INFORMATIONAL OPACITY DETECTION
                 * ==================================================
                 *
                 * IMPORTANT:
                 * Missing income is interpreted as:
                 * behavioural uncertainty signal.
                 */
                if (Boolean.TRUE.equals(borrower.getMissingIncome())) {

                    missingIncomeCount++;
                }
            }

            /**
             * ==================================================
             * COMPUTE CLUSTER AVERAGES
             * ==================================================
             */

            double averageDTI = totalDTI / clusterBorrowers.size();

            double averageUtilisation = totalUtilisation / clusterBorrowers.size();

            double averageDelinquencies = (double) totalDelinquencies / clusterBorrowers.size();

            double averageInquiries = (double) totalInquiries
                            / clusterBorrowers.size();

            double defaultRate = (double) defaultCount / clusterBorrowers.size();

            /**
             * Percentage of borrowers
             * exhibiting informational opacity.
             */
            double missingIncomeRate = (double) missingIncomeCount / clusterBorrowers.size();

            /**
             * ==================================================
             * GENERATE PERSONA
             * ==================================================
             */

            String persona =
                    determinePersona(

                            averageDTI,

                            averageUtilisation,

                            averageDelinquencies,

                            averageInquiries,

                            defaultRate,

                            missingIncomeRate
                    );

            /**
             * ==================================================
             * DISPLAY CLUSTER INTELLIGENCE
             * ==================================================
             */

            System.out.println(
                    "\n=================================================="
            );

            System.out.println(
                    "CLUSTER PROFILE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Cluster ID: "
                            + clusterId
            );

            System.out.println(
                    "Cluster Size: "
                            + clusterBorrowers.size()
            );

            System.out.println(
                    "Behavioural Persona: "
                            + persona
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
                    "Average Delinquencies: "
                            + averageDelinquencies
            );

            System.out.println(
                    "Average Inquiries: "
                            + averageInquiries
            );

            System.out.println(
                    "Default Rate: "
                            + defaultRate
            );

            System.out.println(
                    "Informational Opacity Rate: "
                            + missingIncomeRate
            );

            /**
             * ==================================================
             * EXPLAINABLE INTERPRETATION
             * ==================================================
             */

            System.out.println(
                    "\nINTERPRETATION:"
            );

            printInterpretation(

                    persona,

                    missingIncomeRate
            );
        }
    }

    /**
     * determinePersona()
     *
     * Generates explainable behavioural persona.
     *
     * IMPORTANT:
     * Personas now integrate:
     * - financial behaviour,
     * - uncertainty,
     * - and informational opacity.
     *
     * @return
     * Behavioural persona label.
     */
    private String determinePersona(

            double averageDTI,

            double averageUtilisation,

            double averageDelinquencies,

            double averageInquiries,

            double defaultRate,

            double missingIncomeRate
    ) {

        /**
         * ==================================================
         * INFORMATIONALLY OPAQUE CLUSTER
         * ==================================================
         */

        if (

                missingIncomeRate > 0.40

                        &&

                        averageUtilisation > 60
        ) {

            return
                    "Financially Opaque High-Stress Borrowers";
        }

        /**
         * ==================================================
         * FINANCIAL DISTRESS
         * ==================================================
         */

        if (

                averageDTI > 45

                        &&

                        averageUtilisation > 80
        ) {

            return
                    "Financially Distressed Borrowers";
        }

        /**
         * ==================================================
         * AGGRESSIVE CREDIT SEEKING
         * ==================================================
         */

        if (

                averageInquiries > 5
        ) {

            return
                    "Aggressive Credit Seekers";
        }

        /**
         * ==================================================
         * HIGH DEFAULT RISK
         * ==================================================
         */

        if (

                averageDelinquencies > 3

                        ||

                        defaultRate > 0.30
        ) {

            return
                    "High Default Risk Cluster";
        }

        /**
         * ==================================================
         * STABLE PRIME BORROWERS
         * ==================================================
         */

        if (

                averageDTI < 20

                        &&

                        averageUtilisation < 30
        ) {

            return
                    "Stable Prime Borrowers";
        }

        /**
         * ==================================================
         * THIN-FILE STABLE BORROWERS
         * ==================================================
         */

        if (

                missingIncomeRate > 0.40

                        &&

                        averageUtilisation < 40
        ) {

            return
                    "Thin-File Stable Borrowers";
        }

        /**
         * ==================================================
         * DEFAULT PERSONA
         * ==================================================
         */

        return
                "Moderate Risk Borrowers";
    }

    /**
     * printInterpretation()
     *
     * Generates explainable behavioural narrative.
     *
     * IMPORTANT:
     * Personas are now:
     * - uncertainty-aware,
     * - graph-aware,
     * - and behaviourally interpretable.
     */
    private void printInterpretation(

            String persona,

            double missingIncomeRate
    ) {

        switch (persona) {

            /**
             * ==================================================
             * FINANCIALLY OPAQUE HIGH-STRESS BORROWERS
             * ==================================================
             */

            case "Financially Opaque High-Stress Borrowers":

                System.out.println(
                        "This cluster exhibits elevated financial stress "
                                + "combined with significant informational opacity."
                );

                System.out.println(
                        "Research-aligned interpretation suggests:"
                );

                System.out.println(
                        "- elevated behavioural uncertainty,"
                );

                System.out.println(
                        "- possible thin-file borrower behaviour,"
                );

                System.out.println(
                        "- institutional invisibility,"
                );

                System.out.println(
                        "- or unstable income structures."
                );

                System.out.println(
                        "High utilisation combined with missing income "
                                + "may indicate elevated repayment uncertainty."
                );

                break;

            /**
             * ==================================================
             * FINANCIALLY DISTRESSED
             * ==================================================
             */

            case "Financially Distressed Borrowers":

                System.out.println(
                        "This cluster exhibits elevated financial stress "
                                + "characterised by high debt pressure "
                                + "and excessive revolving utilisation."
                );

                System.out.println(
                        "These borrowers may experience repayment difficulty "
                                + "under adverse economic conditions."
                );

                break;

            /**
             * ==================================================
             * AGGRESSIVE CREDIT SEEKERS
             * ==================================================
             */

            case "Aggressive Credit Seekers":

                System.out.println(
                        "This cluster demonstrates elevated credit-seeking behaviour "
                                + "through frequent hard inquiries."
                );

                System.out.println(
                        "This behaviour may indicate liquidity pressure "
                                + "or aggressive borrowing activity."
                );

                break;

            /**
             * ==================================================
             * HIGH DEFAULT RISK
             * ==================================================
             */

            case "High Default Risk Cluster":

                System.out.println(
                        "This cluster exhibits significant historical delinquency "
                                + "and elevated default behaviour."
                );

                System.out.println(
                        "These borrowers may require enhanced monitoring "
                                + "or stricter lending controls."
                );

                break;

            /**
             * ==================================================
             * STABLE PRIME BORROWERS
             * ==================================================
             */

            case "Stable Prime Borrowers":

                System.out.println(
                        "This cluster demonstrates stable financial behaviour "
                                + "with low debt pressure and controlled utilisation."
                );

                System.out.println(
                        "These borrowers represent relatively healthy "
                                + "credit profiles."
                );

                break;

            /**
             * ==================================================
             * THIN-FILE STABLE BORROWERS
             * ==================================================
             */

            case "Thin-File Stable Borrowers":

                System.out.println(
                        "This cluster exhibits elevated informational opacity "
                                + "without strong financial stress indicators."
                );

                System.out.println(
                        "Research-aligned interpretation suggests:"
                );

                System.out.println(
                        "- thin-file borrower behaviour,"
                );

                System.out.println(
                        "- informal economic participation,"
                );

                System.out.println(
                        "- or institutional underrepresentation."
                );

                System.out.println(
                        "Despite missing income signals, "
                                + "the cluster demonstrates relatively stable "
                                + "financial behaviour."
                );

                break;

            /**
             * ==================================================
             * DEFAULT INTERPRETATION
             * ==================================================
             */

            default:

                System.out.println(
                        "This cluster exhibits moderate behavioural risk "
                                + "without extreme financial stress signals."
                );

                /**
                 * Additional uncertainty interpretation.
                 */
                if (missingIncomeRate > 0.20) {

                    System.out.println(
                            "The cluster also demonstrates moderate "
                                    + "informational opacity through missing income behaviour."
                    );
                }
        }
    }
}

