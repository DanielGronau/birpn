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
public class Or extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return (testForBooleans(args))
                ? fromBool(toBool(args[1]) || toBool(args[0]))
                : args[1].or(args[0]);
    }

    @Override public String toString() {
        return "|";
    }
}