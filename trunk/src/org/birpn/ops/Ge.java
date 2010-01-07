/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops;

import java.math.BigInteger;
import static org.birpn.BIRPN.*;

/**
 *
 * @author Gronau
 */
public class Ge extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].compareTo(args[0]) >= 0 ? TRUE : FALSE;
    }

    @Override public String toString() {
        return ">=";
    }
}
