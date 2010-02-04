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
    public BigInteger calc(BigInteger x) {
        if(x.compareTo(BigInteger.ZERO) < 0) {
            return FALSE;
        }
        int i = x.mod(BigInteger.valueOf(3)).intValue();
        if(i == 2) {
            return FALSE;
        }
        i = x.mod(BigInteger.valueOf(16)).intValue();
        if(i != 0 && i != 1 && i != 4 && i != 9) {
            return FALSE;
        }
        i = x.mod(BigInteger.valueOf(5)).intValue();
        if(i != 0 && i != 1 && i != 4) {
            return FALSE;
        }
        BigInteger isqrt = Isqrt.bigintroot(x);
        return fromBool(isqrt.pow(2).equals(x));
    }

    @Override
    public String toString() {
        return "isSquare";
    }

}
