/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops;

import java.math.BigInteger;
import java.util.Stack;

public class ApplyRight extends Op {

  private final Function2 fn;

  public ApplyRight(Op fn) {
    this.fn = (Function2) fn;
  }

  public void eval(Stack<BigInteger> input) {
    Stack<BigInteger> temp = new Stack<BigInteger>();
    BigInteger rightOperand = input.pop();
    while(! input.isEmpty()) {
      temp.push(input.pop());
    }
    while(! temp.isEmpty()) {
      input.push(temp.pop());
      input.push(rightOperand);
      fn.eval(input);
    }
  }

  public String toString() {
    return "applyright:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new ApplyRight(op);
      }
      @Override public String toString() {
        return "applyright";
      }
    };
  }
}
