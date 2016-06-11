/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap8.part8;

/**
 *
 * @author Prithpal Sooriya
 */
public class Fan {

    public static final int SLOW = 1;
    public static final int MEDIUM = 1;
    public static final int FAST = 1;

    private int speed = SLOW;
    private boolean on = false;
    private double radius = 5;
    private String colour = "Blue";

    public Fan() { //no args constructor
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return (on == true)?
                "Fan speed: " + speed + ", colour: " + colour + ", radius: " + radius
                : "Colour: " + colour + ", radius: " + radius + ", Fan is off";
    }

}
