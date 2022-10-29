import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class urinalsTest {

    @org.junit.jupiter.api.Test
    void getUrinals(){
        assertEquals(0, urinals.getUrinals("1"));
        assertEquals(1, urinals.getUrinals("0"));
        assertEquals(0, urinals.getUrinals("10"));
        assertEquals(0, urinals.getUrinals("1001"));
        assertEquals(3, urinals.getUrinals("00000"));
        assertEquals(-1, urinals.getUrinals("110"));
        assertEquals(-1,urinals.getUrinals("101100001"));
        System.out.println("====== Varun Menon == TEST ONE EXECUTED =======");
    }



    @Test
    void validateStrChars() {

        assertEquals(true, urinals.validate("101"));
        assertEquals(true, urinals.validate("1001"));
        assertEquals(true, urinals.validate("0"));
        assertEquals(true, urinals.validate("0100"));
        assertEquals(true, urinals.validate("10"));
        assertEquals(true, urinals.validate("10000"));
        assertEquals(false, urinals.validate("1234"));
        assertEquals(false, urinals.validate("!@#$"));
        assertEquals(false, urinals.validate("01101101@#$"));
        assertEquals(false, urinals.validate("abcd"));
        System.out.println("====== Varun Menon == TEST TWO EXECUTED =======");
    }


    @Test
    void validateStrLen() {

        assertEquals(true, urinals.validate("101"));
        assertEquals(true, urinals.validate("1001"));
        assertEquals(true, urinals.validate("0"));
        assertEquals(true, urinals.validate("0100"));
        assertEquals(true, urinals.validate("10"));
        assertEquals(true, urinals.validate("10000"));
        assertEquals(false, urinals.validate(""));
        assertEquals(false, urinals.validate("10001010100001001000000010100000100"));
        System.out.println("====== Varun Menon == TEST THREE EXECUTED =======");
    }


    @Test
    void validateConsecutive1s() {

        assertEquals(true, urinals.validate("101"));
        assertEquals(true, urinals.validate("1001"));
        assertEquals(true, urinals.validate("0"));
        assertEquals(true, urinals.validate("0100"));
        assertEquals(true, urinals.validate("10"));
        assertEquals(true, urinals.validate("10000"));
        assertEquals(false, urinals.validate("11"));
        assertEquals(false, urinals.validate("10001100110000"));
        assertEquals(false, urinals.validate("100010001011"));
        assertEquals(false, urinals.validate("1011"));
        System.out.println("====== Varun Menon == TEST FOUR EXECUTED =======");
    }


    @Test
    void File() throws Exception {
        assertEquals(" 0 1 0 0 3 -1 -1", urinals.File("src/urinal.dat"));
        System.out.println("====== Varun Menon == TEST FIVE EXECUTED =======");

    }
}