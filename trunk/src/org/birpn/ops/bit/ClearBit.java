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
public class ClearBit extends Function2 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y) {
        return x.clearBit(y.intValue());
    }

    @Override public String toString() {
        return "clearBit";
    }
}
