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
public class And extends Function2 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y) {
        return (testForBooleans(x, y))
                ? fromBool(toBool(x) && toBool(y))
                : x.and(y);
    }

    @Override
    public String toString() {
        return "&";
    }
}
