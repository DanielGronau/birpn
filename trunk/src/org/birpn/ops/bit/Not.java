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
    public BigInteger calc(BigInteger... args) {
        return (testForBooleans(args))
                ? fromBool(! toBool(args[0]))
                : args[0].not();
    }
    @Override public String toString() {
        return "~";
    }
}
