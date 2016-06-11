/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package exercises.chap1.part7;

/**
 *
 * @author Prithpal
 */
public class ApproximatePI {
    public static void main(String[] args){
        //approximate PI
        
        double ans = 4.0;
        
        //6 numbers in brackets
        System.out.println(ans * approximator(6));
        //7 numbers in brackets
        System.out.println(ans * approximator(7));
    }
    
    public static double approximator(double a){
        double ans = 0.0;
        for(double i = 0; i < a; i++){
            if(i % 2 == 0){
                //it is even number so will be positive/ a plus
                ans += (1/((2 * (i+1))-1));
            }
            else{
                //it is odd number so will be negative/ a minus
                ans -= (1/ ((2 * (i+1)-1)));
            }
        }
        return ans;
    }
}
