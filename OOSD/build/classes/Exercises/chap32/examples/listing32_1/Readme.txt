Task Thread Demo

Create a Task Class (an Object that can be run on a thread) 
    --> The Task class implements Runnable
        --> Runnable allows you to use the run() method, this will be called when you START a thread


This program creates threads
    --> first task: prints letter 'a' 100 times
    --> second task: prints letter 'b' 100 times
    --> third task: prints integers 1 to 100
When you run the program, the 3 threads will share the CPU and take turns executing their commands
    --> thus the output will be something like: "ab1ab2ab3...aab46ab47..."