/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.function;

import org.birpn.Function1;
import java.math.BigInteger;

public class Isqrt extends Function1 {

 /* Code taken from
  * http://lists.apple.com/archives/Java-dev/2004/Dec/msg00302.html
  * (where it is stated that is originates in the mersenne-prime forum)
  */
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
    public BigInteger calc(BigInteger... args) {
        if(args[0].compareTo(BigInteger.ZERO) < 0) {
            throw new ArithmeticException("Square root from negative number");
        }
        return bigintroot(args[0]);
    }

    @Override
    public String toString() {
        return "isqrt";
    }
}