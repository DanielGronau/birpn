/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn.ops;

import java.math.BigInteger;
import java.util.Stack;
import static org.birpn.BIRPN.*;

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

    protected boolean testForBooleans(BigInteger ... bis) {
        boolean hasBool = false;
        boolean hasNum = false;
        for(BigInteger bi : bis) {
            boolean is = isLogic(bi);
            hasBool |= is;
            hasNum |= !is;
        }
        if(hasNum && hasBool) {
            throw new ArithmeticException("Mixing BigInteger and booleans");
        }
        return hasBool;
    }

    protected static boolean isLogic(BigInteger bi) {
        return bi == TRUE || bi == FALSE;
    }

    protected static boolean toBool(BigInteger bi) {
        if (bi == TRUE) {
            return true;
        } else if (bi == FALSE) {
            return false;
        } else {
            throw new ArithmeticException("No boolean value");
        }
    }

    protected static BigInteger fromBool(boolean b) {
        return b ? TRUE : FALSE;
    }

}
