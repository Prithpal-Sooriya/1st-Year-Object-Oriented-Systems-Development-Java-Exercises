/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises.chap6;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Prithpal
 */
/*
analyse scores:
write a program that reads an unspecified number of scores in an examination.
determine how many scores are >= the passing score and how many scores are < passing score.
enter -1 to signify end of an input
maximum numbr of scores are 100
 */
public class AnalyseScores4 {

  public static void main(String[] args) {
    //scanner for input
    Scanner scan = new Scanner(System.in);
    //arraylist for scores
    ArrayList<Integer> scores = new ArrayList<>();
    //prompt the input of scores and end
    boolean run = true;
    while (run) {
      System.out.println("Enter score:");
      int temp = scan.nextInt();
      if ((scores.size() <= 100) && (temp != -1)) {
        scores.add(temp);
      } else if (temp == -1) {
        run = false;
      } else {
        System.out.println("You have reached the maximium number of scores (100)");
      }
    }
    //now we calculate how many scores are >= passing score and ones < passing score
    int passed = 0, failed = 0;
    for (Integer score : scores) {
      if (score >= 60)
        passed++;
      else
        failed++;
    }
    System.out.println("Number of scores passed: " + passed);
    System.out.println("Number of scores failed: " + failed);
  }
}
