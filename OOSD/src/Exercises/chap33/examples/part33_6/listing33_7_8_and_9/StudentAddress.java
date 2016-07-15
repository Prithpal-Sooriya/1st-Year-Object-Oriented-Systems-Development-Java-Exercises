/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap33.examples.part33_6.listing33_7_8_and_9;

import java.io.Serializable;

/**
 *
 * @author Prithpal Sooriya
 */

//implements Serializable so it can be read and written by Object input/output stream
public class StudentAddress implements Serializable{
    //variables to use
    private String name;
    private String street;
    private String city;
    private String postcode;
    
    //constructor
    public StudentAddress(String name, String street, String city, String postcode){
        this.name = name;
        this.street = street;
        this.city = city;
        this.postcode = postcode;
    }
    
    //getters
    public String getName() {
        return name;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }
    
}
