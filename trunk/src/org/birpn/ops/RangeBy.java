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
public class RangeBy extends Op {

    @Override
    public void eval(Stack<BigInteger> input) {
        BigInteger delta = input.pop();
        BigInteger toInt = input.pop();
        BigInteger fromInt = input.pop();
        if(delta.equals(BigInteger.ZERO)) {
            throw new ArithmeticException("Step size can't be zero.");
        }
        if(delta.signum() != toInt.compareTo(fromInt)) {
            throw new ArithmeticException("Step size has the wrong sign.");
        }
        for(BigInteger i = fromInt; i.compareTo(toInt) < 1; i.add(delta)) {
            input.push(i);
        }
    }

    @Override
    public String toString() {
        return "...";
    }

}