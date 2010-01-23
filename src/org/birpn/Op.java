/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn;

import java.math.BigInteger;
import java.util.Stack;
import static org.birpn.BIRPN.TRUE;
import static org.birpn.BIRPN.FALSE;

/**
 *
 * @author Gronau
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
