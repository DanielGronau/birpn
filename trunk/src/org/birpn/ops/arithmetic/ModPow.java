/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.arithmetic;

import org.birpn.Function3;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class ModPow extends Function3 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y, BigInteger z) {
        return x.modPow(y, z);
    }
    @Override public String toString() {
        return "^%";
    }
}
