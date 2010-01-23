/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.meta;

import org.birpn.Meta;
import org.birpn.Function2;
import org.birpn.Op;
import java.math.BigInteger;
import java.util.Stack;

public class ApplyLeft extends Op {

  private final Function2 fn;

  public ApplyLeft(Op fn) {
    this.fn = (Function2) fn;
  }

  public void eval(Stack<BigInteger> input) {
    Stack<BigInteger> temp = new Stack<BigInteger>();
    BigInteger leftOperand = input.pop();
    while(! input.isEmpty()) {
      temp.push(input.pop());
    }
    while(! temp.isEmpty()) {
      input.push(leftOperand);  
      input.push(temp.pop());
      fn.eval(input);
    }
  }

  public String toString() {
    return "applyleft:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new ApplyLeft(op);
      }
      @Override public String toString() {
        return "applyleft";
      }
    };
  }
}
