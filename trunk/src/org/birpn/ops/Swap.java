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
public class Swap implements Op {
    public void eval(Stack<BigInteger> input) {
        BigInteger a = input.pop();
        BigInteger b = input.pop();
        input.push(a);
        input.push(b);
    }
    @Override public String toString() {
        return "swap";
    }
}
