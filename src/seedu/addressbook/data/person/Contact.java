package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's contact in the address book
 */
public abstract class Contact {
    
    protected final String value;
    protected boolean isPrivate;
    
    public Contact(String contact, boolean isPrivate, String messageConstraints, String validationRegex) throws IllegalValueException {
        this.isPrivate = isPrivate;
        
        contact = contact.trim();
        
        if (!isValidContact(contact, validationRegex)) {
            throw new IllegalValueException(messageConstraints);
        }
        
        this.value = contact;
    }
    
    /**
     * Returns true if a given string is a valid contact type.
     */
    public boolean isValidContact(String testContact, String validationRegex) {
        return testContact.matches(validationRegex);
    }
    
    /**
     * Returns the hash code of value
     */
    public int hashCode(){
        return value.hashCode();
    }
    
    public String toString() {
        return value;
    }
    
    public boolean isPrivate() {
        return isPrivate;
    }
}
