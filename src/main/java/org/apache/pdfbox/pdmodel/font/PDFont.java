package org.apache.pdfbox.pdmodel.font;

/**
 * Simplified PDFont representation returning approximate string widths to keep
 * layout calculations functional in offline environments.
 */
public class PDFont {
    public float getStringWidth(String text) {
        // Approximate width so table sizing continues to behave reasonably.
        return text.length() * 500f;
    }
}
