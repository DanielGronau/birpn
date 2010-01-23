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
public class Ne extends Function2 {

    @Override
    public BigInteger calc(BigInteger... args) {
        return args[1].equals(args[0]) ? FALSE : TRUE;
    }

    @Override public String toString() {
        return "!=";
    }
}
