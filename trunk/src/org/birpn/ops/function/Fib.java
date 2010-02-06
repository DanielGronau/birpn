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

package org.birpn.ops.function;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 * This class is based on code from
 * Otto Forster, "Algorithmische Zahlentheorie", ISBN 3-528-06580-X, p. 19
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Fib extends Function1 {

    private static BigInteger fib(BigInteger n) {
        if (n.signum() < 0) {
            throw new ArithmeticException("Argument must be non-negative.");
        }
        if(n.compareTo(BigInteger.ONE) <= 0) {
            return n;
        }
        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.ZERO;
        for(int k = n.bitLength() - 2; k >= 0; k--) {
            BigInteger xx = x.multiply(x);
            x = xx.add(x.multiply(y).shiftLeft(1));
            y = xx.add(y.multiply(y));
            if(n.testBit(k)) {
                BigInteger temp = x;
                x = x.add(y);
                y = temp;
            }
        }
        return x;
    }

    @Override
    public BigInteger calc(BigInteger x) {
        return fib(x);
    }

    @Override
    public String toString() {
        return "fib";
    }
}
