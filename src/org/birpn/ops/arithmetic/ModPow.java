/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.arithmetic;

import org.birpn.Function3;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class ModPow extends Function3 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[2].modPow(args[1], args[0]);
    }
    @Override public String toString() {
        return "^%";
    }
}
