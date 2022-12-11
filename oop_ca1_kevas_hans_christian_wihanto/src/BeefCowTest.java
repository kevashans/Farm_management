import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeefCowTest {

    BeefCow bc = new BeefCow(12,11,"xxx");
    @Test
    void setAge() {
        bc.setAge(-1);
        int expres = 0;
        int actres = bc.getAge();
        assertEquals(expres,actres);
    }
    @Test
    void setAge2() {
        bc.setAge(11);
        int expres = 11;
        int actres = bc.getAge();
        assertEquals(expres,actres);
    }
}