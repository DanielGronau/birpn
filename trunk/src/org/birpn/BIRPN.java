/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import org.birpn.ops.Abs;
import org.birpn.ops.And;
import org.birpn.ops.AndNot;
import org.birpn.ops.BitCount;
import org.birpn.ops.BitLength;
import org.birpn.ops.ClearBit;
import org.birpn.ops.Dec;
import org.birpn.ops.Div;
import org.birpn.ops.DivMod;
import org.birpn.ops.Dup;
import org.birpn.ops.Eq;
import org.birpn.ops.Factorial;
import org.birpn.ops.Fib;
import org.birpn.ops.FlipBit;
import org.birpn.ops.FromBool;
import org.birpn.ops.Gcd;
import org.birpn.ops.Ge;
import org.birpn.ops.Gt;
import org.birpn.ops.Minus;
import org.birpn.ops.Plus;
import org.birpn.ops.Op;
import org.birpn.ops.Inc;
import org.birpn.ops.IsPrime;
import org.birpn.ops.IsProbablePrime;
import org.birpn.ops.Le;
import org.birpn.ops.Left;
import org.birpn.ops.LowestBit;
import org.birpn.ops.Lt;
import org.birpn.ops.Max;
import org.birpn.ops.Min;
import org.birpn.ops.Mod;
import org.birpn.ops.ModInverse;
import org.birpn.ops.ModPow;
import org.birpn.ops.Ne;
import org.birpn.ops.Negate;
import org.birpn.ops.NextPrime;
import org.birpn.ops.Not;
import org.birpn.ops.Or;
import org.birpn.ops.Pow;
import org.birpn.ops.PrimeOfBitLength;
import org.birpn.ops.Remainder;
import org.birpn.ops.Right;
import org.birpn.ops.SetBit;
import org.birpn.ops.Signum;
import org.birpn.ops.Square;
import org.birpn.ops.Swap;
import org.birpn.ops.TestBit;
import org.birpn.ops.Times;
import org.birpn.ops.ToBool;
import org.birpn.ops.Xor;

/**
 *
 * @author Gronau
 */
public class BIRPN {

    public static final BigInteger TRUE = new BigInteger("1");
    public static final BigInteger FALSE = new BigInteger("0");
    public static final BigInteger ABS = new BigInteger("0");
    public static final BigInteger AND = new BigInteger("0");
    public static final BigInteger ANDNOT = new BigInteger("0");
    public static final BigInteger BITCOUNT = new BigInteger("0");
    public static final BigInteger BITLENGTH = new BigInteger("0");
    public static final BigInteger CLEARBIT = new BigInteger("0");
    public static final BigInteger DEC = new BigInteger("0");
    public static final BigInteger DIV = new BigInteger("0");
    public static final BigInteger DIVMOD = new BigInteger("0");
    public static final BigInteger DUP = new BigInteger("0");
    public static final BigInteger EQ = new BigInteger("0");
    public static final BigInteger FACTORIAL = new BigInteger("0");
    public static final BigInteger FIB = new BigInteger("0");
    public static final BigInteger FLIPBIT = new BigInteger("0");
    public static final BigInteger FROMBOOL = new BigInteger("0");
    public static final BigInteger GE = new BigInteger("0");
    public static final BigInteger GCD = new BigInteger("0");
    public static final BigInteger GT = new BigInteger("0");
    public static final BigInteger INC = new BigInteger("0");
    public static final BigInteger ISPRIME = new BigInteger("0");
    public static final BigInteger ISPROBABLEPRIME = new BigInteger("0");
    public static final BigInteger LE = new BigInteger("0");
    public static final BigInteger LEFT = new BigInteger("0");
    public static final BigInteger LT = new BigInteger("0");
    public static final BigInteger LOWESTBIT = new BigInteger("0");
    public static final BigInteger MAX = new BigInteger("0");
    public static final BigInteger MIN = new BigInteger("0");
    public static final BigInteger MINUS = new BigInteger("0");
    public static final BigInteger MOD = new BigInteger("0");
    public static final BigInteger MODINVERSE = new BigInteger("0");
    public static final BigInteger MODPOW = new BigInteger("0");
    public static final BigInteger NE = new BigInteger("0");
    public static final BigInteger NEGATE = new BigInteger("0");
    public static final BigInteger NEXTPRIME = new BigInteger("0");
    public static final BigInteger NOT = new BigInteger("0");
    public static final BigInteger OR = new BigInteger("0");
    public static final BigInteger PLUS = new BigInteger("0");
    public static final BigInteger POW = new BigInteger("0");
    public static final BigInteger PRIMEOFBITLENGTH = new BigInteger("0");
    public static final BigInteger REMAINDER = new BigInteger("0");
    public static final BigInteger RIGHT = new BigInteger("0");
    public static final BigInteger SETBIT = new BigInteger("0");
    public static final BigInteger SIGNUM = new BigInteger("0");
    public static final BigInteger SQUARE = new BigInteger("0");
    public static final BigInteger SWAP = new BigInteger("0");
    public static final BigInteger TESTBIT = new BigInteger("0");
    public static final BigInteger TIMES = new BigInteger("0");
    public static final BigInteger TOBOOL = new BigInteger("0");
    public static final BigInteger XOR = new BigInteger("0");
    private static final Map<BigInteger, Op> ops =
            new IdentityHashMap<BigInteger, Op>();
    private static final Map<String, BigInteger> opNames =
            new HashMap<String, BigInteger>();

    static {
        registerOperation(ABS, new Abs());
        registerOperation(AND, new And());
        registerOperation(ANDNOT, new AndNot());
        registerOperation(BITCOUNT, new BitCount());
        registerOperation(BITLENGTH, new BitLength());
        registerOperation(CLEARBIT, new ClearBit());
        registerOperation(DEC, new Dec());
        registerOperation(DIV, new Div());
        registerOperation(DIVMOD, new DivMod());
        registerOperation(DUP, new Dup());
        registerOperation(EQ, new Eq());
        registerOperation(FACTORIAL, new Factorial());
        registerOperation(FIB, new Fib());
        registerOperation(FLIPBIT, new FlipBit());
        registerOperation(FROMBOOL, new FromBool());
        registerOperation(GE, new Ge());
        registerOperation(GCD, new Gcd());
        registerOperation(GT, new Gt());
        registerOperation(INC, new Inc());
        registerOperation(ISPRIME, new IsPrime());
        registerOperation(ISPROBABLEPRIME, new IsProbablePrime());
        registerOperation(LE, new Le());
        registerOperation(LEFT, new Left());
        registerOperation(LT, new Lt());
        registerOperation(LOWESTBIT, new LowestBit());
        registerOperation(MAX, new Max());
        registerOperation(MIN, new Min());
        registerOperation(MINUS, new Minus());
        registerOperation(MOD, new Mod());
        registerOperation(MODINVERSE, new ModInverse());
        registerOperation(MODPOW, new ModPow());
        registerOperation(NE, new Ne());
        registerOperation(NEGATE, new Negate());
        registerOperation(NEXTPRIME, new NextPrime());
        registerOperation(NOT, new Not());
        registerOperation(OR, new Or());
        registerOperation(PLUS, new Plus());
        registerOperation(POW, new Pow());
        registerOperation(PRIMEOFBITLENGTH, new PrimeOfBitLength());
        registerOperation(REMAINDER, new Remainder());
        registerOperation(RIGHT, new Right());
        registerOperation(SETBIT, new SetBit());
        registerOperation(SIGNUM, new Signum());
        registerOperation(SQUARE, new Square());
        registerOperation(SWAP, new Swap());
        registerOperation(TESTBIT, new TestBit());
        registerOperation(TIMES, new Times());
        registerOperation(TOBOOL, new ToBool());
        registerOperation(XOR, new Xor());

        opNames.put("true", TRUE);
        opNames.put("false", FALSE);
    }

    public static void registerOperation(BigInteger bi, Op op) {
        ops.put(bi, op);
        opNames.put(op.toString(), bi);
    }

    private BIRPN() {
        /* do not instantiate */
    }

    public static List<BigInteger> results(Number... elements) {
        Stack<BigInteger> stack = new Stack<BigInteger>();
        for (Number n : elements) {
            @SuppressWarnings("element-type-mismatch")
            Op e = ops.get(n);
            if (e == null) {
                stack.push(num2bigInt(n));
            } else {
                e.eval(stack);
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
                    + stack.size() + " elements instead of one.");
        }
    }

    public static BigInteger _(String expr, Number... varargs) {
        String[] tokens = expr.split("\\s+");
        BigInteger[] args = new BigInteger[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i].toLowerCase();
            BigInteger op = opNames.get(token);
            try {
                args[i] = op != null ? op
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
        return _(args);
    }

    public static boolean is(Number... elements) {
        BigInteger result = _(elements);
        if (result == TRUE) {
            return true;
        } else if (result == FALSE) {
            return false;
        } else {
            throw new ArithmeticException("Expression doesn't result in a boolean value");
        }
    }

    public static boolean is(String expr, Number... varargs) {
        BigInteger result = _(expr, varargs);
        if (result == TRUE) {
            return true;
        } else if (result == FALSE) {
            return false;
        } else {
            throw new ArithmeticException("Expression doesn't result in a boolean value");
        }
    }

    private static BigInteger num2bigInt(Number n) {
        if (n instanceof Double || n instanceof Float || n instanceof BigDecimal) {
            throw new IllegalArgumentException("Floating point numbers are not allowed");
        }
        return n instanceof BigInteger ? (BigInteger) n : BigInteger.valueOf(n.longValue());
    }
}
