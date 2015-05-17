# 2010-11-12 #

As I had to implement a shunting yard based parser for another project, I'm thinking about ways to integrate or adapt this code. If I can find a suitable design, you would have the possibility to use "normal" (infix) notation in BIRPN.

# 2010-02-06 #

The new release is there: BIRPN 0.3
I added three functions that work on the whole stack (sort, reverse, shuffle). Then I added another example (Ackermann function) and the `JUnit` test for meta function (`MetaTest`).

# 2010-02-04 #

I changed the Function1,2,3 interfaces to be more readable, `OperatorTest` is now backward compatible to `JUnit3`, and I changed the representation for square and cube to the corresponding Unicode escape sequences (as I had some checkin problems because of that). Hmmm, seems to be time for a new release.

# 2010-01-23 #

I completely reorganized the package structure: Classes to be extended by users (Op, Meta, Function...) are now direcly in org.birpn, the meta functions got their own package org.birpn.meta, and the ops package got splitted into several sub-packages. There is a new org.birpn.example package too, containing right now only the old example of the Lucas-Lehmer test from the Main class. The Main class itself is now a little bit more useful, as it acts like a little calculator. I found out that the all-lowercase toString() values of my Ops really suck, so I changed them to lowerCamelCase, which allows the calculator to show e.g. "isProbablePrime" instead of "isprobableprime" in the function reference. Last little change: I added two methods to get a list of all Ops and Metas registered in BIRPN.

# 2010-01-17 #

I made a new release BIRPN 0.2. `OperatorTest` has now full operator coverage (which revealed some minor bugs in the process). I think it is time for a little feature freeze, until I got yesterday's promises fulfilled.

# 2010-01-16 #

I added three more functions. There was a little bug in ne (not equal), which shows that I should really complete the JUnit tests before making a new release. `OperatorTest` covers now about half of the functions. I'll make a `MetaTest` class for meta functions as well. A meta function page and a little "write your own function" tutorial in the wiki is missing as well.

# 2010-01-09 #

I added some more functions and meta-functions. E.g. to get all primes of the form p = n²+3 below 10000, just write:
```
System.out.println(results("1 99 .. foreach:² 3 applyLeft:+ filter:isPrime"));
//[7, 19, 67, 103, 199, 487, 787, 1447, 2503, 2707, 3847, 4099, 4903, 5479, 5779, 8467, 8839]
```
I think this is pretty cool. But before getting lost in feature-space, I'll try to focus on getting BIRPN-0.2 out, and to improve documentation. A lot of things are counter-intuitive, and currently it's not obvious to see why the calculation blows up, so improved error messages and logging are on my taks list, too.

# 2010-01-08 #

I changed the internal structure of the project and introduced the function "if". I came up with a funny concept called "meta-functions", which allows you to parametrize functions with functions. I introduced the meta-functions fold and foreach. Here an example what you can do with it:
```
//add all elements on the stack
BigInteger s0 = _(1,2,3,4,5,PLUS,PLUS,PLUS,PLUS); //old way
BigInteger s1 = _("1 2 3 4 5 + + + +"); //old way parsed
BigInteger s2 = _(1,2,3,4,5,fold(PLUS)); //meta-function
BigInteger s3 = _("1 2 3 4 5 fold:+"); //meta-function parsed

//decrease all numbers by one
List<BigIntegeger> list0 = results(1,DEC,2,DEC,3,DEC,4,DEC,5,DEC); //old way
List<BigIntegeger> list1 = results("1 -- 2 -- 3 -- 4 -- 5 --"); //old way parsed
List<BigIntegeger> list2 = results(1,2,3,4,5,foreach(DEC)); //meta-function
List<BigIntegeger> list3 = results("1 2 3 4 5 foreach:--"); //meta-function parsed
```

# 2010-01-07 #

Okay, the scope of this project is quite limited, but I'm working on the next release. I'll add some JUnit tests and maybe some useful functions. The biggest improvement will be, that I make BIRPN "pluggable", which means that you can add your own functions at runtime.

Today I had the idea to support boolean operations by having a TRUE and FALSE constant, and it seems to work quite well. I included a boolean evaluation function is(...), and a function results(...) which exposes the stack content (if you want to calculate several values at once, like `BigInteger.divideAndRemainder()` does, or for debugging)