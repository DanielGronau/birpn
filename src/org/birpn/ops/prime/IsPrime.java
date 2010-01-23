/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.prime;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class IsPrime extends Function1 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return fromBool(args[0].isProbablePrime(15));
    }

    @Override public String toString() {
        return "isprime";
    }
}
