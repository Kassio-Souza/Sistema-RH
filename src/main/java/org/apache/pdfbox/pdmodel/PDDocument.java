package org.apache.pdfbox.pdmodel;

import java.io.Closeable;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simplified PDDocument that collects text output and writes a plain-text file
 * instead of a binary PDF. This keeps export features working in restricted
 * environments without external libraries.
 */
public class PDDocument implements Closeable {
    private final List<PDPage> pages = new ArrayList<>();
    private final StringBuilder exportedText = new StringBuilder();

    public void addPage(PDPage page) {
        pages.add(page);
    }

    void appendText(String text) {
        exportedText.append(text).append(System.lineSeparator());
    }

    public void save(String filename) throws IOException {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(exportedText.toString());
        }
    }

    @Override
    public void close() {
        // Nothing to free in the stub implementation
    }
}
