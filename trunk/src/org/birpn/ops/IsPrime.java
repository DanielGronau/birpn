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
public class IsPrime extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return fromBool(args[0].isProbablePrime(15));
    }

    @Override public String toString() {
        return "isprime";
    }
}
