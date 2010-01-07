/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.birpn;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.IdentityHashMap;
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
import org.birpn.ops.Factorial;
import org.birpn.ops.Fib;
import org.birpn.ops.FlipBit;
import org.birpn.ops.Gcd;
import org.birpn.ops.Minus;
import org.birpn.ops.Plus;
import org.birpn.ops.Op;
import org.birpn.ops.Inc;
import org.birpn.ops.Left;
import org.birpn.ops.LowestBit;
import org.birpn.ops.Max;
import org.birpn.ops.Min;
import org.birpn.ops.Mod;
import org.birpn.ops.ModInverse;
import org.birpn.ops.ModPow;
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
import org.birpn.ops.Times;
import org.birpn.ops.Xor;

/**
 *
 * @author Gronau
 */
public class BIRPN {

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
    public static final BigInteger FACTORIAL = new BigInteger("0");
    public static final BigInteger FIB = new BigInteger("0");
    public static final BigInteger FLIPBIT = new BigInteger("0");
    public static final BigInteger GCD = new BigInteger("0");
    public static final BigInteger INC = new BigInteger("0");
    public static final BigInteger LEFT = new BigInteger("0");
    public static final BigInteger LOWESTBIT = new BigInteger("0");
    public static final BigInteger MAX = new BigInteger("0");
    public static final BigInteger MIN = new BigInteger("0");
    public static final BigInteger MINUS = new BigInteger("0");
    public static final BigInteger MOD = new BigInteger("0");
    public static final BigInteger MODINVERSE = new BigInteger("0");
    public static final BigInteger MODPOW = new BigInteger("0");
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
    public static final BigInteger TIMES = new BigInteger("0");
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
        registerOperation(FACTORIAL, new Factorial());
        registerOperation(FIB, new Fib());
        registerOperation(FLIPBIT, new FlipBit());
        registerOperation(GCD, new Gcd());
        registerOperation(INC, new Inc());
        registerOperation(LEFT, new Left());
        registerOperation(LOWESTBIT, new LowestBit());
        registerOperation(MAX, new Max());
        registerOperation(MIN, new Min());
        registerOperation(MINUS, new Minus());
        registerOperation(MOD, new Mod());
        registerOperation(MODINVERSE, new ModInverse());
        registerOperation(MODPOW, new ModPow());
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
        registerOperation(TIMES, new Times());
        registerOperation(XOR, new Xor());
    }

    public static void registerOperation(BigInteger bi, Op op) {
        ops.put(bi, op);
        opNames.put(op.toString(), bi);
    }

    private BIRPN() {
        /* do not instantiate */
    }

    public static BigInteger _(Number... elements) {
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
        if (stack.size() == 1) {
            return stack.pop();
        } else {
            throw new IllegalArgumentException();
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

    private static BigInteger num2bigInt(Number n) {
        if (n instanceof Double || n instanceof Float || n instanceof BigDecimal) {
            throw new IllegalArgumentException("Floating point numbers are not allowed");
        }
        return n instanceof BigInteger ? (BigInteger) n : BigInteger.valueOf(n.longValue());
    }
}
