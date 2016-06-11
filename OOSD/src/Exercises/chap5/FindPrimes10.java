/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

/**
 *
 * @author ps2-sooriya
 */
public class FindPrimes10 {
  public static void main(String[] args) {
    /*
    Find prime numbers:
    use the is prime function to print all primes less than 20 000
    */
    System.out.println("Number of primes less than 20 000");
    //loop to run through all primes
    for (int i = 0; i < 20000; i++) {
      if(isPrime((i+1)) == true){
        System.out.println((i+1));
      }
    }
  }
  //taken this method
  public static boolean isPrime(int number){
    //for loop to check if the number is prime by checking if it is divisible from 2 - (n/2)
    for (int divisor = 2; divisor <= (number/2); divisor++) {
      if((number % divisor) == 0){
        return false;
      }
    }
    return true;
  }
}
