Parallel Merge sort

Parallel programming
    --> utilise multiple cores and threads to solve problems more faster

Non overlapping subproblems solved using threads
    1) Break a problem (known as Fork) into sub problems
        --> invoke() and invokeAll(tasks) implicitly calls fork() to execute the task
    2) For each of the subproblems, run a thread for each of them
    3) Use the join() Thread method for each of the threads and combine subproblems into the final solution
        --> join() = waits till the thread is complete

Important classes:
    java.utilconcurrent.Future (interface) methods
        --> cancel() = attempt to cancel the task
        --> get() = waits till computation is complete, then return the result (return is generic, so can be anything returned)
        --> isDone() = returns TRUE if the task is complete

    java.util.concurrent.ForkJoinTask<T> (abstract)
        --> adapt() = returns a ForkJoinTask from a runnable task
        --> fork() = Arranges asynchronous execution of a task (RUN SUBPROBLEMS ASYNCHRONOUSLY)
        --> join() = returns the result of when computation is done
            --> so when calling fork() you must call a join() somewhere else
        --> invoke() = performs the task and awaits for its completion, (once completed, return the result)
            --> the same as saying x.fork().join(), great for 1 line but you may not want to call join so early
        --> invokeAll(tasks ForkJoinTask<> ...) = Forks the given tasks and returns when all tasks are completed

    java.util.concurrent.RecursiveAction (abstract)
        --> compute() = defines how task is performed
            --> does not return any value (void method)

    java.util.concurrent.Recursivetask (abstract)
        --> compute() = defines how task is performed.
            --> Returns the value after the task is completed

    java.util.concurrent.ForkJoinPool (subclass of Executor service)
        --> ForkJoinPool(int parallelism) = constructor specifying number of processors
        --> ForkJoinPool() = constructor with whatever available processors
        --> <T> invoke(ForkJoinTask<T>) = performs the task and returns its result upon completion (returned as the Generic)