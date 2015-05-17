# Function Reference #

The String representations are **not** case sensistive.

| **BIRPN Operator** | **String Representation** | **`BigInteger` Function** | **Description** |
|:-------------------|:--------------------------|:--------------------------|:----------------|
| ABS                | abs                       | abs()                     | absolute value  |
| AND                | `&`                       | and(n)                    | bitwise/logical and |
| ANDNOT             | `&~`                      | andNot(n)                 | bitwise/logical and not |
| BITCOUNT           | bitCount                  | bitCount()                | number of set bits |
| BITLENGTH          | bitLength                 | bitLength()               | length of binary representation |
| CLEARBIT           | clearBit                  | clearBit(k)               | set the k-th bit to 0 |
| CUBE               | `³`                      | pow(3)                    | calculates the cube |
| DEC                | `--`                      | subtract(`BigInteger.ONE`) | decrease number by one |
| DIV                | `/`                       | divide(n)                 | integer division |
| DIVMOD             | `/%`                      | divideAndRemainder(n)     | division and remainder |
| DUP                | dup                       | -none-                    | duplicate top value on stack |
| EQ                 | `==`                      | equals                    | tests for equality |
| FACTORIAL          | !                         | -none-                    | factorial       |
| FIB                | fib                       | -none-                    | fibonacci function |
| FLIPBIT            | flipBit                   | flipBit(k)                | flips the k-th bit |
| FROMBOOL           | fromBool                  | -none-                    | true -> 1 and false -> 0 |
| GCD                | gcd                       | gdc(n)                    | greatest common divisor |
| GE                 | `>=`                      | compareTo(x) >= 0         | greater or equal |
| GT                 | `>`                       | compareTo(x) > 0          | greater         |
| IF                 | if                        | cond ? x : y              | if statement    |
| INC                | `++`                      | add(`BigInteger.ONE`)     | increase number by one |
| ISPRIME            | isPrime                   | isProbablePrime(15)       | test if prime number |
| ISPROBABLEPRIME    | isProbablePrime           | isProbablePrime           | test if prime number |
| ISSQUARE           | isSquare                  | -none-                    | test if square number |
| ISQRT              | isqrt                     | -none-                    | biggest number x with x\*x <= n |
| LE                 | `<=`                      | compareTo(x) <= 0         | less or equal   |
| LEFT               | `<<`                      | shiftLeft(k)              | shift bits left by k positions |
| LOWESTBIT          | lowestbit                 | getLowestBitSet()         | the position of the lowest bit |
| LT                 | `<`                       | compareTo(x) < 0          | less than       |
| MAX                | max                       | max(n)                    | maximum         |
| MIN                | min                       | min(n)                    | minimum         |
| MINUS              | `-`                       | subtract(n)               | difference      |
| MOD                | `%`                       | mod(n)                    | modulo          |
| MODINVERSE         | modInverse                | modInverse(n)             | 1/this for module n |
| MODPOW             | `^%`                      | modPow(e, m)              | (this^e) % m    |
| NE                 | `!=`                      | compareTo(x) != 0         | not equal       |
| NEGATE             | negate                    | negate                    | unary minus     |
| NEXTPRIME          | nextPrime                 | nextProbablePrime()       | the next probable prime greater than this |
| NOT                | `~`                       | not()                     | bitwise/logical not |
| OR                 | `|`                       | or(n)                     | bitwise/logical or |
| PLUS               | `+`                       | add(n)                    | sum             |
| POW                | `^`                       | pow(k)                    | exponentation   |
| PRIMEOFBITLENGTH   | primeOfBitLength          | probablePrime(k,random)   | probable prime of bit length k |
| RANGE              | `..`                      | -none-                    | range with step 1 or -1 |
| RANGEBY            | `...`                     | -none-                    | range with given step |
| REMAINDER          | remainder                 | remainder(n)              | remainder of integer division |
| REVERSE            | reverse                   | -none-                    | reverses the stack |
| RIGHT              | `>>`                      | shiftRight(k)             | shift bits right by k positions |
| SETBIT             | setBit                    | setBit(k)                 | set the k-th bit |
| SHUFFLE            | shuffle                   | -none-                    | shuffles the elements of the stack |
| SIGNUM             | signum                    | signum()                  | 1,0,-1 for positive, zero, negative number |
| SORT               | sort                      | -none-                    | sorts all elements of the stack |
| SQUARE             | `²`                      | pow(2)                    | calculates the square |
| SWAP               | swap                      | -none-                    | swaps the top an second stack entry |
| TESTBIT            | testBit                   | testBit(k)                | tests if k-th bit is set |
| TIMES              | `*`                       | multiply(n)               | multiplication  |
| TOBOOL             | toBool                    | -none-                    | converts 0 to false, all other numbers to true |
| XOR                | xor                       | xor(n)                    | bitwise/logical xor |

# Meta Functions #

| **BIRPN Meta Function** | **String Representation** | **Description** |
|:------------------------|:--------------------------|:----------------|
| applyLeft(op)           | applyLeft:op              | `[1,2,3,9] --> [9 op 1, 9 op 2, 9 op 3]` |
| applyRight(op)          | applyRight:op             | `[1,2,3,9] --> [1 op 9, 2 op 9, 3 op 9]` |
| filter(cond)            | filter:cond               | keep only elements fulfilling the condition |
| filterNot(cond)         | filterNot:cond            | keep only elements **not** fulfilling the condition |
| fold(op)                | fold:op                   | `[1,2,3,4] --> [1 op (2 op (3 op 4))]` |
| foreach(op)             | forEach:op                | `[1,2,3,4] --> [op(1), op(2), op(3), op(4)]` |