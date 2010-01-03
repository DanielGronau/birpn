/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops;

import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class Dec extends Function1 {
    @Override
    public BigInteger calc(BigInteger... args) {
        return args[0].subtract(BigInteger.ONE);
    }

    @Override public String toString() {
        return "--";
    }
}