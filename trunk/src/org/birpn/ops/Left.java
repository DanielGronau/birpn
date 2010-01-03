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
public class Left extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].shiftLeft(args[0].intValue());
    }
    @Override public String toString() {
        return "<<";
    }
}