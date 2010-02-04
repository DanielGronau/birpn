/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn;

import org.birpn.Function;
import java.math.BigInteger;

public abstract class Function3 extends Function {
  public Function3() {
    super(3);
  }

  @Override
  final public BigInteger calculate(BigInteger ...xs) {
    return calc(xs[2], xs[1], xs[0]);
  }

  abstract public BigInteger calc(BigInteger x, BigInteger y, BigInteger z);

}
