/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.function;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
//Based on code from
//Otto Forster, "Algorithmische Zahlentheorie", ISBN 3-528-06580-X, p. 19
public class Fib extends Function1 {

    private static BigInteger fib(BigInteger n) {
        if (n.signum() < 0) {
            throw new ArithmeticException("Argument must be non-negative.");
        }
        if(n.compareTo(BigInteger.ONE) <= 0) {
            return n;
        }
        BigInteger x = BigInteger.ONE;
        BigInteger y = BigInteger.ZERO;
        for(int k = n.bitLength() - 2; k >= 0; k--) {
            BigInteger xx = x.multiply(x);
            x = xx.add(x.multiply(y).shiftLeft(1));
            y = xx.add(y.multiply(y));
            if(n.testBit(k)) {
                BigInteger temp = x;
                x = x.add(y);
                y = temp;
            }
        }
        return x;
    }

    @Override
    public BigInteger calc(BigInteger... args) {
        return fib(args[0]);
    }

    @Override
    public String toString() {
        return "fib";
    }
}
