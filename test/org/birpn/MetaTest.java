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
import java.util.EmptyStackException;
import java.util.List;
import junit.framework.JUnit4TestAdapter;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class MetaTest {

    @Test
    public void applyleft() {
        List<BigInteger> list = results(7, 8, 9, 20, applyLeft(MINUS));
        assertEquals(3, list.size());
        assertEquals(BigInteger.valueOf(13), list.get(0));
        assertEquals(BigInteger.valueOf(12), list.get(1));
        assertEquals(BigInteger.valueOf(11), list.get(2));

        List<BigInteger> list1 = results("7 8 9 20 applyLeft:-");
        assertEquals(3, list1.size());
        assertEquals(BigInteger.valueOf(13), list1.get(0));
        assertEquals(BigInteger.valueOf(12), list1.get(1));
        assertEquals(BigInteger.valueOf(11), list1.get(2));

        List<BigInteger> list2 = results("20 applyLeft:-");
        assertEquals(0, list2.size());
    }

    @Test(expected = EmptyStackException.class)
    public void applyleftEx() {
        results("applyLeft:-");
    }

    @Test
    public void applyright() {
        List<BigInteger> list = results(7, 8, 9, 5, applyRight(MINUS));
        assertEquals(3, list.size());
        assertEquals(BigInteger.valueOf(2), list.get(0));
        assertEquals(BigInteger.valueOf(3), list.get(1));
        assertEquals(BigInteger.valueOf(4), list.get(2));

        List<BigInteger> list1 = results("7 8 9 5 applyRight:-");
        assertEquals(3, list1.size());
        assertEquals(BigInteger.valueOf(2), list1.get(0));
        assertEquals(BigInteger.valueOf(3), list1.get(1));
        assertEquals(BigInteger.valueOf(4), list1.get(2));
        
        List<BigInteger> list2 = results("20 applyRight:-");
        assertEquals(0, list2.size());
    }

    @Test(expected = EmptyStackException.class)
    public void applyrightEx() {
        results("applyRight:-");
    }

    @Test
    public void filterTest() {
        List<BigInteger> list = results(10, 20, RANGE, filter(ISPRIME));
        assertEquals(4, list.size());
        assertEquals(BigInteger.valueOf(11), list.get(0));
        assertEquals(BigInteger.valueOf(13), list.get(1));
        assertEquals(BigInteger.valueOf(17), list.get(2));
        assertEquals(BigInteger.valueOf(19), list.get(3));

        List<BigInteger> list1 = results("10 20 .. filter:isprime");
        assertEquals(4, list1.size());
        assertEquals(BigInteger.valueOf(11), list1.get(0));
        assertEquals(BigInteger.valueOf(13), list1.get(1));
        assertEquals(BigInteger.valueOf(17), list1.get(2));
        assertEquals(BigInteger.valueOf(19), list1.get(3));

        List<BigInteger> list2 = results("filter:isprime");
        assertEquals(0, list2.size());
    }

    @Test
    public void filternot() {
        List<BigInteger> list = results(10, 15, RANGE, filterNot(ISPRIME));
        assertEquals(4, list.size());
        assertEquals(BigInteger.valueOf(10), list.get(0));
        assertEquals(BigInteger.valueOf(12), list.get(1));
        assertEquals(BigInteger.valueOf(14), list.get(2));
        assertEquals(BigInteger.valueOf(15), list.get(3));

        List<BigInteger> list1 = results("10 15 .. filterNot:isprime");
        assertEquals(4, list1.size());
        assertEquals(BigInteger.valueOf(10), list1.get(0));
        assertEquals(BigInteger.valueOf(12), list1.get(1));
        assertEquals(BigInteger.valueOf(14), list1.get(2));
        assertEquals(BigInteger.valueOf(15), list1.get(3));

        List<BigInteger> list2 = results("filterNot:isprime");
        assertEquals(0, list2.size());
    }

    @Test
    public void foldTest() {
        assertEquals(BigInteger.valueOf(10000), _(11000, 1100, 110, 11, 1, fold(MINUS)));
        assertEquals(BigInteger.valueOf(10000), _("11000 1100 110 11 1 fold:-"));
        assertEquals(BigInteger.valueOf(42), _("42 fold:-"));
    }

    @Test
    public void foreachTest() {
        List<BigInteger> list = results(6, 7, 8, 9, foreach(SQUARE));
        assertEquals(4, list.size());
        assertEquals(BigInteger.valueOf(36), list.get(0));
        assertEquals(BigInteger.valueOf(49), list.get(1));
        assertEquals(BigInteger.valueOf(64), list.get(2));
        assertEquals(BigInteger.valueOf(81), list.get(3));

        List<BigInteger> list1 = results("6 7 8 9 foreach:\u00b2");
        assertEquals(4, list1.size());
        assertEquals(BigInteger.valueOf(36), list1.get(0));
        assertEquals(BigInteger.valueOf(49), list1.get(1));
        assertEquals(BigInteger.valueOf(64), list1.get(2));
        assertEquals(BigInteger.valueOf(81), list1.get(3));

        List<BigInteger> list2 = results(foreach(SQUARE));
        assertEquals(0, list2.size());
    }

    public static junit.framework.Test suite() {
        return new JUnit4TestAdapter(MetaTest.class);
    }
}
