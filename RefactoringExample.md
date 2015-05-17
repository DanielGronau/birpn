# The original application #

Here is a little application calculating perfect numbers. Basically we check for a given n if 2<sup>n</sup>-1 is prime (then it is a Mersenne prime), and if this is the case, we return 2<sup>n-1</sup> (2<sup>n</sup>-1) as a perfect number. For details of the algorithm see http://en.wikipedia.org/wiki/Perfect_number.

```
import java.math.BigInteger;

public class PerfectNumber {

    public static BigInteger perfectNumber(int n) {
        //if n is not prime, 2^n - 1 isn't either 
        if (BigInteger.valueOf(n).isProbablePrime(20)) {
            return null;
        }
        //calculates a Mersenne prime candidate
        BigInteger prime = BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE);
        return prime.isProbablePrime(20)
                ? prime.multiply(BigInteger.valueOf(2).pow(n - 1))
                : null;
    }

    public static void main(String[] args) {
        for (int n = 1; n < 100; n++) {
            BigInteger bi = perfectNumber(n);
            if (bi != null) {
                System.out.println("n=" + n + ", perfect number:" + bi);
            }
        }
    }
}
```


# Refactoring #

First we need a static import of the BIRPN utility class: `import static org.birpn.BIRPN.*;`

Now the test if n is no prime can be written as: `! is(n, ISPRIME)` or `is(n, ISPRIME, NOT)`.

The calculation of the Mersenne prime candidate is written best using the String version. If we had a fix n (let's say 7) we could write: `BigInteger prime = _("2 7 ^ 1 -");` As we have a variable n, we need to substitute it in a similar way String.format does. The difference is that our variables are numbered $0, $1... So out code becomes: `BigInteger prime = _("2 $0 ^ 1 -", n);`

Next we need to test if the Mersenne prime candidate is indeed prime. This is similar to our first test: `is(prime, ISPRIME)`

Now the remaining calculation is the multiplication of prime with 2<sup>n-1</sup>, which can be written as: `_(2, n-1, POW, prime, TIMES)`. The first three entries calculate the factor 2<sup>n-1</sup>, then we add `prime` to the stack and multiply both values. The String version would be: `_("2 $0 ^ $1 *", n-1, prime)`, but it is less readable in this case.

Here is the complete refactored application:

```
import java.math.BigInteger;
import static org.birpn.BIRPN.*;

public class PerfectNumber {

    public static BigInteger perfectNumber(int n) {
        //if n is not prime, 2^n - 1 isn't either 
        if (is(n, ISPRIME, NOT)) {
            return null;
        }
        //calculates a Mersenne prime candidate
        BigInteger prime = _("2 $0 ^ 1 -", n);
        return is(prime, ISPRIME)
                ? _(2, n-1, POW, prime, TIMES)
                : null;
    }

    public static void main(String[] args) {
        for (int n = 1; n < 100; n++) {
            BigInteger bi = perfectNumber(n);
            if (bi != null) {
                System.out.println("n=" + n + ", perfect number:" + bi);
            }
        }
    }
}
```

I hope you agree that the application is more readable now (once you got used to the Reversed Polish Notation).