Wildcard Generic Demo

Number class<-- Integer class (Integer class is a subtype of number class)
GenericStack<Number> <-/- GenericStack<Integer> (this is not a subtype to GenericStack<Number>/ class we created)

<? extends number> where ? is a WILDCARD

    --> 3 forms of wild cards:
        --> ? (unbounded wildcard) = can be anything
        --> ? extends T (bounded wildcard) = wildcard represents T or subType of T
        --> ? super T (lower bounded wildcard) = denoted T or unknown supertype of T

WILDCARD allows (in this case) any Number or a subtype of Number (e.g. Integer)


<?> is equivalent to <? extends Object> BUT
    -->GenericStack<?> =/= GenericStack<Object>
        --> may not work a method is looking for a wildcard instead of an object
            --> e.g. <Integer> passed to param looking for <Object> will not work
            --> e.g. <Integer> passed to param looking for <?> will work
        --> NOTE CLASS<Integer> is not a subtype for CLASS<Object> even though Integer is a subtype for Object