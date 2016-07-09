Semaphores

What are semaphores
    --> semaphores are objects when methods (threads) want to use the same resource
        --> when something wants to use the semaphore, must require a permit
        --> once used with the resource use used, the permit must be returned to the semaphore

Using Semaphore class
    --> to use the Semaphore class, you must create "new Semaphore"
        --> new Semaphore(int numberOfPermits, boolean fairness) = set number of permits, and set fairness policy
        --> new Semaphore(int numberOfPermits) = set number of permits
    --> use Semaphore methods:
        --> acquire() = Acquires a permit from the semaphore, number of permits in Semaphore decrease by 1
        --> release() = Returns the permit to the semaphore, number of perits in Semaphore increase by 1

How to use
    --> should use in a similar fashion to this
        1) semaphore.acquire()
        2) Access the resource
        3) semaphore.release()