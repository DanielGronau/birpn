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
 * This class is based on code form Peter Luschny,
 * see http://www.luschny.de/math/factorial/index.html --> Factorial Swing
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Factorial extends Function1 {

    private BigInteger factorial(int n) {
        if (n < 0) {
            throw new ArithmeticException("Factorial: n has to be >= 0, but was " + n);
        }
        //ndivArray[0] = ndiv4OddFact, ndivArray[1] = ndiv2OddFact
        BigInteger[] ndivArray = {BigInteger.ONE, BigInteger.ONE};
        return oddFactorial(n, ndivArray).shiftLeft(n - Integer.bitCount(n));
    }

    private BigInteger oddFactorial(int n, BigInteger[] ndivArray) {
        BigInteger oddFact = (n < 17)
                ? BigInteger.valueOf(smallOddFactorial[n])
                : oddFactorial(n / 2, ndivArray).pow(2).multiply(oddSwing(n, ndivArray[0]));
        ndivArray[0] = ndivArray[1];
        ndivArray[1] = oddFact;
        return oddFact;
    }

    private BigInteger oddSwing(int n, BigInteger ndiv4OddFact) {
        if (n < 33) {
            return BigInteger.valueOf(smallOddSwing[n]);
        }
        int len = (n - 1) / 4;
        if ((n % 4) != 2) {
            len++;
        }
        int high = n - ((n + 1) & 1);
        int ndiv4 = n / 4;
        BigInteger oddFact = ndiv4 < 17
                ? BigInteger.valueOf(smallOddFactorial[ndiv4])
                : ndiv4OddFact;
        return product(high, len).divide(oddFact);
    }

    private static BigInteger product(int m, int len) {
        switch (len) {
            case 1:
                return BigInteger.valueOf(m);
            case 2:
                return BigInteger.valueOf((long) m * (m - 2));
            default:
                int hlen = len >>> 1;
                return product(m - hlen * 2, len - hlen).multiply(product(m, hlen));
        }
    }
    private static int[] smallOddSwing = {1, 1, 1, 3, 3, 15, 5, 35, 35, 315, 63,
        693, 231, 3003, 429, 6435, 6435, 109395, 12155, 230945, 46189, 969969,
        88179, 2028117, 676039, 16900975, 1300075, 35102025, 5014575, 145422675,
        9694845, 300540195, 300540195};
    private static int[] smallOddFactorial = {1, 1, 1, 3, 3, 15, 45, 315, 315,
        2835, 14175, 155925, 467775, 6081075, 42567525, 638512875, 638512875};

    @Override
    public BigInteger calc(BigInteger x) {
        return factorial(x.intValue());
    }

    @Override
    public String toString() {
        return "!";
    }
}
