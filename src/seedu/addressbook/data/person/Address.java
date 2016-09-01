package seedu.addressbook.data.person;

import javax.swing.plaf.SliderUI;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {
	public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in the following format: a/BLOCK, STREET, UNIT, POSTAL_CODE";
    public static final String ADDRESS_VALIDATION_REGEX = "[\\d]+([A-Z])?, .+, #[\\d]{1,2}-[\\d]{2,3}, [\\d]{6}";

    public final String value;
    private boolean isPrivate;
    
    private String[] splittedAddress;
    private Block block;
    private Street street;
    private Unit unit;
    private PostalCode postalCode;

    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        this.isPrivate = isPrivate;
        if (!isValidAddress(address)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        this.value = address;
        
        //Split user-entered address
        address.replace("/a","");
        splittedAddress = address.split(", ");
        
        //Create new Block object
        this.block = new Block(splittedAddress[0]);
        
        //Create new Street object 
        this.street = new Street(splittedAddress[1]);
        
        //Create new Unit object
        this.unit = new Unit(splittedAddress[2]);
        
        //Create new PostalCode object
        this.postalCode = new PostalCode(splittedAddress[3]);
    }

    /**
     * Returns true if a given string is a valid person email.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(ADDRESS_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return block.getBlock() + ", " + street.getStreet() + ", " + unit.getUnit() + ", " + postalCode.getPostalCode() ;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
        		&& this.block.equals(((Address) other).block))
                && this.street.equals(((Address) other).street)
				&& this.unit.equals(((Address) other).unit)
				&& this.postalCode.equals(((Address) other).postalCode);// state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}

class Block{
	private String block;
	
	public Block(String block){
		this.block = block;
	}
	
	public String getBlock(){
		return block;
	}
	
	public void setBlock(String newBlock){
		this.block = newBlock;
	}

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
        		&& this.block == (((Block) other).block));// state check
    }
}

class Street {
	private String street;
	
	public Street(String street){
		this.street = street;
	}
	
	public String getStreet(){
		return street;
	}
	
	public void setStreet(String newStreet){
		this.street = newStreet;
	}
	
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Street // instanceof handles nulls
                && this.street == (((Street) other).street));// state check
    }
}

class Unit {
	private String unit;
	
	public Unit(String unit) {
		this.unit = unit;
	}
	
	public String getUnit(){
		return unit;
	}
	
	public void setUnit(String newUnit){
		unit = newUnit;
	}
    
	@Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Unit // instanceof handles nulls
				&& this.unit == (((Unit) other).unit));// state check
    }
}

class PostalCode {
	private String postalCode;
	
	public PostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
	public String getPostalCode(){
		return postalCode;
	}
	
	public void setPostalCode(String postalCode){
		this.postalCode = postalCode;
	}
	
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PostalCode // instanceof handles nulls
				&& this.postalCode == (((PostalCode) other).postalCode));// state check
    }
}