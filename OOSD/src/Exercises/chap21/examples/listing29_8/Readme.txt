Any Wildcard Demo

shows of <?> compared to <Object>

<?> is equivalent to <? extends Object> BUT
    -->GenericStack<?> =/= GenericStack<Object>
        --> may not work a method is looking for a wildcard instead of an object
            --> e.g. <Integer> passed to param looking for <Object> will not work
            --> e.g. <Integer> passed to param looking for <?> will work
        --> NOTE CLASS<Integer> is not a subtype for CLASS<Object> even though Integer is a subtype for Object