Synchronisation

you can call the "synchronized" keyword:
    --> use this in a method: public static synchronized xMethod()....
    --> CANNOT use in specific code/statements
        --> BUT you can encapsulate the code/statements by saying: ... synchronized(this){ code/statements to synchronize... }

A synchronised method needs a "Lock":
    --> To allow a thread to access/unlock data to use and pass key onto the next thread to use data

This lock is supplied implicitly, but you can express a lock explicitly
    --> A lock can also use the newCondition method to create Condition objects (used for thread communication and what threads should run when)
        -> newCondition returns a new Condition instance that is bound to this Lock instance

ReentrantLock
    --> Lock is an abstract class (so you cannot call "new lock()")
    --> But you can call "new" of its children
        -->ReentrantLock is a subtype of Lock, so can be used

    -->constructors
        -->ReentrantLock() //sets fairness to false, no priority on threads so threads access in no particular order
        -->ReentrantLock(boolean fair) //if true, then the longest waiting thread will use lock first