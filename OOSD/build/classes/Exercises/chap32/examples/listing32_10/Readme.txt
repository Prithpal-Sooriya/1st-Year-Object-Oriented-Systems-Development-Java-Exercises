Consumer Producer

this is a simple program which utilised 2 threads

Thread 1: Producer
    --> keeps looping and awaiting until a counter (integer) meets a capacity
    --> once this condition is met, a Buffer (from the Buffer class) will add an integer to it
    --> Once the integer is added, a signal is sent to other threads (the consumer thread) (notEmpty Condition)

Thread 2: Consumer
    --> keeps looping and awaiting until the count is equal to 0
    --> once the condition is met, then an integer is deleated/"consumed" from the buffer
    --> once the integer is removed, a signal is sent to other threads (producer thread) (notFull Condition)


...

To summerise:
    --> If the buffer is not full, Thread 2 will send the signal called notFull which Thread 1 is awaiting
    --> If the buffer is not empty, Thread 1 will send the signal called notEmpty which Thread 2 is awaiting