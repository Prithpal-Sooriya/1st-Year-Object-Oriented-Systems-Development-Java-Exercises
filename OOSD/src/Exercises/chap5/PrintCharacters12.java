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
public class PrintCharacters12 {
  public static void main(String[] args) {
    /*
    print characters:
    use method: void printChars(char char1, char2, int numberPerLine)
    program should print chars between char1 and char2
    print 10 numbers per line from l to Z
    */
    printChars('1', 'Z', 10);
  }
  
  public static void printChars(char char1, char char2, int numberPerLine){
    //print all the chars between char1 and char2
    boolean run = true;
    int counter = 0;
    while(run == true){
      //check the size of the char to use
      if(char1 > char2){
        //exit out of method
        run = false;
      }
      else{
        //print char
        System.out.format("%c ", char1);
        //increments
        char1++;
        counter++;
      }
      if((counter % numberPerLine) == 0){
        //print a new line every 10 lines
        System.out.println("");
        counter %= numberPerLine;
      }
    }
    //another new line for tidyness
    System.out.println("");
  }
}
