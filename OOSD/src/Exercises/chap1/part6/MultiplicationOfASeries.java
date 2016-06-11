/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercises.chap1.part6;

/**
 *
 * @author Prithpal
 */
public class MultiplicationOfASeries {
    public static void main(String[] args){
         //do 9 factorial
        int ans = 1;
        for(int i = 0 ; i<9; i++)
            //same as ans = ans* (i+1)
            ans *= (i+1);
        System.out.println(ans);
    }
}
