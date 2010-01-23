/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn;

import org.birpn.Op;
import java.math.BigInteger;
import java.util.Stack;

/**
 *
 * @author Gronau
 */
public abstract class Function extends Op {

    public Function(int arity) {
        this.arity = arity;
    }
    private final int arity;

    public void eval(Stack<BigInteger> input) {
        BigInteger[] args = new BigInteger[arity];
        for (int i = 0; i < arity; i++) {
            args[i] = input.pop();
        }
        input.push(calc(args));
    }

    abstract public BigInteger calc(BigInteger... args);
}
