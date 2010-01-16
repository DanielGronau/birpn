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
public class Cube extends Function1 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[0].pow(3);
    }
    @Override public String toString() {
        return "³";
    }
}
