/**
 * DataParser
 *
 * Responsible ONLY for:
 * - safe datatype conversion,
 * - null handling,
 * - and defensive parsing.
 *
 * IMPORTANT:
 * - No validation
 * - No SQL
 * - No ingestion
 * - No business rules
 *
 * Single Responsibility:
 * Structured datatype transformation.
 */
public class DataParser {

    /**parseIntegerSafe() --> Safely converts String → Integer and Returns:
     * - parsed Integer
     * OR
     * - null if parsing fails.
     *
     * @param value
     * Raw String value.
     *
     * @return
     * Parsed Integer or null.
     */
    public static Integer parseIntegerSafe(
            String value
    ) {

        try {

            /**
             * Defensive null protection.
             */
            if (
                    value == null
                            || value.trim().isEmpty()
                            || value.equalsIgnoreCase("null")
            ) {

                return null;
            }

            /**
             * Parse decimal-formatted numeric values.
             *
             * Example:
             * "35.5" -> 35
             * "25.0" -> 25
             */
            Double parsedDouble =
                    Double.parseDouble(
                            value.trim()
                    );

            /**
             * Convert decimal number
             * into integer representation.
             */
            return parsedDouble.intValue();

        }

        catch (Exception exception) {

            return null;
        }
    }

    /**
     * parseDoubleSafe()
     *
     * Safely converts String → Double.
     *
     * @param value
     * Raw String value.
     *
     * @return
     * Parsed Double or null.
     */
    public static Double parseDoubleSafe(String value) {


        if (value == null) {

            return null;
        }

        value = value.trim();


        if (value.isEmpty()) {

            return null;
        }

        try {

            return Double.parseDouble(value);

        } catch (NumberFormatException exception) {

            return null;
        }
    }

    /**
     * parseBooleanSafe()
     *
     * Safely converts String → Boolean.
     *
     * Handles:
     * - true/false
     * - yes/no
     * - 1/0
     *
     * @param value
     * Raw String value.
     *
     * @return
     * Parsed Boolean or null.
     */
    public static Boolean parseBooleanSafe(String value) {

        if (value == null) {

            return null;
        }

        value = value.trim().toLowerCase();

        if (value.isEmpty()) {

            return null;
        }

        //TRUE conditions.
        if (value.equals("true") || value.equals("yes") || value.equals("1")) {

            return true;
        }

        //FALSE conditions.

        if (value.equals("false") || value.equals("no") || value.equals("0")) {

            return false;
        }

        //Unknown boolean format.
        return null;
    }

    /**
     * normalizeString()
     *
     * Cleans textual categorical values.
     *
     * Removes:
     * - surrounding whitespace
     * - inconsistent casing
     *
     * @param value
     * Raw String value.
     *
     * @return
     * Cleaned String or null.
     */
    public static String normalizeString(String value) {


        if (value == null) {

            return null;
        }

        value = value.trim();

        if (value.isEmpty()) {

            return null;
        }


        return value.toUpperCase();
    }
}