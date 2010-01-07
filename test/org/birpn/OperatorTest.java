/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.birpn.BIRPN.*;
import java.math.BigInteger;
import java.util.List;

/**
 *
 * @author Gronau
 */
public class OperatorTest {

    @Test
    public void abs() {
        assertEquals(BigInteger.valueOf(0), _(0, ABS));
        assertEquals(BigInteger.valueOf(42), _(42, ABS));
        assertEquals(BigInteger.valueOf(42), _(-42, ABS));
        assertEquals(BigInteger.valueOf(0), _("0 abs"));
        assertEquals(BigInteger.valueOf(42), _("42 abs"));
        assertEquals(BigInteger.valueOf(42), _("-42 abs"));
    }

    @Test
    public void and() {
        assertEquals(BigInteger.valueOf(0), _(7, 8, AND));
        assertEquals(BigInteger.valueOf(2), _(7, 10, AND));
        assertEquals(BigInteger.valueOf(6404), _(7493, 6534, AND));
        assertEquals(BigInteger.valueOf(0), _("7 8 &"));
        assertEquals(BigInteger.valueOf(2), _("7 10 &"));
        assertEquals(BigInteger.valueOf(6404), _("7493 6534 &"));
    }

    @Test
    public void andBool() {
        assertEquals(true, is(TRUE, TRUE, AND));
        assertEquals(false, is(TRUE, FALSE, AND));
        assertEquals(false, is(FALSE, TRUE, AND));
        assertEquals(false, is(FALSE, FALSE, AND));
        assertEquals(true, is("true true &"));
        assertEquals(false, is("true false &"));
        assertEquals(false, is("false true &"));
        assertEquals(false, is("false false &"));
    }

    @Test(expected = ArithmeticException.class)
    public void andMixed() {
        _(7, TRUE, AND);
    }

    @Test
    public void andNot() {
        assertEquals(BigInteger.valueOf(7), _(7, 8, ANDNOT));
        assertEquals(BigInteger.valueOf(5), _(7, 10, ANDNOT));
        assertEquals(BigInteger.valueOf(1089), _(7493, 6534, ANDNOT));
        assertEquals(BigInteger.valueOf(7), _("7 8 &~"));
        assertEquals(BigInteger.valueOf(5), _("7 10 &~"));
        assertEquals(BigInteger.valueOf(1089), _("7493 6534 &~"));
    }

    public void andNotBool() {
        assertEquals(false, is(TRUE, TRUE, ANDNOT));
        assertEquals(true, is(TRUE, FALSE, ANDNOT));
        assertEquals(false, is(FALSE, TRUE, ANDNOT));
        assertEquals(false, is(FALSE, FALSE, ANDNOT));
        assertEquals(false, is("true true &~"));
        assertEquals(true, is("true false &~"));
        assertEquals(false, is("false true &~"));
        assertEquals(false, is("false false &~"));
    }

    @Test(expected = ArithmeticException.class)
    public void andNotMixed() {
        _(7, TRUE, ANDNOT);
    }
    
    @Test
    public void bitCount() {
        assertEquals(BigInteger.valueOf(3), _(7, BITCOUNT));
        assertEquals(BigInteger.valueOf(7), _(7493, BITCOUNT));
        assertEquals(BigInteger.valueOf(6), _(-7493, BITCOUNT));
        assertEquals(BigInteger.valueOf(3), _("7 bitCount"));
        assertEquals(BigInteger.valueOf(7), _("7493 bitCount"));
        assertEquals(BigInteger.valueOf(6), _("-7493 bitCount"));
    }

    @Test
    public void bitLength() {
        assertEquals(BigInteger.valueOf(3), _(7, BITLENGTH));
        assertEquals(BigInteger.valueOf(13), _(7493, BITLENGTH));
        assertEquals(BigInteger.valueOf(13), _(-7493, BITLENGTH));
        assertEquals(BigInteger.valueOf(3), _("7 bitLength"));
        assertEquals(BigInteger.valueOf(13), _("7493 bitLength"));
        assertEquals(BigInteger.valueOf(13), _("-7493 bitLength"));
    }

    @Test
    public void clearBit() {
        assertEquals(BigInteger.valueOf(3), _(7, 2, CLEARBIT));
        assertEquals(BigInteger.valueOf(7), _(7, 7, CLEARBIT));
        assertEquals(BigInteger.valueOf(7489), _(7493, 2, CLEARBIT));
        assertEquals(BigInteger.valueOf(3), _("7 2 clearBit"));
        assertEquals(BigInteger.valueOf(7), _("7 7 clearBit"));
        assertEquals(BigInteger.valueOf(7489), _("7493 2 clearBit"));
    }

    @Test
    public void dec() {
        assertEquals(BigInteger.valueOf(-1), _(0, DEC));
        assertEquals(BigInteger.valueOf(6), _(7, DEC));
        assertEquals(BigInteger.valueOf(7492), _(7493, DEC));
        assertEquals(BigInteger.valueOf(-1), _("0 --"));
        assertEquals(BigInteger.valueOf(6), _("7 --"));
        assertEquals(BigInteger.valueOf(7492), _("7493 --"));
    }

    @Test
    public void div() {
        assertEquals(BigInteger.valueOf(-1), _(1, -1, DIV));
        assertEquals(BigInteger.valueOf(2), _(-15, -7, DIV));
        assertEquals(BigInteger.valueOf(11468), _(74937493, 6534, DIV));
        assertEquals(BigInteger.valueOf(-1), _("1 -1 /"));
        assertEquals(BigInteger.valueOf(2), _("-15 -7 /"));
        assertEquals(BigInteger.valueOf(11468), _("74937493 6534 /"));
    }

    @Test
    public void divMod() {
        List<BigInteger> list = results(49, 10, DIVMOD);
        assertEquals(BigInteger.valueOf(4), list.get(0));
        assertEquals(BigInteger.valueOf(9), list.get(1));

        assertEquals(BigInteger.valueOf(5887), _(74937493, 6534, DIVMOD, MINUS));
        assertEquals(BigInteger.valueOf(5887), _("74937493 6534 /% -"));
    }

    @Test
    public void dup() {
        assertEquals(BigInteger.valueOf(49), _(7, DUP, TIMES));
        assertEquals(BigInteger.valueOf(49), _("7 dup *"));
    }

    @Test
    public void equals() {
        assertEquals(TRUE, _(7, 7, EQ));
        assertEquals(FALSE, _(7, 8, EQ));
        assertEquals(TRUE, _("7 7 =="));
        assertEquals(FALSE, _("7 8 =="));
    }

    @Test
    public void factorial() {
        BigInteger f100 = new BigInteger(
                "9332621544394415268169923885626670049071596826438162146859296389"
                + "5217599993229915608941463976156518286253697920827223758251185210"
                + "916864000000000000000000000000");
        assertEquals(BigInteger.valueOf(1), _(0, FACTORIAL));
        assertEquals(BigInteger.valueOf(1), _(1, FACTORIAL));
        assertEquals(BigInteger.valueOf(120), _(5, FACTORIAL));
        assertEquals(f100, _(100, FACTORIAL));
        assertEquals(BigInteger.valueOf(1), _("0 !"));
        assertEquals(BigInteger.valueOf(1), _("1 !"));
        assertEquals(BigInteger.valueOf(120), _("5 !"));
        assertEquals(f100, _("100 !"));
    }

    @Test(expected = ArithmeticException.class)
    public void negativeFactorial() {
        _(-1, FACTORIAL);
    }

    @Test
    public void fib() {
        assertEquals(BigInteger.valueOf(0), _(0, FIB));
        assertEquals(BigInteger.valueOf(1), _(1, FIB));
        assertEquals(BigInteger.valueOf(39088169), _(38, FIB));
        assertEquals(BigInteger.valueOf(0), _("0 fib"));
        assertEquals(BigInteger.valueOf(1), _("1 fib"));
        assertEquals(BigInteger.valueOf(39088169), _("38 fib"));
    }

    @Test(expected = ArithmeticException.class)
    public void negativeFib() {
        _(-1, FIB);
    }
}
