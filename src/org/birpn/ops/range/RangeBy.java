/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn.ops.range;

import org.birpn.Op;
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
        if (toInt.equals(fromInt)) {
            input.push(fromInt);
        } else {
            if (delta.signum() != toInt.compareTo(fromInt)) {
                throw new ArithmeticException("Step size has the wrong sign.");
            }
            for (BigInteger i = fromInt; i.compareTo(toInt) != delta.signum(); i = i.add(delta)) {
                input.push(i);
            }
        }
    }

    @Override
    public String toString() {
        return "...";
    }
}
