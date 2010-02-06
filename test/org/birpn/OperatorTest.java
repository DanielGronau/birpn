/* This file is part of BIRPN.
 *
 * BIRPN is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * BIRPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public
 * License along with BIRPN.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.birpn;

import org.junit.Test;
import static org.junit.Assert.*;

import static org.birpn.BIRPN.*;
import java.math.BigInteger;
import java.util.List;
import junit.framework.JUnit4TestAdapter;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
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
    public void cube() {
        assertEquals(BigInteger.valueOf(125), _(5, CUBE));
        assertEquals(BigInteger.valueOf(-125), _(-5, CUBE));
        assertEquals(BigInteger.valueOf(0), _(0, CUBE));
        assertEquals(BigInteger.valueOf(125), _("5 \u00b3"));
        assertEquals(BigInteger.valueOf(-125), _("-5 \u00b3"));
        assertEquals(BigInteger.valueOf(0), _("0 \u00b3"));
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
        List<BigInteger> list1 = results("49 10 /%");
        assertEquals(BigInteger.valueOf(4), list.get(0));
        assertEquals(BigInteger.valueOf(9), list.get(1));
    }

    @Test
    public void dup() {
        List<BigInteger> list = results(10, DUP);
        assertEquals(2, list.size());
        assertEquals(BigInteger.valueOf(10), list.get(0));
        assertEquals(BigInteger.valueOf(10), list.get(1));
        List<BigInteger> list1 = results("42 dup");
        assertEquals(2, list1.size());
        assertEquals(BigInteger.valueOf(42), list1.get(0));
        assertEquals(BigInteger.valueOf(42), list1.get(1));
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

    @Test
    public void filpBit() {
        assertEquals(BigInteger.valueOf(3), _(7, 2, FLIPBIT));
        assertEquals(BigInteger.valueOf(7), _(3, 2, FLIPBIT));
        assertEquals(BigInteger.valueOf(7489), _(7493, 2, FLIPBIT));
        assertEquals(BigInteger.valueOf(3), _("7 2 flipBit"));
        assertEquals(BigInteger.valueOf(7), _("3 2 flipBit"));
        assertEquals(BigInteger.valueOf(7489), _("7493 2 flipBit"));
    }

    @Test
    public void fromBool() {
        assertEquals(BigInteger.valueOf(0), _(FALSE, FROMBOOL));
        assertEquals(BigInteger.valueOf(1), _(TRUE, FROMBOOL));
        assertEquals(BigInteger.valueOf(0), _("false frombool"));
        assertEquals(BigInteger.valueOf(1), _("true frombool"));
    }

    @Test(expected = ArithmeticException.class)
    public void fromBoolEx() {
        _(3, FROMBOOL);
    }

    @Test
    public void gcd() {
        assertEquals(BigInteger.valueOf(13), _(1001, 169, GCD));
        assertEquals(BigInteger.valueOf(13), _(-1001, 169, GCD));
        assertEquals(BigInteger.valueOf(1), _(65537, 257, GCD));
        assertEquals(BigInteger.valueOf(13), _("1001 169 gcd"));
        assertEquals(BigInteger.valueOf(13), _("-1001 169 gcd"));
        assertEquals(BigInteger.valueOf(1), _("65537 257 gcd"));
    }

    @Test
    public void greaterEqual() {
        assertEquals(true, is(1001, 1000, GE));
        assertEquals(true, is(1000, 1000, GE));
        assertEquals(false, is(999, 1000, GE));
        assertEquals(true, is("1001 1000 >="));
        assertEquals(true, is("1000 1000 >="));
        assertEquals(false, is("999 1000 >="));
    }

    @Test
    public void greater() {
        assertEquals(true, is(1001, 1000, GT));
        assertEquals(false, is(1000, 1000, GT));
        assertEquals(false, is(999, 1000, GT));
        assertEquals(true, is("1001 1000 >"));
        assertEquals(false, is("1000 1000 >"));
        assertEquals(false, is("999 1000 >"));
    }

    @Test
    public void ifOperation() {
        assertEquals(BigInteger.valueOf(42), _(TRUE, 42, 55, IF));
        assertEquals(BigInteger.valueOf(55), _(FALSE, 42, 55, IF));
        assertEquals(false, is(TRUE, FALSE, TRUE, IF));
        assertEquals(BigInteger.valueOf(42), _("true 42 55 if"));
        assertEquals(BigInteger.valueOf(55), _("false 42 55 if"));
        assertEquals(false, is("true false true if"));
    }

    @Test
    public void inc() {
        assertEquals(BigInteger.valueOf(13), _(12, INC));
        assertEquals(BigInteger.valueOf(0), _(-1, INC));
        assertEquals(BigInteger.valueOf(-13), _(-14, INC));
        assertEquals(BigInteger.valueOf(13), _("12 ++"));
        assertEquals(BigInteger.valueOf(0), _("-1 ++"));
        assertEquals(BigInteger.valueOf(-13), _("-14 ++"));
    }

    @Test
    public void isPrime() {
        assertEquals(false, is(1001, ISPRIME));
        assertEquals(true, is(104729, ISPRIME));
        assertEquals(false, is(-1047292, ISPRIME));
        assertEquals(false, is("1001 isprime"));
        assertEquals(true, is("104729 isprime"));
        assertEquals(false, is("-1047292 isprime"));
    }

    @Test
    public void isProbablePrime() {
        assertEquals(false, is(1001, 5, ISPROBABLEPRIME));
        assertEquals(true, is(104729, 10, ISPROBABLEPRIME));
        assertEquals(false, is(-1047292, 5, ISPROBABLEPRIME));
        assertEquals(false, is("1001 5 isprobableprime"));
        assertEquals(true, is("104729 10 isprobableprime"));
        assertEquals(false, is("-1047292 5 isprobableprime"));
    }

    @Test
    public void isSquare() {
        assertEquals(false, is(168, ISSQUARE));
        assertEquals(true, is(169, ISSQUARE));
        assertEquals(false, is(-171, ISSQUARE));
        assertEquals(false, is(15241578750190520L, ISSQUARE));
        assertEquals(true, is(15241578750190521L, ISSQUARE));
        assertEquals(false, is(15241578750190522L, ISSQUARE));
        assertEquals(false, is("168 issquare"));
        assertEquals(true, is("169 issquare"));
        assertEquals(false, is("-171 issquare"));
    }

    @Test
    public void isqrt() {
        assertEquals(BigInteger.valueOf(12), _(168, ISQRT));
        assertEquals(BigInteger.valueOf(13), _(169, ISQRT));
        assertEquals(BigInteger.valueOf(13), _(195, ISQRT));
        assertEquals(BigInteger.valueOf(123456788), _(15241578750190520L, ISQRT));
        assertEquals(BigInteger.valueOf(123456789), _(15241578750190521L, ISQRT));
        assertEquals(BigInteger.valueOf(123456789), _(15241578750190529L, ISQRT));
        assertEquals(BigInteger.valueOf(12), _("168 isqrt"));
        assertEquals(BigInteger.valueOf(13), _("169 isqrt"));
        assertEquals(BigInteger.valueOf(13), _("195 isqrt"));
    }

    @Test(expected = ArithmeticException.class)
    public void isqrtEx() {
        _(-10, ISQRT);
    }

    @Test
    public void lessOrEqual() {
        assertEquals(false, is(1001, 1000, LE));
        assertEquals(true, is(1000, 1000, LE));
        assertEquals(true, is(999, 1000, LE));
        assertEquals(false, is("1001 1000 <="));
        assertEquals(true, is("1000 1000 <="));
        assertEquals(true, is("999 1000 <="));
    }

    @Test
    public void less() {
        assertEquals(false, is(1001, 1000, LT));
        assertEquals(false, is(1000, 1000, LT));
        assertEquals(true, is(999, 1000, LT));
        assertEquals(false, is("1001 1000 <"));
        assertEquals(false, is("1000 1000 <"));
        assertEquals(true, is("999 1000 <"));
    }

    @Test
    public void left() {
        assertEquals(BigInteger.valueOf(1), _(3, -1, LEFT));
        assertEquals(BigInteger.valueOf(3), _(3, 0, LEFT));
        assertEquals(BigInteger.valueOf(12), _(3, 2, LEFT));
        assertEquals(BigInteger.valueOf(1), _("3 -1 <<"));
        assertEquals(BigInteger.valueOf(3), _("3 0 <<"));
        assertEquals(BigInteger.valueOf(12), _("3 2 <<"));
    }

    @Test
    public void lowestBit() {
        assertEquals(BigInteger.valueOf(-1), _(0, LOWESTBIT));
        assertEquals(BigInteger.valueOf(0), _(3, LOWESTBIT));
        assertEquals(BigInteger.valueOf(2), _(12, LOWESTBIT));
        assertEquals(BigInteger.valueOf(-1), _("0 lowestBit"));
        assertEquals(BigInteger.valueOf(0), _("3 lowestBit"));
        assertEquals(BigInteger.valueOf(2), _("12 lowestBit"));
    }

    @Test
    public void max() {
        assertEquals(BigInteger.valueOf(-1), _(-1, -100, MAX));
        assertEquals(BigInteger.valueOf(1), _(-100, 1, MAX));
        assertEquals(BigInteger.valueOf(0), _(0, 0, MAX));
        assertEquals(BigInteger.valueOf(-1), _("-1 -100 max"));
        assertEquals(BigInteger.valueOf(1), _("-100 1 max"));
        assertEquals(BigInteger.valueOf(0), _("0 0 max"));
    }

    @Test
    public void min() {
        assertEquals(BigInteger.valueOf(-100), _(-1, -100, MIN));
        assertEquals(BigInteger.valueOf(-100), _(-100, 1, MIN));
        assertEquals(BigInteger.valueOf(0), _(0, 20, MIN));
        assertEquals(BigInteger.valueOf(-100), _("-1 -100 min"));
        assertEquals(BigInteger.valueOf(-100), _("-100 1 min"));
        assertEquals(BigInteger.valueOf(0), _("0 20 min"));
    }

    @Test
    public void minus() {
        assertEquals(BigInteger.valueOf(0), _(-100, -100, MINUS));
        assertEquals(BigInteger.valueOf(-100), _(0, 100, MINUS));
        assertEquals(BigInteger.valueOf(22), _(42, 20, MINUS));
        assertEquals(BigInteger.valueOf(0), _("-100 -100 -"));
        assertEquals(BigInteger.valueOf(-100), _("0 100 -"));
        assertEquals(BigInteger.valueOf(22), _("42 20 -"));
    }

    @Test
    public void mod() {
        assertEquals(BigInteger.valueOf(0), _(-100, 10, MOD));
        assertEquals(BigInteger.valueOf(3), _(13, 5, MOD));
        assertEquals(BigInteger.valueOf(2), _(-13, 5, MOD));
        assertEquals(BigInteger.valueOf(0), _("-100 10 %"));
        assertEquals(BigInteger.valueOf(3), _("13 5 %"));
        assertEquals(BigInteger.valueOf(2), _("-13 5 %"));
    }

    @Test
    public void modInverse() {
        assertEquals(BigInteger.valueOf(2), _(3, 5, MODINVERSE));
        assertEquals(BigInteger.valueOf(3), _(-3, 5, MODINVERSE));
        assertEquals(BigInteger.valueOf(4), _(7, 27, MODINVERSE));
        assertEquals(BigInteger.valueOf(2), _("3 5 modInverse"));
        assertEquals(BigInteger.valueOf(3), _("-3 5 modInverse"));
        assertEquals(BigInteger.valueOf(4), _("7 27 modInverse"));
    }

    @Test(expected = ArithmeticException.class)
    public void modInverseEx() {
        _(12, 4, MODINVERSE);
    }

    @Test(expected = ArithmeticException.class)
    public void modInverseNegativeEx() {
        _(5, -3, MODINVERSE);
    }

    @Test
    public void modPow() {
        assertEquals(BigInteger.valueOf(0), _(10, 5, 10, MODPOW));
        assertEquals(BigInteger.valueOf(1), _(2, 100, 101, MODPOW));
        assertEquals(BigInteger.valueOf(1), _(33, 65536, 65537, MODPOW));
        assertEquals(BigInteger.valueOf(0), _("10 5 10 ^%"));
        assertEquals(BigInteger.valueOf(1), _("2 100 101 ^%"));
        assertEquals(BigInteger.valueOf(1), _("33 65536 65537 ^%"));
    }

    @Test
    public void notEqual() {
        assertEquals(FALSE, _(7, 7, NE));
        assertEquals(TRUE, _(7, 8, NE));
        assertEquals(FALSE, _("7 7 !="));
        assertEquals(TRUE, _("7 8 !="));
    }

    @Test
    public void negate() {
        assertEquals(BigInteger.valueOf(-42), _(42, NEGATE));
        assertEquals(BigInteger.valueOf(0), _(0, NEGATE));
        assertEquals(BigInteger.valueOf(42), _(-42, NEGATE));
        assertEquals(BigInteger.valueOf(-42), _("42 negate"));
        assertEquals(BigInteger.valueOf(0), _("0 negate"));
        assertEquals(BigInteger.valueOf(42), _("-42 negate"));
    }

    @Test
    public void nextPrime() {
        assertEquals(BigInteger.valueOf(2), _(0, NEXTPRIME));
        assertEquals(BigInteger.valueOf(13), _(11, NEXTPRIME));
        assertEquals(BigInteger.valueOf(257), _(256, NEXTPRIME));
        assertEquals(BigInteger.valueOf(2), _("0 nextPrime"));
        assertEquals(BigInteger.valueOf(13), _("11 nextPrime"));
        assertEquals(BigInteger.valueOf(257), _("256 nextPrime"));
    }

    @Test(expected = ArithmeticException.class)
    public void nextPrimeNegativeEx() {
        _(-3, NEXTPRIME);
    }

    @Test
    public void not() {
        assertEquals(FALSE, _(TRUE, NOT));
        assertEquals(TRUE, _(FALSE, NOT));
        assertEquals(FALSE, _("true ~"));
        assertEquals(TRUE, _("false ~"));
    }

    @Test
    public void or() {
        assertEquals(BigInteger.valueOf(15), _(7, 9, OR));
        assertEquals(BigInteger.valueOf(23), _(7, 16, OR));
        assertEquals(BigInteger.valueOf(7623), _(7493, 6534, OR));
        assertEquals(BigInteger.valueOf(15), _("7 9 |"));
        assertEquals(BigInteger.valueOf(23), _("7 16 |"));
        assertEquals(BigInteger.valueOf(7623), _("7493 6534 |"));
    }

    @Test
    public void orBool() {
        assertEquals(true, is(TRUE, TRUE, OR));
        assertEquals(true, is(TRUE, FALSE, OR));
        assertEquals(true, is(FALSE, TRUE, OR));
        assertEquals(false, is(FALSE, FALSE, OR));
        assertEquals(true, is("true true |"));
        assertEquals(true, is("true false |"));
        assertEquals(true, is("false true |"));
        assertEquals(false, is("false false |"));
    }

    @Test
    public void plus() {
        assertEquals(BigInteger.valueOf(0), _(-100, 100, PLUS));
        assertEquals(BigInteger.valueOf(100), _(0, 100, PLUS));
        assertEquals(BigInteger.valueOf(62), _(42, 20, PLUS));
        assertEquals(BigInteger.valueOf(0), _("-100 100 +"));
        assertEquals(BigInteger.valueOf(100), _("0 100 +"));
        assertEquals(BigInteger.valueOf(62), _("42 20 +"));
    }

    @Test
    public void pow() {
        assertEquals(BigInteger.valueOf(0), _(0, 100, POW));
        assertEquals(BigInteger.valueOf(-27), _(-3, 3, POW));
        assertEquals(BigInteger.valueOf(1024), _(4, 5, POW));
        assertEquals(BigInteger.valueOf(0), _("0 100 ^"));
        assertEquals(BigInteger.valueOf(-27), _("-3 3 ^"));
        assertEquals(BigInteger.valueOf(1024), _("4 5 ^"));
    }

    @Test
    public void pimeOfBitLength() {
        BigInteger prime = _(20, PRIMEOFBITLENGTH);
        assertEquals(true, prime.isProbablePrime(5));
        assertEquals(20, prime.bitLength());
        BigInteger prime1 = _("20 primeofbitlength");
        assertEquals(true, prime1.isProbablePrime(5));
        assertEquals(20, prime1.bitLength());
    }

    @Test
    public void range() {
        List<BigInteger> list = results(-1, 1, RANGE);
        assertEquals(3, list.size());
        assertEquals(-1, list.get(0).intValue());
        assertEquals(0, list.get(1).intValue());
        assertEquals(1, list.get(2).intValue());
        List<BigInteger> list1 = results(1, -1, RANGE);
        assertEquals(3, list1.size());
        assertEquals(1, list1.get(0).intValue());
        assertEquals(0, list1.get(1).intValue());
        assertEquals(-1, list1.get(2).intValue());
        List<BigInteger> list2 = results("9 12 ..");
        assertEquals(4, list2.size());
        assertEquals(9, list2.get(0).intValue());
        assertEquals(10, list2.get(1).intValue());
        assertEquals(11, list2.get(2).intValue());
        assertEquals(12, list2.get(3).intValue());
        List<BigInteger> list3 = results("42 42 ..");
        assertEquals(1, list3.size());
        assertEquals(42, list3.get(0).intValue());
    }

    @Test
    public void rangeBy() {
        List<BigInteger> list = results(-10, 10, 10, RANGEBY);
        assertEquals(3, list.size());
        assertEquals(-10, list.get(0).intValue());
        assertEquals(0, list.get(1).intValue());
        assertEquals(10, list.get(2).intValue());
        List<BigInteger> list1 = results(10, -10, -10, RANGEBY);
        assertEquals(list1.toString(), 3, list1.size());
        assertEquals(10, list1.get(0).intValue());
        assertEquals(0, list1.get(1).intValue());
        assertEquals(-10, list1.get(2).intValue());
        List<BigInteger> list2 = results("9 17 3 ...");
        assertEquals(3, list2.size());
        assertEquals(9, list2.get(0).intValue());
        assertEquals(12, list2.get(1).intValue());
        assertEquals(15, list2.get(2).intValue());
        List<BigInteger> list3 = results("42 42 -5 ...");
        assertEquals(1, list3.size());
        assertEquals(42, list3.get(0).intValue());
    }

    @Test(expected = ArithmeticException.class)
    public void rangeByZeroStepEx() {
        results(42, 11, 0, RANGEBY);
    }

    @Test(expected = ArithmeticException.class)
    public void rangeByWrongSignEx() {
        results(42, 11, 5, RANGEBY);
    }

    @Test
    public void remainder() {
        assertEquals(BigInteger.valueOf(0), _(-100, 10, REMAINDER));
        assertEquals(BigInteger.valueOf(3), _(13, 5, REMAINDER));
        assertEquals(BigInteger.valueOf(-3), _(-13, 5, REMAINDER));
        assertEquals(BigInteger.valueOf(3), _(13, -5, REMAINDER));
        assertEquals(BigInteger.valueOf(0), _("-100 10 remainder"));
        assertEquals(BigInteger.valueOf(3), _("13 5 remainder"));
        assertEquals(BigInteger.valueOf(-3), _("-13 5 remainder"));
        assertEquals(BigInteger.valueOf(3), _("13 -5 remainder"));
    }

    @Test
    public void reverse() {
        List<BigInteger> list = results(5, 1, 8, 0, REVERSE);
        assertEquals(4, list.size());
        assertEquals(0, list.get(0).intValue());
        assertEquals(8, list.get(1).intValue());
        assertEquals(1, list.get(2).intValue());
        assertEquals(5, list.get(3).intValue());
        List<BigInteger> list1 = results("5 1 8 0 reverse");
        assertEquals(4, list1.size());
        assertEquals(0, list1.get(0).intValue());
        assertEquals(8, list1.get(1).intValue());
        assertEquals(1, list1.get(2).intValue());
        assertEquals(5, list1.get(3).intValue());
    }

    @Test
    public void right() {
        assertEquals(BigInteger.valueOf(1), _(3, 1, RIGHT));
        assertEquals(BigInteger.valueOf(3), _(3, 0, RIGHT));
        assertEquals(BigInteger.valueOf(12), _(3, -2, RIGHT));
        assertEquals(BigInteger.valueOf(1), _("3 1 >>"));
        assertEquals(BigInteger.valueOf(3), _("3 0 >>"));
        assertEquals(BigInteger.valueOf(12), _("3 -2 >>"));
    }

    @Test
    public void setBit() {
        assertEquals(BigInteger.valueOf(11), _(3, 3, SETBIT));
        assertEquals(BigInteger.valueOf(19), _(17, 1, SETBIT));
        assertEquals(BigInteger.valueOf(32), _(0, 5, SETBIT));
        assertEquals(BigInteger.valueOf(11), _("3 3 setBit"));
        assertEquals(BigInteger.valueOf(19), _("17 1 setBit"));
        assertEquals(BigInteger.valueOf(32), _("0 5 setBit"));
    }

    @Test
    public void shuffle() {
        List<BigInteger> list = results(5, 1, 8, 0, SHUFFLE);
        assertEquals(4, list.size());
        assertEquals(true, list.contains(BigInteger.valueOf(0)));
        assertEquals(true, list.contains(BigInteger.valueOf(1)));
        assertEquals(true, list.contains(BigInteger.valueOf(8)));
        assertEquals(true, list.contains(BigInteger.valueOf(5)));
        List<BigInteger> list1 = results("5 1 8 0 shuffle");
        assertEquals(4, list1.size());
        assertEquals(true, list1.contains(BigInteger.valueOf(0)));
        assertEquals(true, list1.contains(BigInteger.valueOf(1)));
        assertEquals(true, list1.contains(BigInteger.valueOf(8)));
        assertEquals(true, list1.contains(BigInteger.valueOf(5)));
    }

    @Test
    public void signum() {
        assertEquals(BigInteger.valueOf(-1), _(-18, SIGNUM));
        assertEquals(BigInteger.valueOf(0), _(0, SIGNUM));
        assertEquals(BigInteger.valueOf(1), _(42, SIGNUM));
        assertEquals(BigInteger.valueOf(-1), _("-18 signum"));
        assertEquals(BigInteger.valueOf(0), _("0 signum"));
        assertEquals(BigInteger.valueOf(1), _("42 signum"));
    }

    @Test
    public void sort() {
        List<BigInteger> list = results(9, 1, 5, 2, 3, 8, 6, 0, 7, 4, SORT);
        assertEquals(10, list.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, list.get(i).intValue());
        }
        List<BigInteger> list1 = results("9 1 5 2 3 8 6 0 7 4 sort");
        assertEquals(10, list1.size());
        for (int i = 0; i < 10; i++) {
            assertEquals(i, list1.get(i).intValue());
        }
    }

    @Test
    public void square() {
        assertEquals(BigInteger.valueOf(0), _(0, SQUARE));
        assertEquals(BigInteger.valueOf(169), _(-13, SQUARE));
        assertEquals(BigInteger.valueOf(65536), _(256, SQUARE));
        assertEquals(BigInteger.valueOf(0), _("0 \u00b2"));
        assertEquals(BigInteger.valueOf(169), _("-13 \u00b2"));
        assertEquals(BigInteger.valueOf(65536), _("256 \u00b2"));
    }

    @Test
    public void swap() {
        List<BigInteger> list = results(42, 53, SWAP);
        assertEquals(2, list.size());
        assertEquals(53, list.get(0).intValue());
        assertEquals(42, list.get(1).intValue());
        List<BigInteger> list1 = results("TRUE FALSE SWAP");
        assertEquals(2, list1.size());
        assertSame(FALSE, list1.get(0));
        assertSame(TRUE, list1.get(1));
    }

    @Test
    public void testBit() {
        assertEquals(true, is(9, 0, TESTBIT));
        assertEquals(false, is(9, 1, TESTBIT));
        assertEquals(true, is(9, 3, TESTBIT));
        assertEquals(true, is("9 0 testBit"));
        assertEquals(false, is("9 1 testBit"));
        assertEquals(true, is("9 3 testBit"));
    }

    @Test
    public void times() {
        assertEquals(BigInteger.valueOf(0), _(0, 4532, TIMES));
        assertEquals(BigInteger.valueOf(12300), _(-123, -100, TIMES));
        assertEquals(BigInteger.valueOf(65535), _(255, 257, TIMES));
        assertEquals(BigInteger.valueOf(0), _("0 4532 *"));
        assertEquals(BigInteger.valueOf(12300), _("-123 -100 *"));
        assertEquals(BigInteger.valueOf(65535), _("255 257 *"));
    }

    @Test
    public void toBool() {
        assertEquals(true, is(1, TOBOOL));
        assertEquals(true, is(42, TOBOOL));
        assertEquals(false, is(0, TOBOOL));
        assertEquals(true, is("1 toBool"));
        assertEquals(true, is("-42 toBool"));
        assertEquals(false, is("0 toBool"));
    }

    @Test
    public void xor() {
        assertEquals(BigInteger.valueOf(14), _(7, 9, XOR));
        assertEquals(BigInteger.valueOf(0), _(7, 7, XOR));
        assertEquals(BigInteger.valueOf(23), _(7, 16, XOR));
        assertEquals(BigInteger.valueOf(1219), _(7493, 6534, XOR));
        assertEquals(BigInteger.valueOf(14), _("7 9 xor"));
        assertEquals(BigInteger.valueOf(0), _("7 7 xor"));
        assertEquals(BigInteger.valueOf(23), _("7 16 xor"));
        assertEquals(BigInteger.valueOf(1219), _("7493 6534 xor"));
    }

    @Test
    public void xorBool() {
        assertEquals(false, is(TRUE, TRUE, XOR));
        assertEquals(true, is(TRUE, FALSE, XOR));
        assertEquals(true, is(FALSE, TRUE, XOR));
        assertEquals(false, is(FALSE, FALSE, XOR));
        assertEquals(false, is("true true xor"));
        assertEquals(true, is("true false xor"));
        assertEquals(true, is("false true xor"));
        assertEquals(false, is("false false xor"));
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(OperatorTest.class);
    }
}
