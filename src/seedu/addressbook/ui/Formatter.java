package seedu.addressbook.ui;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Format message(s) to be shown to the user */
    public String formatMessage(String... message) {
        final StringBuilder formatted = new StringBuilder();
        for (String m : message) {
            formatted.append(LINE_PREFIX).append(m.replace("\n", LS + LINE_PREFIX)).append("\n");
        }
        return formatted.toString();
    }

}
