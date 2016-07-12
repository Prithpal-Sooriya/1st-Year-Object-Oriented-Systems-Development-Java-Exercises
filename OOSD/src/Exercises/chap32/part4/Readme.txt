Synchronize threads

Create 1000 threads that adds 1 to a variabble called sum (with initial value of 0)
    --> you need to pass sum by reference to each thread.
        --> in order to pass it by reference, wrap it as an Integer object to hold sum
    
    run program with and without synchronization to see its effects