package org.apache.commons.csv;

/**
 * Minimal CSVFormat stub used to avoid external dependencies in offline builds.
 * Only the features used by the project are implemented.
 */
public class CSVFormat {
    public static final CSVFormat DEFAULT = new CSVFormat();

    public CSVFormat withHeader(String... headers) {
        // Header handling is performed in CSVPrinter; returning this allows chaining.
        return this;
    }
}
