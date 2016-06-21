/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercises.chap14.part19;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * @author Prithpal Sooriya
 */
public class CountWordsFromWebsite {
    
    //main method to run code
    public static void main(String[] args) {
        
        try {
            //create a url object to access the website
            URL url = new URL("http://cs.armstrong.edu/liang/data/Lincoln.txt");
            
            try {
                //use the url openstream to create an inputStream, Scanner can be used to access this
                Scanner scan = new Scanner(url.openStream());
                
                //read the URL, and count each word (delimeter is whitespace so use .next())
                int total = 0;
                while(scan.hasNext()){
                    scan.next();
                    total++;
                }
                
                //output the total
                System.out.println("The total number of words are: " + total);
            } catch (IOException ex) {
                System.out.println("The Scanner could not read the URL, IOException");
            }
        } catch (MalformedURLException ex) {
            System.out.println("URL given cannot be accessed or is incorrect, MalformedURLException");
        }
        
    }
    
}
