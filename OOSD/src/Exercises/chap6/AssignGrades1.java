/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
/*
write a program that reads student scores and gets the best score
assaign grades by:
A if >= best - 10
B if >= best - 20
c if >= best - 30
D if >= best - 40
prompt for input scores
 */
public class AssignGrades1 {

  public static void main(String[] args) {
    //scanner to read input
    Scanner scan = new Scanner(System.in);
    //number of students
    System.out.println("Enter the number of students:");
    int numberOfStudents = scan.nextInt();
    //create array and initialise their scores
    int students[] = new int[numberOfStudents];

    //safer to use this but im lasy for testing
//    for (int i = 0; i < students.length; i++) {
//      System.out.println("Enter Student " + i + " Score");
//      students[i] = scan.nextInt();
//    }
    System.out.println("Enter " + numberOfStudents + " scores:");
    for (int i = 0; i < students.length; i++) {
      students[i] = scan.nextInt();
    }
    
    //find largest score done by loop
    int temp = students[0];
    int tempIndex = 0;
    for (int i = 1; i < students.length; i++) {
      if(students[i] > temp){
        temp = students[i];
        tempIndex = i;
      }
    }
    
    //calculate scores
    for (int i = 0; i < students.length; i++) {
      System.out.format("Student %d score is %d and grade is ", i, students[i]);
      if(students[i] >= (students[tempIndex] - 10))
        System.out.println("A");
      else if(students[i] >= (students[tempIndex] - 20))
        System.out.println("B");
      else if(students[i] >= (students[tempIndex] - 30))
        System.out.println("C");
      else if(students[i] >= (students[tempIndex] - 40))
        System.out.println("D");
      else
        System.out.println("U");
    }
  }
}
