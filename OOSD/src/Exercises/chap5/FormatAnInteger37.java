/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap5;

/**
 *
 * @author Prithpal
 */
/*
write a method called: String formaT(int number, it width)
returns a string for the number with one or mroe prefix 0's
size of the string is the width
for example:
format(34, 4) returns 0034
format(35, 5) returns 00034
if number is larger than width return original number
format(34, 1) returns 34
*/
public class FormatAnInteger37 {
  
  public static void main(String[] args) {
    //call method, and see if it works in all cases
    System.out.println(format(34, 4));
    System.out.println(format(34, 5));
    System.out.println(format(34, 1));
  }
  
  public static String format(int number, int width){
    int numberSize;
    //first we have to check if the width is large enough
    int temp = (int) Math.log10(number);
    //only issue with using logs is that 1, 10, 100, ect will be 1 less actual width size (so +1)
    if(temp % 1 == 0){
      numberSize = temp + 1;
    }
    else{
      numberSize = (int) Math.ceil(temp);
    }
    
    //now check number size to width and return correct value
    if(numberSize >= width){
      return String.valueOf(number);
    }
    else{
      //find out how many 0's we need to add at front
      numberSize = width - numberSize;
      
      //add 0's
      String s = "";
      for(int i = 0; i < numberSize; i++){
        s += "0";
      }
      s += String.valueOf(number);
      return s;
    }
  }
}
