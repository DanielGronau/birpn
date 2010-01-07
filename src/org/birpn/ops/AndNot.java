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
public class AndNot extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
         return (testForBooleans(args))
                ? fromBool(toBool(args[1]) && ! toBool(args[0]))
                : args[1].andNot(args[0]);
    }

    @Override public String toString() {
        return "&~";
    }
}
