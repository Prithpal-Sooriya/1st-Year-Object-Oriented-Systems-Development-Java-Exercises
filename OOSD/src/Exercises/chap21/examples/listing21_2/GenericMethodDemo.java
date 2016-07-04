/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap21.examples.listing21_2;

/**
 *
 * @author Prithpal Sooriya
 */
public class GenericMethodDemo {

    //main method to run code
    public static void main(String[] args) {

        Integer[] integers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] strings = {"Hello", "World", "Java", "Is", "Awesome"};

        //call explicitly
        GenericMethodDemo.<Integer>printList(integers);
        GenericMethodDemo.<String>printList(strings);

        //call method to print a list of objects through consoles
        //call implicitly
        printList(integers);
        printList(strings);
        
        //print numbers list (bound to numbers only)
        GenericMethodDemo.<Integer>printListNumbers(integers);
        printListNumbers(integers);

    }

    //method that has a parameter E
    //need to explicitly show that this method is Generic by using <E> before void
    private static <E> void printList(E[] list) {
        //print list to console
        for (E e : list)
            System.out.print(e + " ");
        //output a new line
        System.out.println();
    }
    
    //you can also bound generics to particular parents
    public static <E extends Number> void printListNumbers(E[] list){
        //print list to console
        for (E e : list)
            System.out.print(e + " ");
        //output a new line
        System.out.println();
    }

}
