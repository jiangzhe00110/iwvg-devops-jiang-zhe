package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;


public class UsersDatabaseTest {

    // 在类里面先声明并初始化 db
    private final UsersDatabase db = new UsersDatabase();

    @Test
    void testSearch0_findUserFamilyNameInitialBySomeProperFraction() {
        List<String> initials = db.findUserFamilyNameInitialBySomeProperFraction().sorted().toList();
        assertEquals(List.of("B", "F", "L"), initials);
    }

    @Test
    void testSearch9_findHighestFraction() {
        Fraction highest = db.findHighestFraction();
        assertNotNull(highest);
        assertEquals(2, highest.getNumerator());
        assertEquals(1, highest.getDenominator()); // 最高是 2/1
    }

}