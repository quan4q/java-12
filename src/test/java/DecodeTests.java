import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class DecodeTests {
    @Test
    void Integer_Decimal_Decode(){
        assertEquals(33, Integer.decode("33"));
    }

    @Test
    void Integer_Oct_Decode(){
        assertEquals(33, Integer.decode("041"));
    }

    @Test
    void Integer_Hex_Decode(){
        assertEquals(33, Integer.decode("0x21"));
        assertEquals(33, Integer.decode("#21"));
        assertEquals(33, Integer.decode("0X21"));
    }

    @Test
    void Integer_Decode_Negative_Sign(){
        assertEquals(-33, Integer.decode("-33"));
        assertEquals(-33, Integer.decode("-041"));
        assertEquals(-33, Integer.decode("-0x21"));
    }

    @Test
    void Integer_Decode_Positive_Sign(){
        assertEquals(21, Integer.decode("+21"));
        assertEquals(16, Integer.decode("+020"));
        assertEquals(202, Integer.decode("+0xCA"));
    }

    @Test
    void Integer_Decode_InvalidFormat(){
        assertThrows(NumberFormatException.class, () -> Integer.decode("23+1"));
        assertThrows(NumberFormatException.class, () -> Integer.decode("number"));
        assertThrows(NumberFormatException.class, () -> Integer.decode(""));
        assertThrows(NumberFormatException.class, () -> Integer.decode("2-31"));
    }

    @Test
    void Integer_Decode_NullPointer(){
        assertThrows(NullPointerException.class, () -> Integer.decode(null));
    }

    @Test
    void Integer_Decode_BigValue(){
        assertThrows(NumberFormatException.class, () -> Integer.decode("1000000000000000000000"));
    }
}
