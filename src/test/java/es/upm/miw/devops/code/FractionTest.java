package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void testDefaultConstructor() {
        Fraction f = new Fraction();
        assertEquals(1, f.getNumerator());
        assertEquals(1, f.getDenominator());
    }

    @Test
    void testParameterizedConstructor() {
        Fraction f = new Fraction(3, 4);
        assertEquals(3, f.getNumerator());
        assertEquals(4, f.getDenominator());
    }

    @Test
    void testSetters() {
        Fraction f = new Fraction();
        f.setNumerator(5);
        f.setDenominator(6);
        assertEquals(5, f.getNumerator());
        assertEquals(6, f.getDenominator());
    }

    @Test
    void testDecimal() {
        Fraction f = new Fraction(1, 2);
        assertEquals(0.5, f.decimal(), 1e-10);
    }

    @Test
    void testToString() {
        Fraction f = new Fraction(2, 3);
        assertEquals("Fraction{numerator=2, denominator=3}", f.toString());
    }
}
//1