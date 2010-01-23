/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.birpn.ops.function.Abs;
import org.birpn.ops.bit.And;
import org.birpn.ops.bit.AndNot;
import org.birpn.meta.ApplyLeft;
import org.birpn.meta.ApplyRight;
import org.birpn.ops.bit.BitCount;
import org.birpn.ops.bit.BitLength;
import org.birpn.ops.bit.ClearBit;
import org.birpn.ops.function.Cube;
import org.birpn.ops.arithmetic.Dec;
import org.birpn.ops.arithmetic.Div;
import org.birpn.ops.arithmetic.DivMod;
import org.birpn.ops.stack.Dup;
import org.birpn.ops.comparision.Eq;
import org.birpn.ops.function.Factorial;
import org.birpn.ops.function.Fib;
import org.birpn.meta.Filter;
import org.birpn.meta.FilterNot;
import org.birpn.ops.bit.FlipBit;
import org.birpn.ops.bool.FromBool;
import org.birpn.ops.arithmetic.Gcd;
import org.birpn.ops.comparision.Ge;
import org.birpn.ops.comparision.Gt;
import org.birpn.ops.arithmetic.Inc;
import org.birpn.ops.prime.IsPrime;
import org.birpn.ops.prime.IsProbablePrime;
import org.birpn.ops.comparision.Le;
import org.birpn.ops.bit.Left;
import org.birpn.ops.bit.LowestBit;
import org.birpn.ops.comparision.Lt;
import org.birpn.ops.arithmetic.Max;
import org.birpn.ops.arithmetic.Min;
import org.birpn.ops.arithmetic.Minus;
import org.birpn.ops.arithmetic.Mod;
import org.birpn.ops.arithmetic.ModInverse;
import org.birpn.ops.arithmetic.ModPow;
import org.birpn.ops.comparision.Ne;
import org.birpn.ops.arithmetic.Negate;
import org.birpn.ops.prime.NextPrime;
import org.birpn.ops.bit.Not;
import org.birpn.ops.bit.Or;
import org.birpn.ops.arithmetic.Plus;
import org.birpn.ops.arithmetic.Pow;
import org.birpn.ops.prime.PrimeOfBitLength;
import org.birpn.ops.arithmetic.Remainder;
import org.birpn.ops.bit.Right;
import org.birpn.ops.bit.SetBit;
import org.birpn.ops.arithmetic.Signum;
import org.birpn.ops.function.Square;
import org.birpn.ops.stack.Swap;
import org.birpn.ops.bit.TestBit;
import org.birpn.ops.arithmetic.Times;
import org.birpn.ops.bool.ToBool;
import org.birpn.ops.bit.Xor;
import org.birpn.ops.bool.If;
import org.birpn.meta.Fold;
import org.birpn.meta.ForEach;
import org.birpn.ops.function.IsSquare;
import org.birpn.ops.function.Isqrt;
import org.birpn.ops.range.Range;
import org.birpn.ops.range.RangeBy;

/**
 *
 * @author Gronau
 */
public class BIRPN {

    public static final BigInteger TRUE = new BigInteger("1");
    public static final BigInteger FALSE = new BigInteger("0");
    public static final Op ABS = new Abs();
    public static final Op AND = new And();
    public static final Op ANDNOT = new AndNot();
    public static final Op BITCOUNT = new BitCount();
    public static final Op BITLENGTH = new BitLength();
    public static final Op CLEARBIT = new ClearBit();
    public static final Op CUBE = new Cube();
    public static final Op DEC = new Dec();
    public static final Op DIV = new Div();
    public static final Op DIVMOD = new DivMod();
    public static final Op DUP = new Dup();
    public static final Op EQ = new Eq();
    public static final Op FACTORIAL = new Factorial();
    public static final Op FIB = new Fib();
    public static final Op FLIPBIT = new FlipBit();
    public static final Op FROMBOOL = new FromBool();
    public static final Op GE = new Ge();
    public static final Op GCD = new Gcd();
    public static final Op GT = new Gt();
    public static final Op IF = new If();
    public static final Op INC = new Inc();
    public static final Op ISPRIME = new IsPrime();
    public static final Op ISPROBABLEPRIME = new IsProbablePrime();
    public static final Op ISSQUARE = new IsSquare();
    public static final Op ISQRT = new Isqrt();
    public static final Op LE = new Le();
    public static final Op LEFT = new Left();
    public static final Op LT = new Lt();
    public static final Op LOWESTBIT = new LowestBit();
    public static final Op MAX = new Max();
    public static final Op MIN = new Min();
    public static final Op MINUS = new Minus();
    public static final Op MOD = new Mod();
    public static final Op MODINVERSE = new ModInverse();
    public static final Op MODPOW = new ModPow();
    public static final Op NE = new Ne();
    public static final Op NEGATE = new Negate();
    public static final Op NEXTPRIME = new NextPrime();
    public static final Op NOT = new Not();
    public static final Op OR = new Or();
    public static final Op PLUS = new Plus();
    public static final Op POW = new Pow();
    public static final Op PRIMEOFBITLENGTH = new PrimeOfBitLength();
    public static final Op RANGE = new Range();
    public static final Op RANGEBY = new RangeBy();
    public static final Op REMAINDER = new Remainder();
    public static final Op RIGHT = new Right();
    public static final Op SETBIT = new SetBit();
    public static final Op SIGNUM = new Signum();
    public static final Op SQUARE = new Square();
    public static final Op SWAP = new Swap();
    public static final Op TESTBIT = new TestBit();
    public static final Op TIMES = new Times();
    public static final Op TOBOOL = new ToBool();
    public static final Op XOR = new Xor();
    private static final Map<String, Op> opNames =
            new HashMap<String, Op>();
    private static final Map<String, Meta> metaNames =
            new HashMap<String, Meta>();

    static {
        registerOps(ABS, AND, ANDNOT, BITCOUNT, BITLENGTH, CLEARBIT, CUBE, DEC,
                DIV, DIVMOD, DUP, EQ, FACTORIAL, FIB, FLIPBIT, FROMBOOL, GE,
                GCD, GT, IF, INC, ISPRIME, ISPROBABLEPRIME, ISQRT, ISSQUARE, LE,
                LEFT, LT, LOWESTBIT, MAX, MIN, MINUS, MOD, MODINVERSE, MODPOW,
                NE, NEGATE, NEXTPRIME, NOT, OR, PLUS, POW, PRIMEOFBITLENGTH,
                RANGE, RANGEBY, REMAINDER, RIGHT, SETBIT, SIGNUM, SQUARE,
                SWAP, TESTBIT, TIMES, TOBOOL, XOR);
        registerMetas(ApplyLeft.meta(), ApplyRight.meta(), Filter.meta(),
                FilterNot.meta(), Fold.meta(), ForEach.meta());
    }

    public static void registerOps(Op... ops) {
        for (Op op : ops) {
            Op other = opNames.put(op.toString().toLowerCase(), op);
            if (other != null) {
                throw new IllegalArgumentException("Operation " +
                        op.getClass().getSimpleName() + " and " +
                        other.getClass().getSimpleName() +
                        " use the same symbol '" + op.toString() + "'");
            }
        }
    }

    public static void registerMetas(Meta... metas) {
        for (Meta meta : metas) {
            Meta other = metaNames.put(meta.toString().toLowerCase(), meta);
            if (other != null) {
                throw new IllegalArgumentException("Meta " +
                        meta.getClass().getSimpleName() + " and " +
                        other.getClass().getSimpleName() +
                        " use the same symbol '" + meta.toString() + "'");
            }
        }
    }

    private BIRPN() {
        /* do not instantiate */
    }

    public static Op applyLeft(Op op) {
        return new ApplyLeft(op);
    }

    public static Op applyRight(Op op) {
        return new ApplyRight(op);
    }

    public static Op filter(Op op) {
        return new Filter(op);
    }

    public static Op filterNot(Op op) {
        return new FilterNot(op);
    }

    public static Op fold(Op op) {
        return new Fold(op);
    }

    public static Op foreach(Op op) {
        return new ForEach(op);
    }

    public static List<BigInteger> results(Number... elements) {
        Stack<BigInteger> stack = new Stack<BigInteger>();
        for (Number n : elements) {
            if (n instanceof Op) {
                ((Op) n).eval(stack);
            } else {
                stack.push(num2bigInt(n));
            }
        }
        return Collections.unmodifiableList(stack);
    }

    public static BigInteger _(Number... elements) {
        List<BigInteger> stack = results(elements);
        if (stack.size() == 1) {
            return stack.get(0);
        } else {
            throw new IllegalArgumentException("Calculation yields "
                    + stack.size()
                    + " elements instead of one.");
        }
    }

    public static List<BigInteger> results(String expr, Number... varargs) {
        String[] tokens = expr.split("\\s+");
        Number[] args = new Number[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].toLowerCase();
            Number op = opNames.get(token);
            try {
                args[i] = op != null ? op
                        : token.equals("true")
                        ? TRUE
                        : token.equals("false")
                        ? FALSE
                        : token.indexOf(":") != -1
                        ? extractMeta(token)
                        : token.startsWith("$")
                        ? num2bigInt(varargs[Integer.parseInt(token.substring(1))])
                        : token.startsWith("0x")
                        ? new BigInteger(token.substring(2), 16)
                        : token.startsWith("0b")
                        ? new BigInteger(token.substring(2), 2)
                        : new BigInteger(token);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Unknown Token " + token);
            }
        }
        return results(args);
    }

    private static Op extractMeta(String token) {
        String[] parts = token.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("No valid meta definition: " + token);
        } else {
            Meta meta = metaNames.get(parts[0]);
            Op op = opNames.get(parts[1]);
            if (meta == null || op == null) {
                throw new IllegalArgumentException("No valid meta definition" + token);
            } else {
                return meta.getOp(op);
            }
        }
    }

    public static BigInteger _(String expr, Number... varargs) {
        List<BigInteger> stack = results(expr, varargs);
        if (stack.size() == 1) {
            return stack.get(0);
        } else {
            throw new IllegalArgumentException("Calculation yields " + stack.size()
                    + " elements instead of one.");
        }
    }

    public static boolean is(Number... elements) {
        BigInteger result = _(elements);
        if (result == TRUE) {
            return true;
        } else if (result == FALSE) {
            return false;
        } else {
            throw new ArithmeticException(
                    "Expression doesn't result in a boolean value");
        }
    }

    public static boolean is(String expr, Number... varargs) {
        BigInteger result = _(expr, varargs);
        if (result == TRUE) {
            return true;
        } else if (result == FALSE) {
            return false;
        } else {
            throw new ArithmeticException(
                    "Expression doesn't result in a boolean value");
        }
    }

    private static BigInteger num2bigInt(Number n) {
        if (n instanceof Double || n instanceof Float || n instanceof BigDecimal) {
            throw new IllegalArgumentException(
                    "Floating point numbers are not allowed");
        }
        return n instanceof BigInteger ? (BigInteger) n
                : BigInteger.valueOf(n.longValue());
    }

    public static List<Op> getOperations() {
        return new ArrayList(opNames.values());
    }

    public static List<Meta> getMetas() {
        return new ArrayList(metaNames.values());
    }
}
