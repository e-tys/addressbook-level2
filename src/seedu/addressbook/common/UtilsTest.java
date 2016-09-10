package seedu.addressbook.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
    
    public ArrayList<Integer> testList;
    public String[] testList2;
    
    @Before
    public void setup(){
        testList = new ArrayList<Integer>();
    }
    
    @Test
    public void checkNull_ShouldReturnTrue(){
        assertEquals(true, Utils.isAnyNull("Item1", "Item2", null));
    }
    
    @Test
    public void checkNull_shouldReturnFalse(){
        assertEquals(false, Utils.isAnyNull("Item1", "Item2", "Item3"));
    }
   
    @Test
    public void checkUniqueElements_shouldReturnTrue(){
        testList.add(1);
        testList.add(2);
        testList.add(3);
    
        assertEquals(true, Utils.elementsAreUnique(testList));
    }

    @Test
    public void checkUniqueElements_shouldReturnFalse(){
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(4);
        
        assertEquals(false, Utils.elementsAreUnique(testList));
    }
}
