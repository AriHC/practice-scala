# Scala Thoughts
Tyler Marklyn and Ari Hausman-Cohen

### Things that are easy in Scala
We found functional programming to be pretty easy, and pattern matching is
really cool. It's nice that you can basically switch on anything, and it will
match on types, or elements, or composition, or really anything.

We really liked how easy it was to chain functional calls on lists together
such as map/reduce/fold/filter.

Anonymous functions are very easy to create, especially ones that lend
themselves to the use of the underscore. 

There are multiple ways of doing almost anything (especially things involving
collections), so finding one that works is usually not too bad.

### Things that are _not_ easy in Scala
Anything having to do with objects felt very unfamilliar, and a little bit
awkward. Scala works for OOP, but not as well as it works for functional
programming.

The whole idea of traits was difficult to understand, and we're still not quite
sure what they do. 

Trying to write recursive functions using only pattern matching and recursion,
without using any higher-order functions gets messy fast.

### Language design choices in Scala that make us happy
It's nice that there are several different valid syntaxes, so you can choose
the one that looks best for whatever operation you are trying to do (whether it
is to make a DSL, make use of OOP, or write intentionally obfuscated
one-liners[^fn-Mstyle])

The designers probably included all of these syntaxes because they are
academics, so they were vulnerable to "Oh wait! What if it could also be
written this way?" more than anyone else. Also, they probably wanted to attract
a large number of users with different backgrounds to their language.

[^fn-Mstyle]: Melissa O'Neill-style

### Language design choices that make us sad
We don't like companion objects in general. We mostly don't like them because
they feel unfamiliar. It makes sense that all of the static members and
functions go in an object that is initialized once, but they could have done
that under the hood and used the keyword `static`, without explicitly making
you do it.

It's a little strange that the first line of the class also defines a
constructor. We feel like this makes it difficult to define multiple
constructors, or it makes the second constructor feel, well, _secondary_.
However, generally, there is only one constructor, or there is one constructor
that is more common than the rest. Furthermore, the first constructor lets you
define members easily, which often is all you want to do in a constructor.

### Things we'd like to learn more about in Scala
We'd like to learn more about the built-in functions that Scala has to offer,
especially those on collections. We wrote a lot of one-liners, but they could
have been even shorter!

We also want to learn more about lazy things in Scala, and what functionality
they provide.

