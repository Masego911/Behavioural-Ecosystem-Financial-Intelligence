/**
 * Borrower
 *
 * Represents:
 * - analytical borrower intelligence,
 * - behavioural financial attributes,
 * - informational uncertainty,
 * - graph-compatible borrower state,
 * - and explainable behavioural features.
 *
 * IMPORTANT:
 * This class is a:
 * behavioural entity model.
 *
 * It is NOT responsible for:
 * - validation,
 * - graph traversal,
 * - anomaly detection,
 * - clustering,
 * - propagation,
 * - or persistence logic.
 *
 * Research Alignment:
 * Modern behavioural credit systems preserve:
 * - informational opacity,
 * - uncertainty signals,
 * - thin-file borrower behaviour,
 * - and behavioural explainability.
 *
 * Therefore:
 * missing income is treated as:
 * a first-class behavioural feature.
 *
 * Single Responsibility:
 * Behavioural borrower representation.
 */
public class Borrower {

    /**
     * ==================================================
     * CORE BORROWER IDENTITY
     * ==================================================
     */

    //Unique borrower identifier.
    private String applicantIdHash;

    //Regional behavioural locality.
    private String region;

    //Home ownership category.
    private String homeOwnership;

    //Email domain infrastructure type.
    private String emailDomainType;

    //Branch origination identifier.
    private String branchCodeId;

    /**
     * ==================================================
     * DEMOGRAPHIC FEATURES
     * ==================================================
     */

    //Borrower age.
    private Integer age;

    /**
     * ==================================================
     * FINANCIAL FEATURES
     * ==================================================
     */

    //Annual borrower income.
    private Double annualIncome;

    //Debt-to-income ratio.
    private Double dtiRatio;

    //Credit utilisation percentage.
    private Double creditUtilisationPct;

    //Historical delinquency frequency.
    private Integer numDelinquencies2yr;

    //Recent hard inquiries.
    private Integer numHardInquiries6mo;

    /**
     * ==================================================
     * DEFAULT / REPAYMENT FEATURES
     * ==================================================
     */

    //Historical default behaviour.
    private Boolean defaultFlag;

    /**
     * ==================================================
     * INFORMATIONAL UNCERTAINTY FEATURES
     * ==================================================
     */

    /**
     * Missing income indicator.
     *
     * IMPORTANT:
     * Represents:
     * - informational opacity,
     * - thin-file borrower behaviour,
     * - institutional invisibility,
     * - or elevated uncertainty.
     *
     * Research Alignment:
     * Missingness itself may become:
     * behaviourally predictive.
     */
    private Boolean missingIncome;

    /**
     * ==================================================
     * CONSTRUCTOR
     * ==================================================
     */

    /**
     * Constructs behavioural borrower entity.
     *
     * @param applicantIdHash
     * Unique borrower identifier.
     *
     * @param region
     * Behavioural locality.
     *
     * @param homeOwnership
     * Housing ownership category.
     *
     * @param emailDomainType
     * Email infrastructure type.
     *
     * @param branchCodeId
     * Branch origination identifier.
     *
     * @param age
     * Borrower age.
     *
     * @param annualIncome
     * Annual borrower income.
     *
     * @param dtiRatio
     * Debt-to-income ratio.
     *
     * @param creditUtilisationPct
     * Credit utilisation percentage.
     *
     * @param numDelinquencies2yr
     * Historical delinquency frequency.
     *
     * @param numHardInquiries6mo
     * Hard inquiry behaviour.
     *
     * @param defaultFlag
     * Historical repayment instability.
     *
     * @param missingIncome
     * Informational opacity indicator.
     */
    public Borrower(

            String applicantIdHash,

            String region,

            String homeOwnership,

            String emailDomainType,

            String branchCodeId,

            Integer age,

            Double annualIncome,

            Double dtiRatio,

            Double creditUtilisationPct,

            Integer numDelinquencies2yr,

            Integer numHardInquiries6mo,

            Boolean defaultFlag,

            Boolean missingIncome
    ) {

        /**
         * ==================================================
         * CORE IDENTITY ASSIGNMENT
         * ==================================================
         */

        this.applicantIdHash =
                applicantIdHash;

        this.region =
                region;

        this.homeOwnership =
                homeOwnership;

        this.emailDomainType =
                emailDomainType;

        this.branchCodeId =
                branchCodeId;

        /**
         * ==================================================
         * DEMOGRAPHIC ASSIGNMENT
         * ==================================================
         */

        this.age =
                age;

        /**
         * ==================================================
         * FINANCIAL ASSIGNMENT
         * ==================================================
         */

        this.annualIncome =
                annualIncome;

        this.dtiRatio =
                dtiRatio;

        this.creditUtilisationPct =
                creditUtilisationPct;

        this.numDelinquencies2yr =
                numDelinquencies2yr;

        this.numHardInquiries6mo =
                numHardInquiries6mo;

        /**
         * ==================================================
         * DEFAULT ASSIGNMENT
         * ==================================================
         */

        this.defaultFlag =
                defaultFlag;

        /**
         * ==================================================
         * INFORMATIONAL UNCERTAINTY ASSIGNMENT
         * ==================================================
         */

        this.missingIncome =
                missingIncome;
    }

    /**
     * ==================================================
     * GETTERS
     * ==================================================
     */

    public String getApplicantIdHash() {

        return applicantIdHash;
    }

    public String getRegion() {

        return region;
    }

    public String getHomeOwnership() {

        return homeOwnership;
    }

    public String getEmailDomainType() {

        return emailDomainType;
    }

    public String getBranchCodeId() {

        return branchCodeId;
    }

    public Integer getAge() {

        return age;
    }

    public Double getAnnualIncome() {

        return annualIncome;
    }

    public Double getDtiRatio() {

        return dtiRatio;
    }

    public Double getCreditUtilisationPct() {

        return creditUtilisationPct;
    }

    public Integer getNumDelinquencies2yr() {

        return numDelinquencies2yr;
    }

    public Integer getNumHardInquiries6mo() {

        return numHardInquiries6mo;
    }

    public Boolean getDefaultFlag() {

        return defaultFlag;
    }

    /**
     * ==================================================
     * INFORMATIONAL OPACITY GETTER
     * ==================================================
     */

    public Boolean getMissingIncome() {

        return missingIncome;
    }

    /**
     * ==================================================
     * SETTERS
     * ==================================================
     */

    public void setMissingIncome(
            Boolean missingIncome
    ) {

        this.missingIncome =
                missingIncome;
    }

    /**
     * ==================================================
     * EXPLAINABLE STRING REPRESENTATION
     * ==================================================
     */

    @Override
    public String toString() {

        return

                "\n=================================================="

                        +

                        "\nBORROWER PROFILE"

                        +

                        "\n=================================================="

                        +

                        "\nBorrower ID: "
                        + applicantIdHash

                        +

                        "\nRegion: "
                        + region

                        +

                        "\nHome Ownership: "
                        + homeOwnership

                        +

                        "\nAge: "
                        + age

                        +

                        "\nAnnual Income: "
                        + annualIncome

                        +

                        "\nDTI Ratio: "
                        + dtiRatio

                        +

                        "\nCredit Utilisation: "
                        + creditUtilisationPct

                        +

                        "\nDelinquencies: "
                        + numDelinquencies2yr

                        +

                        "\nHard Inquiries: "
                        + numHardInquiries6mo

                        +

                        "\nDefault Flag: "
                        + defaultFlag

                        +

                        "\nMissing Income: "
                        + missingIncome;
    }
}