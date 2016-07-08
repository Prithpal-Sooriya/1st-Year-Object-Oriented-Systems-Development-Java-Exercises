Cooperation between threads
    --> threads can cooperate and communicate between

Lock method, create a Condition by using newCondition

Condition methods:
    --> await() = Causes the current thread to wait until the condition is signalled
    --> signal() = Wakes up one waiting thread
    --> signalAll() = Wakes up all waiting threads
