/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.arithmetic;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Gronau
 */
public class Inc extends Function1 {
    @Override
    public BigInteger calc(BigInteger x) {
        return x.add(BigInteger.ONE);
    }
    @Override public String toString() {
        return "++";
    }
}
