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
public class DivMod implements Op {

  public void eval(Stack<BigInteger> input) {
      BigInteger a = input.pop();
      BigInteger b = input.pop();
      BigInteger[] result = b.divideAndRemainder(a);
      input.push(result[0]);
      input.push(result[1]);
   }

    @Override public String toString() {
        return "/%";
    }
}