/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.bool;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class ToBool extends Function1 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return fromBool(! args[0].equals(BigInteger.ZERO));
    }

    @Override public String toString() {
        return "toBool";
    }
}