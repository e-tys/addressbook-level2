package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.Person;

public class Tagging {
    
    public static enum Action {
        ADD, REMOVE
    }
    
    public static final String ADD_ACTION = "+";
    public static final String DELETE_ACTION = "-";
    
    private Action action;
    private Person person;
    private Tag tag;
    
    public Tagging(Action action, Person person, Tag tag) {
        this.action = action;
        this.person  = person;
        this.tag = tag;
    }
    
    /**
     * Change the tag status when the person is removed
     */
    public void changeTagStatus() {
        this.action = (this.action == Action.ADD) ? Action.REMOVE : Action.ADD; 
    }
    
    public Tag getTag() {
        return this.tag;
    }
    
    public Person getPerson() {
        return this.person;
    }
    
    @Override
    public String toString() {
        return (this.action == Action.ADD) ? ADD_ACTION : DELETE_ACTION + " " + this.person.getName() + " " + this.tag;
    }
}
