/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap15.part2;

import java.util.Date;

/**
 *
 * @author Prithpal Sooriya
 */
public abstract class GeometricObject {
    
    private String colour = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    
    //get Area method (abstract)
    public abstract double getArea();
    
    //get Perimeter method (Abstract)
    public abstract double getPerimeter();
    
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
    @Override
    public String toString(){
        return "created on: " + dateCreated + "\ncolour: " + colour + " and filled: " + filled;
    }
    
}
