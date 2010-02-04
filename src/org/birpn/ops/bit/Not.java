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
public class Not extends Function1 {

    @Override
    public BigInteger calc(BigInteger x) {
        return (testForBooleans(x))
                ? fromBool(! toBool(x))
                : x.not();
    }
    @Override public String toString() {
        return "~";
    }
}
