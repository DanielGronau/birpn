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
public class ApplyLeft extends Op {

  private final Function2 fn;

  public ApplyLeft(Op fn) {
    this.fn = (Function2) fn;
  }

  public void eval(Stack<BigInteger> input) {
    Stack<BigInteger> temp = new Stack<BigInteger>();
    BigInteger leftOperand = input.pop();
    while(! input.isEmpty()) {
      temp.push(input.pop());
    }
    while(! temp.isEmpty()) {
      input.push(leftOperand);  
      input.push(temp.pop());
      fn.eval(input);
    }
  }

  public String toString() {
    return "applyLeft:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new ApplyLeft(op);
      }
      @Override public String toString() {
        return "applyLeft";
      }
    };
  }
}
