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

/**
 *
 * @author Daniel Gronau
 * @version 1.0
 */
import java.math.BigInteger;

public abstract class Function1 extends Function {
  public Function1() {
    super(1);
  }

  @Override
  final public BigInteger calculate(BigInteger ...xs) {
    return calc(xs[0]);
  }

  abstract public BigInteger calc(BigInteger x);
}
