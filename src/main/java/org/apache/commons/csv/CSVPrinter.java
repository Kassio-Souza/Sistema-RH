package org.apache.commons.csv;

import java.io.Closeable;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.StringJoiner;

/**
 * Lightweight CSVPrinter stub that writes comma-separated values using only the
 * standard library. It supports the printRecord(List) method used by the
 * application and flushes output on close.
 */
public class CSVPrinter implements Closeable {
    private final Writer writer;

    public CSVPrinter(Writer writer, CSVFormat format) {
        this.writer = writer;
    }

    public void printRecord(List<String> values) throws IOException {
        StringJoiner joiner = new StringJoiner(",");
        for (String value : values) {
            // Basic escaping for quotes and commas.
            String sanitized = value.replace("\"", "\"\"");
            if (sanitized.contains(",")) {
                sanitized = "\"" + sanitized + "\"";
            }
            joiner.add(sanitized);
        }
        writer.write(joiner.toString());
        writer.write(System.lineSeparator());
    }

    @Override
    public void close() throws IOException {
        writer.flush();
    }
}
