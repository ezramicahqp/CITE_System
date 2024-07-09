
package DbCITESystemUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FilterLetter extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) {
            return;
        }
        if (isOnlyLetters(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }
        if (isOnlyLetters(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isOnlyLetters(String text) {
        return text.chars().allMatch(Character::isLetter);
    }
}
