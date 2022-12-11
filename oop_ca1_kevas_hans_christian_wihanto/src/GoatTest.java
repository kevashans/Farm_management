import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GoatTest {
    Goat g1 = new Goat("name");
    @Test
    void setUdderCap() {
        g1.setUdderCap(10);
        int expRes = 10;
        int actRes = g1.getUdderCap();
        assertEquals(expRes,actRes);
    }
    @Test
    void setUdderCap2() {
        g1.setUdderCap(-1);
        int expRes = 0;
        int actRes = g1.getUdderCap();
        assertEquals(expRes,actRes);
    }
}