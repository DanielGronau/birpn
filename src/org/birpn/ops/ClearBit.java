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
public class ClearBit extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].clearBit(args[0].intValue());
    }

    @Override public String toString() {
        return "clearbit";
    }
}
