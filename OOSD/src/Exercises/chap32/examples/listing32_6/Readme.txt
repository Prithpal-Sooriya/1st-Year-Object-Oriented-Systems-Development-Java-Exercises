Executor Demo

Use of thread pools:
--> Using threads can be great for small amount of threads, but too many threads can limit throughput
    --> Therefore user thread pools

How thread pools can be used
--> Java provides Executer interface for executing threads in a thread pool
--> Also provides ExecuterService interface for managing and controlling tasks
    --> ExecuterService is a subinterface of Executer

Use Executers methods (they can be stored in an ExecuterService)
--> done by using the Executer static methods
    --> newFixedThreadPool(int numberOfThreads)
        --> creates a thread pool with a certain number of threads
        --> threads executed concurrently, and can be reused if current task is finished
    --> newCachedThreadPool()
        --> creates a thread pool with as many threads as needed (size can change)
        --> will reuse threads when they are available