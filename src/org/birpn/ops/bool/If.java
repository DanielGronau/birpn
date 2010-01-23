package org.birpn.ops.bool;

import org.birpn.Function3;
import java.math.BigInteger;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class If extends Function3 {

  public BigInteger calc(BigInteger... args) {
    return toBool(args[2]) ? args[1] : args [0];
  }

  @Override public String toString() {
    return "if";
  }

}
