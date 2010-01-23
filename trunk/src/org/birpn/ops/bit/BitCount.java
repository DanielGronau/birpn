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
public class BitCount extends Function1 {
    @Override
    public BigInteger calc(BigInteger... args) {
        return BigInteger.valueOf(args[0].bitCount());
    }
    @Override public String toString() {
        return "bitCount";
    }
}
