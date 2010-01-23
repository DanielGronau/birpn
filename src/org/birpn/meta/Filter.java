/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.meta;

import org.birpn.Meta;
import org.birpn.Function1;
import org.birpn.Op;
import java.math.BigInteger;
import java.util.Stack;

public class Filter extends Op {

  private final Function1 fn;

  public Filter(Op fn) {
    this.fn = (Function1) fn;
  }

  public void eval(Stack<BigInteger> input) {
    Stack<BigInteger> temp = new Stack<BigInteger>();
    while(! input.isEmpty()) {
        BigInteger value = input.peek();
        fn.eval(input);
        if (toBool(input.pop())) {
          temp.push(value);
        }
    }
    while(! temp.isEmpty()) {
      input.push(temp.pop());
    }
  }

  public String toString() {
    return "filter:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new Filter(op);
      }
      @Override public String toString() {
        return "filter";
      }
    };
  }
}
