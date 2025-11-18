package org.apache.pdfbox.pdmodel.font;

/**
 * Minimal PDType1Font stub that delegates to PDFont behaviour.
 */
public class PDType1Font extends PDFont {
    private final Standard14Fonts.FontName fontName;

    public PDType1Font(Standard14Fonts.FontName fontName) {
        this.fontName = fontName;
    }

    public Standard14Fonts.FontName getFontName() {
        return fontName;
    }
}
