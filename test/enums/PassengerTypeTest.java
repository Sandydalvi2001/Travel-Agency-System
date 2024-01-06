package test.enums;

import enums.PassengerType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTypeTest {

    @Test
    public void testPassengerTypeValues() {
        assertEquals(PassengerType.STANDARD, PassengerType.valueOf("STANDARD"));
        assertEquals(PassengerType.GOLD, PassengerType.valueOf("GOLD"));
        assertEquals(PassengerType.PREMIUM, PassengerType.valueOf("PREMIUM"));
    }
}