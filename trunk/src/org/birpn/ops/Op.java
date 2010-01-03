/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.ops;

import java.math.BigInteger;
import java.util.Stack;

/**
 *
 * @author Gronau
 */
public interface Op {
    public void eval(Stack<BigInteger> input);
}
