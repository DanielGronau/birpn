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
import java.util.Stack;
import java.math.BigInteger;

/**
 * @author Daniel Gronau
 * @version 1.0
 */
public class Fold extends Op {

  private final Function2 fn;

  public Fold(Op fn) {
    this.fn = (Function2) fn;
  }

  public void eval(Stack<BigInteger> input) {
    while (input.size() > 1) {
      fn.eval(input);
    }
  }

  @Override public String toString() {
    return "fold:" + fn.toString();
  }

  public static Meta meta() {
    return new Meta() {
      public Op getOp(Op op) {
        return new Fold(op);
      }
      @Override public String toString() {
        return "fold";
      }
    };
  }
}
