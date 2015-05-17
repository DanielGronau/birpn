# Introduction #

First you need to understand what "Postfix Notation" or "Reverse Polish Notation" is. You can look it up at [Wikipedia](http://en.wikipedia.org/wiki/Reverse_Polish_notation). Note that you never need braces, just the the right order of numbers and operators. See the FunctionReference for supported functions. You need to include `static import org.birpn.BIRPN.*;` in your code. Of course you can mix the different styles as you like.

There are two ways to use BIRPN: With operators or with a String containing the calculation.



# Operator Style #

You call the static Method `_(Numbers ... n)`. Note that the operators (like PLUS oder FACTORIAL) are Numbers, too. You can use any number type, except Double, Float and `BigDecimal`. The boolean values are represented with the constants TRUE and FALSE.
Some examples:
| **Calculation** | **Reverse Polish Notation** | **BIRPN call** |
|:----------------|:----------------------------|:---------------|
| `a - b`         | `a b -`                     | `_(a, b, MINUS)` |
| `3 + (4*5)`     | `3 4 5 * +`                 | `_(3, 4, 5, TIMES, PLUS)` |
| `(3+4) *5`      | `3 4 + 5 *`                 | `_(3, 4, PLUS, 5, TIMES)` |
| `16!`           | `16 !`                      | `_(16, FACTORIAL)` |
| `fib(fib(5))`   | `5 fib fib`                 | `_(5, FIB, FIB)` |
| `true ? 42 : 51` | `true 42 51 if`             | `_(TRUE, 42, 51, IF)` |



# Parsed Style #

You call the static Method `_(String s, Numbers ... args)`. You put the String representation of the operators on the stack, separated by whitespaces. Operators are not case sensitive. Variables use a placeholder syntax similar to the printf notation, but with a $ prefix. $0 refers to `args[0]`, $1 refers to `args[1]` etc. Some examples:
| **Calculation** | **Reverse Polish Notation** | **Parsed BIRPN call** |
|:----------------|:----------------------------|:----------------------|
| `a - b`         | `a b -`                     | `_("$0 $1 -", a, b)`  |
| `3 + (4*5)`     | `3 4 5 * +`                 | `_("3 4 5 * +")`      |
| `(3+4) * 5`     | `3 4 + 5 *`                 | `_("3 4 + 5 *")`      |
| `16!`           | `16 !`                      | `_("16 !")`           |
| `fib(fib(5))`   | `5 fib fib`                 | `_("5 fib fib")`      |
| `true ? 42 : 51` | `true 42 51 if`             | `_("true 42 51 if")`  |

In Parsed Style you can use hexadeximal numbers (starting with 0x) or binary numbers (starting with 0b):
| **Calculation** | **Reverse Polish Notation** | **Parsed BIRPN call** |
|:----------------|:----------------------------|:----------------------|
| `FF!`           | `FF !`                      | `_("0xFF !")`         |
| `1001(b)!`      | `1001(b)!`                  | `_("0b1001 !")`       |

It is possible to substitute not only numbers but operators, too. The following example prints the results of 33+17, 33-17, 33\*17, 33/17:
```
Number[] ops = { PLUS, MINUS, TIMES, DIV };
for(BigInteger op : ops) {
  System.out.println(_("33 17 $0", op));
}
```

# Result Types #

So far all examples returned a single number, and for this purpose you can use the `_()` function. If there are more numbers on the stack as the result of your calculation, you must use the `results()` function instead, as `_()` throws an error in this case. Sometimes the result of a calculation is a boolean constant (e.g. ISPRIME or TESTBIT). Of course you can use `_()` in this case as well, but it is more convenient to use the `is()` function, which returns a boolean.

# Stack Manipulation #

At the moment there are only two stack operations: `dup` duplicates the first stack element and `swap` swaps the first and second argument. E.g you could calculate the fifth power using the expression ` BigInteger fifthPower = _(n, DUP, SQUARE, SQUARE, TIMES); `. There are two additional functions generating ranges of numbers: range ("..") and rangeBy ("...").

# Meta Functions #

Sometimes you want to apply an operation on all elements of the stack. For this purpose there are six meta functions available, which take other functions as argument, e.g. ` results("1 20 .. filter:isPrime"); ` returns all prime numbers below 20. For more information go to the meta function section in the FunctionReference.

# Pros and Cons #

For time critical operations you should use `BigInteger` directly. Operator style is more restricted than parsed style, it is less error prone, slightly faster and you need no placeholder syntax for variables. But it is not as readable and compact as parsed style. A String for parsed style (which must not containing placeholders for operators) is the only way to serialize BIRPN calculations (a serialized array of Numbers in operator style won't work).