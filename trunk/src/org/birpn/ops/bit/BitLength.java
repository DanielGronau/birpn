/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.bit;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class BitLength extends Function1 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return BigInteger.valueOf(args[0].bitLength());
    }
    @Override public String toString() {
        return "bitLength";
    }
}
