/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercises.chap1.part5;

/**
 *
 * @author Prithpal
 */
public class ComputeExpressions {
    public static void main(String[] args){
        //computer expression
        double topLine = (7.5 * 2.5) - (1.5 * 3);
        double bottomLine = 33.5 - 2.5;
        //display 2dp
        System.out.format("%.2f\n",(topLine/bottomLine));
    }
}
