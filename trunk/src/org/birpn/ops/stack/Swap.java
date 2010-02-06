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
 * Swaps the first and second element of the stack.
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class Swap extends Op {
    public void eval(Stack<BigInteger> input) {
        BigInteger a = input.pop();
        BigInteger b = input.pop();
        input.push(a);
        input.push(b);
    }
    @Override public String toString() {
        return "swap";
    }
}
