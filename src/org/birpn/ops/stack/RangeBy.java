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
public class RangeBy extends Op {

    @Override
    public void eval(Stack<BigInteger> input) {
        BigInteger delta = input.pop();
        BigInteger toInt = input.pop();
        BigInteger fromInt = input.pop();
        if (toInt.equals(fromInt)) {
            input.push(fromInt);
        } else {
            if (delta.signum() != toInt.compareTo(fromInt)) {
                throw new ArithmeticException("Step size has the wrong sign.");
            }
            for (BigInteger i = fromInt; i.compareTo(toInt) != delta.signum(); i = i.add(delta)) {
                input.push(i);
            }
        }
    }

    @Override
    public String toString() {
        return "...";
    }
}
