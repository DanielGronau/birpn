# Writing Functions #

While the basic class for an operation is Op, most of the operations in BIRPN are actually functions, which means that they remove their operands from the stack and put **one** `BigInteger` back to the stack. In this case you should use one of the function classes as your base class.

Consider you want to write a function for the least common denominator. You can calculate it by the formula lcd(a,b) = a\*b/gcd(a,b). It needs two arguments, so you can extend Function2.
You must just provide the calc- and the toString-Method. Here is a possible implementation:

```
package mypackage;

import org.birpn.Function2; 
import java.math.BigInteger;

public class Lcd extends Function2 {

    @Override
    public BigInteger calc(BigInteger x, BigInteger y) {
        return x.multiply(y).divide(x.gcd(y));
    }

    @Override public String toString() {
        return "lcd";
    }
}
```

# Extending Op #

If your operation doesn't fit in the usual function scheme, you can extends Op directly. E.g. if you want to write an operation that rotates the first three stack entries (so that the third entry gets the first one), you could write:

```
import org.birpn.Op;
import java.math.BigInteger;
import java.util.Stack;

public class Rot extends Op {
    public void eval(Stack<BigInteger> input) {
        BigInteger a = input.pop();
        BigInteger b = input.pop();
        BigInteger c = input.pop();
        input.push(b);
        input.push(a);
        input.push(c);
    }
    @Override public String toString() {
        return "rot";
    }
}
```