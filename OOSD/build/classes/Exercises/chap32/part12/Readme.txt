Parallel array initialiser

implement the following method using Fork/Join Framework to assign random values to a list

public static void parallelAssignValues(double[] list)

write a test program that creates a list with 9 000 000 elements
    --> inkove parallelAssignValues method
    --> implement a sequential method (no threads) to assign values

DO NOT USE Math.random() as this is synchronised --> does not work with parallel threads/programming
USE Random class to assign values (it is not synchronised so can be used in parallel programming)

