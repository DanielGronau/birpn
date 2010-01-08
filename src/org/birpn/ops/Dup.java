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
public class Dup extends Op {

    public void eval(Stack<BigInteger> input) {
        input.push(input.peek());
    }

    @Override public String toString() {
        return "dup";
    }
}
