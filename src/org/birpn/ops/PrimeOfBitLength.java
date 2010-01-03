/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops;

import java.math.BigInteger;
import java.util.Random;

/**
 *
 * @author Gronau
 */
public class PrimeOfBitLength extends Function1 {
   private final Random random = new Random();

    @Override
    public BigInteger calc(BigInteger... args) {
        return BigInteger.probablePrime(args[0].intValue(), random);
    }

    @Override public String toString() {
        return "primeofbitlength";
    }
}
