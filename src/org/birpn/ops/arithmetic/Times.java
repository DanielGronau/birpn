/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.arithmetic;

import org.birpn.Function2;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class Times extends Function2 {

    @Override
    public BigInteger calc(BigInteger ... args) {
        return args[0].multiply(args[1]);
    }
    @Override public String toString() {
        return "*";
    }
}
