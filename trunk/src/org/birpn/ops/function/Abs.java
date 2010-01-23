/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.function;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class Abs extends Function1 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[0].abs();
    }

    @Override public String toString() {
        return "abs";
    }
}
