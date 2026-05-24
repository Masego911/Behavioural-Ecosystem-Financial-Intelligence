/**
 * BorrowerValidator
 *
 * Responsible ONLY for:
 * - validating parsed borrower data,
 * - enforcing financial sanity checks,
 * - distinguishing invalidity from uncertainty,
 * - and preserving behaviourally meaningful missingness.
 *
 * IMPORTANT:
 * - No parsing
 * - No SQL
 * - No CSV ingestion
 * - No graph logic
 * - No ML logic
 *
 * Research Alignment:
 * Modern behavioural credit modelling systems
 * distinguish:
 *
 * 1. invalid financial data
 * from
 * 2. informational uncertainty.
 *
 * Therefore:
 * some missing values are preserved intentionally
 * because they may contain behavioural meaning.
 *
 * Single Responsibility:
 * Behavioural financial validation.
 */
public class BorrowerValidator {

    /**
     * ==================================================
     * AGE VALIDATION
     * ==================================================
     */

    /**
     * isValidAge()
     *
     * Validates borrower age.
     *
     * IMPORTANT:
     * Age is considered:
     * structurally mandatory.
     *
     * Missing age prevents:
     * - demographic interpretation,
     * - lifecycle modelling,
     * - and age-based behavioural analysis.
     *
     * Rules:
     * - cannot be null
     * - must be >= 18
     * - must be <= 100
     *
     * @param age
     * Parsed borrower age.
     *
     * @return
     * true if valid
     * false otherwise.
     */
    public static boolean isValidAge(
            Integer age
    ) {

        /**
         * Null age is structurally invalid.
         */
        if (age == null) {

            return false;
        }

        /**
         * Financial age boundaries.
         */
        return age >= 18
                &&
                age <= 100;
    }

    /**
     * ==================================================
     * INCOME VALIDATION
     * ==================================================
     */

    /**
     * isValidIncome()
     *
     * IMPORTANT CONCEPT:
     * Missing income is NOT automatically:
     * invalid borrower data.
     *
     * Research Interpretation:
     * Missing income may indicate:
     * - thin-file borrowers,
     * - informal economy participation,
     * - institutional invisibility,
     * - behavioural opacity,
     * - or elevated uncertainty.
     *
     * Therefore:
     * missing income is preserved intentionally.
     *
     * ONLY:
     * structurally impossible income values
     * are rejected.
     *
     * Rules:
     * - null income allowed
     * - negative income invalid
     *
     * @param income
     * Parsed annual income.
     *
     * @return
     * true if behaviourally acceptable
     * false if structurally invalid.
     */
    public static boolean isValidIncome(
            Double income
    ) {

        /**
         * ==================================================
         * PRESERVE INFORMATIONAL UNCERTAINTY
         * ==================================================
         *
         * IMPORTANT:
         * Missingness itself may become:
         * - predictive,
         * - anomalous,
         * - or behaviourally informative.
         */
        if (income == null) {

            return true;
        }

        /**
         * Negative income is structurally invalid.
         */
        return income >= 0;
    }

    /**
     * ==================================================
     * CREDIT UTILISATION VALIDATION
     * ==================================================
     */

    /**
     * isValidCreditUtilisation()
     *
     * Behavioural Interpretation:
     * Very high utilisation may indicate:
     * - financial stress,
     * - overextension,
     * - or aggressive borrowing.
     *
     * IMPORTANT:
     * Extreme values may still contain:
     * behavioural meaning.
     *
     * Therefore:
     * validator should allow:
     * behavioural extremes,
     * while rejecting impossible values.
     *
     * Rules:
     * - cannot be null
     * - must be between 0 and 100
     *
     * @param utilisation
     * Parsed utilisation ratio.
     *
     * @return
     * true if valid
     * false otherwise.
     */
    public static boolean isValidCreditUtilisation(
            Double utilisation
    ) {

        /**
         * Missing utilisation prevents:
         * financial behaviour interpretation.
         */
        if (utilisation == null) {

            return false;
        }

        /**
         * Preserve behavioural extremes
         * while rejecting impossible values.
         */
        return utilisation >= 0
                &&
                utilisation <= 100;
    }

    /**
     * ==================================================
     * DTI VALIDATION
     * ==================================================
     */

    /**
     * isValidDTI()
     *
     * Behavioural Interpretation:
     * High DTI may indicate:
     * - repayment strain,
     * - financial overextension,
     * - or elevated default exposure.
     *
     * IMPORTANT:
     * Extreme DTI values may still
     * contain behavioural meaning.
     *
     * Rules:
     * - cannot be null
     * - must be between 0 and 5
     *
     * @param dti
     * Parsed debt-to-income ratio.
     *
     * @return
     * true if valid
     * false otherwise.
     */
    public static boolean isValidDTI(
            Double dti
    ) {

        /**
         * Missing DTI prevents:
         * debt burden interpretation.
         */
        if (dti == null) {

            return false;
        }

        /**
         * Preserve behavioural extremes
         * while rejecting impossible values.
         */
        return dti >= 0
                &&
                dti <= 5;
    }

    /**
     * ==================================================
     * HARD INQUIRY VALIDATION
     * ==================================================
     */

    /**
     * isValidInquiryCount()
     *
     * Behavioural Interpretation:
     * High inquiry frequency may indicate:
     * - financial desperation,
     * - aggressive credit seeking,
     * - or liquidity stress.
     *
     * Rules:
     * - cannot be null
     * - must be between 0 and 50
     *
     * @param inquiries
     * Parsed inquiry count.
     *
     * @return
     * true if valid
     * false otherwise.
     */
    public static boolean isValidInquiryCount(
            Integer inquiries
    ) {

        /**
         * Missing inquiry history prevents:
         * credit-seeking interpretation.
         */
        if (inquiries == null) {

            return false;
        }

        /**
         * Preserve behavioural extremes
         * while rejecting impossible values.
         */
        return inquiries >= 0
                &&
                inquiries <= 50;
    }

    /**
     * ==================================================
     * DELINQUENCY VALIDATION
     * ==================================================
     */

    /**
     * isValidDelinquencyCount()
     *
     * Behavioural Interpretation:
     * Historical delinquency frequency
     * represents repayment instability.
     *
     * Rules:
     * - cannot be null
     * - must be between 0 and 100
     *
     * @param delinquencies
     * Parsed delinquency count.
     *
     * @return
     * true if valid
     * false otherwise.
     */
    public static boolean isValidDelinquencyCount(
            Integer delinquencies
    ) {

        /**
         * Missing delinquency history prevents:
         * repayment behaviour interpretation.
         */
        if (delinquencies == null) {

            return false;
        }

        /**
         * Preserve behavioural extremes
         * while rejecting impossible values.
         */
        return delinquencies >= 0
                &&
                delinquencies <= 100;
    }
}