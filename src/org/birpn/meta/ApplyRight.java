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

package org.birpn.meta;

import org.birpn.Meta;
import org.birpn.Function2;
import org.birpn.Op;
import java.math.BigInteger;
import java.util.Stack;

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
public class ApplyRight extends Op {

  private final Function2 fn;

  public ApplyRight(Op fn) {
    this.fn = (Function2) fn;
  }

  public void eval(Stack<BigInteger> input) {
    Stack<BigInteger> temp = new Stack<BigInteger>();
    BigInteger rightOperand = input.pop();
    while(! input.isEmpty()) {
      temp.push(input.pop());
    }
    while(! temp.isEmpty()) {
      input.push(temp.pop());
      input.push(rightOperand);
      fn.eval(input);
    }
  }

  public String toString() {
    return "applyRight:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new ApplyRight(op);
      }
      @Override public String toString() {
        return "applyRight";
      }
    };
  }
}
