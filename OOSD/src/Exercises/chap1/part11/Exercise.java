/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Exercises.chap1.part11;

/**
 *
 * @author Prithpal
 */
public class Exercise {
    public static void main(String[] args){
        //population projection
        
        //number of seconds in a year
        double yearInSec = 60 * 60 * 24 * 365; //number of seconds = 60 seconds in a minute, 60min in 1hr, 24hr in a day, 365days in a year
        /* NEEDS TO BE INT'S, NEED WHOLE NUMBER OF PEOPLE IN POPULATION*/
        //number of births
        int births = (int) yearInSec / 7; //1 birth every 7 seconds
        //number of deaths
        int deaths = (int) yearInSec / 13; //1 death every 13 seconds
        //immigration
        int immigration = (int) yearInSec / 45; //1 immigrant every 45 seconds
        //current population
        int currentPop = 312032486;
        //new population
        int newPop = births - deaths + immigration + currentPop;
        
        System.out.println("The population projection for next year is: " + newPop);
    }
}
