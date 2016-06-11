/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap4;

import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
public class HighAndLowestScores9 {

    public static void main(String[] args) {
        /*
         find the highest and lowest scores:
         write a program to promt to enter how many students
         then enter each students name and score
         then display the student with the highest score and lowest score
         */
        //scanner for input
        Scanner scan = new Scanner(System.in);

        //prompt user to enter how many students
        System.out.println("Enter the amount of students:");
        int amount = scan.nextInt();
        scan.nextLine(); //USE THIS TO CONSUME THE \N CREATED FROM FROM nextInt()

        /*
        could create an arraylist (for real world applications)
        but i will use arrays as its easier to work with
        */
        Student students[] = new Student[amount];
        //initialise students
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(); 
        }
        //now we can use array in a for loop to give each student a name and score
        for(int i = 0; i < amount; i++){
            System.out.println("Enter student " + (i+1) + "'s name:");
            String tempString = scan.nextLine();
            students[i].setName(tempString);
            System.out.println("Enter student " + (i+1) + "'s score:");
            int tempInt = scan.nextInt();
            scan.nextLine(); //USE THIS TO CONSUME THE \N CREATED FROM FROM nextInt()
            students[i].setScore(tempInt);
        }
        
        //we set the names and scores so now we can find highest and lowest scores
            //highest score will be set to the first student
        int highestScore = 0;
        int lowestScore = 0;
        //scart at 1 because we already set the first student as both highest and lowest score
        for (int i = 1; i < students.length; i++) {
            //check highest
            if(students[i].getScore() > students[highestScore].getScore()){
                highestScore = i;
            }
            if(students[i].getScore() < students[lowestScore].getScore()){
                lowestScore = i;
            }
        }
        
        //print out lowest and highest scoring students
        System.out.format("%s has the highest score of: %d\n", students[highestScore].getName(), students[highestScore].getScore());
        System.out.format("%s has the lowest score of: %d\n", students[lowestScore].getName(), students[lowestScore].getScore());
    }
}

class Student{

     String name = "";
     int score = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
