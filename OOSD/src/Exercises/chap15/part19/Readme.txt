Math: the Complex class

<Background>

complex numbers: real number + imaginary number (4.2 + 6.1i)

Addition: a + bi + c + di = (a + c) + (b + d)i

Subtraction: a + bi - (c + di) = (a - c) + (b - d)i

Multiplication:  (a + bi) * (c + di) = (ac - bd) + (bc + ad)i

Division: (a + bi) / (c + di) = (ac + bd)/(c^2 + d^2) + (bc - ad)i/(c^2 + d^2)

Absolute value: |a + bi| = sqrt(a^2 + b^2)

</Background>

Design a class called Complex for representing complex numbers
methods:
    add, subtract, multiply, divide, abs for performing complex-number operations
    toString() --> "(a + bi)", if b is 0 just return a
    getRealPart --> return a
    getImaginaryPart --> return b

constuctors:
    complex(a, b) --> a and b value
    complex(a) --> a values, b = 0
    complex() --> a = 0, b = 0

Create a test class to test the Complex class, contains user input