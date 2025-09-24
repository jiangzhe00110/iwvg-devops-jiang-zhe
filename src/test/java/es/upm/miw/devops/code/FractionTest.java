package es.upm.miw.devops.code;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FractionTest {

    @Test
    void testIsProper() {
        Fraction fraction = new Fraction(1, 3);
        assertTrue(fraction.isProper());

        Fraction improper = new Fraction(5, 3);
        assertFalse(improper.isProper());
    }

    @Test
    void testIsImproper() {
        Fraction fraction = new Fraction(5, 3);
        assertTrue(fraction.isImproper());

        Fraction proper = new Fraction(1, 3);
        assertFalse(proper.isImproper());
    }

    @Test
    void testIsEquivalent() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 4);
        Fraction fraction3 = new Fraction(3, 5);

        assertTrue(fraction1.isEquivalent(fraction2));
        assertFalse(fraction1.isEquivalent(fraction3));
    }

    @Test
    void testAdd() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(1, 3);

        Fraction result = fraction1.add(fraction2);
        assertEquals(5, result.getNumerator());
        assertEquals(6, result.getDenominator());
    }

    @Test
    void testMultiply() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(3, 5);

        Fraction result = fraction1.multiply(fraction2);
        assertEquals(6, result.getNumerator());
        assertEquals(15, result.getDenominator());
    }

    @Test
    void testDivide() {
        Fraction fraction1 = new Fraction(2, 3);
        Fraction fraction2 = new Fraction(3, 5);

        Fraction result = fraction1.divide(fraction2);
        assertEquals(10, result.getNumerator());
        assertEquals(9, result.getDenominator());
    }
}

//1