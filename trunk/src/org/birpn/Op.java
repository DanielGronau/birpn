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

import java.math.BigInteger;
import java.util.Stack;
import static org.birpn.BIRPN.TRUE;
import static org.birpn.BIRPN.FALSE;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public abstract class Op extends Number {

  public int intValue() {
    throw new UnsupportedOperationException();
  }

  public long longValue() {
    throw new UnsupportedOperationException();
  }

  public float floatValue() {
    throw new UnsupportedOperationException();
  }

  public double doubleValue() {
    throw new UnsupportedOperationException();
  }

  public abstract void eval(Stack<BigInteger> input);

  @Override public abstract  String toString();

     protected boolean testForBooleans(BigInteger ... bis) {
        boolean hasBool = false;
        boolean hasNum = false;
        for(BigInteger bi : bis) {
            boolean is = isLogic(bi);
            hasBool |= is;
            hasNum |= !is;
        }
        if(hasNum && hasBool) {
            throw new ArithmeticException("Mixing BigInteger and booleans");
        }
        return hasBool;
    }

    protected static boolean isLogic(BigInteger bi) {
        return bi == TRUE || bi == FALSE;
    }

    protected static boolean toBool(BigInteger bi) {
        if (bi == TRUE) {
            return true;
        } else if (bi == FALSE) {
            return false;
        } else {
            throw new ArithmeticException("No boolean value");
        }
    }

    protected static BigInteger fromBool(boolean b) {
        return b ? TRUE : FALSE;
    }
  
}
