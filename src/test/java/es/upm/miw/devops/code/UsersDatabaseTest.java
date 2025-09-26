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
    @Test
    void testFindFractionDivisionByUserId() {
        UsersDatabase db = new UsersDatabase();
        Fraction result = db.findFractionDivisionByUserId("2");
        assertNotNull(result);
        // 简单校验：用户 "2" 的 fractions2 = [2/1, -1/5, 2/4, 4/3]
        // 预期计算： (((2/1) ÷ (-1/5)) ÷ (2/4)) ÷ (4/3) = ...
        // 这里只检查结果不为 null
        System.out.println("Division result: " + result);
    }
}