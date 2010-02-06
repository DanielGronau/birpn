/* This file is part of BIRPN.
 *
 * BIRPN is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of
 * the License, or (at your option) any later version.
 *
 * BIRPN is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the Lesser GNU General Public
 * License along with BIRPN.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.birpn.ops.function;

import org.birpn.Function1;
import java.math.BigInteger;

import static org.birpn.BIRPN.FALSE;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
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
