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
public class ForEach extends Op {

  private final Function1 fn;

  public ForEach(Op fn) {
    this.fn = (Function1) fn;
  }

  public void eval(Stack<BigInteger> input) {
    Stack<BigInteger> temp = new Stack<BigInteger>();
    while(! input.isEmpty()) {
      fn.eval(input);
      temp.push(input.pop());
    }
    while(! temp.isEmpty()) {
      input.push(temp.pop());
    }
  }

  public String toString() {
    return "foreach:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new ForEach(op);
      }
      @Override public String toString() {
        return "foreach";
      }
    };
  }
}
