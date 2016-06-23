/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part8;

/**
 *
 * @author Prithpal Sooriya
 */
public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{

    //costructor
    public ComparableCircle(){
        super();
    }
    
    public ComparableCircle(int radius){
        super(radius);
    }
    
    @Override
    public int compareTo(ComparableCircle t) {
        //what circle is larger --> larger by their area
        if(this.getArea() > t.getArea()){
            return 1;
        }
        else if(this.getArea() < t.getArea()){
            return -1;
        }
        else
            return 0;
    }
    
}
