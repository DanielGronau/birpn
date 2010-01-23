/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.function;

import org.birpn.Function1;
import java.math.BigInteger;

import static org.birpn.BIRPN.FALSE;

/**
 *
 * @author Gronau
 */
public class IsSquare extends Function1 {

    @Override
    public BigInteger calc(BigInteger... args) {
        if(args[0].compareTo(BigInteger.ZERO) < 0) {
            return FALSE;
        }
        int i = args[0].mod(BigInteger.valueOf(3)).intValue();
        if(i == 2) {
            return FALSE;
        }
        i = args[0].mod(BigInteger.valueOf(16)).intValue();
        if(i != 0 && i != 1 && i != 4 && i != 9) {
            return FALSE;
        }
        i = args[0].mod(BigInteger.valueOf(5)).intValue();
        if(i != 0 && i != 1 && i != 4) {
            return FALSE;
        }
        BigInteger isqrt = Isqrt.bigintroot(args[0]);
        return fromBool(isqrt.pow(2).equals(args[0]));
    }

    @Override
    public String toString() {
        return "isSquare";
    }

}
