Blocking queue

What is a queue? 
    --> A queue is a data structure, in which data is added to the tail and removed from the head
    --> First in, First out (FIFO)

What is a BlockingQueue?
    --> causes a thread to be blocked when a queue is full
    --> it extends Queue object, and contains methods:
        --> put = add an element to the tail
        --> take = remove an element from the head

3 types of BlockingQueue
    --> ArrayBlockingQueue
        --> implements a blocking queue to an array
        --> specify capacity and an optional fairness
    --> LinkedBlockingQueue
        --> implements a blocking queue to a linked list
        --> can create a bounded or unbounded LinkedBlockingQueue
    --> PriorityBlockingQueue
        --> is a Priority Queue
        --> you can create a bounded or unbounded PriorityBlockingQueue

Why use BlockingQueue?
    -->Super useful when using threads (where one thread is adding, and another thread is removing)
    -->Blocking Queue can be BOUND, meaning that they can be set a limit
    Rules of BlockingQueue:
        --> blocks all method calls for adding an item when queue is full (reached specified limit)
        --> blocks all method calls for removing an item when queue is empty