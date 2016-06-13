/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap10.part3;

/**
 *
 * @author Prithpal Sooriya
 */
public class MyInteger {
    
    private int value;
    
    //constuctor
    public MyInteger(int value){
        this.value = value;
    }
    
    //get method
    public int getValue() {
        return value;
    }
    
    //non static methods for isEven/Odd/Prime
    public boolean isEven(){
        return (value % 2) == 0;  
    }
    
    public boolean isOdd(){
        return (value % 2) == 1;  
    }
    
    /*
    code for isPrime was from http://beginnersbook.com/2014/01/java-program-to-check-prime-number/
    it is a basic program to check if a number is prime
    */
    public boolean isPrime(){
        int temp;
        for(int i=2;i<=value/2;i++)
	{
           temp=value%i;
	   if(temp==0)
	   {
	      return false;
	   }
	}
        return true;
    }
    
    //static methods for isEven/Odd/Prime
    public static boolean isEven(int value){
        return (value % 2) == 0;  
    }
    
    public static boolean isOdd(int value){
        return (value % 2) == 1;  
    }
    
    /*
    code for isPrime was from http://beginnersbook.com/2014/01/java-program-to-check-prime-number/
    it is a basic program to check if a number is prime
    */
    public static boolean isPrime(int value){
        int temp;
        for(int i=2;i<=value/2;i++)
	{
           temp=value%i;
	   if(temp==0)
	   {
	      return false;
	   }
	}
        return true;
    }
    
    //non static equals method
    public boolean equals(int i){
        return value == i;
    }
    
    //static equals method
    public static boolean equals(int i, int j){
        return i == j;
    }
    
    //static parseInt(char[])
    public static int parseInt(char[] c){
        return Integer.parseInt(new String(c));
    }
    
    //static parseInt(String)
    public static int parseInt(String s){
        return Integer.parseInt(s);
    }
}
