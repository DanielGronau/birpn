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
public class Cube extends Function1 {

    @Override
    public BigInteger calc(BigInteger x) {
        return x.pow(3);
    }
    @Override public String toString() {
        return "\u00b3";
    }
}
