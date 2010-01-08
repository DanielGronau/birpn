package org.birpn.ops;

import java.util.Stack;
import java.math.BigInteger;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Fold extends Op {

  private final Function2 fn;

  public Fold(Op fn) {
    this.fn = (Function2) fn;
  }

  public void eval(Stack<BigInteger> input) {
    while (input.size() > 1) {
      fn.eval(input);
    }
  }

  @Override public String toString() {
    return "fold" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new Fold(op);
      }
      @Override public String toString() {
        return "fold";
      }
    };
  }
}
