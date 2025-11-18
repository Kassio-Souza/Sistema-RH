package org.apache.pdfbox.pdmodel;

import java.io.Closeable;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.font.PDFont;

/**
 * Lightweight content stream that forwards written text to the owning document
 * as plain text. Drawing operations are no-ops but retained for API
 * compatibility with PdfWriter.
 */
public class PDPageContentStream implements Closeable {
    private final PDDocument document;
    private PDFont currentFont;

    public PDPageContentStream(PDDocument document, PDPage page) {
        this.document = document;
    }

    public void beginText() {
        // no-op for stub
    }

    public void setFont(PDFont font, float size) {
        this.currentFont = font;
    }

    public void newLineAtOffset(float x, float y) {
        // no-op for stub
    }

    public void showText(String text) throws IOException {
        document.appendText(text);
    }

    public void endText() {
        // no-op for stub
    }

    public void setLineWidth(float width) {
        // no drawing support in stub
    }

    public void addRect(float x, float y, float width, float height) {
        // drawing ignored in stub implementation
    }

    public void stroke() {
        // drawing ignored in stub implementation
    }

    @Override
    public void close() throws IOException {
        // nothing to close
    }
}
