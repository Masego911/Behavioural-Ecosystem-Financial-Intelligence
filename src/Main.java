import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Main
 *
 * Entry point of the BCIP system.
 *
 * Responsible ONLY for:
 * - pipeline orchestration,
 * - execution coordination,
 * - behavioural intelligence workflow control,
 * - and architectural layer integration.
 *
 * IMPORTANT:
 * Main does NOT contain:
 * - parsing logic,
 * - validation logic,
 * - graph algorithms,
 * - SQL logic,
 * - or anomaly logic.
 *
 * Research Alignment:
 * This orchestration layer coordinates:
 * - behavioural uncertainty modelling,
 * - explainable graph intelligence,
 * - propagated behavioural analysis,
 * - and informational opacity interpretation.
 *
 * Single Responsibility:
 * Behavioural intelligence pipeline orchestration.
 */
public class Main {


    // Responsible for:
    // - temporal behavioural state classification,
    // - behavioural evolution interpretation,
    // - and Markov state assignment
    private static BehaviouralStateClassifier
            behaviouralStateClassifier =
            new BehaviouralStateClassifier();

    // Responsible for:
    // - behavioural transition probabilities,
    // - temporal movement modelling,
    // - and Markov infrastructure
    private static MarkovTransitionMatrix
            markovTransitionMatrix =
            new MarkovTransitionMatrix();

    // Responsible for:
    // - temporal behavioural evolution,
    // - future-state prediction,
    // - and Markov forecasting
    private static MarkovChainEngine
            markovChainEngine =
            new MarkovChainEngine(
                    markovTransitionMatrix
            );

    // Responsible for:
    // - explainable behavioural trajectories,
    // - temporal reporting,
    // - and operational forecasting
    private static BehaviouralTrajectoryReporter
            behaviouralTrajectoryReporter =
            new BehaviouralTrajectoryReporter(
                    markovTransitionMatrix
            );

    // Responsible for:
    // - future portfolio forecasting,
    // - temporal ecosystem projection,
    // - and behavioural evolution analysis
    private static TemporalRiskPredictor
            temporalRiskPredictor =
            new TemporalRiskPredictor(
                    markovChainEngine
            );

    // Responsible for:
    // - explainable temporal causality,
    // - behavioural transition reasoning,
    // - and future-state interpretation
    private static BehaviouralTransitionExplainer
            behaviouralTransitionExplainer =
            new BehaviouralTransitionExplainer();

    // Responsible for:
    // - ecosystem contagion evolution,
    // - temporal instability propagation,
    // - and behavioural ecosystem forecasting
    private static TemporalContagionAnalyzer
            temporalContagionAnalyzer =
            new TemporalContagionAnalyzer(
                    markovChainEngine
            );
    /**
     * ==================================================
     * INFRASTRUCTURE LAYER
     * ==================================================
     */

    private static SchemaManager schemaManager =
            new SchemaManager();

    private static CSVLoader csvLoader =
            new CSVLoader();

    private static PipelineLogger pipelineLogger =
            new PipelineLogger();

    private static TransactionManager transactionManager =
            new TransactionManager();

    /**
     * ==================================================
     * PERSISTENCE LAYER
     * ==================================================
     */

    private static BatchRawRecordDAO batchRawRecordDAO =
            new BatchRawRecordDAO();

    private static BatchBorrowerDAO batchBorrowerDAO =
            new BatchBorrowerDAO();

    /**
     * ==================================================
     * PIPELINE METRICS
     * ==================================================
     */

    private static PipelineMetrics pipelineMetrics =
            new PipelineMetrics();

    /**
     * ==================================================
     * GRAPH INTELLIGENCE LAYER
     * ==================================================
     */

    private static IndexedRelationshipDetector indexedRelationshipDetector =
            new IndexedRelationshipDetector();

    private static BehaviouralClusterEngine behaviouralClusterEngine =
            new BehaviouralClusterEngine();

    private static ClusterAnalytics clusterAnalytics =
            new ClusterAnalytics();

    private static BehaviouralPersonaReporter behaviouralPersonaReporter =
            new BehaviouralPersonaReporter();

    /**
     * ==================================================
     * RISK & ANOMALY LAYER
     * ==================================================
     */

    private static RiskPropagationEngine riskPropagationEngine =
            new RiskPropagationEngine();

    private static AnomalyDetectionEngine anomalyDetectionEngine =
            new AnomalyDetectionEngine();

    private static BehaviouralRiskScorer behaviouralRiskScorer =
            new BehaviouralRiskScorer();

    private static HighRiskBorrowerReporter highRiskBorrowerReporter =
            new HighRiskBorrowerReporter();

    /**
     * ==================================================
     * FEATURE ENGINEERING
     * ==================================================
     */

    private static BehaviouralFeatureExporter behaviouralFeatureExporter =
            new BehaviouralFeatureExporter();

    /**
     * ==================================================
     * PIPELINE METRICS
     * ==================================================
     */

    private static int successfulBorrowers = 0;

    private static int failedBorrowers = 0;

    /**
     * ==================================================
     * MAIN ENTRY POINT
     * ==================================================
     */

    public static void main(String[] args) {


        try {

            /**
             * ==================================================
             * PIPELINE INITIALISATION
             * ==================================================
             */

            pipelineMetrics.startPipelineTimer();

            initializeInfrastructure();

            /**
             * ==================================================
             * LOAD RAW DATA
             * ==================================================
             */

            List<RawRecord> rawRecords =
                    loadRawRecords();

            pipelineMetrics.setTotalRecords(
                    rawRecords.size()
            );

            /**
             * ==================================================
             * RAW INGESTION
             * ==================================================
             */

            batchRawRecordDAO.insertBatch(

                    rawRecords,

                    transactionManager
            );

            /**
             * ==================================================
             * PIPELINE PROCESSING
             * ==================================================
             */

            List<Borrower> validatedBorrowers =
                    processPipeline(
                            rawRecords
                    );

            /**
             * ==================================================
             * VALIDATED PERSISTENCE
             * ==================================================
             */

            batchBorrowerDAO.insertBatch(

                    validatedBorrowers,

                    transactionManager
            );

            /**
             * ==================================================
             * RELATIONSHIP DETECTION
             * ==================================================
             */

            List<BorrowerRelationship> relationships =

                    indexedRelationshipDetector.detectRelationships(
                            validatedBorrowers
                    );

            printRelationshipResults(
                    relationships
            );

            /**
             * ==================================================
             * CLUSTER CONSTRUCTION
             * ==================================================
             */

            behaviouralClusterEngine.buildClusters(

                    validatedBorrowers,

                    relationships
            );

            printClusterResults(
                    validatedBorrowers
            );

            /**
             * ==================================================
             * CLUSTER ANALYTICS
             * ==================================================
             */

            clusterAnalytics.analyzeClusters(

                    validatedBorrowers,

                    behaviouralClusterEngine.getUnionFind()
            );

            /**
             * ==================================================
             * PERSONA GENERATION
             * ==================================================
             */

            behaviouralPersonaReporter.generatePersonas(

                    validatedBorrowers,

                    behaviouralClusterEngine.getUnionFind()
            );

            /**
             * ==================================================
             * GRAPH-BASED PROPAGATION
             * ==================================================
             */

            Map<String, Integer> propagatedRiskScores =

                    riskPropagationEngine.propagateRisk(

                            validatedBorrowers,

                            relationships
                    );

            printRiskPropagationResults();

            /**
             * ==================================================
             * ANOMALY DETECTION
             * ==================================================
             */

            List<String> anomalies =

                    anomalyDetectionEngine.detectAnomalies(

                            validatedBorrowers,

                            propagatedRiskScores
                    );

            printAnomalyResults(
                    anomalies
            );

            /**
             * ==================================================
             * BEHAVIOURAL RISK SCORING
             * ==================================================
             */

            Map<String, Integer> behaviouralScores =

                    behaviouralRiskScorer.scoreBorrowers(

                            validatedBorrowers,

                            propagatedRiskScores
                    );

            printBehaviouralScoringResults();
            /**
             * ==================================================
             * TEMPORAL BEHAVIOURAL INTELLIGENCE
             * ==================================================
             */

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "TEMPORAL BEHAVIOURAL INTELLIGENCE"
            );

            System.out.println(
                    "=================================================="
            );

            /**
             * ==================================================
             * DISPLAY TRANSITION MATRIX
             * ==================================================
             */

            markovTransitionMatrix
                    .printTransitionMatrix();

            /**
             * ==================================================
             * SAMPLE BORROWER TEMPORAL ANALYSIS
             * ==================================================
             *
             * IMPORTANT:
             * Analyze only first few borrowers
             * for explainability visibility.
             */

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "SAMPLE TEMPORAL TRAJECTORIES"
            );

            System.out.println(
                    "=================================================="
            );

            for (

                    int i = 0;

                    i < Math.min(
                            5,
                            validatedBorrowers.size()
                    );

                    i++
            ) {

                Borrower borrower =
                        validatedBorrowers.get(i);

                /**
                 * Determine:
                 * current behavioural state.
                 */

                BehaviouralState currentState =

                        behaviouralStateClassifier
                                .classifyState(

                                        borrower,

                                        propagatedRiskScores
                                );

                /**
                 * Predict:
                 * future behavioural state.
                 */

                BehaviouralState futureState =

                        markovChainEngine
                                .predictNextState(
                                        currentState
                                );

                /**
                 * ==================================================
                 * DISPLAY TEMPORAL RESULTS
                 * ==================================================
                 */

                System.out.println(

                        "\n--------------------------------------------------"
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
                 * EXPLAINABLE TRAJECTORY
                 * ==================================================
                 */

                behaviouralTrajectoryReporter
                        .generateTrajectoryReport(
                                currentState
                        );

                /**
                 * ==================================================
                 * EXPLAINABLE TRANSITION CAUSALITY
                 * ==================================================
                 */

                behaviouralTransitionExplainer
                        .explainTransition(

                                borrower,

                                currentState,

                                futureState,

                                propagatedRiskScores
                        );
            }

            /**
             * ==================================================
             * PORTFOLIO FORECASTING
             * ==================================================
             */

            temporalRiskPredictor.predictPortfolioEvolution(validatedBorrowers, propagatedRiskScores);

            /**
             * ==================================================
             * TEMPORAL CONTAGION ANALYSIS
             * ==================================================
             */

            temporalContagionAnalyzer
                    .analyzeTemporalContagion(

                            validatedBorrowers,

                            propagatedRiskScores,

                            behaviouralClusterEngine
                                    .getUnionFind()
                    );

            /**
             * ==================================================
             * HIGH-RISK REPORTING
             * ==================================================
             */

            highRiskBorrowerReporter.printHighRiskBorrowers(

                    validatedBorrowers,

                    behaviouralScores
            );

            printHighRiskInterpretation();

            /**
             * ==================================================
             * FEATURE EXPORT
             * ==================================================
             */

            behaviouralFeatureExporter.exportFeatures(

                    validatedBorrowers,

                    propagatedRiskScores,

                    behaviouralScores,

                    anomalies
            );

            printFeatureEngineeringResults();

            /**
             * ==================================================
             * PIPELINE METRICS
             * ==================================================
             */

            pipelineMetrics.setSuccessfulBorrowers(
                    successfulBorrowers
            );

            pipelineMetrics.setFailedBorrowers(
                    failedBorrowers
            );

            pipelineMetrics.stopPipelineTimer();

            printPipelineSummary();

            pipelineMetrics.printMetrics();

            /**
             * ==================================================
             * CLEAN SHUTDOWN
             * ==================================================
             */

            transactionManager.close();
        }

        catch (Exception exception) {

            System.out.println(

                    "\n=================================================="
            );

            System.out.println(
                    "CRITICAL BCIP FAILURE"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "System Failure: "
                            + exception.getMessage()
            );

            exception.printStackTrace();
        }
    }

    /**
     * ==================================================
     * INITIALISE INFRASTRUCTURE
     * ==================================================
     */

    private static void initializeInfrastructure()
            throws SQLException {

        schemaManager.initializeDatabase();

        System.out.println(
                "Infrastructure initialized successfully."
        );
    }

    /**
     * ==================================================
     * LOAD RAW RECORDS
     * ==================================================
     */

    private static List<RawRecord> loadRawRecords() {

        return csvLoader.loadCSV(
                "loan_book.csv"
        );
    }

    /**
     * ==================================================
     * PROCESS PIPELINE
     * ==================================================
     */

    private static List<Borrower> processPipeline(
            List<RawRecord> rawRecords
    ) {

        List<Borrower> validatedBorrowers =
                new ArrayList<>();

        for (RawRecord rawRecord : rawRecords) {

            Borrower borrower =
                    processRawRecord(
                            rawRecord
                    );

            if (borrower != null) {

                validatedBorrowers.add(
                        borrower
                );
            }
        }

        return validatedBorrowers;
    }

    /**
     * ==================================================
     * PROCESS RAW RECORD
     * ==================================================
     */

    private static Borrower processRawRecord(
            RawRecord rawRecord
    ) {

        /**
         * ==================================================
         * PARSE FEATURES
         * ==================================================
         */

        Integer age =
                DataParser.parseIntegerSafe(
                        rawRecord.getAge()
                );

        Double annualIncome =
                DataParser.parseDoubleSafe(
                        rawRecord.getAnnualIncome()
                );

        Double utilisation =
                DataParser.parseDoubleSafe(
                        rawRecord.getCreditUtilisationPct()
                );

        Double dtiRatio =
                DataParser.parseDoubleSafe(
                        rawRecord.getDtiRatio()
                );

        Integer delinquencies =
                DataParser.parseIntegerSafe(
                        rawRecord.getNumDelinquencies2yr()
                );

        Integer inquiries =
                DataParser.parseIntegerSafe(
                        rawRecord.getNumHardInquiries6mo()
                );

        /**
         * ==================================================
         * INFORMATIONAL OPACITY
         * ==================================================
         */

        boolean informationalOpacity =
                annualIncome == null;

        /**
         * ==================================================
         * INFORMATIONAL UNCERTAINTY OBSERVABILITY
         * ==================================================
         */

        if (informationalOpacity) {

            System.out.println(
                    "\n=================================================="
            );

            System.out.println(
                    "INFORMATIONAL OPACITY DETECTED"
            );

            System.out.println(
                    "=================================================="
            );

            System.out.println(
                    "Borrower ID: "
                            + rawRecord.getApplicantIdHash()
            );

            System.out.println(
                    "Missing income may indicate:"
            );

            System.out.println(
                    "- thin-file borrower behaviour"
            );

            System.out.println(
                    "- informal economic participation"
            );

            System.out.println(
                    "- institutional invisibility"
            );

            System.out.println(
                    "- or behavioural uncertainty"
            );

            pipelineLogger.log(

                    rawRecord.getApplicantIdHash(),

                    "UNCERTAINTY",

                    "MISSING_INCOME",

                    "Borrower exhibits informational opacity."
            );
        }

        /**
         * ==================================================
         * STRUCTURAL VALIDATION
         * ==================================================
         */

        boolean structurallyValid =

                validateBorrower(

                        age,

                        annualIncome,

                        utilisation,

                        dtiRatio,

                        delinquencies,

                        inquiries
                );

        /**
         * ==================================================
         * VALIDATION FAILURE
         * ==================================================
         */

        if (!structurallyValid) {

            failedBorrowers++;

            pipelineLogger.log(

                    rawRecord.getApplicantIdHash(),

                    "VALIDATION",

                    "STRUCTURAL_INVALIDITY",

                    "Borrower failed behavioural validation."
            );

            return null;
        }

        /**
         * ==================================================
         * CREATE STRUCTURED BORROWER
         * ==================================================
         */

        Borrower borrower =

                createBorrower(

                        rawRecord,

                        age,

                        annualIncome,

                        utilisation,

                        dtiRatio,

                        delinquencies,

                        inquiries
                );

        successfulBorrowers++;

        return borrower;
    }

    /**
     * ==================================================
     * VALIDATE BORROWER
     * ==================================================
     */

    private static boolean validateBorrower(

            Integer age,

            Double annualIncome,

            Double utilisation,

            Double dtiRatio,

            Integer delinquencies,

            Integer inquiries
    ) {

        return

                BorrowerValidator.isValidAge(
                        age
                )

                        &&

                        BorrowerValidator.isValidIncome(
                                annualIncome
                        )

                        &&

                        BorrowerValidator.isValidCreditUtilisation(
                                utilisation
                        )

                        &&

                        BorrowerValidator.isValidDTI(
                                dtiRatio
                        )

                        &&

                        BorrowerValidator.isValidDelinquencyCount(
                                delinquencies
                        )

                        &&

                        BorrowerValidator.isValidInquiryCount(
                                inquiries
                        );
    }

    /**
     * ==================================================
     * CREATE BORROWER
     * ==================================================
     */

    private static Borrower createBorrower(

            RawRecord rawRecord,

            Integer age,

            Double annualIncome,

            Double utilisation,

            Double dtiRatio,

            Integer delinquencies,

            Integer inquiries
    ) {

        /**
         * ==================================================
         * INFORMATIONAL OPACITY
         * ==================================================
         */

        boolean missingIncome =
                annualIncome == null;

        /**
         * ==================================================
         * CREATE STRUCTURED BORROWER
         * ==================================================
         */

        return new Borrower(

                rawRecord.getApplicantIdHash(),

                DataParser.normalizeString(
                        rawRecord.getRegion()
                ),

                DataParser.normalizeString(
                        rawRecord.getHomeOwnership()
                ),

                DataParser.normalizeString(
                        rawRecord.getEmailDomainType()
                ),

                rawRecord.getBranchCodeId(),

                age,

                annualIncome,

                dtiRatio,

                utilisation,

                delinquencies,

                inquiries,

                DataParser.parseBooleanSafe(
                        rawRecord.getDefaultFlag()
                ),

                missingIncome
        );
    }

    /**
     * ==================================================
     * RELATIONSHIP RESULTS
     * ==================================================
     */

    private static void printRelationshipResults(
            List<BorrowerRelationship> relationships
    ) {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "EXPLAINABLE RELATIONSHIP INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Relationships Detected: "
                        + relationships.size()
        );

        System.out.println(
                "\nINTERPRETATION:"
        );

        System.out.println(
                "Relationships represent explainable behavioural similarity."
        );

        System.out.println(
                "Graph edges preserve:"
        );

        System.out.println(
                "- shared financial stress"
        );

        System.out.println(
                "- informational opacity overlap"
        );

        System.out.println(
                "- repayment similarity"
        );

        System.out.println(
                "- and behavioural locality"
        );

        System.out.println(
                "\nSAMPLE RELATIONSHIPS:"
        );

        for (

                int i = 0;

                i < Math.min(10, relationships.size());

                i++
        ) {

            System.out.println(
                    relationships.get(i)
            );
        }
    }

    /**
     * ==================================================
     * CLUSTER RESULTS
     * ==================================================
     */

    private static void printClusterResults(
            List<Borrower> borrowers
    ) {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL CLUSTER INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        int uniqueClusters =

                behaviouralClusterEngine.countUniqueClusters(
                        borrowers
                );

        System.out.println(
                "Unique Behavioural Communities: "
                        + uniqueClusters
        );

        System.out.println(
                "\nINTERPRETATION:"
        );

        System.out.println(
                "Clusters represent borrower ecosystems "
                        + "with shared behavioural characteristics."
        );

        System.out.println(
                "Borrowers inside the same cluster may share:"
        );

        System.out.println(
                "- financial stress profiles"
        );

        System.out.println(
                "- uncertainty overlap"
        );

        System.out.println(
                "- behavioural borrowing patterns"
        );

        System.out.println(
                "- and graph-connected instability"
        );
    }

    /**
     * ==================================================
     * PROPAGATION RESULTS
     * ==================================================
     */

    private static void printRiskPropagationResults() {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "GRAPH-BASED RISK PROPAGATION"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Behavioural propagation completed."
        );

        System.out.println(
                "\nINTERPRETATION:"
        );

        System.out.println(
                "Propagation models how:"
        );

        System.out.println(
                "- repayment instability,"
        );

        System.out.println(
                "- uncertainty,"
        );

        System.out.println(
                "- financial stress,"
        );

        System.out.println(
                "- and aggressive borrowing behaviour"
        );

        System.out.println(
                "spread across behavioural borrower networks."
        );
    }

    /**
     * ==================================================
     * ANOMALY RESULTS
     * ==================================================
     */

    private static void printAnomalyResults(
            List<String> anomalies
    ) {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL ANOMALY INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Suspicious Borrowers: "
                        + anomalies.size()
        );

        System.out.println(
                "\nINTERPRETATION:"
        );

        System.out.println(
                "Anomalies represent:"
        );

        System.out.println(
                "- behavioural inconsistency"
        );

        System.out.println(
                "- elevated financial stress"
        );

        System.out.println(
                "- propagated instability"
        );

        System.out.println(
                "- aggressive credit-seeking behaviour"
        );

        System.out.println(
                "- and informational opacity"
        );
    }

    /**
     * ==================================================
     * SCORING RESULTS
     * ==================================================
     */

    private static void printBehaviouralScoringResults() {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BEHAVIOURAL INTELLIGENCE SCORING"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Unified behavioural scores generated."
        );

        System.out.println(
                "\nINTERPRETATION:"
        );

        System.out.println(
                "Scores aggregate:"
        );

        System.out.println(
                "- graph influence"
        );

        System.out.println(
                "- propagated instability"
        );

        System.out.println(
                "- financial stress"
        );

        System.out.println(
                "- behavioural anomalies"
        );

        System.out.println(
                "- and repayment instability"
        );
    }

    /**
     * ==================================================
     * HIGH-RISK INTERPRETATION
     * ==================================================
     */

    private static void printHighRiskInterpretation() {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "HIGH-RISK OPERATIONAL INTELLIGENCE"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "High-risk borrowers contain:"
        );

        System.out.println(
                "- overlapping behavioural risk signals"
        );

        System.out.println(
                "- propagated graph instability"
        );

        System.out.println(
                "- behavioural uncertainty"
        );

        System.out.println(
                "- and elevated financial stress"
        );

        System.out.println(
                "\nOPERATIONAL USE CASES:"
        );

        System.out.println(
                "- enhanced monitoring"
        );

        System.out.println(
                "- fraud investigation"
        );

        System.out.println(
                "- repayment intervention"
        );

        System.out.println(
                "- governance escalation"
        );

        System.out.println(
                "- and explainable operational review"
        );
    }

    /**
     * ==================================================
     * FEATURE ENGINEERING RESULTS
     * ==================================================
     */

    private static void printFeatureEngineeringResults() {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "ML FEATURE ENGINEERING"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "ML-ready behavioural dataset exported."
        );

        System.out.println(
                "\nDATASET CONTAINS:"
        );

        System.out.println(
                "- borrower behavioural features"
        );

        System.out.println(
                "- graph intelligence"
        );

        System.out.println(
                "- propagated risk"
        );

        System.out.println(
                "- anomaly indicators"
        );

        System.out.println(
                "- behavioural uncertainty"
        );

        System.out.println(
                "- and explainable risk signals"
        );

        System.out.println(
                "\nREADY FOR:"
        );

        System.out.println(
                "- Python analytics"
        );

        System.out.println(
                "- machine learning"
        );

        System.out.println(
                "- graph analytics"
        );

        System.out.println(
                "- behavioural modelling"
        );

        System.out.println(
                "- and AI experimentation"
        );
    }

    /**
     * ==================================================
     * PIPELINE SUMMARY
     * ==================================================
     */

    private static void printPipelineSummary() {

        System.out.println(
                "\n=================================================="
        );

        System.out.println(
                "BCIP PIPELINE SUMMARY"
        );

        System.out.println(
                "=================================================="
        );

        System.out.println(
                "Successful Borrowers: "
                        + successfulBorrowers
        );

        System.out.println(
                "Failed Borrowers: "
                        + failedBorrowers
        );

        System.out.println(
                "\nResearch-aligned behavioural pipeline completed."
        );
    }
}