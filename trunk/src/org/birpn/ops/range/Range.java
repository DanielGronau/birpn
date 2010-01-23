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
public class Range extends Op {

    @Override
    public void eval(Stack<BigInteger> input) {
        BigInteger toInt = input.pop();
        BigInteger fromInt = input.pop();
        if (fromInt.compareTo(toInt) <= 0) {
            for (BigInteger i = fromInt; i.compareTo(toInt) < 1; i = i.add(BigInteger.ONE)) {
                input.push(i);
            }
        } else {
            for (BigInteger i = fromInt; i.compareTo(toInt) > -1; i = i.subtract(BigInteger.ONE)) {
                input.push(i);
            }
        }
    }

    @Override
    public String toString() {
        return "..";
    }
}
