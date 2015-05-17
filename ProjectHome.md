Let's face it: Working with `BigInteger` in Java is not a great experience. But it's hard to derive a really good DSL considering the harsh syntax limitations of Java.

This tiny project allows you to work with `BigInteger`s in a very concise, but slightly unusual way. If you never heard about "Postfix Notation" or "Reverse Polish Notation", I'd suggest to [look up](http://en.wikipedia.org/wiki/Reverse_Polish_notation) how it works.

Say we have a given piece of code dealing with `BigInteger`s like the following Lucas Lehmer Test (which decides if a Mersenne number is prime):

```
    //from http://en.literateprograms.org/Lucas-Lehmer_test_for_Mersenne_numbers_%28Java%29
    public static boolean lucasLehmer(int p) {
        BigInteger s = BigInteger.valueOf(4);
        BigInteger m = BigInteger.valueOf(2).pow(p).subtract(BigInteger.ONE);
        for (int i = 0; i < p - 2; i++) {
            s = s.multiply(s).subtract(BigInteger.valueOf(2)).mod(m);
        }
        return s.equals(BigInteger.ZERO);
    }
```

After making a single static import, you can write the same method using RPN:
```
import static org.birpn.BIRPN.*;
...
    public static boolean lucasLehmerBIRPN(int p) {
        BigInteger s = _(4);
        BigInteger m = _(2, p, POW, DEC);
        for (int i = 0; i < p - 2; i++) {
            s = _(s, SQUARE, 2, MINUS, m, MOD);
        }
        return is(0, s, EQ);
    }
```

An alternative version parses a String (which may contain placeholders, similar like printf works):
```
import static org.birpn.BIRPN.*;
...
    public static boolean lucasLehmerParsed(int p) {
        BigInteger s = _("4");
        BigInteger m = _("2 $0 ^ --", p);
        for (int i = 0; i < p - 2; i++) {
            s = _("$0 ² 2 - $1 %", s, m);
        }
        return is("0 $0 ==", s);
    }
```

You can do more things, so check out the [Introduction](Introduction.md) and the FunctionReference. BIRPN supports pretty much all methods `BigInteger` does, but uses sometimes other names. There are some additional functions as well, e.g. factorial, fibo, dup and swap. If you think, other functions should be included, let me know. If you want to know what's going on, look at the DevBlog. If you just want to play around little bit, you can open a little RPN calculator by double clicking on the jar (given that your Java environment is set up properly).

Have fun!