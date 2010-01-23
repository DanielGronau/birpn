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
public class SetBit extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].setBit(args[0].intValue());
    }
    @Override public String toString() {
        return "setbit";
    }
}
