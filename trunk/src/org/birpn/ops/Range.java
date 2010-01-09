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
public class Range extends Op {

    @Override
    public void eval(Stack<BigInteger> input) {
        BigInteger toInt = input.pop();
        BigInteger fromInt = input.pop();
        if(fromInt.equals(toInt)) {
            throw new ArithmeticException("Lower and upper bound of Range are equal.");
        }
        BigInteger delta = fromInt.compareTo(toInt) < 0
                ? BigInteger.ONE : BigInteger.ONE.negate();
        for(BigInteger i = fromInt; i.compareTo(toInt) < 1; i = i.add(delta)) {
            input.push(i);
        }
    }

    @Override
    public String toString() {
        return "..";
    }

}
