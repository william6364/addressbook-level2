package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidContact(String, String)}
 */
public class Contact {

    public final String value;
    protected boolean isPrivate;

    /**
     * Validates given contact.
     *
     * @throws IllegalValueException if given contact string is invalid.
     */
    public Contact(String contact, boolean isPrivate, String regex, String constraints) throws IllegalValueException {
        this.isPrivate = isPrivate;
        String trimmedContact = contact.trim();
        if(!isValidContact(trimmedContact, regex)){
            throw new IllegalValueException(constraints);
        }
        this.value = trimmedContact;
    }

    /**
     * Returns true if the given string is a valid person contact.
     */
    public static boolean isValidContact(String test, String regex) {
        return test.matches(regex);
    }

    @Override
    public String toString() {
        return value;
    }


    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
