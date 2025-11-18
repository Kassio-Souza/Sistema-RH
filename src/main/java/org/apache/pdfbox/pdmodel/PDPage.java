package org.apache.pdfbox.pdmodel;

import org.apache.pdfbox.pdmodel.common.PDRectangle;

/**
 * Minimal PDPage stub storing media box dimensions.
 */
public class PDPage {
    private PDRectangle mediaBox = new PDRectangle(595, 842); // default A4-ish

    public PDRectangle getMediaBox() {
        return mediaBox;
    }

    public void setMediaBox(PDRectangle mediaBox) {
        this.mediaBox = mediaBox;
    }
}
