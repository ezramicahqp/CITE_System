

package DbCITESystemUI;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class FilterNumber extends DocumentFilter {
    @Override
    public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
        if (string == null) {
            return;
        }
        if (isOnlyNumbers(string)) {
            super.insertString(fb, offset, string, attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        if (text == null) {
            return;
        }
        if (isOnlyNumbers(text)) {
            super.replace(fb, offset, length, text, attrs);
        }
    }

    private boolean isOnlyNumbers(String text) {
        return text.chars().allMatch(Character::isDigit);
    }
}
