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

package org.birpn;

import java.math.BigInteger;
import java.util.Stack;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public abstract class Function extends Op {

    public Function(int arity) {
        this.arity = arity;
    }
    private final int arity;

    public void eval(Stack<BigInteger> input) {
        BigInteger[] args = new BigInteger[arity];
        for (int i = 0; i < arity; i++) {
            args[i] = input.pop();
        }
        input.push(calculate(args));
    }

    abstract public BigInteger calculate(BigInteger... args);
}
