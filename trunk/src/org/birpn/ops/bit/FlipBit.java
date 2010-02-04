/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.bit;

import org.birpn.Function2;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class FlipBit extends Function2 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y) {
        return x.flipBit(y.intValue());
    }

    @Override public String toString() {
        return "flipBit";
    }
}
