/**
 * RawRecord
 *
 * Purpose:
 * Represents a completely raw borrower record
 * exactly as received from the CSV dataset.
 *
 * This class is part of:
 * - the Extract phase,
 * - and raw behavioural preservation layer
 * of the BCIP hybrid ELT architecture.
 *
 * IMPORTANT:
 * - No parsing
 * - No validation
 * - No cleaning
 * - No business logic
 *
 * All fields remain Strings because:
 * CSV files are raw text sources.
 */
public class RawRecord {

    /**
     * Unique anonymised borrower identifier.
     */
    private String applicantIdHash;

    /**
     * Raw borrower age value.
     */
    private String age;

    /**
     * Raw annual income value.
     */
    private String annualIncome;

    /**
     * Raw employment length value.
     */
    private String employmentLengthYears;

    /**
     * Raw home ownership category.
     */
    private String homeOwnership;

    /**
     * Raw borrower region.
     */
    private String region;

    /**
     * Raw number of open accounts.
     */
    private String numOpenAccounts;

    /**
     * Raw delinquency count.
     */
    private String numDelinquencies2yr;

    /**
     * Raw revolving balance.
     */
    private String totalRevolvingBalance;

    /**
     * Raw credit utilisation percentage.
     */
    private String creditUtilisationPct;

    /**
     * Raw account age metric.
     */
    private String monthsSinceOldestAccount;

    /**
     * Raw inquiry count.
     */
    private String numHardInquiries6mo;

    /**
     * Raw loan amount.
     */
    private String loanAmount;

    /**
     * Raw interest rate.
     */
    private String interestRate;

    /**
     * Raw loan purpose category.
     */
    private String loanPurpose;

    /**
     * Raw debt-to-income ratio.
     */
    private String dtiRatio;

    /**
     * Raw delinquency recency metric.
     */
    private String monthsSinceLastDelinquency;

    /**
     * Raw current account percentage.
     */
    private String pctAccountsCurrent;

    /**
     * Raw application date.
     */
    private String applicationDate;

    /**
     * Raw day-of-week value.
     */
    private String applicationDow;

    /**
     * Raw branch identifier.
     */
    private String branchCodeId;

    /**
     * Raw address stability metric.
     */
    private String monthsAtCurrentAddress;

    /**
     * Raw email domain category.
     */
    private String emailDomainType;

    /**
     * Raw phone verification value.
     */
    private String phoneVerified;

    /**
     * Raw default target variable.
     */
    private String defaultFlag;

    /**
     * Raw dataset split category.
     */
    private String datasetSplit;

    /**
     * Full constructor.
     *
     * Stores all raw CSV values exactly as received.
     */
    public RawRecord(
            String applicantIdHash,
            String age,
            String annualIncome,
            String employmentLengthYears,
            String homeOwnership,
            String region,
            String numOpenAccounts,
            String numDelinquencies2yr,
            String totalRevolvingBalance,
            String creditUtilisationPct,
            String monthsSinceOldestAccount,
            String numHardInquiries6mo,
            String loanAmount,
            String interestRate,
            String loanPurpose,
            String dtiRatio,
            String monthsSinceLastDelinquency,
            String pctAccountsCurrent,
            String applicationDate,
            String applicationDow,
            String branchCodeId,
            String monthsAtCurrentAddress,
            String emailDomainType,
            String phoneVerified,
            String defaultFlag,
            String datasetSplit
    ) {

        this.applicantIdHash = applicantIdHash;
        this.age = age;
        this.annualIncome = annualIncome;
        this.employmentLengthYears = employmentLengthYears;
        this.homeOwnership = homeOwnership;
        this.region = region;
        this.numOpenAccounts = numOpenAccounts;
        this.numDelinquencies2yr = numDelinquencies2yr;
        this.totalRevolvingBalance = totalRevolvingBalance;
        this.creditUtilisationPct = creditUtilisationPct;
        this.monthsSinceOldestAccount = monthsSinceOldestAccount;
        this.numHardInquiries6mo = numHardInquiries6mo;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
        this.loanPurpose = loanPurpose;
        this.dtiRatio = dtiRatio;
        this.monthsSinceLastDelinquency = monthsSinceLastDelinquency;
        this.pctAccountsCurrent = pctAccountsCurrent;
        this.applicationDate = applicationDate;
        this.applicationDow = applicationDow;
        this.branchCodeId = branchCodeId;
        this.monthsAtCurrentAddress = monthsAtCurrentAddress;
        this.emailDomainType = emailDomainType;
        this.phoneVerified = phoneVerified;
        this.defaultFlag = defaultFlag;
        this.datasetSplit = datasetSplit;
    }

    /**
     * Getter methods.
     */

    public String getApplicantIdHash() {
        return applicantIdHash;
    }

    public String getAge() {
        return age;
    }

    public String getAnnualIncome() {
        return annualIncome;
    }

    public String getEmploymentLengthYears() {
        return employmentLengthYears;
    }

    public String getHomeOwnership() {
        return homeOwnership;
    }

    public String getRegion() {
        return region;
    }

    public String getNumOpenAccounts() {
        return numOpenAccounts;
    }

    public String getNumDelinquencies2yr() {
        return numDelinquencies2yr;
    }

    public String getTotalRevolvingBalance() {
        return totalRevolvingBalance;
    }

    public String getCreditUtilisationPct() {
        return creditUtilisationPct;
    }

    public String getMonthsSinceOldestAccount() {
        return monthsSinceOldestAccount;
    }

    public String getNumHardInquiries6mo() {
        return numHardInquiries6mo;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public String getInterestRate() {
        return interestRate;
    }

    public String getLoanPurpose() {
        return loanPurpose;
    }

    public String getDtiRatio() {
        return dtiRatio;
    }

    public String getMonthsSinceLastDelinquency() {
        return monthsSinceLastDelinquency;
    }

    public String getPctAccountsCurrent() {
        return pctAccountsCurrent;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public String getApplicationDow() {
        return applicationDow;
    }

    public String getBranchCodeId() {
        return branchCodeId;
    }

    public String getMonthsAtCurrentAddress() {
        return monthsAtCurrentAddress;
    }

    public String getEmailDomainType() {
        return emailDomainType;
    }

    public String getPhoneVerified() {
        return phoneVerified;
    }

    public String getDefaultFlag() {
        return defaultFlag;
    }

    public String getDatasetSplit() {
        return datasetSplit;
    }


    /**
     * toString()
     *
     * Returns formatted readable RawRecord output.
     *
     * Useful for:
     * - debugging
     * - ingestion verification
     * - logging
     * - pipeline observability
     */
    @Override
    public String toString() {

        return String.format( """
                ID: %s | Age: %s | Income: %s | Employment Length: %s |
                Home Ownership: %s | Region: %s | Open Accounts: %s |
                Delinquencies: %s | Revolving Balance: %s |
                Utilisation: %s | Oldest Account Months: %s |
                Inquiries: %s | Loan Amount: %s | Interest Rate: %s |
                Loan Purpose: %s | DTI Ratio: %s |
                Months Since Delinquency: %s |
                Accounts Current: %s | Application Date: %s |
                Application DOW: %s | Branch Code: %s |
                Months At Address: %s | Email Domain: %s |
                Phone Verified: %s | Default Flag: %s |
                Dataset Split: %s
                """,

                applicantIdHash,
                age,
                annualIncome,
                employmentLengthYears,
                homeOwnership,
                region,
                numOpenAccounts,
                numDelinquencies2yr,
                totalRevolvingBalance,
                creditUtilisationPct,
                monthsSinceOldestAccount,
                numHardInquiries6mo,
                loanAmount,
                interestRate,
                loanPurpose,
                dtiRatio,
                monthsSinceLastDelinquency,
                pctAccountsCurrent,
                applicationDate,
                applicationDow,
                branchCodeId,
                monthsAtCurrentAddress,
                emailDomainType,
                phoneVerified,
                defaultFlag,
                datasetSplit
        );
    }
}