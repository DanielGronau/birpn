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
package org.birpn.examples;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import static org.birpn.BIRPN.*;

/**
 * Calculates the Ackermann Function.
 * (see <a href="http://en.wikipedia.org/wiki/Ackermann_function">Wikipedia: 
 * Ackermann Function</a>)
 * Note that this is a very fast growing function, so you probably won't be able
 * to compute ack(4,2) or higher.
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Ackermann {

    private static BigInteger ack(BigInteger n, BigInteger m) {
        if (n.equals(BigInteger.ZERO)) {
            return m.add(BigInteger.ONE);
        } else {
            return ack(n.subtract(BigInteger.ONE), m.equals(BigInteger.ZERO)
                    ? BigInteger.ONE : ack(n, m.subtract(BigInteger.ONE)));
        }
    }


    private static BigInteger ackBIRPN(BigInteger n, BigInteger m) {
        if (is(n, 0, EQ)) {
            return _(m, INC);
        } else {
            return ackBIRPN(_(n, DEC), is(m, 0, EQ) ? _(1) : ackBIRPN(n, _(m, DEC)));
        }
    }

    public static void main(String... args) {
        System.out.println("Ackermann Function");
        System.out.println("Conventional BigInteger Arithmetic Results:");
        System.out.println("ack(3,8) " + ack(BigInteger.valueOf(3), BigInteger.valueOf(8)));
        System.out.println("BIRPN Operator Style Results:");
        System.out.println("ack(3,8) " + ackBIRPN(_(3), _(8)));
    }
}
