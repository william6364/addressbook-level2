package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable;
 */
public class Contact {
    public final String value;
    protected boolean isPrivate;

    public Contact(String contact, boolean isPrivate) {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        this.value = trimmedContact;
    }
}
