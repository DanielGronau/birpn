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

package org.birpn.ops.stack;

import org.birpn.Op;
import java.math.BigInteger;
import java.util.Stack;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Range extends Op {

    @Override
    public void eval(Stack<BigInteger> input) {
        BigInteger toInt = input.pop();
        BigInteger fromInt = input.pop();
        if (fromInt.compareTo(toInt) <= 0) {
            for (BigInteger i = fromInt; i.compareTo(toInt) < 1; i = i.add(BigInteger.ONE)) {
                input.push(i);
            }
        } else {
            for (BigInteger i = fromInt; i.compareTo(toInt) > -1; i = i.subtract(BigInteger.ONE)) {
                input.push(i);
            }
        }
    }

    @Override
    public String toString() {
        return "..";
    }
}
