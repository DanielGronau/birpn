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
public class Pow extends Function2 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y) {
        return x.pow(y.intValue());
    }
    @Override public String toString() {
        return "^";
    }
}
