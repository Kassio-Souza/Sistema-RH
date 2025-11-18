package org.apache.pdfbox.pdmodel.common;

/**
 * Minimal rectangle representation used by the PdfBox stubs.
 */
public class PDRectangle {
    private final float width;
    private final float height;

    public PDRectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
