/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.birpn.examples;

import java.math.BigInteger;
import static org.birpn.BIRPN.*;

/**
 *
 * @author Gronau
 */
public class LucasLehmerTest {

    //from http://en.literateprograms.org/Lucas-Lehmer_test_for_Mersenne_numbers_%28Java%29
    public static boolean lucasLehmer(int p) {
        BigInteger s = BigInteger.valueOf(4);
        BigInteger m = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
        for (int i = 0; i < p - 2; i++) {
            s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(m);
        }
        return s.equals(BigInteger.ZERO);
    }

    public static boolean lucasLehmerBIRPN(int p) {
        BigInteger s = _(4);
        BigInteger m = _(2, p, POW, DEC);
        for (int i = 0; i < p - 2; i++) {
            s = _(s, SQUARE, 2, MINUS, m, MOD);
        }
        return is(s, 0, EQ);
    }

    public static boolean lucasLehmerParsed(int p) {
        BigInteger s = _("4");
        BigInteger m = _("2 $0 ^ --", p);
        for (int i = 0; i < p - 2; i++) {
            s = _("$0 ² 2 - $1 %", s, m);
        }
        return is("$0 0 ==", s);
    }

    public static void main(String[] args) {
        System.out.println("Lucas Lehmer Test");
        System.out.println("Conventional BigInteger Arithmetic Results:");
        System.out.println("2^107-1: " + lucasLehmer(107) +
                ", 2^257-1: " + lucasLehmer(257));
        System.out.println("BIRPN Operator Style Results:");
        System.out.println("2^107-1: " + lucasLehmerBIRPN(107) +
                ", 2^257-1: " + lucasLehmerBIRPN(257));
        System.out.println("BIRPN Parsed Style Results:");
        System.out.println("2^107-1: " + lucasLehmerParsed(107) +
                ", 2^257-1: " + lucasLehmerParsed(257));
    }
}