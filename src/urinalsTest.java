import org.junit.jupiter.api.Assertions;

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



}