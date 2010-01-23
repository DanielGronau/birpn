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
public class Gcd extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].gcd(args[0]);
    }

    @Override public String toString() {
        return "gcd";
    }
}
