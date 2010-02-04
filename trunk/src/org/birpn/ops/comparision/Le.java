/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops.comparision;

import org.birpn.Function2;
import java.math.BigInteger;
import static org.birpn.BIRPN.*;

/**
 *
 * @author Gronau
 */
public class Le extends Function2 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y) {
        return x.compareTo(y) <= 0 ? TRUE : FALSE;
    }

    @Override public String toString() {
        return "<=";
    }
}
