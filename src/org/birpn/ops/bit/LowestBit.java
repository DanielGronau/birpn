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

package org.birpn.ops.bit;

import org.birpn.Function1;
import java.math.BigInteger;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class LowestBit extends Function1 {

    @Override
    public BigInteger calc(BigInteger x) {
        return BigInteger.valueOf(x.getLowestSetBit());
    }

    @Override public String toString() {
        return "lowestBit";
    }
}
