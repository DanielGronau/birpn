/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops;

import java.math.BigInteger;
import java.util.Stack;

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

}
