package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.*;

public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    /** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

    /** Format welcome message to be shown to the user */
    public static String formatWelcomeMessage(String version, String storageFilePath) {
        String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
        return formatMessage(
                DIVIDER,
                DIVIDER,
                MESSAGE_WELCOME,
                version,
                MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
                storageFileInfo,
                DIVIDER);
    }

    /** Format goodbye message to be shown to the user */
    public static String formatGoodbyeMessage() {
        return formatMessage(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
    }

    /** Format initialisation failed message to be shown to the user */
    public static String formatInitFailedMessage() {
        return formatMessage(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
    }

    /** Format message(s) to be shown to the user */
    public static String formatMessage(String... message) {
        final StringBuilder formatted = new StringBuilder();
        for (String m : message) {
            formatted.append(LINE_PREFIX).append(m.replace("\n", LS + LINE_PREFIX)).append("\n");
        }
        return formatted.toString();
    }

}
