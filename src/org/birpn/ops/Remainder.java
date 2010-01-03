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
public class Remainder extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].remainder(args[0]);
    }

    @Override
    public String toString() {
        return "remainder";
    }
}
