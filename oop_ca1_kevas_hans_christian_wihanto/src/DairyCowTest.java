import static org.junit.jupiter.api.Assertions.*;

class DairyCowTest {


    @org.junit.jupiter.api.Test
    void setUdderCap() {
        DairyCow d1= new DairyCow("name");
        d1.setUdderCap(20);
        int expRes= 20;
        int actRes = d1.getUdderCap();
        assertEquals(expRes,actRes);
    }
    @org.junit.jupiter.api.Test
    void setUdderCap2() {
        DairyCow d1= new DairyCow("name");
        d1.setUdderCap(45);
        int expRes= 40;
        int actRes = d1.getUdderCap();
        assertEquals(expRes,actRes);
    }
    @org.junit.jupiter.api.Test
    void setUdderCap3() {
        DairyCow d1= new DairyCow("name");
        d1.setUdderCap(-1);
        int expRes= 0;
        int actRes = d1.getUdderCap();
        assertEquals(expRes,actRes);
    }
}