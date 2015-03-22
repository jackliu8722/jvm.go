package java7.reflection;

import java.lang.reflect.Array;
import libs.junit.UnitTestRunner;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArraySetTest {

    public static void main(String[] args) {
        UnitTestRunner.run(ArraySetTest.class);
    }

    @Test
    public void setNullArray() {
        try {
            Object x = null;
            Array.set(x, 3, "a");
            fail();
        } catch (NullPointerException e) {
            assertNull(e.getMessage());
        }
    }
    
    @Test
    public void setNonArray() {
        try {
            String str = "abc";
            Array.set(str, 1, "a");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Argument is not an array", e.getMessage());
        }
    }
    
    @Test
    public void setArrayBadIndex() {
        try {
            int[] arr = {1, 2, 3};
            Array.set(arr, -1, 4);
            fail();
        } catch (ArrayIndexOutOfBoundsException e) {
            assertEquals(null, e.getMessage());
        }
    }
    
    @Test
    public void setObjectArray() {
        String[] arr = {"beyond"};
        Array.set(arr, 0, "5457");
        assertEquals("5457", Array.get(arr, 0));
    }

    @Test
    public void setPrimitiveArray() {
        int[] arr = {5, 4, 5, 7};
        Array.set(arr, 0, 0);
        assertEquals(0, Array.get(arr, 0));

        //Array.set(arr, 0, "beyond");
    }

}
