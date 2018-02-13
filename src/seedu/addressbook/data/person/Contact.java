package seedu.addressbook.data.person;

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
