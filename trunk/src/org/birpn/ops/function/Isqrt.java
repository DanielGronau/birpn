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
 * This class contains code based on
 * http://lists.apple.com/archives/Java-dev/2004/Dec/msg00302.html
 * (where it is stated that is originates in the mersenne-prime forum)
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Isqrt extends Function1 {

 static BigInteger bigintroot(BigInteger n) {
  int currBit = n.bitLength() / 2;

  BigInteger remainder = n;
  BigInteger currSquared = BigInteger.ZERO.setBit(2*currBit);

  BigInteger temp = BigInteger.ZERO;
  BigInteger toReturn = BigInteger.ZERO;

  BigInteger potentialIncrement;
  do {
   temp = toReturn.setBit(currBit);
   potentialIncrement = currSquared.add(toReturn.shiftLeft(currBit+1));

   int cmp = potentialIncrement.compareTo(remainder);
   if (cmp < 0) {
    toReturn = temp;
    remainder = remainder.subtract(potentialIncrement);
   }
   else if (cmp == 0) {
    return temp;
   }
   currBit--;
   currSquared = currSquared.shiftRight(2);
  } while (currBit >= 0);
  return toReturn;
 }

    @Override
    public BigInteger calc(BigInteger x) {
        if(x.compareTo(BigInteger.ZERO) < 0) {
            throw new ArithmeticException("Square root from negative number");
        }
        return bigintroot(x);
    }

    @Override
    public String toString() {
        return "isqrt";
    }
}
