/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part5;

import Exercises.chap11.part1.*;
import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public class GeometricObject {
    
    private String colour = "white";
    private boolean filled;
    private java.util.Date dateCreated;
    
    /* Construct a default geometric object*/
    public GeometricObject() {
        dateCreated = new java.util.Date();
    }
    
    /* construct a geometric object with specified colour*/

    public GeometricObject(String colour, boolean filled) {
        dateCreated = new java.util.Date();
        this.colour = colour;
        this.filled = filled;
    }
    
    //get methods
    public String getColour() {
        return colour;
    }

    public boolean isFilled() {
        return filled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
    
    //set methods
    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    //to String method
    public String toString(){
        return "created on: " + dateCreated + "\ncolour: " + colour + " and filled: " + filled;
    }
    
}
