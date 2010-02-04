/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn;

import org.birpn.Function;
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
